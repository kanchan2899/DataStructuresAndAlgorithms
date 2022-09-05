package com.dsalgo.recursion;

// https://www.geeksforgeeks.org/recursively-remove-adjacent-duplicates-given-string/
/*
Not completed
 */
public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) {
        String s = "aabccba";
        System.out.println(removeAdjacentDuplicates(s));
    }

    private static String removeAdjacentDuplicates(String s) {
        char[] x = new char[10];
        int j = -1;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) != s.charAt(i + 1)){
               x[++j] = s.charAt(i);
            }
        }
        return String.valueOf(x);
    }
}
