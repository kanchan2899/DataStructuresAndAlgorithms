package com.dsalgo.arrays;

// https://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
public class MaximumNumberOfJumps {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(arr));
    }
    static int minJumps(int[] arr){
        int numberOfJumps = 1;
        for(int i = 2; i < arr.length;) {
            if(i + arr[i] < arr.length - 1) {
                i = i + arr[i];
            } else {
                numberOfJumps++;
                break;
            }
            numberOfJumps++;
        }
        return numberOfJumps;
    }
}
