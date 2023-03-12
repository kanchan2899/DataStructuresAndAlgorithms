package com.dsalgo.hashing;

import java.util.HashMap;

public class LongestCommonSpanWithSameSumInTwoBinaryArrays {
    public static void main(String[] args) {
        int[][] a = {
                {0, 1, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 1}
        };
        int[][] b = {
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 1}
        };

        for(int i = 0; i < a.length; i++) {
            System.out.println(longestCommonSpanWithSameSum1(a[i], b[i]));
            System.out.println(longestCommonSpanWithSameSum3(a[i], b[i]));
            System.out.println("*********************");
        }
    }


    /**
     * Using Bruteforce: Initialize longest_span_length to 0.
     * Start a loop i from 0 to n - 1 and initialize count_a and count_b to 0
     * Start another loop j from i to n - 1
     * Add a[j] to count_a and b[j] to count_b
     * If count_a == count_b and longest_span_length < j - i + 1, we found one of the longest common span
     * assign j - i + 1 to longest_span_length.
     * Return longest_span_length
     *
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param a binary array
     * @param b binary array
     * @return the length of the longest common span with same sum in two binary arrays
     */
    private static int longestCommonSpanWithSameSum1(int[] a, int[] b) {

        int longest_span_length = 0;
        for(int i = 0; i < a.length; i++) {
            int count_a = 0;
            int count_b = 0;
            for(int j = i ; j < a.length; j++) {
                count_a += a[j];
                count_b += b[j];

                if(count_a == count_b && longest_span_length < j - i + 1) {
                    longest_span_length = j - i + 1;
                }
            }
        }
        return longest_span_length;
    }


    /**
     * Using HashMap - Convert the problem into finding the longest subarray with sum = 0 by subtracting one array
     * from  another. You will get an array with elements 0s, -1s and 1s. Find the longest subaray with sum = 0.
     *
     * Intiialize longest_subarray_length and prefix_sum to 0.
     * Add a[i] to prefix_sum. If prefix_sum == 0 and i + 1 > longest_subarray_length, assign i + 1 to
     * longest_subarray_length.
     * If countMap doesn't contain prefix_sum - sum (here sum = 0), add prefix_sum and index to the map.
     * If countMap contains prefix_sum, check maximum between longest_subarray_length and i - prefix_sum index.
     * return longest_subarray_length.
     * @param a
     * @param b
     * @return
     */
    private static int longestCommonSpanWithSameSum3(int[] a, int[] b) {
        int longest_span_length = 0;
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int[] temp = new int[a.length];
        int prefix_sum = 0;
        for(int i = 0; i < a.length; i++) {
            temp[i] = a[i] - b[i];
        }
        for(int i = 0; i < a.length; i++) {
            prefix_sum += temp[i];

            if(prefix_sum == 0 && longest_span_length < i + 1) {
                longest_span_length = i + 1;
            }

            if(!countMap.containsKey(prefix_sum)) {
                countMap.put(prefix_sum, i);
            }

            if(countMap.containsKey(prefix_sum)) {
                longest_span_length = Math.max(longest_span_length, i - countMap.get(prefix_sum));
            }
        }

        return longest_span_length;
    }
}
