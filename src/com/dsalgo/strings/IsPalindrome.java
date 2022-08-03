package com.dsalgo.strings;

public class IsPalindrome {
    public static void main(String[] args) {
        String[] a = {"abccba", "abcba", "abcdefgh", "", null};
        for(int i = 0; i < a.length; i++){
            System.out.println(isPalindrome(a[i]));
        }
    }

    private static boolean isPalindrome(String s) {
        if(s == "" || s == null){
            return true;
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
