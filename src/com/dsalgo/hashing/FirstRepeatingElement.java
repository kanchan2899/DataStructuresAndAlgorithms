package com.dsalgo.hashing;

import com.dsalgo.search.binary.CountNumberOfOccurrencesInSortedArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import static com.dsalgo.search.binary.CountNumberOfOccurrencesInSortedArray.*;

// https://www.geeksforgeeks.org/find-first-repeating-element-array-integers/
public class FirstRepeatingElement {
    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        System.out.println(firstRepeatingElement(arr));
        System.out.println(firstRepeatingElement1(arr));
        System.out.println(firstRepeatingElement2(arr));
        System.out.println(firstRepeatingElement3(arr));
        System.out.println("Index of first repeating element: " + firstRepeatingElementIndex(arr));

    }

    /**
     * Find index using HashMap: Initialize ans as max value and create a hashmap. Traverse the array
     * if map contains arr[i], assign ans as min value index of i and ans. Otherwise, add arr[i] and i
     * to map. If ans is max value, return -1. Otherwise return ans.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int firstRepeatingElementIndex(int[] arr) {
        int ans = Integer.MAX_VALUE;

        HashMap<Integer, Integer> set = new HashMap<>();

        // Traverse the array from right to left
        for(int i = 0; i < arr.length; i++) {
            if(set.containsKey(arr[i])) {
                ans = Math.min(ans, set.get(arr[i]));
            } else {
                set.put(arr[i], i+1);
            }
        }

        return (ans == Integer.MAX_VALUE ? -1 : ans);
    }

    /**
     * Using Hash array: The idea is to use Hash array to store the occurrence of elements. Then
     * traverse the array from left to right and return the first element with occurrence > 1
     *
     * Steps:
     * 1. Initialize a variable max to -1 to keep track of the maximum value in the array.
     * 2. Iterate over all values of arr[] to store the largest value in max.
     * 3. Declare an integer array hash of size max+1 and initialize all its elements to 0.
     * 4. This array will be used as a hash table to store the count of occurrences of each element
     * in the input array.
     * 5. Traverse the input array again from index 0 to n-1, and increment the count of the
     * corresponding element in the hash table.
     * 6. Traverse the input array again from index 0 to n-1, and for each element in the input array,
     * check if the count of the corresponding element in the hash table is greater than 1. If it is,
     * return the index of that element in the input array (i.e., i+1, since the function is
     * expected to return a 1-based index). If no repeated element is found, the function returns -1.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int firstRepeatingElement3(int[] arr) {
        int max = -1;

        // find max
        for(int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        // create hash array
        int[] hash = new int[max + 1];

        // mapping/counting
        for(int i = 0; i < arr.length; i++) {
            hash[arr[i]]++;
        }

        // check for repeating elements
        int repeating = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(hash[arr[i]] > 1) {
                repeating = arr[i];
                break;
            }
        }

        return (repeating == Integer.MIN_VALUE ? -1 : repeating);
    }

    /**
     * Using HashSet: The idea is to traverse the given arr[] from right to left and update the
     * minimum index whenever, an already existing visited element has been found. To check if
     * the element was already visited, HashSet can be used.
     *
     * Steps:
     * 1. Initialize an empty HashSet and a variable minimum with -1
     * 2. Run a loop for each index of arr array from n-1 to 0
     *  a. If the current element is present in the set, update min with i
     *  b. Else insert arr[i] in set
     * 3. Return min
     *
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int firstRepeatingElement2(int[] arr) {
        int min = -1;

        HashSet<Integer> set = new HashSet<>();

        // Traverse the array from right to left
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                min = i;
            } else {
                set.add(arr[i]);
            }
        }

        if(min != -1) {
            return arr[min];
        }

        return min;
    }

    /**
     * Using sorting: Store the elements in a temp array and sort temp. Traverse arr and simultaneously
     * check the count of the element in temp array and if the current element arr[i] has more
     * than one occurrence, then return arr[i]
     *
     * Steps:
     * 1. Copy the given array to an auxiliary array temp[] and sort temp array.
     * 2. Traverse the input array arr
     *  a. For every element, count its occurrences in temp[] using binary search
     *  b. If the count of occurrence of current element is more than one, then return the current ele.
     * 3. If no repeating element, return -1.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int firstRepeatingElement1(int[] arr) {
        int[] temp = Arrays.copyOf(arr, arr.length);

        // sort temp array
        Arrays.sort(temp);

        // traverse arr and check the frequency of each element in temp.
        for(int i = 0; i < arr.length; i++) {
            int freqOfElement = CountNumberOfOccurrencesInSortedArray.countOccurrences2(temp, arr[i]);
            if(freqOfElement > 1) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * Bruteforce: Run two nested loops, the outer loop picks an element one by one, and the inner
     * loop checks whether the element is repeated or not. Once a repeating element is found, break
     * the loops and return it
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int firstRepeatingElement(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; i++) {
                if(arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }


}
