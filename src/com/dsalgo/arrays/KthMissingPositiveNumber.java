package com.dsalgo.arrays;

// https://leetcode.com/problems/kth-missing-positive-number/
public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }
    public static int findKthPositive(int[] arr, int k) {
        int count = 1;
        int c = 0;
        int i = 0;
        while(count <= arr[arr.length - 1]){
            if(count != arr[i]){
                c = count;
                k--;
                if(k == 0){
                    break;
                }
            } else {
                i++;
            }
            count++;
        }
        if(k != 0){
            return arr[i - 1] + k;
        }
        return c;
    }
}
