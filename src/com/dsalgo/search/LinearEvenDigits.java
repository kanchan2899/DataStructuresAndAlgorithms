package com.dsalgo.search;

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

import java.util.ArrayList;

public class LinearEvenDigits {

    public static void main(String[] args) {
        int[] arr = {-43, 3476, 4873232, 236, 12837, 0, -65};
        System.out.println(findNumbers(arr));
    }

    public static int findNumbers(int[] arr){
        int count = 0;
        for (int num : arr){
            if ( even(num) ){
                count++;
            }
        }
        return count;
    }

    private static boolean even(int num) {
        // Solution 1 : Count number of digits
        // Solution 2 : Convert the number to string and return the length
        return countDigits(num) % 2 == 0;
    }

    static int countDigits(int num){
        if (num == 0) { return 1; }
        if( num < 0 ) {num = num * -1;}
        int count  = 0;
        while (num > 0){
            count++;
            num /= 10;
        }
        return count;
    }

    // Function to check if the number contains even digits or not

}
