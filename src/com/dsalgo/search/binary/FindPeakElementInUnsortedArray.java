package com.dsalgo.search.binary;

public class FindPeakElementInUnsortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 10, 20, 15};
        System.out.println(peakElement(arr));
        System.out.println(peakElement1(arr));
    }

    /**
     * Using Binary Search: Using Binary Search, check if the middle element is the peak element
     * or not. If the middle element the peak element terminate the while loop and print middle
     * element, then check if the element on the right side is greater than the middle element
     * then there is always a peak element on the right side. If the element on the left side is
     * greater than the middle element then there is always a peak element on the left side.
     *
     * 1. Create two variables, l and r, initialize l = 0 and r = n-1
     * 2. Run a while loop till l <= r, lowerbound is less than the upperbound
     *      a. Check if the mid value or indexmid = low + (high - low) / 2, is the peak element or not,
     *      if yes then print the element and terminate.
     *      b. Else if the element on the left side of the middle element is greater than check for
     *      peak element on the left side, i.e. update r = mid – 1
     *      c. Else if the element on the right side of the middle element is greater than check
     *      for peak element on the right side, i.e. updatel = mid + 1
     *
     * TC: O(log n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int peakElement1(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = arr.length;

        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;

            // first case if mid is the answer
            if((mid == 0 || arr[mid - 1] <= arr[mid]) && (mid == n - 1 || arr[mid + 1] <= arr[mid])) {
                break;
            }
            // move the right pointer
            if(mid > 0 && arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            }
            // move the left pointer
            else {
                end = mid + 1;
            }
        }
        return arr[mid];
    }

    /**
     * Bruteforce: The array can be traversed and the element whose neighbors are less than that
     * element can be returned.
     * 1. If the first element is greater than the second or the last element is
     * greater than the second last, print the respective element and terminate the program.
     * 2. Else traverse the array from the second index to the second last index i.e. 1 to N – 1
     * If for an element array[i] is greater than both its neighbors,
     * i.e.,array[i] > =array[i-1] and array[i] > =array[i+1] , then print that element and terminate.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int peakElement(int[] arr) {
        int n = arr.length;
        if(n == 1) {
            return -1;
        }
        // First or last element is peak element
        if(arr[0] >= arr[1]) {
            return arr[0];
        }
        if(arr[n - 1] >= arr[n - 2]) {
            return arr[n - 1];
        }

        // Check for every other element
        for(int i = 1; i < n-1; i++) {
            // Check if the neighbors are smaller
            if(arr[i-1] < arr[i] && arr[i] > arr[i+1]) {
                return arr[i];
            }
        }
        return -1;
    }
}
