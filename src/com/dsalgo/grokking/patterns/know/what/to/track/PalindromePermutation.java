package com.dsalgo.grokking.patterns.know.what.to.track;

import java.util.HashMap;

// https://leetcode.com/problems/palindrome-permutation/description/
public class PalindromePermutation{
    public static void main(String[] args) {
        String str = "abbd";
        System.out.println(palindromePermutation(str));
    }

    private static boolean palindromePermutation(String str) {
        HashMap<Character, Integer> frequencies = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            frequencies.put(str.charAt(i), frequencies.getOrDefault(str.charAt(i), 0) + 1);
        }
        int count = 0;

        for(Character ch: frequencies.keySet()) {
            if(frequencies.get(ch) % 2 != 0) {
                count += 1;
            }
        }

        if(count <= 1) {
            return true;
        } else {
            return false;
        }
    }
}
