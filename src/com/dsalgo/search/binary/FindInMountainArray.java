package com.dsalgo.search.binary;

// https://leetcode.com/problems/find-in-mountain-array/
public class FindInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 5, 3, 1};
        System.out.println(search(arr, 1));
    }

    private static int search(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int peak = findPeakElement(arr, start, end);
//        int a = binarySearch(arr, target, start, peak);
//        int b = binarySearch(arr, target, peak + 1, end);
//        System.out.println(a + " " + b);
//        if (a > 0 && b > 0) {
//            return Math.min(a, b);
//        } else {
//            return Math.max(a, b);
//        }
        int a = binarySearch(arr, target, start, peak);
        if( a != -1) return a;
        return binarySearch(arr, target, peak + 1, end);

    }

        private static int findPeakElement (int[] arr, int start, int end){
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (arr[mid] > arr[mid + 1]) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println("Peak " + start);
            return start; // return end
        }

        private static int binarySearch ( int[] arr, int target, int start, int end){
            boolean isAscending;
            if(arr[start] < arr[end]){
                isAscending = true;
            } else
                isAscending = false;

            while (start <= end){
                // addition of start and end index might exceed integer range if the array is too big
                //int mid = (start + end) / 2;
                int mid = start + (end - start) / 2;

                if(arr[mid] == target) return mid;

                if(!isAscending){
                    if (target < arr[mid]){
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    if (target < arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
            return -1;
        }
}
