package com.dsalgo.sort.cycle;


import java.util.ArrayList;

// https://www.geeksforgeeks.org/minimum-number-swaps-required-sort-array/
public class CountMinimumNumberOfSwaps {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1, 5, 7, 6};
        System.out.println(minimumSwaps(arr, arr.length));
    }

    /**
     * Using cycles: This problem can be viewed as graphs. We will have N nodes and an edge directed
     * from node i to node j if the element at at the ith index must be present at the jth index in
     * the sorted array. The graph will now contain many non-intersecting cycles. Now a cycle with 2
     * nodes will only require 1 swap to reach the correct ordering, similarly a cycle with 3 nodes
     * will only require 2 swaps to do so.
     * Therefore, ans = Σi = 1^k * (cycle_size – 1), where k is the number of cycles
     *
     * Steps:
     * 1. Create an array of pairs arrPos to store the input array elements along with their index
     * 2. Sort arrPos and run a loop for i [0, N]
     *      a. If the current element is already visited or it is at its correct position then
     *      continue
     *      b. else calculate the cycle size from the current element using a while loop
     *      c. Declare an integer j equal to i and in the while loop set j equal to the index of
     *      arrPos[j] and increase cycle size while the element at jth position is not visited.
     * 3. Increase the answer by the size of the current_cycle - 1
     * 4. Return answer
     *
     * @param arr
     * @param n
     * @return
     */
    private static int minimumSwaps(int[] arr, int n) {
        return 0;
    }
}
