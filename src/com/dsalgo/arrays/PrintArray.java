package com.dsalgo.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for(int a: arr){
            System.out.println(a + " ");
        }

        System.out.println(Arrays.toString(arr));
    }
}
