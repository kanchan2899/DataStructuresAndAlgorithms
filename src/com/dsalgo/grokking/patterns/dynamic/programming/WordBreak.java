package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-break/
public class WordBreak {
    public static void main(String[] args) {
        String s = "vegancookbooks";
        List<String> dict = Arrays.asList("ncoo", "kboo", "inea", "icec", "ghway", "and", "anco", "hi", "way", "wa",
                "amic", "ed", "cecre", "ena", "tsa", "ami", "lepen", "highway", "ples",
                "ookb", "epe", "nea", "cra", "lepe", "ycras", "dog", "nddo", "hway",
                "ecrea", "apple", "shp", "kbo", "yc", "cat", "tsan", "ganco", "lescr",
                "ep", "penapple", "pine", "book", "cats", "andd", "vegan", "cookbook");
        System.out.println(wordBreak(s, dict));
    }

    private static boolean wordBreak(String s, List<String> dict) {
        int n = s.length();

        // create a set of words from the list so that the lookup cost in the set becomes O(1)
        Set<String> wordSet = new HashSet<>(dict);

        boolean[] dp = new boolean[n + 1];

        // set the first element to true as it represents the empty string
        dp[0] = true;

        for(int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                // check if the substring from j to i is present in the wordSet and dp[j] is true
                if(dp[j] && wordSet.contains(s.substring(j , i))) {
                    dp[i] = true;
                    break;      // if a substring is found, no need to check further smaller substrings
                }
            }
        }


        return dp[n];
    }
}
