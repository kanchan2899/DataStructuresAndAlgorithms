package com.dsalgo.grokking.patterns.two.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/maximum-amount-of-capital-required-for-selecting-at-most-k-projects/
public class MaximizeCapital {

    public static void main(String[] args) {
        int c = 2;
        int k = 3;
        int[] capitals = {1, 3, 4, 5, 6};
        int[] profits = {1, 2, 3, 4, 5};
        System.out.println(maximumCapital(capitals, profits, c, k));
    }

    private static int maximumCapital(int[] capitals, int[] profits, int c, int k) {
        PriorityQueue<int[]> capitalMinHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> profitsMaxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int currentCapital = c;
        int n = capitals.length;
        int i = 0;

        // inset all capital values in the min heap
        for (i = 0; i < n; i++) {
            capitalMinHeap.offer(new int[] {capitals[i], i});
        }

        // calculate capital of all the required number of projects containing maximum profits
        i = 0;
        while (i < k) {
            // select projects (in the range of current capital) then push them onto the max-heap
            while (!capitalMinHeap.isEmpty() && capitalMinHeap.peek()[0] <= currentCapital) {
                int[] j = capitalMinHeap.poll();
                profitsMaxHeap.offer(new int[]{profits[j[1]]});
            }

            // check if the max-heap is empty
            if(profitsMaxHeap.isEmpty()) {
                break;
            }

            // select those projects from the max-heap that contain the maximum profit
            int x = profitsMaxHeap.poll()[0];
            currentCapital += x;
            i++;
        }
        return currentCapital;
    }
}
