package com.dsalgo.dynamic.programming;

import java.util.Arrays;

// https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class MinimumNumberOfJumpsToReachEnd {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr, 0, arr.length - 1));
        System.out.println(minJumps1(arr));
        System.out.println(minJumps2(arr));
    }

    /**
     * Using DP - Tabulation:
     *
     * 1. Create jumps[] array from left to right such that jumps[i] indicate the minimum number
     * of jumps needed to reach arr[i] from arr[0].
     * 2. To fill the jumps array run a nested loop inner loop counter is j and the outer loop
     * count is i.
     *      a. Outer loop from 1 to n-1 and inner loop from 0 to i.
     *      b. If i is less than j + arr[j] then set jumps[i] to minimum of jumps[i] and jumps[j] + 1.
     *      initially set jump[i] to INT MAX
     * 3. Return jumps[n-1].
     *
     * TC: I(n ^ 2)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int minJumps2(int[] arr) {
        int[] jumps = new int[arr.length];
        int i, j;

        // if first element is 0 or array is empty
        if(arr.length == 0 || arr[0] == 0) {
            return Integer.MAX_VALUE;
        }

        jumps[0] = 0;

        // find the minimum number of jumps to reach arr[i] from arr[0] and assign this value to jump[i]
        for(i = 1; i < arr.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for(j = 0; j < i; j++) {
                if(i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[arr.length - 1];
    }

    /**
     * Using DP - memoization:
     *
     * 1. Create memo[] such that memo[i] indicates the minimum number of jumps needed to reach
     * memo[n-1] from memo[i] to store previously solved subproblems.
     * 2. During the recursion call, if the same state is called more than once, then we can
     * directly return the answer stored for that state instead of calculating again.
     * 3. Otherwise, In each recursive call get all the reachable nodes from that index.
     *      a. For each of the index call the recursive function.
     *      b. Find the minimum number of jumps to reach the end from current index.
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int minJumps1(int[] arr) {
        int[] mem = new int[arr.length];
        Arrays.fill(mem, -1);
        return helper(arr, 0, arr.length - 1, mem);
    }

    private static int helper(int[] arr, int index, int end, int[] mem) {
        // we reached the end, no jumps to make further
        if(index == end) {
            return 0;
        }

        if(mem[index] != -1) {
            return mem[index];
        }

        int minJumps = Integer.MAX_VALUE - 1;

        // We will try to make all possible jumps from the current index and select the minimum of those.
        for(int j = arr[index]; j >= 1; --j) {
            // if we make this jump 'j' distance away from index, do we overshoot?
            // If we land within the arr, we will test further
            if(index + j <= end) {
                // make a jump to (index + j) index and explore further, then update minJumps with
                // the minimum jumps we made to reach the end while trying all possible arr[index]
                // jumps from the current index

                minJumps = Math.min(minJumps, 1 + helper(arr, index + j, end, mem));
            }
        }

        return mem[index] = minJumps;
    }


    /**
     * Using recursion: Start from the first element and recursively call for all the elements
     * reachable from the first element. The minimum number of jumps to reach end from first can
     * be calculated using the minimum value from the recursive calls.
     *
     * minJumps(start, end) = 1 + Min(minJumps(k, end)) for all k reachable from start.
     *
     * 1. Create a recursive function.
     * 2. In each recursive call get all the reachable nodes from that index.
     *      a. For each of the index call the recursive function.
     *      b. Find the minimum number of jumps to reach the end from current index.
     * 3. Return the minimum number of jumps from the recursive call.
     *
     * TC: O(n ^ n)
     * SC: O(n)
     *
     * @param arr
     * @param l
     * @param h
     * @return
     */
    private static int minJumps(int[] arr, int l, int h) {
        // when source and destination are same
        if(h == l) {
            return 0;
        }

        // when nothing is reachable from the given source
        if(arr[l] == 0) {
            return Integer.MAX_VALUE;
        }

        // Traverse through all the points reachable from arr[l]. Recursively get the minimum
        // number of jumps needed to reach arr[h] from these reachable points
        int min = Integer.MAX_VALUE;

        for(int i = l + 1; i <= h && i <= l + arr[l]; i++) {
            int jumps = minJumps(arr, i, h);
            if(jumps != Integer.MAX_VALUE && jumps + 1 < min) {
                min = jumps + 1;
            }
        }
        return min;
    }


}
