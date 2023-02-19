package com.dsalgo.hashing;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSubarrayWithEqual0s1s {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 1, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1}
        };
        for(int[] a: arr) {
            System.out.println("Using Bruteforce: " + longestSubarrayWithEqual0aAnd1s_1(a));
            System.out.println("Using HashMap: " + longestSubarrayWithEqual0aAnd1s_2(a));
            System.out.println("**********************");
        }
    }

    /**
     * Using Bruteforce: Initialize longest_subarray_length to 0.
     * Start a loop i from 0 to n - 1 and initialize count_0 and count_1 to 0.
     * Start another loop j from i to n - 1
     * If a[j] == 0, increment count_0. If a[j] == 1, increment count_1.
     * IF count_0 == count_1 and longest_subarray_length < (j - i + 1),
     * longest_subarray_length = j - i + 1
     * return longest_subarray_length
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param a array that contains 0s and 1s only
     * @return the longest length of subarray with equal number of 1s and 0s
     */
    private static int longestSubarrayWithEqual0aAnd1s_1(int[] a) {
        int longest_subarray_length = 0;
        for(int i = 0; i < a.length; i++) {
            int count_0 = 0;
            int count_1 = 0;
            for(int j = i ; j < a.length; j++){
                if(a[j] == 0)
                    count_0++;
                if(a[j] == 1)
                    count_1++;

                if(count_0 == count_1 && longest_subarray_length < (j - i + 1)) {
                    longest_subarray_length = j - i + 1;
                }
            }
        }
        return longest_subarray_length;
    }

    /**
     * Using HashMap: Convert the problem into finding the longest subarray with sum = 0 by replacing 0s with -1.
     * Intiialize longest_subarray_length and prefix_sum to 0.
     * Add a[i] to prefix_sum. If prefix_sum == 0 and i + 1 > longest_subarray_length, assign i + 1 to
     * longest_subarray_length.
     * If countMap doesn't contain prefix_sum - sum (here sum = 0), add prefix_sum and index to the map.
     * If countMap contains prefix_sum, check maximum between longest_subarray_length and i - prefix_sum index.
     * return longest_subarray_length.
     *
     * Time complexity - O(n)
     * Space complexity - O(n)
     *
     * @param a
     * @return the longest subarray length with equal number of 0s and 1s.
     */
    private static int longestSubarrayWithEqual0aAnd1s_2(int[] a) {
        int longest_subarray_length = 0;
        int prefix_sum = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0; i < a.length; i++) {
            if(a[i] == 0) {
                a[i] = -1;
            }

            prefix_sum += a[i];
            if(prefix_sum == 0 && (i + 1 > longest_subarray_length)) {
                longest_subarray_length = (i + 1);
            }

            if(!countMap.containsKey(prefix_sum)) {
                countMap.put(prefix_sum, i);
            }

            if(countMap.containsKey(prefix_sum)) {
                longest_subarray_length = Math.max(longest_subarray_length, i - countMap.get(prefix_sum));
            }
        }

        return longest_subarray_length;
    }
}
