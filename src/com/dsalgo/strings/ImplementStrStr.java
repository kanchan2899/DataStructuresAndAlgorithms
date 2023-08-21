package com.dsalgo.strings;

// https://www.geeksforgeeks.org/check-string-substring-another/
public class ImplementStrStr {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        String x = "for";
        System.out.println(strstr(s, x));
    }

    /**
     * Naive approach: Run a loop from start to end and for every index in the given string check
     * whether the sub-string can be formed from that index. This can be done by running a nested
     * loop traversing the given string and in that loop running another loop checking for
     * sub-strings starting from every index.
     *
     * 1. Run a for loop with counter i from 0 to N – M.
     * 2. Run a for loop with counter j from 0 to M-1.
     * 3. Compare jth character of S1 with (i+j)th character of S2.
     * 4. If the loop terminates after matching all the characters, then return i, i.e.
     * substring S1 is found starting from ith character of S2
     * 5. Return -1 as no substring is found.
     *
     * TC: O(n * m)
     * SC: O(1)
     *
     * @param s
     * @param x
     * @return
     */
    private static int strstr(String s, String x) {
        for(int i = 0; i <= s.length() - x.length(); i++) {
            int j = 0;
            for(; j < x.length(); j++) {
                if(s.charAt(i+j) == x.charAt(j)) {
                    continue;
                }
                else {
                    break;
                }
            }
            if(j == x.length()) {
                return i;
            }
        }
        return -1;
    }
}
