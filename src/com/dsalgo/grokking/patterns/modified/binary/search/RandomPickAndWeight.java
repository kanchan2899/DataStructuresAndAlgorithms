package com.dsalgo.grokking.patterns.modified.binary.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// https://leetcode.com/problems/random-pick-with-weight/
public class RandomPickAndWeight {
    private List<Integer> runningSums;
    private int totalSum;

    public RandomPickAndWeight(int[] weights) {
        // list to store running sums of weights
        runningSums = new ArrayList<>();

        // variable to calculate running sum
        int runningSum = 0;

        // iterate through the given weights
        for(int w : weights) {
            // adding the current weight to the running sum
            runningSum += w;

            // append the running sum to the runningSums list
            runningSums.add(runningSum);

        }

        // store the total sum of weights
        totalSum = runningSum;
    }

    // method to pick an index on the weights
    public int pickIndex() {
        // generate a random number between 1 and the total sum of the array
        Random random = new Random();

        int target = random.nextInt(totalSum) + 1;

        // initialize low and high variables for binary search
        int low = 0;
        int high = runningSums.size();

        // perform the binary search to find the value higher than the target
        while (low < high) {
            int mid = low + (high - low) / 2;
            if(target > runningSums.get(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        // return the index of low found
        return low;
    }

    private static int sum(int[] arr) {
        int total = 0;

        for(int num: arr) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        int counter = 10;
        int[] arr = {1, 12, 23, 34, 45, 56, 67, 78, 89, 90};

        RandomPickAndWeight randomPickAndWeight = new RandomPickAndWeight(arr);

        for(int i = 0; i < counter; i++) {
            int index = randomPickAndWeight.pickIndex();
            System.out.println(index);
        }
    }
}
