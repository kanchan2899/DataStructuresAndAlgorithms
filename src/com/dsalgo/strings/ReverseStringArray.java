package com.dsalgo.strings;

import java.util.Arrays;

public class ReverseStringArray {
    public static void main(String[] args) {
        String[] s = {"h","e","l","l","o"};
        reverseArray1(s);
        System.out.println(Arrays.toString(s));
        s = new String[]{"h", "e", "l", "l", "o"};
        reverseArray2(s);
        System.out.println(Arrays.toString(s));
    }

    /**
     * Using Bruteforce: Run a loop till mid element. Swap the current element with n - i - 1
     * element.
     *
     * Time complexity = O(n)
     * Space complexity = O(1)
     * @param s
     */
    private static void reverseArray2(String[] s) {
        if(s.length == 0) return;
        int n = s.length;
        for(int i = 0; i < n / 2; i++) {
            String temp = s[i];
            s[i] = s[n - i - 1];
            s[n - i - 1] = temp;
        }
    }

    /**
     * Using two pointers approach: Start one pointer from 0th element and another pointer from
     * the last element. Swap elements at start and end pointer. Increment start pointer, decrement
     * end pointer. Run the loop until start is less than or equal to end.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     * @param s
     */
    private static void reverseArray1(String[] s) {
        if(s.length == 0) return;
        int start = 0, end = s.length - 1;
        while (start <= end) {
            String temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
