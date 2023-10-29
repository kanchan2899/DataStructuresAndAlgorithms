package com.dsalgo.greedy;

import java.util.Arrays;

// https://www.geeksforgeeks.org/job-sequencing-problem/
public class JobSequencingProblem {
    static class Job implements Comparable<Job> {
        char id;
        int deadline;
        int profit;

        Job(char id, int d, int p) {
            this.id = id;
            this.deadline = d;
            this.profit = p;
        }

        @Override
        public int compareTo(Job o) {
            if(this.profit < o.profit) {
                return 1;
            }
            return -1;
        }
    }

    static void printJobScheduling(Job[] arr) {
        // To store result (Sequence of jobs)
        int[] result = new int[arr.length];
        // To keep track of free time slots
        boolean[] slot = new boolean[arr.length];

        Arrays.sort(arr);

        for(int i = 0; i < arr.length; i++) {
            // Find a free slot for this job  (Note that we start from the last possible slot)
            for(int j = Math.min(arr.length, arr[i].deadline) - 1; j >= 0; j--) {
                // free slot found
                if(!slot[j]) {
                    result[j] = i;  // Add this job to result
                    slot[j] = true; // Make this slot occupied
                    break;
                }
            }
        }

        for(int i = 0; i < arr.length; i++) {
            if(slot[i]) {
                System.out.print(arr[result[i]].id + " ");
            }
        }
    }

    public static void main(String[] args) {
        Job[] arr = {
                new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)
        };

        printJobScheduling(arr);
    }
}
