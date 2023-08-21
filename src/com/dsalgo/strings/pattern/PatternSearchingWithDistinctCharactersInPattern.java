package com.dsalgo.strings.pattern;

public class PatternSearchingWithDistinctCharactersInPattern {
    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pattern = "eks";
        patternSearching(text, pattern);
    }

    private static void patternSearching(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for(int i = 0; i <= n - m;) {
            int j;
            for(j = 0; j < m; j++) {
                if(pattern.charAt(j) != text.charAt(i + j)) {
                    break;
                }
            }
            if(j == m) {
                System.out.println(i + " ");
            }
            if(j == 0) {
                i++;
            } else {
                i = i + j;
            }
        }
    }
}
