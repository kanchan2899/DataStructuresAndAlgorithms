package com.dsalgo.search.binary;

import java.util.Scanner;

public class FirstOccurrenceOfNumber {
    public static void main(String[] args) {
        int[] arr = {5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 10, 10, 10};
        int num = 7;
        System.out.println("First occurrence of " + num + " in the array is " + firstOccurrence(arr, num));
        System.out.println("First occurrence of " + num + " in the array is " + firstOccurrence1(arr, num));
    }

    /**
     * Using binary search: If you found the element using binary search, it may or may not be the first
     * occurrence. So when you find the element, check if either it is at index 0 or previous element
     * is not equal to arr[mid]. If these conditions satisfy, return mid. Otherwise, keep searching
     * for the first occurrence in the first half of the array.
     *
     * TC: O(log n)
     * SC: O(1)
     * @param arr
     * @param num
     * @return
     */
    private static int firstOccurrence(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] > num)
                end = mid - 1;
            else if (arr[mid] < num)
                start = mid + 1;
            else {
                if(mid == 0 || arr[mid] != arr[mid - 1]) {
                    return mid;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * Using linear search: The idea to solve this problem is to iterate on the elements of
     * given array and check given elements in an array and keep track of first and last
     * occurrence of the found element’s index.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param num
     * @return
     */
    private static int firstOccurrence1(int[] arr, int num) {
        int firstOccurrence = -1;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != num) {
                continue;
            }
            if(arr[i] == num && firstOccurrence == -1) {
                firstOccurrence = i;
            }
        }
        return firstOccurrence;
    }
}
