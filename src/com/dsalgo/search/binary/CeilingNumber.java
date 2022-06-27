package com.dsalgo.search.binary;

public class CeilingNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 10, 14, 15, 18, 23};
        int target = 4;
        System.out.println(findCeilingNumber(arr, target));
    }

    // return the smallest number >= target
    private static int findCeilingNumber(int[] arr, int target) {
        // What if the target is greater than the greatest number in the array
        if(target > arr[arr.length - 1]){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target) return arr[mid];
            else if(arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return arr[start];
    }
}
