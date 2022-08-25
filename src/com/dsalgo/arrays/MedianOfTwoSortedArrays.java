package com.dsalgo.arrays;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[][] nums1 = {{1, 3}, {1, 2}};
        int[][] nums2 = {{2}, {3, 4}};
        for(int i = 0; i < nums1.length; i++){
            System.out.println(findMedianSortedArrays(nums1[i], nums2[i]));
        }

    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double median = 0d;
        List<Integer> merged = new ArrayList<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0, j = 0;
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                merged.add(nums1[i]);
                i++;
            }
            else {
                merged.add(nums2[j]);
                j++;
            }
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            merged.add(nums1[i]);
            i++;
        }

            /* Copy remaining elements of R[] if any */
        while (j < n2) {
            merged.add(nums2[j]);
            j++;
        }
        int index = (merged.size() - 1) / 2;
        System.out.println(index);
        System.out.println(merged);
        if(merged.size() % 2 == 0){
            System.out.println(merged.get(index) + " " + merged.get(index + 1));
            median = (double) (merged.get(index) + merged.get(index + 1)) / 2;
        } else {
            median = merged.get(index);
        }
        return median;
    }
}
