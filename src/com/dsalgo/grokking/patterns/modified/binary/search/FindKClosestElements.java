package com.dsalgo.grokking.patterns.modified.binary.search;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-k-closest-elements/description/
public class FindKClosestElements {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 4;
        int target = 3;
        System.out.println(findClosestElements(arr, k, target));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int target) {
        List<Integer> closestElements = new ArrayList<>();

        // If the length of 'nums' is the same as k, return 'arr'
        if(arr.length == k) {
            for(int n : arr) {
                closestElements.add(n);
            }
            return closestElements;
        }

        // if target is less than or equal to first element in 'arr',
        // return the first k elements from 'arr'
        if(target <= arr[0]) {
            for(int i = 0; i < k; i++) {
                closestElements.add(arr[i]);
            }
            return closestElements;
        }

        // if target is greater than or equal to last element in 'arr',
        // return the last k elements from 'arr'
        if(target >= arr[arr.length - 1]) {
            for(int i = arr.length - k; i < arr.length; i++) {
                closestElements.add(arr[i]);
            }
            return closestElements;
        }


        // find the first closest element to target using binary search
        int firstClosest = BinarySearch.binarySearch(arr, target);

        // initialize the sliding window pointers
        int windowLeft = firstClosest - 1;
        int windowRight = windowLeft + 1;

        // expand the sliding window until its size becomes equal to k
        while ((windowRight - windowLeft - 1) < k) {
            // if window's left pointer is going out to bounds, move the window rightward
            if(windowLeft == -1) {
                windowRight++;
                continue;
            }

            // if window's right pointer is going out of bounds OR if the element pointed to
            // by window's left pointer is closer to target than the element pointed to by
            // the window's right pointer, move the window leftward
            if(windowRight == arr.length || Math.abs(arr[windowLeft] - target) <= Math.abs(arr[windowRight] - target)) {
                windowLeft--;
            }

            // if the element pointed by window's right pointer is closer to target than the element
            // pointed by the window's left pointer, move the window rightward
            else {
                windowRight++;
            }

        }
        // return k closest elements present inside the window
        for(int i = windowLeft + 1; i < windowRight; i++) {
            closestElements.add(arr[i]);
        }

        return closestElements;
    }
}
