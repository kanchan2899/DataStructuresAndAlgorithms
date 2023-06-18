package com.dsalgo.recursion.strings;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode.com/problems/decode-string/
public class DecodeString {
    static int i = 0;
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
        System.out.println(decodeString1(s));
    }

    private static String decodeString1(String s) {
        return helper1(s, new int[]{0});
    }

    private static String helper1(String s, int[] i) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        String temp = "";

        while(i[0] < s.length()) {
            char ch = s.charAt(i[0]);
            i[0]++;

            if(ch == '[') {
                temp = helper1(s, i);
                while (count > 0) {
                    sb.append(temp);
                    count--;
                }
            } else if(ch == ']') {
                break;
            } else if(Character.isAlphabetic(ch)) {
                sb.append(ch);
            } else {
                count = count * 10 + ch - '0';
            }
        }
        return sb.toString();
    }

    public static String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count  = 0;

        while(i < s.length()) {
            char ch = s.charAt(i);
            i++;
            if(ch == '[') {
                String temp = decodeString(s);
                while (count > 0) {
                    sb.append(temp);
                    count--;
                }
            } else if (ch == ']') {
                break;
            } else if(Character.isAlphabetic(ch)) {
                sb.append(ch);
            } else {
                count = count * 10 + ch - '0';
            }
        }
        return sb.toString();
    }


}
