package com.algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * http://www.techiedelight.com/job-sequencing-problem-deadlines/
 *
 *
 */
public class JobSequencing {


    static class Job {
        int taskId;
        int deadline;
        int profit;

        Job(int taskId, int deadline, int profit) {
            this.taskId = taskId;
            this.deadline = deadline;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return "Job{" +
                    "taskId=" + taskId +
                    ", deadline=" + deadline +
                    ", profit=" + profit +
                    '}';
        }
    }


    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job(1,9,15),
                new Job(2,2,2),
                new Job(3,5,18),
                new Job(4,7,1),
                new Job(5,4,25),
                new Job(6,2,20),
                new Job(7,5,8),
                new Job(8,7,10),
                new Job(9,4,12),
                new Job(10,3,5)
        );

        Comparator<Job> profitCompartor = new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return Integer.compare(job2.profit, job1.profit);
            }
        };
        Collections.sort(jobs, profitCompartor);

       // System.out.println(jobs);


        int[] schedule = new int[jobs.size()];
        Arrays.fill(schedule, -1);

        int totalProfit = 0;
        for(Job job : jobs) {
            int loc = job.deadline-1;
            while(loc>=0 && schedule[loc]!=-1) {
                loc--;
            }
            if(loc>=0 && schedule[loc]==-1) {//found empty slot
                schedule[loc] = job.taskId;//schedule
                totalProfit+= job.profit;
            }
        }

        System.out.println("Total profit:"+totalProfit);
        for(int taskId:schedule) {
            if(taskId!=-1) {
                System.out.println(taskId);
            }
        }

    }
}
