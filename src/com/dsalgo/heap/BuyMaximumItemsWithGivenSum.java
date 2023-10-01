package com.dsalgo.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class BuyMaximumItemsWithGivenSum {


    public static void main(String[] args) {
        int[] cost = {1, 12, 5, 111, 200};

        int sum = 10;

        System.out.println(maxItems(cost, sum));
        System.out.println(maxItems1(cost, sum));

    }

    /**
     * Using priority queue: Insert all the elements of the given array in a priority_queue now
     * one by one remove elements from this priority queue and add these costs in a variable sum
     * initialised to 0. Keep removing the elements while the new addition keep the sum smaller
     * than K. In the end, the count of elements removed will be the required answer.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param cost
     * @param sum
     * @return
     */
    private static int maxItems1(int[] cost, int sum) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : cost) {
            pq.offer(i);
        }

        int max = 0;

        while (!pq.isEmpty() && pq.peek() <= sum) {
            sum -= pq.poll();
            max++;
        }
        return max;
    }

    /**
     * Using sorting: Sort the array and one by one check if sum - i is greater than 0.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param cost
     * @param sum
     * @return
     */
    private static int maxItems(int[] cost, int sum) {
        Arrays.sort(cost);
        int max = 0;
        for(int i : cost) {
            if(sum - i > 0)
            {
                max++;
                sum = sum - i;
            }
        }
        return max;
    }
}
