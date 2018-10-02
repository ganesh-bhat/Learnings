package com.features.concurrency;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

public class ForkJoinExample {

    public static void main(String[] args) {

        ForkJoinPool pool = new ForkJoinPool();

        int[] nums = new int[20_000_00];

        Random ran = new Random();
        for(int i=0;i<20_000_00;i++) {
            nums[i] = ran.nextInt(20_000);
        }

        long start = System.currentTimeMillis();
        //pool.invoke(new ParallelMergeSort(nums));
        mergeSort(nums,0,nums.length-1);
        long end = System.currentTimeMillis();
        System.out.println("Time taken:"+(end-start));


        //mergeSort(nums,0,nums.length-1);
        //System.out.println(Arrays.toString(nums));


    }


    static class ParallelMergeSort extends RecursiveAction {

        int[] num;
        int low;
        int high;
        ParallelMergeSort(int[] num) {
            this.num = num;
            low = 0;
            high = num.length-1;
        }

        ParallelMergeSort(int[] num, int low, int high) {
            this.num = num;
            this.low = low;
            this.high = high;
        }


        @Override
        protected void compute() {
            if(low>=high) {
                return;
            }
            int mid = low+(high-low)/2;
            invokeAll(new ParallelMergeSort(num, low, mid),new ParallelMergeSort(num,mid+1,high));
            merge(low, mid, high);
        }

        private void merge(int lo, int mid, int hi) {
            int i = lo;
            int j = mid+1;
            int k=0;

            int[] aux = new int[hi-lo+1];

            while(i<=mid && j<=hi) {
                if(num[i]<num[j]) aux[k++] = num[i++];
                if(num[i]>=num[j]) aux[k++] = num[j++];
            }

            while(i<=mid) {
                aux[k++] = num[i++];
            }

            while(j<=hi) {
                aux[k++] = num[j++];
            }

            //copy back
            i = lo;
            k=0;
            for(;k<aux.length;k++) {
                num[i++] = aux[k];
            }

        }
    }


    public static void mergeSort(int[] nums, int low, int high) {
        if(low>=high) return;

        int mid = low+(high-low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums, low, mid, high);
    }

    private static void merge(int[] num, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        int k=0;

        int[] aux = new int[hi-lo+1];

        while(i<=mid && j<=hi) {
            if(num[i]<=num[j]) aux[k++] = num[i++];
            if(num[j]<num[i]) aux[k++] = num[j++];
        }

        while(i<=mid) {
            aux[k++] = num[i++];
        }

        while(j<=hi) {
            aux[k++] = num[j++];
        }

        //copy back
        i = lo;
        k=0;
        for(;k<aux.length;k++) {
            num[i++] = aux[k];
        }

    }




}
