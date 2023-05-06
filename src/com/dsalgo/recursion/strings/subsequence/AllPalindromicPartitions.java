package com.dsalgo.recursion.strings.subsequence;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/given-a-string-print-all-possible-palindromic-partition/
public class AllPalindromicPartitions {
    public static void main(String[] args) {
        String s[] = {"nitin", "geeks"};
        for(String str: s) {
            System.out.println(allPalindromicPartitions(str));
        }
    }

    private static List<String> allPalindromicPartitions(String str) {
        return helper(str, "");
    }

    private static List<String> helper(String str, String processed) {
        if(str.isEmpty()) {
            List<String> list = new ArrayList<>();
            if(isPalindrome(processed))
                list.add(processed);
            return list;
        }
        char ch = str.charAt(0);
        List<String> left = helper(str.substring(1), processed);
        List<String> right = helper(str.substring(1), processed + ch);

        left.addAll(right);
        return left;
    }

    static boolean isPalindrome(String s) {
        if(s == "" || s == null){
            return false;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start != (s.length()/2)){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
