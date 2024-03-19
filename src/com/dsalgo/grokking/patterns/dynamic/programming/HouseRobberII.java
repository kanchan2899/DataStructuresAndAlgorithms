package com.dsalgo.grokking.patterns.dynamic.programming;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode.com/problems/house-robber-ii/description/
public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }

    private static int rob(int[] money) {
        // check if the input array is null or empty
        if(money == null || money.length == 0) {
            return 0;
        }

        // if the input array has only one element, return the element
        if(money.length == 1) {
            return money[0];
        }

        // return the maximum value from calling the helper function on the input array minus
        // the last element and the input array minus the first element
        return Math.max(helper(Arrays.copyOfRange(money, 0, money.length - 1)
        ), helper(Arrays.copyOfRange(money, 1, money.length)));
    }

    private static int helper(int[] money) {
        // create a lookup array with the same length as the input array, filled with 0s
        int[] lookupArray = new int[money.length + 1];
        lookupArray[0] = 0;
        lookupArray[1] = money[0];

        // iterate through the input array starting from the second element
        for(int i = 2; i <= money.length; i++) {
            // update the lookup array at each index with the maximum element
            // between the current element in the input array plus the previous
            // element in the lookup array and the current element in the lookup array
            lookupArray[i] = Math.max(money[i - 1] + lookupArray[i - 2], lookupArray[i - 1]);
        }
        return lookupArray[money.length];
    }
}
