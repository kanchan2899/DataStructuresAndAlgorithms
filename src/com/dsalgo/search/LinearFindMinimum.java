package com.dsalgo.search;

public class LinearFindMinimum {
    public static void main(String[] args) {
        int[] arr = {10, -92, 40, 65, 34, -75};
        System.out.println(min(arr));
    }

    private static int min(int[] arr) {
        int min = arr[0];
        for(int i = 0; i < arr.length; i++){
            if( min > arr[i]){
                min = arr[i];
            }
        }
        return min;
    }
}
