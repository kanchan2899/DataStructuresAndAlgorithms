package com.dsalgo.recursion.subsets;

import java.util.ArrayList;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
/*
    Here,
    1 -> abc
    2 -> def
    3 -> ghi
    4 -> jkl
    5 -> mno
    6 -> pqr
    7 -> stw
    8 -> xyz
 */
public class ModifiedLetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        numberPadToLetters("89", "");
        System.out.println(numberPadToLettersInList("122", ""));
        System.out.println(countNumberPadToLetters("123", ""));
    }

    private static int countNumberPadToLetters(String unprocessed, String processed) {
        if(unprocessed.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = unprocessed.charAt(0) - '0';
        for(int i = (digit - 1) * 3; i < digit * 3 && digit * 3 <= 26; i++) {
            char c = (char) ('a' + i);
            count += countNumberPadToLetters(unprocessed.substring(1), processed + c);
        }
        return count;
    }

    static void numberPadToLetters(String unprocessed, String processed){
        if(unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        int digit = unprocessed.charAt(0) - '0'; // This wil convert '2' to 2
        for(int i = (digit - 1) * 3; i < digit * 3 && i <= 26; i++) {
            char ch = (char) ('a' + i);
            numberPadToLetters(unprocessed.substring(1), processed + ch);
        }
    }

    static ArrayList<String> numberPadToLettersInList(String unprocessed, String processed) {
        if(unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        int digit = unprocessed.charAt(0) - '0';
        ArrayList<String> ls = new ArrayList<>();
        for(int i = (digit - 1) * 3; i < digit * 3 && digit * 3 <= 26; i++) {
            char c = (char) ('a' + i);
            ls.addAll(numberPadToLettersInList(unprocessed.substring(1), processed + c));
        }
        return ls;
    }
}
