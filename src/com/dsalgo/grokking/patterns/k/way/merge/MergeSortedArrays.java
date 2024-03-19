package com.dsalgo.grokking.patterns.k.way.merge;


import java.util.Arrays;

// https://www.geeksforgeeks.org/merge-two-sorted-arrays/
public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {3, 6, 7, 8, 10, 12, 14, 0, 0, 0, 0};
        int[] nums2 = {1, 2, 5, 6};
        System.out.println(Arrays.toString(mergeSorted(nums1, 7, nums2, nums2.length)));
    }

    private static int[] mergeSorted(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;

        for(int p = m + n - 1; p >= 0; p--) {
            if(p2 < 0) {
                break;
            }

            if(p1 >= 0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1 -= 1;
            } else {
                nums1[p] = nums2[p2];
                p2 -= 1;
            }
        }

        return nums1;
    }
}
