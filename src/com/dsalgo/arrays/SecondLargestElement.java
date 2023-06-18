package com.dsalgo.arrays;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 10, 9, 10};
        System.out.println(secondLargestElement(arr));
        System.out.println(secondLargestElement1(arr));
    }

    /**
     * Optimized solution: Intialize secondLargestIndex as -1 and largestIndex as 0.
     * Start a loop from 1 to n. Check if current element is greater than largest element, if so
     * assign largest element index to secondLargestIndex and current index to largest element index.
     * Check if current element is not equal to largest element. If so, check if secondLargestIndex
     * is either -1 or current element is greater than second largest element, then assign current index
     * to secondLargestIndex
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @return
     */
    private static int secondLargestElement1(int[] arr) {
        int secondLargestIndex = -1, largestIndex = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[largestIndex]) {
                secondLargestIndex = largestIndex;
                largestIndex = i;
            } else if (arr[i] != arr[largestIndex]){
                if(secondLargestIndex == -1 || arr[i] > arr[secondLargestIndex]) {
                    secondLargestIndex = i;
                }
            }
        }
        return secondLargestIndex;
    }

    /**
     * Brute force: Find the largest element. Start a loop from 0 to n
     * If the current element is not the largest element, if secondLargestIndex is -1 or current
     * element is greater than second largest element, assign current index to secondLargestIndex.
     *
     * TC: (n) - loop runs 2n times
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int secondLargestElement(int[] arr) {
        int largest = getLargest(arr);
        int secondLargestIndex = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != largest) {
                if(secondLargestIndex == -1) {
                    secondLargestIndex = i;
                } else if (arr[i] > arr[secondLargestIndex]) {
                    secondLargestIndex = i;
                }
            }
        }
        return secondLargestIndex;
    }

    private static int getLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > largest) {
                largest = arr[i];
            }
        }
        return largest;
    }
}
