package com.dsalgo.sort.counting;

import java.util.Arrays;

public class SortStrings {
    public static void main(String[] args) {
        String s = "geeksforgeeksabcd";
        System.out.println(countSort(s));
    }

    public static String countSort(String s)
    {
        int n = s.length();
        char[] output = new char[n];
        int[] count = new int[256];
        char[] arr = s.toCharArray();

        // store the count of each character
        for(int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // change count[i] so that count[i] now contains actual position of this character in o/p array
        for(int i = 1; i < 256; i++) {
           count[i] = count[i - 1] + count[i];
        }

        // build the o/p array to make it stable as we are traversing in reverse order
        for(int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        return String.valueOf(output);
    }
}
