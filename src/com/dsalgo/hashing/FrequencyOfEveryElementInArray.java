package com.dsalgo.hashing;


// https://www.geeksforgeeks.org/counting-frequencies-of-array-elements/
/*
    I/P: arr[] = {10, 20, 20, 10, 10, 20, 5, 20}
    O/P: 10 3
         20 4
         5  1

 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyOfEveryElementInArray {
    public static void main(String[] args) {
        int[][] arr= {{10, 20, 20, 10, 10, 20, 5, 20},
                      {10, 10, 10, 10},
                      {1, 2, 3, 1, 2, 3, 4, 1, 1, 2, 3, 2},
                      {1, 2, 3, 4, 5}};
        for(int[] a: arr){
            System.out.print("Using Bruteforce: ");
            frequencyOfEachElement1(a);
            System.out.print("Using HashMap: ");
            frequencyOfEachElement2(a);
            System.out.print("Using LinkedHashMap: ");
            frequencyOfEachElement3(a);
            System.out.println("***********");

        }
    }

    /**
     * Bruteforce: Run a loop i from 0 to n-1. Inside this loop, initialize a flag as false,
     * This flag indicates if the current element already exists in left side of the current element.
     * First check left side of the current element, if it has visited already. If so, break out of the loop j
     * and make flag as true. If flag == true, skip that current element.
     * If the current element is not visited, then start a loop j from i+1 to n, count the occurrence
     * of the element in right side of the array. Print the count before moving to next element.
     *
     * Time complexity: O(n^2)
     * Space complexity: O(1)
     *
     * @param arr
     */
    private static void frequencyOfEachElement1(int[] arr) {
        for(int i = 0; i < arr.length; i++) {

            // Check if the element is visited before
            boolean flag = false;
            for(int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    flag = true;
                    break;
                }
            }
            // If the element is visited before, skip it
            if(flag == true)
                continue;

            // if it is not visited, count the occurrence of the element
            int count = 1;
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]){
                    count++;
                }
            }
            System.out.println(arr[i] + " " + count);
        }
    }


    /**
     * Using HashMap: Insert unique element in the array in a hashmap. If the same key occurs again,
     * increment the value of key by 1. Print the hashmap with keys and values
     *
     * Time complexity: O(n) / Theta(n)
     * Space complexity: O(n)
     *
     * @param arr
     */
    private static void frequencyOfEachElement2(int[] arr) {
        HashMap<Integer, Integer> frequencyOfElements = new HashMap<>();
        for(int x : arr) {
            frequencyOfElements.put(x, frequencyOfElements.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e: frequencyOfElements.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }

    /**
     * Using LinkedHashMap: Insert unique element in the array in a hashmap. If the same key occurs again,
     * increment the value of key by 1. Print the hashmap with keys and values.
     * LinkedHashMap preserves the insertion order of keys.
     *
     * Time complexity: O(n) / Theta(n)
     * Space complexity: O(n)
     *
     * @param arr
     */
    private static void frequencyOfEachElement3(int[] arr) {
        HashMap<Integer, Integer> frequencyOfElements = new LinkedHashMap<>();
        for(int x : arr) {
            frequencyOfElements.put(x, frequencyOfElements.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> e: frequencyOfElements.entrySet()) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
