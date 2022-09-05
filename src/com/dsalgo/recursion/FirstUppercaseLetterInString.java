package com.dsalgo.recursion;

// https://www.geeksforgeeks.org/first-uppercase-letter-in-a-string-iterative-and-recursive/
public class FirstUppercaseLetterInString {
    public static void main(String[] args) {
        String[] s = {"geeksForgeeKs", "geEkS"};
        for(String str : s){
            System.out.println(firstUpper(str, 0));
        }
    }
    private static char firstUpper(String str, int index) {
        if(index > str.length()){
            return '\u0000';
        }
        if(str.charAt(index) >= 65 && str.charAt(index) <= 90){
            return str.charAt(index);
        }
        return firstUpper(str, index + 1);
    }
}
