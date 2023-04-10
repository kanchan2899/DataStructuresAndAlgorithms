package com.dsalgo.recursion.strings.subsequence;

import java.util.ArrayList;
import java.util.Arrays;

// https://www.geeksforgeeks.org/print-subsequences-string/
public class StringSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        findSequence(str, "");
        System.out.println(findSequence1(str, ""));
        System.out.println(findSequence3(str, "", new ArrayList<String>()));
    }

    private static ArrayList<String> findSequence3(String unprocessed, String processed, ArrayList<String> list) {
        if(unprocessed.isEmpty()){
            list.add(processed);
            return list;
        }
        char ch = unprocessed.charAt(0);
        findSequence3(unprocessed.substring(1), processed + ch, list);
        findSequence3(unprocessed.substring(1), processed, list);
        return list;
    }

    private static ArrayList<String> findSequence1(String str, String sub) {
        if(str.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(sub);
            return list;
        }
        char ch = str.charAt(0);
        ArrayList<String> left = findSequence1(str.substring(1), sub + ch);
        ArrayList<String> right = findSequence1(str.substring(1), sub);

        left.addAll(right);
        return left;
    }

    private static void findSequence(String str, String subsequence) {
        if(str.isEmpty()) {
            System.out.println(subsequence);
            return;
        }
        char ch = str.charAt(0);
        findSequence(str.substring(1), subsequence + ch);
        findSequence(str.substring(1), subsequence);
    }
}
