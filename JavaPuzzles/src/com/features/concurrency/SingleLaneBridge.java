package com.features.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SingleLaneBridge {

    static enum Direction {
        NORTH, SOUTH
    }

    static class Vehicle implements Runnable {
        Bridge bridge;
        String id;
        Direction bound;
        Vehicle(String id, Direction bound,  Bridge bridge) {
            this.bridge = bridge;
            this.id = id;
            this.bound = bound;
        }

        @Override
        public void run() {
            //we will assume crossing takes random time
            bridge.crossBridge(this);

        }

        public String getId() {
            return id;
        }

        public Direction getBound() {
            return bound;
        }
    }


    static class Bridge {
        private static final int MAX_VEHICLE_ON_BRIDGE = 2;
        /*making it fair, so that FIFO ordering is maintained for Vehicles queue */
        private Semaphore bridgeGard = new Semaphore(MAX_VEHICLE_ON_BRIDGE,true);
        volatile int  vehicleOnBridge = 0;
        volatile Direction trafficDirection = Direction.NORTH;
        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();

        public void crossBridge(Vehicle vehicle) {
            while(!(vehicleOnBridge == 0 || trafficDirection == vehicle.getBound())) {
                try {
                    condition.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println("- IN - - - - - - - Vehicle : "+vehicle.getId()+", bound:"+vehicle.getBound()+" trying to cross bridge");
                bridgeGard.acquire(1);
                vehicleOnBridge++;
                trafficDirection = vehicle.getBound();
                System.out.println("= = = = = = = = Vehicle : "+vehicle.getId()+", bound:"+vehicle.getBound()+" crossing bridge");
                TimeUnit.SECONDS.sleep(new Random().nextInt(10));

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                vehicleOnBridge--;
                bridgeGard.release(1);
                condition.notify();
            }
            System.out.println("- OUT - - - - - - - Vehicle : "+vehicle.getId()+", bound:"+vehicle.getBound()+" out of bridge");
        }


    }


   static Runnable simulationRunner = new Runnable() {
       @Override
       public void run() {
           Bridge bridge = new Bridge();
           Random rand = new Random();
           ExecutorService executor = Executors.newCachedThreadPool();
           int id = 1;
           while(true) {
               boolean bool = rand.nextBoolean();
               Vehicle vehicle = new Vehicle(""+id++,bool?Direction.NORTH:Direction.SOUTH,bridge);
               executor.submit(vehicle);

               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }


       }
   };

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(simulationRunner);

    }


}
