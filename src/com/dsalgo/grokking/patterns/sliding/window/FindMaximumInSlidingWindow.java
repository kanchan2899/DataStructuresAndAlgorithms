package com.dsalgo.grokking.patterns.sliding.window;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.stream.Stream;

// https://leetcode.com/problems/sliding-window-maximum/
public class FindMaximumInSlidingWindow {
    public static void main(String[] args) {
        int windowSizes [] = {3, 3, 3, 3, 2, 4, 3, 2, 3, 18};
        int [][] numLists = {
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {10, 9, 8, 7, 6, 5, 4, 3, 2, 1},
                {10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                {1, 5, 8, 10, 10, 10, 12, 14, 15, 19, 19, 19, 17, 14, 13, 12, 12, 12, 14, 18, 22, 26, 26, 26, 28, 29, 30},
                {10, 6, 9, -3, 23, -1, 34, 56, 67, -1, -4, -8, -2, 9, 10, 34, 67},
                {4, 5, 6, 1, 2, 3},
                {9, 5, 3, 1, 6, 3},
                {2, 4, 6, 8, 10, 12, 14, 16},
                {-1, -1, -2, -4, -6, -7},
                {4, 4, 4, 4, 4, 4}
        };
        for (int i = 0; i < numLists.length; i++) {
            System.out.println(i + 1 + ".\tInput array:\t" + Arrays.toString(numLists[i]));
            System.out.println("\tWindow size:\t" + windowSizes[i]);
            System.out.println("\n\tMaximum in each sliding window:\t" + Arrays.toString(findMaxSlidingWindow(numLists[i], windowSizes[i])));
            Stream.generate(() -> "-").limit(100).forEach(System.out::print);
            System.out.println();
        }
    }

    private static int[] findMaxSlidingWindow(int[] nums, int k) {
        // if the input array is empty, return an empty array
        if(nums.length == 0) {
            return new int[0];
        }

        // if the window size is greater than the array size, set the window size to the array size
        if(k > nums.length) {
            k = nums.length;
        }

        // initialize variables
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> currentWindow = new ArrayDeque<>();

        System.out.println("\n\tFinding the maximum in the first window");

        // iterate over the first k elements
        for(int i = 0; i < k; i++) {
            // for every element, remove the previous smaller elements from currentWindow
            currentWindow = cleanUp(i, currentWindow, nums);

            // append the index of the current element to currentWindow
            currentWindow.add(i);
        }


        // appending the maximum element of the current window to the output list
        output[0] = nums[currentWindow.getFirst()];

        // iterate over the remaining input list
        for(int i = k; i < nums.length; i++) {
            // for every element, remove the previous smaller elements from currentWindow
            cleanUp(i, currentWindow, nums);

            // remove first index from the currentWindow if it has fallen out the current window
            if(!currentWindow.isEmpty() && currentWindow.getFirst() <= (i - k)) {
                System.out.println("Index " + currentWindow.getFirst() + " has fallen out of the current window");
                currentWindow.removeFirst();
            }

            // append the index of the current element to currentWindow
            currentWindow.add(i);
            output[i - k + 1] = nums[currentWindow.getFirst()];
        }
        return output;
    }

    private static Deque<Integer> cleanUp(int i, Deque<Integer> currentWindow, int[] nums) {
        // remove all the indexes from currentWindow whose corresponding values are smaller than or equal
        // to the current element
        while (currentWindow.size() != 0 && nums[i] >= nums[currentWindow.getLast()]) {
            currentWindow.removeLast();
        }

        // return the altered window
        return currentWindow;
    }
}
