package com.patterns.observer;


import java.util.Observable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WeatherStation extends Observable {

    private double temp;
    private TemperatureSensor sensor;

    public WeatherStation() {
        this.sensor = new TemperatureSensor(this);
        this.sensor.start();
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
        setChanged();
        notifyObservers(temp);
    }

    private static class TemperatureSensor extends Thread{
        WeatherStation station;
        Random rand = new Random();
        TemperatureSensor(WeatherStation station) {
            this.station = station;
        }

        @Override
        public void run() {
            super.run();
            while(true) {
                //simulate readings
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                this.station.setTemp(rand.nextDouble());
            }

        }
    }

}
