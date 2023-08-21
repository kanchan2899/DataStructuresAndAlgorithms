package com.dsalgo.strings.pattern;

public class KMPAlgo {
    public static void main(String[] args) {
        String text = "ababcababaad";
        String pattern = "ababa";

        kmp(text, pattern);
    }

    private static void kmp(String text, String pattern) {
        int m = pattern.length();
        int n = text.length();

        // create lps[] that will hold the longest prefix suffix values for pattern
        int[] lps = new int[m];
        int j = 0;      // index for pat[]

        // preprocess the pattern (calculate lps[] array)
        computeLPSArray(pattern, m, lps);

        int i = 0;      // index for text[]

        while (n - i >= m - j) {
           if(pattern.charAt(j) == text.charAt(i)) {
               j++;
               i++;
           }
           if(j == m) {
               System.out.println("Found pattern at index " + (i - j));
               j = lps[j - 1];
           }
           // mismatch after j matches
           else if(i < n && pattern.charAt(j) != text.charAt(i)) {
               // do not match lps[0..lps[j-1]] characters, they match anyway
               if(j != 0) {
                   j = lps[j - 1];
               } else {
                   i++;
               }
           }
        }
    }

    private static void computeLPSArray(String pattern, int m, int[] lps) {
        // length of previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;     // lps[0] is always 0

        // the loop calculates lps[i] for i = 1 to m - 1
        while (i < m) {
            if(pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {    //pat[i] != pat[len]
                if(len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
}
