package com.dsalgo.sort.cycle;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 0};
        System.out.println(missingNumber(arr));
    }

    private static int missingNumber(int[] arr) {
        int i = 0;
        while(i < arr.length){
            int correctIndex = arr[i];
            if(arr[i] < arr.length && arr[i] != arr[correctIndex]){
                swap(arr, i, correctIndex);
            } else {
                i++;
            }
        }

        // Search for first missing number
        for(int index = 0; index < arr.length; index++){
            if(arr[index] != index){
                return index;
            }
        }
        return arr.length;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}