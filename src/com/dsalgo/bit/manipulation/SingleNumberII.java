package com.dsalgo.bit.manipulation;

// https://leetcode.com/problems/single-number-ii/
public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 1};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber1(nums));
        System.out.println(singleNumber2(nums));
    }

    private static int singleNumber2(int[] nums) {
        int ans = 0, shift = 1;
        for(int i = 0; i < 32; i++){
            int count = 0;
            for(int curr: nums){
                if((curr & shift) != 0) {
                    count++;
                }
            }
            if(count % 3 != 0){
                ans += shift;
            }
            shift = shift << 1;
        }
        return ans;
    }

    private static int singleNumber1(int[] nums) {
        int ones = 0;
        int twos = 0;
        for(int n : nums){
            ones = (ones ^ n) & (~twos);
            twos = (twos ^ n) & (~ones);
        }
        return ones;
    }

    private static int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int common_bits_mask;

        for (int i = 0; i < nums.length; i++){
            twos = twos | (ones & nums[i]);
            ones = ones ^ nums[i];
            common_bits_mask = ~(ones & twos);
            ones &= common_bits_mask;
            twos &= common_bits_mask;
        }
        return ones;
    }
}
