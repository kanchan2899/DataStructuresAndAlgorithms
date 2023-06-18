package com.dsalgo.recursion.strings;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubstrings {
    public static void main(String[] args) {
        String s = "nitin";
        List<String> substrings = generateAllSubstrings(s);
        System.out.println("Substrings of " + s + " : " + substrings);
        System.out.println("Palindrome substrings of " + s + " are : " + palindromeSubstring(substrings));
    }

    private static List<String> palindromeSubstring(List<String> substrings) {
        List<String> palindromeSubstrings = new ArrayList<>();
        for(String s : substrings) {
            if(isPalindrome(s)) {
                palindromeSubstrings.add(s);
            }
        }
        return palindromeSubstrings;
    }

    static boolean isPalindrome(String s) {
        if(s.length() <= 1) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= (s.length()/2)) {
            if(s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static List<String> generateAllSubstrings(String s) {
        if(s.length() < 1) {
            return null;
        }
        return helper(s, new ArrayList<>(), 1);
    }

    private static List<String> helper(String s, ArrayList<String> substrings, int index) {
        if(index > s.length()) {
            return substrings;
        }
        for(int i = 0; i <= index; i++) {
            int j = 0;
            while (j != i){
                String sub = s.substring(j, i);
                if(!substrings.contains(sub)) {
                    substrings.add(sub);
                }
                j++;
            }
        }
        return helper(s, substrings, index+1);
    }
}
