package com.dsalgo.search.binary;

import java.util.Arrays;
import java.util.Scanner;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/
public class FirstLastOccurrenceOfNumber {
    public static void main(String[] args) {
        int[] arr = {5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 10, 10, 10};
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println("First occurence of " + num + " in the array is " + Arrays.toString(firstLastOccurrence(arr, num)));
    }

    private static int[] firstLastOccurrence(int[] arr, int target) {
        int[] ans = new int[2];
        int start = search(arr, target, true);
        int end = search(arr, target, false);
        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    // This function returns the index value of target
    static int search(int[] nums, int target, boolean findStartIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(target < nums[mid]) end = mid - 1;
            else if(target > nums[mid]) start = mid - 1;
            else {
                // potential answer found
                ans = mid;
                if(findStartIndex){
                    end = mid - 1;
                } else start = mid + 1;
            }
        }
        return ans;
    }
}
