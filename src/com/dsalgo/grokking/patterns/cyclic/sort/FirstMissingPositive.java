package com.dsalgo.grokking.patterns.cyclic.sort;

// https://leetcode.com/problems/first-missing-positive/
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] arr = {3,4,-1,1};
        System.out.println(firstMissingPositiveNumber(arr));
    }

    private static int firstMissingPositiveNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIndex = arr[i] - 1;
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[correctIndex]) {
                int temp = arr[i];
                arr[i] = arr[correctIndex];
                arr[correctIndex] = temp;
            } else {
                i++;
            }
        }
        int j;

        for(j = 0; j < arr.length; j++) {
            if(arr[j] != j + 1) {
                return j + 1;
            }
        }

        return arr.length + 1;
    }
}
