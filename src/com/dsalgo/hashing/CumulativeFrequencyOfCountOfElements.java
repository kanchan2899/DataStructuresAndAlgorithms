package com.dsalgo.hashing;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/frequency-of-each-element-in-an-unsorted-array0759/1

/*
    I/P: arr[] = {1, 2, 2, 2, 1, 3, 4}
    O/P: 2 5 6 7    // (1's count) (1's count + 2's count) (1's count + 2's count + 3's count) ...

 */
public class CumulativeFrequencyOfCountOfElements {
    public static void main(String[] args) {
        int[][] arr= {
                        {10, 5, 6, 3, 8, 1, 1, 8, 2, 1, 5, 10, 9, 4},
                        {10, 10, 10, 10},
                        {1, 2, 3, 1, 2, 3, 4, 1, 1, 2, 3, 2},
                        {1, 2, 3, 4, 5}
                    };
        for (int[] a : arr) {
            System.out.println("Using TreeMap/LinkedHashMap: " + countFreq1(a));
            System.out.println("Using Bruteforce: " + countFreq2(a));
            System.out.println("********************");
        }
    }


    /**
     * Using Bruteforce: Sort the array first. Before starting to count from the current element
     * to the last element in the array, check left part of the array if the element has been visited
     * If the element is visited, skip that element.
     * Add up the count and add it to the arraylist
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     */
    private static ArrayList<Integer> countFreq2(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        int count = 0;
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++){
            boolean flag = false;
            for(int j = 0; j < i; j++) {
                if(arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if(flag == true) {
                continue;
            }
            int c = 1;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    c++;
                }
            }
            count += c;
            al.add(count);
        }

        return al;
    }

    /**
     * Using TreeMap/LinkedHashMap: Count the frequency of distinct element in array in a LinkedHashMap.
     * If using LinkedHashMap, convert it to TreeMap to get the sorted order of keys.
     * Otherwise, use TreeMap directly to store the frequency of elements.
     * Initialize count to 0, loop through the map and add the value (frequency) of each element to
     * an arraylist and return it.
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr
     * @return ArrayList of integers containing cumulative sum of frequency of array elements in sorted order.
     */
    public static ArrayList<Integer> countFreq1(int[] arr)
    {
        ArrayList<Integer> al = new ArrayList<>();
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        // Map<Integer, Integer> countMap = new TreeMap<>();
        for(int x : arr) {
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        }
        // Sort the linked hash map
        Map<Integer, Integer> treeCountMap = new TreeMap<>(countMap);

        int c = 0;
        for(Map.Entry<Integer, Integer> e: treeCountMap.entrySet()) {
            c = c + e.getValue();
            al.add(c);
        }
        return al;
    }
}
