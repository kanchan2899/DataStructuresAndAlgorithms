package com.dsalgo.search.binary;

// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public class ElementInInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7, 9, 10, 11, 13, 14, 15, 16};
        int target = 9;
        System.out.println(findingRange(arr, target));
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
