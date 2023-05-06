package com.dsalgo.bit.manipulation;

// https://leetcode.com/problems/single-number-ii/
public class SingleNumberII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 3};
        System.out.println(singleNumber(nums));
        System.out.println(singleNumber1(nums));
        System.out.println(singleNumber2(nums, 2));
    }

    /**
     * This approach counts the number of set bits at every bit position from 0 to 32.
     * If the (sum % i) != 0, then set that bit in the answer. Iterate for all 32 bits as int takes
     * 32 bits in Java
     *
     * Time complexity: O(32 * n)
     */
    private static int singleNumber2(int[] nums, int i) {
        int answer = 0;
        for(int bit = 0; bit < 32; bit++){
            int sumAtEveryBitPlace = 0;
            for(int curr: nums){
                if((curr >> bit & 1) == 1) {
                    sumAtEveryBitPlace++;
                    sumAtEveryBitPlace %= i;
                }
            }
            if(sumAtEveryBitPlace != 0) {
                answer |= sumAtEveryBitPlace << bit;

            }
        }
        return answer;
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
