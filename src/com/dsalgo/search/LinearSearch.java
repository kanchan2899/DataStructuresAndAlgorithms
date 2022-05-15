package com.dsalgo.search;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 5, 7, 8, 10};
        int element = 10;
        System.out.println(linearSearch(nums, element));
    }

    // Search in the array: return the index if element is found, else return -1
    static int linearSearch(int[] arr, int element){
        if(arr.length < 0 || arr.length == 0){
            return -1;
        }
        for (int index = 0; index < arr.length; index++){
            if(element == arr[index]){
                return index;
            }
        }
        return -1;
    }
}
