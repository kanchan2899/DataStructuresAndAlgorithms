package com.dsalgo.hashing;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/two-sum/
/*
    I/P: a = [2, 7, 11, 15], target = 15
    O/P: [0, 1]

    I/P: a = [3, 2, 4], target = 6
    O/P: [1, 2]
 */
public class TwoSumI {
    public static void main(String[] args) {
        int[][] arr = {{2, 7, 11, 15}, {3, 2, 4}, {1, 4, 2, 9}};
        int[] sum = {26, 6, 7};

        for(int i = 0; i < arr.length; i++) {
            System.out.println("Using Bruteforce: " + Arrays.toString(getSumPair1(arr[i], sum[i])));
            System.out.println("Using HashSet: " + getSumPair2(arr[i], sum[i]));
            System.out.println("Using HashMap: " + Arrays.toString(getSumPair3(arr[i], sum[i])));
            System.out.println("*****************");
        }
    }

    /**
     * Using Bruteforce: Start loop i from 0 to n. Start another loop j from i + 1 to n
     * if a[i] + a[j] == sum, return the indexes i and j. Else return -1, -1.
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param a array with unsorted and duplicates elements
     * @param sum of two elements
     * @return index of elements for which the sum of them is equal to sum
     */
    private static int[] getSumPair1(int[] a, int sum) {
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                if(a[i] + a[j] == sum) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Using HashSet: Create a HashSet
     * Traverse through the array to check if array contains sum - a[i].
     * If so, return true. Else add a[i] to hashset.
     * If no elements form a pair, return false.
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param a
     * @param sum
     */
    private static boolean getSumPair2(int[] a, int sum) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < a.length; i++) {
            if(set.contains(sum - a[i])){
                return true;
            }
            set.add(a[i]);
        }
        return false;
    }

    /**
     * Using HashMap: Create a HashMap
     * Traverse through the array to check if array contains sum - a[i].
     * If so, return index of current element and the value of sum-a[i] in hashmap.
     * Else add (a[i], i) to hashmap.
     * If no elements form a pair, return [-1, -1].
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     * @param a
     * @param sum
     */
    private static int[] getSumPair3(int[] a, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for(int i = 0; i < a.length; i++) {
            if(hashMap.containsKey(sum - a[i])){
                return new int[]{i, hashMap.get(sum - a[i])};
            }
            hashMap.put(a[i], i);
        }
        return new int[]{-1, -1};
    }
}
