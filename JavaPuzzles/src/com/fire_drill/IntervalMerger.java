package com.fire_drill;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Problem description here - https://www.geeksforgeeks.org/merging-intervals/
 */
public class IntervalMerger {

    public static class Interval{
        private int start;
        private int end;

        public Interval(int start,int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        @Override
        public String toString() {
            return "("+start+","+end+")";
        }
    }

    public List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> mergedIntervals = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval interval1, Interval interval2){
                return interval1.getStart()-interval2.getStart();
            }
        });

        mergedIntervals.add(intervals.get(0));

        for(int i=1;i<intervals.size();i++){
            if(mergedIntervals.get(mergedIntervals.size()-1).getEnd() >= intervals.get(i).getStart()) {
                //overlap, hence update
                Interval previousInterval = mergedIntervals.get(mergedIntervals.size()-1);
                if(previousInterval.getEnd() < intervals.get(i).getEnd()) {
                    previousInterval.setEnd(intervals.get(i).getEnd());
                }
            } else {
                mergedIntervals.add(intervals.get(i));
            }
        }

        return mergedIntervals;
    }


    public static void main(String[] args) {
        testCase1();
        testCase2();


    }

    private static void testCase2() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(6,8));
        intervals.add(new Interval(1,9));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(4,7));
        List<Interval> merged =  new IntervalMerger().mergeIntervals(intervals);
        System.out.println(merged);
    }

    private static void testCase1() {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,4));
        intervals.add(new Interval(5,7));
        intervals.add(new Interval(6,8));
        List<Interval> merged =  new IntervalMerger().mergeIntervals(intervals);
        System.out.println(merged);

    }


}