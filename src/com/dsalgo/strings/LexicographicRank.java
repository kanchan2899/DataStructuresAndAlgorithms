package com.dsalgo.strings;

// https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
public class LexicographicRank {
    static final long q = 1000000007;
    static final int CHAR = 256;
    public static void main(String[] args) {
        String str = "string";
        System.out.println(lexRank(str));
    }

    /**
     *
     * Using
     * TC: O(n)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    private static long lexRank(String str) {
        long rank = 1;
        int n = str.length();
        long multiplier = fact(n);
        int[] count = new int[CHAR];

        for(int i = 0; i < n; i++) {
            if(count[str.charAt(i)] == 1) {
                return 0;
            }
            count[str.charAt(i)]++;
        }

        for(int i = 1; i < CHAR; i++) {
            count[i] += count[i - 1];
        }

        for(int i = 0; i < n - 1; i++) {
            multiplier = multiplier / (n - i);
            rank = rank + (count[str.charAt(i) - 1] * fact(n - i - 1)) % q;

            rank = rank % q;

            for(int j = str.charAt(i); j < CHAR; j++) {
                count[j]--;
            }
        }
        return (int)(rank % q);
    }
    private static long fact(int n) {
        if(n == 1 || n == 0) {
            return 1;
        }
        return (n * fact(n - 1)) % q;
    }
}
