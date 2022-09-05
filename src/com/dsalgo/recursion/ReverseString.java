package com.dsalgo.recursion;

import java.util.Arrays;

// https://leetcode.com/problems/reverse-string/
public class ReverseString {
    public static void main(String[] args) {
        String[] str1 = {"a", "b", "c", "d"};
        String[] str2 = {"a", "b", "c", "d", "e"};
        System.out.println(Arrays.toString(reverse(str1, 0)));
        System.out.println(Arrays.toString(reverse(str2, 0)));
    }

    private static String[] reverse(String[] str, int index) {
        if(index >= str.length / 2)
            return str;
        swap(str, index, str.length - index - 1);
        return reverse(str, index + 1);
    }

    private static void swap(String[] str, int index, int i) {
        String temp = str[index];
        str[index] = str[i];
        str[i] = temp;
    }
}
