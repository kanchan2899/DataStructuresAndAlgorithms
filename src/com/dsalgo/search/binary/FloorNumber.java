package com.dsalgo.search.binary;

public class FloorNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 10, 14, 15, 18, 23};
        int target = 1;
        System.out.println(findFloorNumber(arr, target));
    }

    // return the greatest number <= target
    private static int findFloorNumber(int[] arr, int target) {
        if(arr[0] > target){
            return -1;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target) return arr[mid];
            else if(arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return arr[end];
//        return end;
    }
}
