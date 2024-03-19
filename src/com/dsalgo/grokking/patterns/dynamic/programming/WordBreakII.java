package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/word-break-ii/description/
public class WordBreakII {
    public static void main(String[] args) {
        String s = "vegancookbook";
        List<String> wordDict = Arrays.asList("ycrashpineapplepenapplescreamicecreamed", "pin", "book", "p", "sa", "okb", "andd", "ayc", "sh", "vegan", "cookbook");
        System.out.println(wordBreak(s, wordDict));
    }

    /**
     * Using DP:
     *
     * 1. We create a 2D table where each entry corresponds to a prefix of the input string.
     * At this point, each entry contains an empty array.
     * 2. We iterate over all prefixes of the input string. For each prefix, we iterate over
     * all of its suffixes.
     * 3. For each suffix, we check whether it’s a valid word, i.e., whether it’s present in
     * the provided dictionary.
     * 4. If the suffix is a valid word, we combine it with all valid sentences from the
     * corresponding entry (in the table) of the prefix to the left of it.
     * 5. We store the array of all possible sentences that can be formed using the current
     * prefix in the corresponding entry of the table.
     * 6. After processing all prefixes of the input string, we return the array in the last
     * entry of our table.
     *
     * TC: O(n ^ 2 (w + 2 ^ n))
     * SC: O(2 ^ n)
     *
     * @param s
     * @param wordDict
     * @return
     */
    private static List<String> wordBreak(String s, List<String> wordDict) {
        List<List<String>> dp = new ArrayList<>(s.length() + 1);

        for(int i = 0; i <= s.length(); i++) {
            dp.add(new ArrayList<>());
        }

        // setting base case
        dp.get(0).add("");

        // for each substring in the input string, repeat the process
        for(int i = 1; i <= s.length(); i++) {
            String prefix = s.substring(0, i);
            List<String> temp = new ArrayList<>();

            // iterate over the current prefix and break it down into all possible suffixes
            for(int j = 0; j < i; j++) {
                String suffix = prefix.substring(j);

                // check if the current suffix exists in wordDict. If it does, we know that it
                // is a valid word and can be used a part of the solution
                if(wordDict.contains(suffix)) {
                    // retrieve the valid sentences from the previously computed subproblem
                    for(String substring: dp.get(j)) {
                        temp.add(substring + (substring.isEmpty() ? "" : " ") + suffix);
                    }
                }
            }
            dp.set(i, temp);
        }
        return dp.get(s.length());
    }
}
