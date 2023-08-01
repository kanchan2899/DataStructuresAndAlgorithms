package com.dsalgo.search.binary;

// https://www.geeksforgeeks.org/count-number-of-occurrences-or-frequency-in-a-sorted-array/
/*
    Given a sorted array arr[] and a number x, write a function that counts the
    occurrences of x in arr[]. Expected time complexity is O(Logn)
 */
public class CountNumberOfOccurrencesInSortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int x = 2;
        System.out.println(countOccurrences(arr, x));
        System.out.println(countOccurrences1(arr, x));
        System.out.println(countOccurrences2(arr, x));
    }

    /**
     * Using Binary Search:
     * 1. Use Binary search to get the index of the first occurrence of x in arr[ ].
     * Let the index of the first occurrence be i.
     * 2. Use Binary search to get the index of the last occurrence of x in arr[ ].
     * Let the index of the last occurrence be j.
     * 3. Return the count as difference between first and last indices (j – i + 1);
     *
     * TC: O(log n)
     * SC: O(1)
     *
     * @param arr
     * @param x
     * @return
     */
    private static int countOccurrences2(int[] arr, int x) {
        int n = arr.length;
        int i = firstOccurrence(arr, 0, n-1, x);
        int j = lastOccurrence(arr, 0, n-1, x);
        int count = j - i + 1;
        return count;
    }

    private static int lastOccurrence(int[] arr, int start, int end, int x) {
        int n = arr.length;
        if(start <= end) {
            int mid = start + (end - start) / 2;
            if((mid == n-1 || x < arr[mid+1]) && arr[mid] == x) {
                return mid;
            }
            if(x < arr[mid]) {
                return lastOccurrence(arr, start, mid - 1, x);
            } else
                return lastOccurrence(arr, mid+1, end, x);
        }
        return -1;
    }

    private static int firstOccurrence(int[] arr, int start, int end, int x) {

        if(start <= end) {
            int mid = start + (end - start) / 2;
            if((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
                return mid;
            }
            else if(x > arr[mid]) {
                return firstOccurrence(arr, mid+1, end, x);
            }
            else
                return firstOccurrence(arr, start, mid-1, x);
        }
        return -1;
    }



    /**
     * Binary search: We first find an occurrence using binary search.
     * Then we match toward left and right sides of the matched the found index.
     *
     * TC: O(log n + count)
     * SC: O(1)
     *
     * @param arr
     * @param x
     * @return
     */
    private static int countOccurrences1(int[] arr, int x) {
        int index = binarySearch(arr, 0, arr.length - 1, x);
        int count;
        if(index == -1) {
            return 0;
        }
        // Count elements on left side
        count = 1;

        int left = index - 1;
        while (left >= 0 && arr[left] == x) {
            count++;
            left--;
        }

        // Count elements on right side
        int right = index + 1;
        while (right < arr.length && arr[right] == x) {
            count++;
            right++;
        }
        return count;
    }

    private static int binarySearch(int[] arr, int start, int end, int x) {
        if(start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if(arr[mid] == x) {
            return mid;
        }
        if(arr[mid] > x) {
            return binarySearch(arr, start, mid - 1, x);
        }
        else {
            return binarySearch(arr, mid + 1, end, x);
        }
    }

    /**
     * Linear Search: Linearly search for x, count the occurrences of x and return the count.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @param x
     * @return
     */
    private static int countOccurrences(int[] arr, int x) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == x) {
                count++;
            }
        }
        return count;
    }
}
