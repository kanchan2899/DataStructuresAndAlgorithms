package com.dsalgo.arrays;

// Given an array that has numbers in pairs (n, -n) except one number. Find that number.
public class FindUniqueElement {
    public static void main(String[] args) {
        int[] arr = {5, -2, 2, -3, 3, -5, -4};
        System.out.println(findUnique(arr));
    }

    private static int findUnique(int[] arr) {
        int num = 0;
        for(int ele : arr) {
            num += ele;
        }
        return num;
    }
}
