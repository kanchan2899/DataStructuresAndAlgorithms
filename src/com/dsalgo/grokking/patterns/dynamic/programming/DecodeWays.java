package com.dsalgo.grokking.patterns.dynamic.programming;

// https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    public static void main(String[] args) {
        String decodeStr = "11223344";
        System.out.println(numOfDecodings(decodeStr));
    }

    private static int numOfDecodings(String decodeStr) {
        int strLen = decodeStr.length();

        int[] dp = new int[strLen + 1];

        // there is only one way to decode an empty string
        dp[0] = 1;

        // the first element of the dp array is 1 if the first character of the string is not '0',
        // otherwise it is 0
        if(decodeStr.charAt(0) != '0') {
            dp[1] = 1;
        } else {
            dp[1] = 0;
        }

        // iterate through the input string starting from the 2nd character
        for(int i = 2; i <= strLen; i++) {
            // if the current character is not '0', add the number of ways to decode the substring
            // without the current character
            if(decodeStr.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // if the substring of the current and previous characters is a valid two-digit number,
            // add the number of ways to decode the substring without the current and previous characters
            if(decodeStr.charAt(i - 2) == '1' || (decodeStr.charAt(i - 2) == '2' && decodeStr.charAt(i - 1) <= '6')) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[strLen];
    }
}
