package com.dsalgo.strings;

// https://www.geeksforgeeks.org/check-string-substring-another/
public class IsSubsequence {
    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "for";
        System.out.println(isSubsequence(s1, s2));
        System.out.println(isSubsequence1(s1, s2, s1.length(), s2.length()));
    }

    private static boolean isSubsequence1(String s1, String s2, int n, int m) {
        if(m == 0) {
            return true;
        }

        if(n == 0) {
            return false;
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)) {
            return isSubsequence1(s1, s2, n-1, m-1);
        }
        return isSubsequence1(s1, s2, n-1, m);
    }

    private static boolean isSubsequence(String s1, String s2) {
        if(s1.length() < s2.length()) {
            return false;
        }
        int j = 0;
        for(int i = 0; i < s1.length() && j < s2.length(); i++) {
            if(s1.charAt(i) == s2.charAt(j)) {
                j++;
            }
        }
        return j == s2.length();
    }
}
