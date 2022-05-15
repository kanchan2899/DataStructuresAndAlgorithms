package com.dsalgo.arrays;

public class MaximumValue {
    public static void main(String[] args) {
        int[] arr = {5, 4, 1, 9, 10, 12};
        System.out.println(max(arr));
        System.out.println(maxInRange(arr, 1, 3));
    }

    private static int maxInRange(int[] arr, int index1, int index2) {
        if(index1 > index2){
            return -1;
        }
        if(arr == null){
            return -1;
        }
        int max = arr[index1];
        for (int i = 0; i < arr[index2]; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    private static int max(int[] arr) {
        if(arr.length == 0){
            return -1;
        }
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
