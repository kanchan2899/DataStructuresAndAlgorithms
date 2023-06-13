package com.dsalgo.arrays;

public class LargestElementInArray {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1, 4, 7};
        System.out.println(largestElement(arr));
        System.out.println(largestElement1(arr));
    }

    /**
     * Bruteforce: Traverse through all elements in the array. For each element, compare the
     * current element with all the elements. If the current element is less than any element,
     * set the flag as false and break out of loop. Otherwise, return the index of current element.
     *
     *
     * TC: O(n^2)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static int largestElement(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            boolean flag = true;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] > arr[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag == true) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Efficient Solution: If we know the largest element till (i-1)th index, we can compare that
     * with the ith element and decide if the largest element is the ith element or not.
     *
     * TC: O(n)
     * SC: O(1)
     *
     */
    public static int largestElement1(int[] arr) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }
}
