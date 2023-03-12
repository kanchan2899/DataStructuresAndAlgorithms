package com.dsalgo.hashing;

import java.util.HashMap;
import java.util.HashSet;

/*
    https://www.geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/

    I/P: [10, 20, 20, 10, 30, 30, 40, 10], k = 4
    O/P: 2 3 4 3 (number of windows = n - k + 1 => Check distinct elements from index 0 to 3, then
    1 to 4, then 2 to 5 then 3 to 6)

    I/P: [10, 10, 10, 10], k = 3
    O/P: 1 1

    I/P:[10, 20, 30, 40], k = 3
    O/P: 3 3

 */
public class CountDistinctElementsInEveryWindow {
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 20, 10, 30, 40, 10},
                {10, 10, 10, 10},
                {10, 20, 30, 40}
        };
        int[] k = {
                4,
                3,
                3
        };
        for(int i = 0; i < arr.length; i++) {
            System.out.print("Using Bruteforce: ");
            countDistinctElementsInEveryWindow1(arr[i], k[i]);
            System.out.println();
            System.out.print("Using HashSet: ");
            countDistinctElementsInEveryWindow2(arr[i], k[i]);
            System.out.println();
            System.out.print("Using HashMap - Frequency map: ");
            countDistinctElementsInEveryWindow3(arr[i], k[i]);
            System.out.println();
            System.out.println("***************");
        }

    }

    /**
     * Using Bruteforce: Number of windows  = n - k + 1. Start a loop i from 0 to n - k i.e. for every window.
     * Initialize count to 0. Start another loop k from 0 to k - 1 for every window.
     * Initialize boolean as false. Start another loop p from 0 to j - 1 to check if arr[i + j] == arr[i + p]
     * If so, flag = true and break the loop. Check if flag == false, increment count.
     * For every window, print the count.
     *
     * Time complexity: O((n-k) * k * k)
     * Space complexity: O(1)
     * @param arr array that may contain duplicates
     * @param k size of the window
     */

    private static void countDistinctElementsInEveryWindow1(int[] arr, int k) {
        for(int i = 0; i <= arr.length - k; i++) {
            int count = 0;
            for(int j = 0; j < k; j++) {
                boolean flag = false;
                for(int p = 0; p < j; p++) {
                    if(arr[i+j] == arr[i+p]){
                        flag = true;
                        break;
                    }
                }
                if(flag == false){
                    count++;
                }
            }
            System.out.print(count + " ");
        }
    }


    /**
     * Using HashSet: Initialize HashSet. For every window, start a loop i from 0 to n - k.
     * Initialize count to 0. Start another loop j from 0 to k - 1 to traverse through the window,
     * add the elements in the set. count becomes the size of the set. Print the count and reset the set.
     *
     * Time complexity: O((n-k) * k), where k is the size of frequency map
     * Space complexity: O(k), where k is the size of frequency map
     *
     * @param arr array that may contain duplicates
     * @param k size of the window
     */
    private static void countDistinctElementsInEveryWindow2(int[] arr, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i <= arr.length - k; i++) {
            int count;
            for(int j = 0; j < k; j++) {
                set.add(arr[i+j]);
            }
            count = set.size();
            set.clear();
            System.out.print(count + " ");
        }
    }

    /**
     * Using HashMap / Frequency Map: The idea is to create a frequency map of the first window.
     * Then traverse every window and compute the frequency map of current window using the previous window.
     *
     * Steps:
     * 1. Create a frequency map of first k elements.
     * 2. Print the size of the frequency map - count of distinct elements of the first window.
     * 3. Start the loop i from k  to n -1
     * 4.   Decrease the frequency of arr[i - k] (because the second window doesn't include arr[i-k] element.
     *      If the frequency of arr[i - k] becomes 0, remove it from the frequency map.
     * 5.   Current window contains arr[i] element, so check if it exists in the frequency map.
     *      If it doesn't exist add it to the map, else increment the count of the element arr[i].
     * 6.   Print the size of the frequency map for each window.
     *
     * Time complexity: O(n)
     * Space complexity: O(k), where k is the size of frequency map
     *
     * @param arr
     * @param k
     */
    private static void countDistinctElementsInEveryWindow3(int[] arr, int k){
        HashMap<Integer, Integer> frequencyMap = new HashMap<>(k);
        for(int i = 0; i < k; i++) {
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        System.out.print(frequencyMap.size() + " ");

        for(int i = k; i < arr.length; i++) {
            frequencyMap.put(arr[i - k], frequencyMap.get(arr[i - k]) - 1);
            if(frequencyMap.get(arr[i - k]) == 0) {
                frequencyMap.remove(arr[i - k]);
            }

            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

            System.out.print(frequencyMap.size() + " ");
        }
    }
}
