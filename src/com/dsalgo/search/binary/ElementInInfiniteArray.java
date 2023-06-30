package com.dsalgo.search.binary;

// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class ElementInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 9, 10, 11, 13, 14, 15, 16};
        int target = 9;
        System.out.println(findingRange(arr, target));
        System.out.println(searchInfiniteArray(arr, target));
        System.out.println(searchInfiniteArray1(arr, target));
    }

    /**
     * Using binary search: Find the upper limit for the binary search by multiplying i by 2 in every
     * pass. Do binary search from (i/2 + 1, to i - 1)
     *
     * TC: O(log of position)
     * SC: O(1)
     * @param arr
     * @param target
     * @return
     */
    private static int searchInfiniteArray1(int[] arr, int target) {
        int i = 0;
        if(arr[i] == target) {
            return 0;
        }
        i++;

        while (arr[i] < target) {
            i = i * 2;
            if(arr[i] == target) {
                return i;
            }
        }
        return binarySearch(arr, target, i/2 + 1, i - 1);
    }


    /**
     * Linear Search: The idea is to start from the beginning and check if current element is target
     * or it is greater than target. If greater than target, return -1. If arr[i] == target, return i
     *
     *
     * TC: O(position)
     * SC: O(1)
     *
     * @param arr
     * @param target
     * @return
     */
    static int searchInfiniteArray(int[] arr, int target) {
        int i = 0;
        while (true) {
            if(arr[i] == target) {
                return i;
            }
            if(arr[i] > target) {
                return -1;
            }
            i++;
        }
    }



    static int findingRange(int[] arr, int target){
        // find the range
        // start with a box of size 2
        int start = 0;
        int end = 1;

        // condition for the target to lie in the range
        while(arr[end] < target){
            int temp = end + 1;
            // Double the box value
            // end = previous end + (sizeofbox * 2)
            // end = end + (end - start + 1) * 2;
            end = end * 2;
            start = temp;
        }
        return binarySearch(arr, target, start, end);
    }
    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(arr[mid] < target){
                start = mid + 1;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else return mid;
        }
        return -1;
    }
}
