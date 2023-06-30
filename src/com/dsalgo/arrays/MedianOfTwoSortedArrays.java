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
            System.out.println(findMedianSortedArrays1(nums1[i], nums2[i]));
            System.out.println();
        }

    }

    /**
     * Bruteforce:
     * 1. Create an array/AL temp of size (n1 + n2)
     * 2. Merge these two arrays into new array/AL using merge sort's merge algo
     * 3. Check length of merged array. If (n1 + n2) is odd, return the middle element. Else return
     * the average of middle two elements
     *
     * TC: O(n1 + n2)
     * SC: O(n1 + n2)
     *
     * @param nums1
     * @param nums2
     * @return
     */
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

        if(merged.size() % 2 == 0){
//            System.out.println(merged.get(index) + " " + merged.get(index + 1));
            median = (double) (merged.get(index) + merged.get(index + 1)) / 2;
        } else {
            median = merged.get(index);
        }
        return median;
    }

    /**
     * Using Binary Search: The given two arrays are sorted, so we can utilize the ability of
     * Binary Search to divide the array and find the median. Median means the point at which
     * the whole array is divided into two parts. Hence since the two arrays are not merged so
     * to get the median we require merging which is costly. Hence instead of merging, we will
     * use a modified binary search algorithm to efficiently find the median.
     *
     * 1. If we would have merged the two arrays, the median is the point that will divide
     * the sorted merged array into two equal parts. So the actual median point in the merged
     * array would have been (M+N+1)/2;
     * 2. We divide A[] and B[] into two parts. We will find the mid value and divide the
     * first array A[] into two parts and simultaneously choose only those elements from left
     * of B[] array such that the sum of the count of elements in the left part of both A[] and
     * B[] will result in the left part of the merged array.
     * 3. Now we have 4 variables indicating four values two from array A[] and two from array B[].
     * leftA -> Rightmost element in left part of A.
     * leftb -> Rightmost element in left part of B
     * rightA -> Leftmost element in right part of A
     * rightB -> Leftmost element in right part of B
     * 4. Hence to confirm that the partition was correct we have to check if leftA<=rightB
     * and leftB<=rightA. This is the case when the sum of two parts of A and B results in the
     * left part of the merged array.
     *      a. If the condition fails we have to find another midpoint in A and then left part in B[].
     *      b. If we find leftA > rightB. means we have to decrease the size of A’s partition
     *      and shift to lesser value in A[].
     *      c. So update the right pointer of to mid-1 else we will increase the left pointer
     *      to mid+1.
     *      d. Repeat the above steps with new partitions till we get the answers.
     * 5. If leftA ≤ rightB and leftB ≤ rightA, then we get the correct partition and our answer
     * depends on the total size of the merged array (i.e. M+N). If (M+N) is even we take
     * max(leftA, leftB) and min(rightA, rightB), add them and divide by 2 to get our answer,
     * else we will just return the maximum of leftA and leftB.
     *
     * TC: O(min(log n1, log n2))
     * SC: O(1)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        double median = 0.0d;
        int n1 = nums1.length, n2 = nums2.length;
        int begin1 = 0, end1 = nums1.length;

        while (begin1 <= end1) {
            int i1 = (begin1 + end1) / 2;
            int i2 = ((n1 + n2 + 1) / 2) - i1;

            int min1 = (i1 == n1) ? Integer.MAX_VALUE : nums1[i1];
            int max1 = (i1 == 0) ? Integer.MIN_VALUE : nums1[i1 - 1];

            int min2 = (i2 == n2) ? Integer.MAX_VALUE : nums2[i2];
            int max2 = (i2 == 0) ? Integer.MIN_VALUE : nums2[i2 - 1];

            if(max1 <= min2 && max2 <= min1) {
                if((n1 + n2) % 2 == 0) {
                    return  ((double) Math.max(max1, max2) + Math.min(min1, min2)) / 2;
                } else {
                    return   (double) (Math.max(max1, max2));
                }
            }
            else if(max1 > max2) {
                end1 = i1 - 1;
            } else {
                begin1 = i1 + 1;
            }
        }
        return median;
    }
}
