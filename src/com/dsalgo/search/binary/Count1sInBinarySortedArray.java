package com.dsalgo.search.binary;

public class Count1sInBinarySortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 0, 0, 0, 0};
        System.out.println(countOnes(arr, arr.length));
    }

    private static int countOnes(int[] arr, int n) {
        if(arr[0] == 0) {
            return 0;
        }
        if(arr[n - 1] == 1) {
            return n;
        }
        int start = 0, end = n-1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(arr[mid] == 0) {
                end = mid - 1;
            } else {
                if(mid == n - 1 || arr[mid] != arr[mid + 1]) {
                    return mid + 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return 0;
    }
}
