package com.puzzles;

import java.util.Collections;
import java.util.List;



public class TipsMaximizer {

    public static void maximizeTips(List<Waiter> waiters) {
        int orders = 0;
        for (Waiter waiter : waiters) {
            if(waiter.getTips()!=null) {
                Collections.sort(waiter.getTips());
                orders = orders ==0? waiter.getTips().size(): orders;
            }
        }

        Waiter[] assignment = new Waiter[orders];
        int assignCount  = 0;
        while(assignCount<orders) {
            Tip maxTip = null;
            Waiter maxTipWaiter = null;
            for (Waiter waiter : waiters) {
                if(waiter.maxOrders>0) {
                   Tip currentTip = waiter.tips.get(0);
                   if(maxTip == null ||maxTip.tip <= currentTip.tip ) {
                        maxTip = currentTip;
                        maxTipWaiter = waiter;
                   }

                }
            }
            //take out current order and assign
            Tip orderTip = maxTipWaiter .tips.remove(0);
            if(assignment[orderTip.orderId] == null) {
                assignment[orderTip.orderId] = maxTipWaiter;
                assignCount++;
                maxTipWaiter.tipCollected+=orderTip.tip;
                maxTipWaiter.maxOrders --;
            }
        }

        print(assignment);

        printTotalTips(waiters);

    }

    private static void printTotalTips(List<Waiter> waiters) {
        long sum = 0;
        for(Waiter w:waiters) {
            sum+=w.tipCollected;
        }
        System.out.println("\nTip collected:"+sum);
    }


    private static void print(Waiter[] assignment) {
        System.out.println("Assignments:");
        for(int i=0;i<assignment.length;i++) {
            Waiter waiter = assignment[i];
            String name = null;
            if(waiter != null) {
                name = waiter.personName;
            }
            if(i == 0) {
                System.out.print("[ "+i+"="+name+",");
            } else if(i == assignment.length-1) {
                System.out.print(i+"="+name+" ]");
            } else {
                System.out.print(i+"="+name+",");
            }


        }
    }

    static class Waiter {
        String personName;
        List<Tip> tips;
        int maxOrders;
        int tipCollected;

        Waiter(String name, int maxOrders) {
            this.personName = name;
            this.maxOrders = maxOrders;
        }

        public void setTips(List<Tip> tips) {
            this.tips = tips;
        }

        @Override
        public String toString() {
            return "Waiter{" +
                    "personName='" + personName + '\'' +
                    ", tips=" + tips +
                    ", maxOrders=" + maxOrders +
                    '}';
        }

        public List<Tip> getTips() {
            return tips;
        }
    }

    static class Tip implements Comparable{
        int orderId;
        long tip;

        public Tip(int i, long tip) {
            orderId = i;
            this.tip = tip;
        }

        @Override
        public int compareTo(Object o) {
            if(o == this) {
                return 0;
            }
            if(o == null) {
                return -1;
            }
            return Long.compare(((Tip)o).tip, this.tip);
        }

        @Override
        public String toString() {
            return "Tip{" +
                    "orderId=" + orderId +
                    ", tip=" + tip +
                    '}';
        }
    }
}
