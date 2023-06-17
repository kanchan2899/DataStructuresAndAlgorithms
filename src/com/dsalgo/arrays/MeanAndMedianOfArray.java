package com.dsalgo.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MeanAndMedianOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 19, 28, 5};
        System.out.println("Mean is " + mean(arr));
        System.out.println("Median is " + median(arr));
    }

    public static int median(int arr[])
    {
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        int n = arr.length - 1;

        if(n % 2 == 0) {
            return arr[n/2];
        } else {
            return (int)Math.floor((arr[n/2] + arr[(n/2) + 1]) / 2);
        }

    }
    //Function to find median of the array elements.
    public static int mean(int arr[])
    {
        int n = arr.length;
        int sum = 0;

        for(int i = 0; i < n; i++) {
            sum += arr[i];
        }
        return (sum / n);
    }
}
