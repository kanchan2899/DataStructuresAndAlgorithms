package com.dsalgo.sort.counting;

import java.util.Arrays;

// https://www.geeksforgeeks.org/counting-sort/
public class CountingSort {
    public static void main(String[] args) {
        int[] nums = {4, 4, 1 , 2, 7, 8, 7, 6, 5, 4, 8, 9, 1};
        System.out.println(Arrays.toString(countingSort(nums)));
        int[] nums1 = {4, 4, 1 , 2, 7, 8, 7, 6, 5, 4, 8, 9, 1};
        countingSortWithMultipleObjects(nums1);
        System.out.println(Arrays.toString(nums1));
    }

    /**
     * General purpose implementation with multiple members of any class.
     *
     * It is also a stable sorting algo
     *
     * @param arr
     */
    private static void countingSortWithMultipleObjects(int[] arr) {
        int n = arr.length;
        int[] count = new int[n];

        for(int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        for(int i = 1; i < n; i++) {
            count[i] = count[i - 1] + count[i];
        }

        int[] output = new int[n];

        for(int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        for(int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /**
     * Counting sort: It is a sorting technique based on keys between a specific range
     * It works by counting the number of objects having distinct key value.
     * Then doing some arithmetic to calculate the position of each object in the output sequence.
     *
     * 1. For simplicity, consider data in range 0 to 9. => {2, 1, 5, 4, 1, 2, 3}
     * 2. Create a count array to store the count of each unique object.
     * 3. Initially the count of all elements is 0. => {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
     * 4. Count each element in the given array and place the count at the approximate index. => {0, 2, 2, 1, 1, 1, 0, 0, 0, 0}
     * 5. Modify the count array by adding the previous counts. => {0, 2, 4, 5, 6, 7, 7, 7, 7, 7}
     * 6. Create a new array of same length as the given array
     * 7. Corresponding values represent the places in the count array.
     *    Place the objects in their correct positions and decrease the count by one
     *  
     *  TC: O(n + k), where k is the max value + 1 in the range of elements
     *  SC: O(n)
     *  
     */

    private static int[] countingSort(int[] nums) {
        int[] output = new int[nums.length];
        int[] count = new int[10];

        // Store the count of each number
        for(int i = 0; i < nums.length; i++){
            ++count[nums[i]];
        }

        // Change count[i] so that count[i] now contains actual position of this character in output array
        for(int i = 1; i < count.length; i++){
            count[i] += count[i-1];
        }

        // Build the output array
        for(int i = output.length - 1; i >= 0; i--){
            output[count[nums[i]] - 1] = nums[i];
            --count[nums[i]];
        }
        return output;
    }
}
