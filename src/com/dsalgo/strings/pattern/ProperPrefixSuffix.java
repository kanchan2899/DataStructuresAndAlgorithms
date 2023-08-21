package com.dsalgo.strings.pattern;

import java.util.Arrays;

public class ProperPrefixSuffix {
    public static void main(String[] args) {
        String str = "aaaa";
        System.out.println(Arrays.toString(lps(str, new int[str.length()])));
        System.out.println(Arrays.toString(lps1(str, new int[str.length()])));
    }

    private static int[] lps1(String str, int[] lps) {
        int n = str.length();
        int len = 0;
        int i = 1;

        while (i < n) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        return lps;
    }

    /**
     * TC: O(n ^ 3)
     * SC: O(n)
     *
     * @param str
     * @param lps
     * @return
     */
    private static int[] lps(String str, int[] lps) {
        for(int i = 0; i < str.length(); i++) {
            lps[i] = longestProperPrefixSuffix(str, i+1);
        }
        return lps;
    }

    private static int longestProperPrefixSuffix(String str, int n) {
        for(int len = n - 1; len > 0; len--) {
            boolean flag = true;
            for(int i = 0; i < len; i++) {
                if(str.charAt(i) != str.charAt(n - len + i)) {
                    flag = false;
                }
            }

            if(flag == true) {
                return len;
            }
        }
        return 0;
    }
}
