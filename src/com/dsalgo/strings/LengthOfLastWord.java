package com.dsalgo.strings;

// https://leetcode.com/problems/length-of-last-word/
public class LengthOfLastWord {
    public static void main(String[] args) {
        String[] s = {"Hello World", "   red   blue     "};
        for(String k : s){
            System.out.println(lengthOfLastWord(k));
        }
    }
    public static int lengthOfLastWord(String s) {
        int length = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != ' '){
                length++;
            } else {
                if (length > 0) return length;
            }
        }
        return length;
    }
}
