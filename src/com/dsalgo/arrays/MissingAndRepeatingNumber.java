package com.dsalgo.arrays;

import java.util.Arrays;

// https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
public class MissingAndRepeatingNumber {
    public static void main(String[] args) {
        int[]arr = {2, 3, 1, 2, 5};
        int n = arr.length;

        missingAndRepeatingNumber(arr, n);
        System.out.println("*******************");
        missingAndRepeatingNumber1(arr, n);
        System.out.println("*******************");
        missingAndRepeatingNumber2(arr, n);
    }

    /**
     * Using sorting: Sort the array first. Traverse the array to find the missing and repeating
     * number.
     *
     * TC: O(n * log n)
     * SC: O(1)
     * @param arr
     * @param n
     */
    private static void missingAndRepeatingNumber(int[] arr, int n) {
        Arrays.sort(arr);
        int missing = 0, repeating = 0;

        for(int i = 1; i < n; i++) {
            if(arr[i] == arr[i - 1]) {
                repeating = arr[i];
                System.out.println("Repeating number: " + repeating);
            }
            if(arr[i - 1] != i + 1) {
                missing = i + 1;
                System.out.println("Missing number: " + missing);
                i++;
            }
        }
    }

    /**
     * Use a count array:
     * Create a temp array temp[] of size n with all initial values as 0.
     * Traverse the input array arr[], and do the following for each arr[i]
     * if(temp[arr[i]-1] == 0), set temp[arr[i]-1] = 1;
     * if(temp[arr[i]-1] == 1) output “arr[i]” //repeating number
     * Traverse temp[] and output ‘i+1’ corresponding to the element of array temp[] having value as 0. (This is the missing number)
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @param n
     */
    private static void missingAndRepeatingNumber1(int[] arr, int n) {
        int[] temp = new int[n+1];
        int repeatingNum = -1, missingNum = -1;

        for(int i = 0; i < n; i++) {
            temp[arr[i] - 1]++;
            if(temp[arr[i] - 1] > 1) {
                repeatingNum = arr[i];
            }
        }

        for(int i = 0; i < n; i++) {
            if(temp[i] == 0)
            {
                missingNum = i + 1;
                break;
            }
        }
        System.out.println("Missing number: " + missingNum);
        System.out.println("Repeating number: " + repeatingNum);
    }

    /**
     * Use elements as index and mark the visited places:
     * Traverse the array. While traversing, use the absolute value of every element as an index
     * and make the value at this index negative to mark it visited.
     * If something is already marked negative then this is the repeating element.
     * To find the missing, traverse the array again and look for a positive value.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param n
     */
    private static void missingAndRepeatingNumber2(int[] arr, int n) {
        int i;
        for(i = 0; i < n; i++) {
            int abs_value = Math.abs(arr[i]);
            if(arr[abs_value - 1] > 0) {
                arr[abs_value - 1] = -arr[abs_value - 1];
            } else {
                System.out.println("Repeating element: " + abs_value);
            }
        }

        for(i = 0; i < n; i++) {
            if(arr[i] > 0) {
                System.out.println("Missing element: " + (i+1));
            }
        }
    }

    /**
     * Using sum and product equations:
     * 1. Let x be the missing and y be the repeating element.
     * 2. Get the sum of all numbers using formula S = n(n+1)/2 – x + y
     * 3. Get product of all numbers using formula P = 1*2*3*…*n * y / x
     * 4. The above two steps give us two equations, we can solve the equations and
     * get the values of x and y.
     * @param arr
     * @param n
     */
    private static void missingAndRepeatingNumber3(int[] arr, int n) {

    }
}
