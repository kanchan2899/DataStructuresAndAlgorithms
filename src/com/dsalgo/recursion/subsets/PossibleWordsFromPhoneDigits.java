package com.dsalgo.recursion.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Recursion/problem/possible-words-from-phone-digits-1587115620
public class PossibleWordsFromPhoneDigits {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4};
        System.out.println(possibleWords(arr));
    }

    static ArrayList<String> possibleWords(int a[]) {
        ArrayList<String> words = new ArrayList<>();
        if(a.length == 0) {
            return words;
        }

        Map<Integer, String> digitsToLettersMap= new HashMap<>();

        digitsToLettersMap.put(2, "abc");
        digitsToLettersMap.put(3, "def");
        digitsToLettersMap.put(4, "ghi");
        digitsToLettersMap.put(5, "jkl");
        digitsToLettersMap.put(6, "mno");
        digitsToLettersMap.put(7, "pqrs");
        digitsToLettersMap.put(8, "tuv");
        digitsToLettersMap.put(9, "wxyz");

        words = helper(a, "", 0,  digitsToLettersMap);
        return words;
    }

    private static ArrayList<String> helper(int[] a, String processed, int index, Map<Integer, String> digitsToLettersMap) {
        if(index >= a.length) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        ArrayList<String> words = new ArrayList<>();
        String chars = digitsToLettersMap.get(a[index]);

        for(int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            words.addAll(helper(a, processed + c, index + 1, digitsToLettersMap));
        }
        return words;
    }
}
