package com.dsalgo.recursion.strings;

// https://leetcode.com/problems/reverse-string-ii/description/
public class ReverseStringII {
    public static void main(String[] args) {
        String str = "abcdefg";
        int k = 2;
        System.out.println(reverseString1(str, k));
        System.out.println(reverseString2(str, k));
        System.out.println(reverseString3(str, k));
    }

    private static String reverseString3(String str, int k) {
        if(str.length() < k) {
            return reverse(str, 0, str.length() - 1);
        } else if(str.length() <= 2 * k) {
            return reverse(str, 0, 0 + k - 1) + str.substring(k);
        } else {
            return reverse(str, 0, 0 + k - 1) +
                    str.substring(k, 2 * k) +
                    reverseString3(str.substring(2 * k), k);
        }
    }

    private static String reverse(String str, int start, int end) {
        if(start > end) {
            return "";
        }
        return str.charAt(end) + reverse(str, start, end - 1);
    }

    private static String reverseString2(String str, int k) {
        char[] chars = str.toCharArray();
        int n = chars.length;
        for(int i = 0; i <= n - 1; i += 2 * k) {
            if(i + k - 1 <= n - 1) {
                reveseChars(chars, i, i + k - 1);
            } else {
                reveseChars(chars, i, n - 1);
            }
        }
        return new String(chars);
    }

    private static void reveseChars(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

    private static String reverseString1(String str, int k) {
        char[] c = str.toCharArray();
        helper(c, k, 0, 2 * k - 1);
        return new String(c);
    }

    private static void helper(char[] charArray, int k, int start, int end) {
        // When length is less than k, reverse everything
        if(start + k > charArray.length) {
            reveseChars(charArray, start, charArray.length - 1);
            return;
        }

        // Move to 2k characters each time
        helper(charArray, k, end + 1, end + 2 * k);

        // Reverse k characters
        reveseChars(charArray, start, start + k - 1);

    }
    private static String rev(String s) {
        if(s.length() == 0) {
            return "";
        }
        return rev(s.substring(1)) + s.charAt(0);
    }
}
