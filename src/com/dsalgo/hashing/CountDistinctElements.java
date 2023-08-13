package com.dsalgo.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
    arr = {15, 12, 13, 12, 13, 13, 18} => 4
    arr = {10, 10, 10} => 1
    arr = {10, 11, 12} => 3

 */
public class CountDistinctElements {
    public static void main(String[] args) {
        int[][] arr = {{15, 12, 13, 12, 13, 13, 18},
                        {1, 1, 2, 2, 3, 3, 4, 5, 6, 7},
                        {10, 10, 10},
                        {10, 11, 12}};
        for(int[] a : arr) {
            System.out.println("Using Bruteforce: " + countDistinct1(a));
            System.out.println("Using HashSet: " + countDistinct2(a));
            System.out.println("Using HashSet Improved Implementation: " + countDistinct3(a));
            System.out.println("***********");
        }
    }

    /**
     * Bruteforce: Run a loop i from 0 to n-1 and initialize flag as false.
     * Run an inner loop j from 0 to i-1. If arr[i] == arr[j], flag = true, break.
     * If flag == false, count++.
     * Time Complexity = O(n^2)
     * Space Complexity = O(1)
     * @param arr
     * @return count
     */
    static int countDistinct1(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            boolean flag = false;
            for(int j = 0; j < i; j++) {
                if(arr[i] == arr[j]){
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                count++;
            }
        }
        return count;
    }

    /**
     * Using HashSet: Create an empty integer HashSet. Run a loop i from 0 to n-1.
     * Add elements to the hashset if it is not present. At the end, return the size of hashset.
     * Time Complexity = O(n)
     * Space Complexity = O(n)
     * @param arr
     * @return count
     */
    static int countDistinct2(int[] arr) {
        HashSet<Integer> countSet = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            countSet.add(arr[i]);
        }
        return countSet.size();
    }

    /**
     * Using HashSet Improved Implementation: Convert int[] array to Integer[] array first.
     * Initialize the HashSet with Integer[] array and return the size of HashSet.
     * Time Complexity = O(n)
     * Space Complexity = O(n)
     * @param arr
     * @return count
     */
    static int countDistinct3(int[] arr) {
        Integer[] a = new Integer[arr.length];
        Arrays.setAll(a, i -> arr[i]);
        HashSet<Integer> countSet = new HashSet<>(Arrays.asList(a));
        return countSet.size();
    }

}
