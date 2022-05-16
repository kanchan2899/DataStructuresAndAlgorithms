package com.dsalgo.search.linear;

public class LinearSearchInRange {
    public static void main(String[] args) {
        int[] nums = {4, 6, 3, 2, 5, 7, 1, 8, 1, 20};
        System.out.println(linearSearchInRange(nums, 2, 3, 10));
    }

    static int linearSearchInRange(int[] arr, int element, int index1, int index2){
        if(arr.length <= 0 || index2 > index1 || arr.length < index2){
            return -1;
        }
        for(int i = index1; i < index2; i++){
            if(arr[i] == element){
                return arr[i];
            }
        }
        return -1;
    }
}
