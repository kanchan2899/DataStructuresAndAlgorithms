package com.dsalgo.arrays;

import java.util.HashMap;
import java.util.Map;

public class FrequenciesInSortedArray {
    public static void main(String[] args) {
        int[] arr = {10, 10, 10, 23, 25, 25, 25, 25};
        frequencyInSortedArray(arr);
        System.out.println("***************");
        frequencyInSortedArray1(arr);
    }

    /**
     * Bruteforce: Create a map and traverse the array while adding/updating the frequency of each
     * element in the hashmap. Traverse the hashmap and print the frequency of all elements.
     *
     * TC: O(n)
     * SC: O(n)
     * @param arr
     * @return
     */
    private static void frequencyInSortedArray1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     *  In a sorted array, the same elements occur consecutively, so the idea is to maintain a
     *  variable to keep track of the frequency of elements while traversing the array.
     *  Initialize a variable freq as 1 to store the frequency of elements.
     *  Iterate in the range [1, n-1] using variable i. If the value of arr[i] is equal to arr[i-1],
     *  increment freq by 1. Else print the frequency of arr[n-1] from freq and reset freq to 1.
     *  Finally, after above steps, print the frequency of the last distinct element of the array
     *  as freq.
     *
     * @param arr
     */
    private static void frequencyInSortedArray(int[] arr) {
        int freq = 1;

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i - 1]) {
                freq++;
            } else {
                System.out.println(arr[i - 1] + " " + freq);
                freq = 1;
            }
        }
        System.out.println(arr[arr.length - 1] + " " + freq);
    }
}
