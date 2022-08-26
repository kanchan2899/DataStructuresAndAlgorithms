package com.dsalgo.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/
public class FindNUniqueIntegersSumUptoZero {
    public static void main(String[] args) {
        int[] n = {6, 10, 2, 1, 5};
        for(int x : n) {
            System.out.println(Arrays.toString(sumZero(x)));
        }
    }
    public static int[] sumZero(int n) {
        int[] arr = new int[n];
        int value = n;
        for(int i = 0; i < arr.length/2; i++){
            arr[i] = value;
            arr[n-i-1] = -value;
            value--;
        }
        return arr;
    }
}
