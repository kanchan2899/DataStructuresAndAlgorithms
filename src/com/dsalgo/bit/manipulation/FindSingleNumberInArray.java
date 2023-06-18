package com.dsalgo.bit.manipulation;

// https://leetcode.com/problems/single-element-in-a-sorted-array/
public class FindSingleNumberInArray {
    public static void main(String[] args) {
        int[][] arr = {{2, 1, 1, 2, 4, 4, 3, 3, 10, 5, 5, 6, 8, 6, 8},
                       {4, 3, 4, 4, 4, 5, 5},
                       {8, 7, 7, 8, 8}};
        for(int[] a: arr) {
            System.out.println("Using XOR: " + singleElement(a));
            System.out.println("Using Bruteforce: " + singleElement1(a));
        }

    }

    private static int singleElement1(int[] a) {
        int singleElement = -1;
        for(int i = 0; i < a.length; i++) {
            int count = 0;
            for(int j = 0; j < a.length; j++) {
                if(a[i] == a[j]) {
                    count++;
                }
            }
            if(count % 2 != 0) {
                singleElement = a[i];
            }
        }
        return singleElement;
    }

    /**
     * Using XOR: The property of XOR states that if the bits are same, result is 0, otherwise it is 1
     * If a number appear 2 * x times in the array, then its XOR would be 0 always.
     * If a number appears only once, it will remain the same.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static int singleElement(int[] arr) {
        int num = 0;
        for(int ele : arr) {
            num = num ^ ele;
        }
        return num;
    }
}
