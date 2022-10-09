package com.dsalgo.arrays;

import java.util.Arrays;

// https://www.geeksforgeeks.org/convert-array-into-zig-zag-fashion/
/*
4625 < 6202 > 2038 < 5916 > 3405 < 5533 > 5469 < 7004
> 2469 < 9853 > 361 < 9819 > 3294 < 7195 > 4036 < 9404 > 4992
 < 8767 > 1711 < 5404 > 3100 < 3751 > 2139 < 5437 > 3214 < 4993
  > 1759 < 9572 > 3789 < 9623 > 2472 < 9493 > 6270

  4625 < 6202 > 5469 < 5916 > 2038 < 3405 > 5533 < 2469 >
   9853 4992 7004 9819 361 3294 4036 9404 7195 5404 8767 3214 1711 3100 2139 5437 3751 1759 9572 4993 3789 9623 2472 9493 6270


 */
public class ConvertArrayIntoZigzag {
    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 8, 6, 2, 1};
//        zigzag1(arr);
//        System.out.println(Arrays.toString(arr));
//        int[] arr1 = {4, 3, 7, 8, 6, 2, 1};
        zigzag2(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void zigzag1(int[] arr) {
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++) {
            if(i < arr.length - 1) {
                swap(arr, i, i + 1);
            }
        }
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }

    private static void zigzag2(int[] arr) {
        boolean flag = true;
        for(int i = 0; i < arr.length - 1; i++) {
            if(flag) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i+1);
                }
            } else {
                if(arr[i] < arr[i + 1]) {
                    swap(arr, i, i+1);
                }
            }
            flag = !flag;
        }
    }
}
