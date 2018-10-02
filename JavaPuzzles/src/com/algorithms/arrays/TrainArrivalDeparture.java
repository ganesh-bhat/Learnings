package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TrainArrivalDeparture {

    static class TrainTime {
        long start;
        long end;

        TrainTime(String start, String end) {
            String[] starts = start.split("\\.");
            String[] ends = end.split("\\.");
            this.start = Integer.parseInt(starts[0])*60 +Integer.parseInt(starts[1]);
            this.end = Integer.parseInt(ends[0])*60 +Integer.parseInt(ends[1]);
        }
    }

    public static void main(String[] args) {


        List<TrainTime> trainTimes = Arrays.asList(
                new TrainTime("2.00","2.30"),
                new TrainTime("2.10","3.40"),
                new TrainTime("3.00","3.20"),
                new TrainTime("3.20","4.30"),
                new TrainTime("3.50","4.00"),
                new TrainTime("5.00","5.20")
        );

        List<List<TrainTime>> platforms = new ArrayList<>();

        for(int i=0;i<trainTimes.size();i++) {
            TrainTime current = trainTimes.get(i);
            if(platforms.isEmpty()) {
                List<TrainTime> platform = new ArrayList<TrainTime>();
                platform.add(current);
                platforms.add(platform);
            }else {
                boolean allocted = false;
                for(List<TrainTime> platform:platforms ) {
                    TrainTime last = platform.get(platform.size()-1);
                    if(isLesser(last, current)) {
                        allocted = true;
                        platform.add(current);
                    }
                }
                if(!allocted) {
                    List<TrainTime> platform = new ArrayList<TrainTime>();
                    platform.add(current);
                    platforms.add(platform);
                }
            }
        }

        for(int i=0;i<platforms.size();i++) {
            List<TrainTime> platform = platforms.get(i);
            for(TrainTime trainTime:platform) {
                System.out.println("Train arrived at "+format(trainTime.start)+" departed at "+format(trainTime.end)+" on platform "+(i+1));
            }
        }


    }

    private static String format(long num) {
        long hour = num/60;
        long mins = num-(hour*60);

        return hour+"."+mins;
    }

    private static boolean isLesser(TrainTime last, TrainTime current) {
        return last.end <=current.start;
    }
}
