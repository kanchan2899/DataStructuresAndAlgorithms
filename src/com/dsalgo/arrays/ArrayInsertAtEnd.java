package com.dsalgo.arrays;

import java.util.Arrays;

public class ArrayInsertAtEnd {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 0};
        int sizeOfArray = 6;
        int element = 100;

        insertAtEnd(arr, sizeOfArray, element);
        System.out.println(Arrays.toString(arr));
    }

    private static void insertAtEnd(int[] arr, int sizeOfArray, int element) {
        {
            int totalElements = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] != 0) {
                    totalElements++;
                }
            }

            if(totalElements <= sizeOfArray-1) {
                arr[totalElements] = element;
            }

        }
    }
}
