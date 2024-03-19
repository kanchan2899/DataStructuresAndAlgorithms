package com.dsalgo.strings;

public class FirstPalindrome {
    public static void main(String[] args) {
        String[] words = {"abc","car","ada","racecar","cool"};
        System.out.println(firstPalindrome(words));
    }

    private static String firstPalindrome(String[] words) {
        for(String word : words){
            String rev = reverse(word);
            if(word.equals(rev)) {
                return word;
            }
        }

        return "";
    }

    private static String reverse(String word) {
        char[] s = word.toCharArray();
        int n = word.length();
        char[] rev = new char[n];

        for(int i = 0; i < n; i++) {
            rev[i] = s[n - i - 1];
        }
        return String.valueOf(rev);
    }
}
