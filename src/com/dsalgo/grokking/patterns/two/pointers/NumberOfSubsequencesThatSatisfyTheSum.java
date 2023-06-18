package com.dsalgo.grokking.patterns.two.pointers;

import java.util.Arrays;

// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
public class NumberOfSubsequencesThatSatisfyTheSum {
    public static void main(String[] args) {
        int[] nums = {2,3,3,4,6,7};
        int target = 12;
        System.out.println(numSubseq(nums, target));
    }


    /**
     * Two pointer approach:
     *  1. Sort the array
     *  2. Initialize two pointers, l and r, to the first and last elements of the sorted array
     *  3. Initialize count to 0 to store the number of subsequences
     *  4. Compute the array, power, such that power[i] stores 2^i modulo 1000000007
     *  5. Iterate while l is less than or equal to r
     *  6. If the sum of elements pointed by l and r is less than or equal to target, then we can
     *  include all the subsequences that can be formed with these two elements and any elements
     *  between them. Add the number of subsequences to count. This number is given by power[r - l]
     *  and increment l
     *  7. If sum of elements pointed by l and r is greater than target, then decrement r
     *  8. Return count modulo 1000000007
     *
     *  TC: O(n * log n)
     *  SC: O(n)
     *
     * @param nums
     * @param target
     * @return number of subsequences of nums such that the sum of the minimum and
     * maximum element on it is less than or equal to target.
     */
    public static int numSubseq(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mod = (int)Math.pow(10, 9) + 7;
        int count = 0;
        int[] power = new int[nums.length];
        power[0] = 1;
        for(int i = 1; i < power.length; i++) {
            power[i] = (power[i - 1] * 2) % mod;
        }
        Arrays.sort(nums);
        while (l <= r) {
            if(nums[l] + nums[r] > target) {
                r--;
            } else {
                count = (count + power[r - l]) % mod;
                l++;
            }
        }
        return count;
    }
}
