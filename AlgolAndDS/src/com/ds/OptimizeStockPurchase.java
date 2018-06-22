package com.ds;

public class OptimizeStockPurchase {

    public static void main(String[] args) {

        float[] low = {5,8,9,12,3,4,6,7,3,2};
        float[] high = {9,12,15,20,9,7,7,4,5};
        float[] start = {6,7,9,11,18,7,7,7,4,3};

        int[] result = bf_maximizeProfit(0,10,low,high,start);
        System.out.println(result);


    }

    private static int[] bf_maximizeProfit(int startDay, int endDay,float[] low,float[] high,float[] start ) {
        float max = 0;
        int buyDay=0;
        int sellDay=0;

        for(int i=0;i<start.length;i++) {
            for(int j=i;j<start.length;j++) {
                if((start[j]-start[i])>max) {
                    max = start[j]-start[i];
                    buyDay = i;
                    sellDay=j;
                }
            }
        }


        return new int[]{buyDay,sellDay};
    }
}
