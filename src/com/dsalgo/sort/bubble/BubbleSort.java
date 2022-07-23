package com.dsalgo.sort.bubble;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5, 8 ,6, 4, 2, 3, 1, 7};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void bubbleSort(int[] arr){
        boolean swapped;
        // Run the steps n-1 times, i.e n-1 passes
        for(int i = 0; i < arr.length; i++){
            swapped = false;
            // For each step, max item will come at the last respective index
            for(int j = 1; j < arr.length - i; j++){
                // Swap if current element is smaller than the previous element
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }

            // If no swaps for a particular i, array is sorted: BREAK OUT OF THE LOOP
            if(!swapped){
                break;
            }
        }
    }
}
