package com.common.java;

import java.util.Comparator;
import java.util.PriorityQueue;

public class JavaPriorityQueue {

    static class Task {
        int priority;
        String taskName;
        Task(int pri, String str) {
            priority = pri;
            taskName = str;
        }

        @Override
        public String toString() {
            return String.format("{%s : %d}", taskName,priority);
        }
    }

    public static void main(String[] args) {
        Comparator<Task> taskComparator = new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if(o1!=null) {
                    return Integer.compare(o1.priority , o2.priority);
                } else {
                    return -1;
                }
            }
        };

        PriorityQueue<Task> queue = new PriorityQueue<>(taskComparator);
        queue.add(new Task(0,"The"));
        queue.add(new Task(4,"Lazy"));
        queue.add(new Task(5,"Fox"));
        queue.add(new Task(2,"Jumps"));
        queue.add(new Task(3,"Over"));
        queue.add(new Task(1,"Dog"));


        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
