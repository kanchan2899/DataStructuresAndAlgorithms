package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/reverse-array-in-groups0255/1
public class ReverseInGroups {
    public static void main(String[] args) {
        int[] arr = {36, 93, 64, 48, 96, 55, 70, 0, 82, 30, 16,
                22, 38, 53, 19, 50, 91, 43, 70, 88, 10, 57, 14,
                94, 13, 36, 59, 32, 54, 58, 18, 82, 67};
        int k = 13;
        reverseArrayInGroups(arr, k);
        System.out.println(Arrays.toString(arr));
        ArrayList<Integer> list = new ArrayList<>(
                Arrays.asList(36, 93, 64, 48, 96, 55, 70, 0, 82, 30, 16,
                22, 38, 53, 19, 50, 91, 43, 70, 88, 10, 57, 14,
                94, 13, 36, 59, 32, 54, 58, 18, 82, 67));
        reverseArrayListInGroups(list, k);
        System.out.println(list);
    }

    /**
     * Bruteforce: Start a loop i from 0 to n but increment i by k.
     * low index would be i and high index would be the minimum of n - 1 and i + k - 1
     * Then loop over till low < high and swap element at low and high index.
     *
     * TC: O(n)
     * SC: O(1)
     * @param list
     * @param k
     */
    private static void reverseArrayListInGroups(ArrayList<Integer> list, int k) {
        int n = list.size();
        for(int i = 0; i < n; i += k) {
            int low = i;
            int high = Math.min(i + k - 1, n - 1);
            while (low < high) {
                int temp = list.get(low);
                list.set(low, list.get(high));
                list.set(high, temp);
                low++;
                high--;
            }
        }
    }

    /**
     * Bruteforce: Start a loop i from 0 to n but increment i by k.
     * low index would be i and high index would be the minimum of n - 1 and i + k - 1
     * Then loop over till low < high and swap element at low and high index.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @param k
     */
    private static void reverseArrayInGroups(int[] arr, int k) {
        int n = arr.length;
        for(int i = 0; i < n; i += k) {
            int low = i;
            int high = Math.min(i + k - 1, n - 1);
            while (low < high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
    }
}
