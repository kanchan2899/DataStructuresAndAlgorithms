package com.dsalgo.arrays;

// https://www.geeksforgeeks.org/equilibrium-index-of-an-array/?ref=gcse
public class EquilibriumPoint {
    public static void main(String[] args) {
        long[] arr = {1};
        System.out.println(equilibriumPoint(arr, arr.length));
    }
    public static int equilibriumPoint(long arr[], int n) {
        int equilibriumPoint = -1;
        if(n <= 1) {
            equilibriumPoint = n;
        }
        long sumLeft = 0;
        long sumRight = 0;
        long totalSum = 0;


        for(int j = 0; j < arr.length; j++) {
            totalSum += arr[j];
        }

        for(int i = 1; i < arr.length; i++) {
            sumLeft += arr[i - 1];
            sumRight = totalSum - arr[i] - sumLeft;
            System.out.println(sumLeft);
            System.out.println(sumRight);
            if(sumRight == sumLeft) {
                equilibriumPoint = i + 1;
            }
        }
        return equilibriumPoint;
    }
}
