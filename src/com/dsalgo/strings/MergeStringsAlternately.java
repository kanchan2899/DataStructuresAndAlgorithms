package com.dsalgo.strings;

// https://leetcode.com/problems/merge-strings-alternately/
public class MergeStringsAlternately {
    public static void main(String[] args) {
        String a = "abc";
        String b = "xyzz";
        System.out.println(mergeAlternately(a, b));
    }
    public static String mergeAlternately(String word1, String word2) {
        StringBuffer s = new StringBuffer();
        int i = 0;
        int j = 0;
        int count = word1.length() + word2.length();
        while(count != 0){
            while(i < word1.length() && j < word2.length()){
                s.append(word1.charAt(i++));
                count--;
                s.append(word2.charAt(j++));
                count--;
            }
            while(i < word1.length()){
                s.append(word1.charAt(i++));
                count--;
            }
            while(j < word2.length()){
                s.append(word2.charAt(j++));
                count--;
            }
        }
        return s.toString();
    }
}
