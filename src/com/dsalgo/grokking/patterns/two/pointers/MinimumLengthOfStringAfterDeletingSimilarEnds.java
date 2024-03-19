package com.dsalgo.grokking.patterns.two.pointers;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
        String str = "aabccabba";
        System.out.println(minimumLength(str));
    }

    private static int minimumLength(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();

        for(int left = 0, right = chars.length - 1; left < right;) {
            if(chars[left] == chars[right]) {
                char ch = chars[left];
                while (left < right && chars[left] == ch) {
                    left++;
                    n--;
                }

                while (right >= left && chars[right] == ch) {
                    right--;
                    n--;
                }
            } else {
                break;
            }
        }
        return n;
    }
}
