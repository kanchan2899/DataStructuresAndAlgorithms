package com.dsalgo.arrays;

import java.util.Arrays;

//
public class RepeatingElement {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 3, 2, 2};
        System.out.println("Repeating element using bruteforce: " + repeatingElement(arr));
        System.out.println("Repeating element using Sorting: " + repeatingElement1(arr));
        System.out.println("Repeating element using boolean array: " + repeatingElement2(arr));
        System.out.println("Repeating element using cycle: " + repeatingElement3(arr));
    }

    /**
     * Using LL Cycle concept:
     *
     * TC:O(n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int repeatingElement3(int[] arr) {
        int slow = arr[0] + 1, fast = arr[0] + 1;

        do {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        } while (slow != fast);

        slow = arr[0] + 1;
        while (slow != fast) {
            slow = arr[slow] + 1;
            fast = arr[fast] + 1;
        }

        return slow - 1;
    }


    /**
     * Using boolean array:
     * 1. Create a boolean array to mark the visited element
     * 2. Traverse the array and update b[arr[i]] to true.
     * 3. If already visited, return arr[i]
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int repeatingElement2(int[] arr) {
        boolean[] temp = new boolean[arr.length - 1];
        for(int i = 0; i < arr.length; i++) {
            if(temp[arr[i]]) {
                return arr[i];
            }
            temp[arr[i]] = true;
        }
        return -1;
    }

    /**
     * Using sorting:
     * 1. Sort the array
     * 2. Traverse from 0 to n-2, compare current element with next element. If same, return current
     * element
     *
     * TC: O(n * log n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int repeatingElement1(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1]) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * Bruteforce:
     * 1. Traverse the array from 0 to n-2
     * 2. Start another loop j from i + 1 to n-1
     * 3. Compare arr[i] with arr[j]. If same, return arr[i]. Else return -1
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int repeatingElement(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }
}
