package com.dsalgo.hashing;

import java.util.Arrays;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 9, 3, 2, 4, 20},
                {8, 20, 7, 30},
                {20, 30, 40}
        };

        for(int[] a : arr) {
            System.out.println(longestConsecutiveSubsequence1(a));
            System.out.println("***************");
        }
    }

    private static int longestConsecutiveSubsequence1(int[] a) {
        int longestConsecutiveSequenceLength = 0;
        Arrays.sort(a);
        int currentConsecutiveSequenceLength = 1;

        for(int i = 1; i < a.length; i++) {
            if(a[i] == a[i-1] + 1) {
                currentConsecutiveSequenceLength++;
            } else {
                longestConsecutiveSequenceLength = Math.max(longestConsecutiveSequenceLength, currentConsecutiveSequenceLength);
                currentConsecutiveSequenceLength = 1;
            }
        }
        return Math.max(longestConsecutiveSequenceLength, currentConsecutiveSequenceLength);
    }
}
