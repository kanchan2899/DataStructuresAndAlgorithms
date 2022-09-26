package com.dsalgo.bit.manipulation;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class FindSingleNumberInArray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2, 4, 4, 3, 3, 10, 5, 5, 6, 8, 6, 8};
        System.out.println(singleElement(arr));
    }

    private static int singleElement(int[] arr) {
        int num = 0;
        for(int ele : arr) {
            num = num ^ ele;
        }
        return num;
    }
}
