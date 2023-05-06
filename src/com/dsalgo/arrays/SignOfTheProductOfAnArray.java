package com.dsalgo.arrays;

public class SignOfTheProductOfAnArray {
    public static void main(String[] args) {
        int[] nums = {-1,1,-1,1,-1};
        System.out.println(arraySign(nums));
    }

    public static int arraySign(int[] nums) {
        int product = 1;
        for(int n : nums) {
            if(n < 0)
                product *= -1;
            else if(n > 0)
                product *= 1;
            else {
                product *= 0;
                return product;
            }
        }
        return product;
    }
}
