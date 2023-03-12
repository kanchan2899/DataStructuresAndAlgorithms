package com.dsalgo.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
    https://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/

    Given two arrays a[0..m-1] and b[0..n-1]. Find where b[] is a subset of a[] or not.
    Both arrays are not in sorted order. It may be assumed that elements are distinct.

    I/P: a = {11, 1, 13, 21, 3, 7}, b = {11, 3, 7, 1}
    O/P: True

    I/P: a = {3, 4, 2, 1}, b = {3, 5}
    O/P: False

 */
public class CheckIfArrayIsASubsetOfAnotherArray {
    public static void main(String[] args) {
        int[][] a = {
                {11, 1, 13, 21, 3, 7},
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4},
                {4, 3},
                {6, 5, 4, 2},
                {8, 9, 1, 3}
        };

        int[][] b = {
                {11, 3, 7, 1},
                {1, 2, 4},
                {3, 5},
                {1, 2, 3},
                {1},
                {9}
        };
        for(int i = 0; i < a.length; i++) {
            System.out.println("Using Bruteforce with a flag: " + isSubset1(a[i], b[i]));
            System.out.println("Using Bruteforce without a flag: " + isSubset2(a[i], b[i]));
            System.out.println("Using sorting and binary search: " + isSubset3(a[i], b[i]));
            System.out.println("Using sorting and merging: " + isSubset4(a[i], b[i]));
            System.out.println("Using HashSet: " + isSubset5(a[i], b[i]));
            System.out.println("Using HashSet + check size: " + isSubset6(a[i], b[i]));
            System.out.println("Using HashMap: " + isSubset7(a[i], b[i]));
            System.out.println("**********************");
        }

    }

    /**
     * Using Bruteforce with a flag: Start a loop i to iterate through array b and initialize flag
     * as false for each element in array b. Start another loop j to iterate through array a and
     * check if a[j] == b[i]. If so, set flag to true, and break. In i loop, if flag is false,
     * break out of i loop. Return the flag.
     *
     * Time complexity: O(m * n)
     * Space complexity: O(1)
     *
     * @param a
     * @param b
     * @return true if one of the arrays is the subset of the other
     */

    private static boolean isSubset1(int[] a, int[] b) {
        boolean isSubset = false;
        if(a.length < b.length){
            isSubset1(b, a);
        }
        for(int i = 0; i < b.length; i++) {
            isSubset = false;
            for(int j = 0; j < a.length; j++) {
                if(b[i] == a[j]) {
                    isSubset = true;
                    break;
                }
            }
            if(!isSubset) {
                break;
            }
        }
        return isSubset;
    }


    /**
     * Using Bruteforce without flag: Start loop i for array b. Start another loop j for array a.
     * If b[i] == a[j], break out the loop j. If j == a.length, return false. Else return true.
     *
     * Time complexity: O(m * n)
     * Space complexity: O(1)
     *
     * @param a
     * @param b
     * @return true if one of the arrays is the subset of the other
     */
    private static boolean isSubset2(int[] a, int[] b) {
        if(a.length < b.length){
            isSubset1(b, a);
        }
        int i, j;
        for(i = 0; i < b.length; i++) {
            for(j = 0; j < a.length; j++) {
                if (b[i] == a[j]) {
                    break;
                }
            }
            if(j == a.length) {
                return false;
            }
        }
        return true;
    }


    /**
     * Using sorting and binary search: Sort array a. For each element in array b, apply binary search
     * in array a. If b's element not found in array a, return false. Else return true.
     *
     * Time complexity: O((m * log m) + (n * log n)), if quick sort is used, the worst case
     * complexity is O(m ^ 2). Hence, worst case complexity can be O(m ^ 2).
     * Space complexity: O(1)
     *
     * @param a
     * @param b
     * @return true if one of the arrays is the subset of the other
     */
    private static boolean isSubset3(int[] a, int[] b) {
        if(b.length > a.length)
            isSubset3(b, a);
        Arrays.sort(a);
        for(int i = 0; i < b.length; i++) {
            if(!binarySearch(a, b[i])) {
                return false;
            }
        }
        return true;
    }


    private static boolean binarySearch(int[] a, int target) {
        int start = 0;
        int end = a.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(a[mid] == target) return true;
            else if(a[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    /**
     * Using sorting and merging: Sort both arrays. Initialize i and j to 0.
     * Start a while loop until i < a.length and j < b.length.
     * If a[i] < b[j], increment i.
     * If a[i] == b[j], increment i and j.
     * if a[i] > b[j], return false. Also, if j < b.length, return false.
     * Otherwise, return true.
     *
     *
     * Time complexity: O((m * log m) + (n * log n)) - worst case complexity
     * Space complexity: O(1)
     *
     * @param a
     * @param b
     * @return true if one of the arrays is the subset of the other
     */
    private static boolean isSubset4(int[] a, int[] b) {
        if(b.length > a.length)
            return isSubset4(b, a);
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]){
                i++;
            } else if(a[i] == b[j]) {
                i++;
                j++;
            }
            else if(a[i] > b[j]){
                return false;
            }
        }
        if(j < b.length) {
            return false;
        }
        return true;
    }

    /**
     * Using HashSet: Add all elements of a to a HashSet. Start a loop i for array b.
     * Check if b[i] is in the hashset. If no, return false. Else return true.
     *
     * Time complexity: O(m + n) - worst case complexity
     * Space complexity: O(m)
     *
     * @param a
     * @param b
     * @return true if one of the arrays is the subset of the other
     */
    private static boolean isSubset5(int[] a, int[] b) {
        if(b.length > a.length)
            return isSubset5(b, a);

        HashSet<Integer> setA = new HashSet<>(a.length);
        for(int j : a){
            setA.add(j);
        }
        int i;
        for(i = 0; i < b.length; i++) {
            if(!setA.contains(b[i]))
                return false;
        }
        return true;
    }

    /**
     * Using HashSet + check size: Add all elements of array a to a set. Save the size of hashset
     * in a variable. Add all elements of array b to the same set.
     * Check if previous size == current size. If so, return true, else return false.
     *
     * Time complexity: O(m + n) - worst case complexity
     * Space complexity: O(m + n)
     *
     * @param a
     * @param b
     * @return true if one of the arrays is the subset of the other
     */
    private static boolean isSubset6(int[] a, int[] b) {
        if(b.length > a.length)
            return isSubset5(b, a);

        HashSet<Integer> setA = new HashSet<>(a.length);
        for(int j : a){
            setA.add(j);
        }
        int p = setA.size();
        for(int i : b) {
            setA.add(i);
        }
        if(p == setA.size())
            return true;
        return false;
    }

    /**
     * Using Frequency map: Save the elements of array a to a map with frequency 1.
     * Loop through array b and if getOrDefault(b[i], 0) > 0, reduce the frequency of element b
     * Otherwise, return false.
     *
     * Time complexity: O(m + n) - worst case complexity
     * Space complexity: O(m)
     *
     * @param a
     * @param b
     * @return true if one of the arrays is the subset of the other
     */
    private static boolean isSubset7(int[] a, int[] b) {
        if(b.length > a.length)
            return isSubset5(b, a);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int j : a){
            map.put(j, map.getOrDefault(j, 0) + 1);
        }

        for(int i : b) {
            if(map.getOrDefault(i, 0) > 0) {
                map.put(i, map.get(i) - 1);
            } else {
                return false;
            }
        }
        return true;
    }

}
