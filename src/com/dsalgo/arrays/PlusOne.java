package com.dsalgo.arrays;

// https://leetcode.com/problems/plus-one/

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        int nums[][] = {{1, 4, 9},
                        {9, 9, 9},
                        {1, 2, 3}};
        System.out.println(Arrays.toString(plusOne(nums[0])));
        System.out.println(Arrays.toString(plusOne(nums[1])));
        System.out.println(Arrays.toString(plusOne(nums[2])));
    }
    public static int[] plusOne(int[] digits) {
        boolean carry = false;
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] < 9){
                digits[i] = digits[i] + 1;
                carry = false;
                break;
            } else {
                digits[i] = 0;
                carry = true;
                continue;
            }
        }
        if(digits[0] == 0 && carry){
            int[] digits1 = Arrays.copyOf(digits, digits.length + 1);
            digits1[0] = 1;
            return digits1;
        }
        return digits;
    }
}
