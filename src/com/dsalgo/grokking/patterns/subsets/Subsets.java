package com.dsalgo.grokking.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6};
        System.out.println(findAllSubsets(arr));
    }

    private static List<List<Integer>> findAllSubsets(int[] arr) {
        List<List<Integer>> subsets = new ArrayList<>();

        if(arr.length != 0) {
            // finds number of subsets by taking power of length of input array
            int subsetsCount = (int) Math.pow(2, arr.length);

            for(int i = 0; i < subsetsCount; i++) {
                // set is created to store each subset
                List<Integer> subset = new ArrayList<>();

                for(int j = 0; j < arr.length; j++) {
                    // if a specified bit is 1, choose that number from the original set and
                    // add it to the current subset
                    if(getBit(i, j) == 1) {
                        int x = arr[j];
                        subset.add(x);
                    }
                }
                subsets.add(subset);
            }
        } else {
            List<Integer> emptySubset = new ArrayList<>();
            subsets.add(emptySubset);
        }

        return subsets;
    }

    static int getBit(int num, int bit) {
        // shifting the first operand the specified number of bits to the left
        int temp = (1 << bit);

        // if binary number and current subset count are equal, return 1 else 0
        temp = temp & num;

        if(temp == 0) {
            return 0;
        }
        return 1;
    }
}
