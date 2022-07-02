package com.dsalgo.search.binary;

import java.util.Scanner;

public class LastOccurrenceOfNumber {
    public static void main(String[] args) {
        int[] arr = {5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 8, 8, 10, 10, 10};
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println("First occurence of " + num + " in the array is " + lastOccurrence(arr, num));
    }

    private static int lastOccurrence(int[] arr, int num) {
        int start = 0;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == num) start = mid + 1;
            else if(arr[mid] > num) end = mid - 1;
            else start = mid + 1;
        }
        return end;
    }
}
