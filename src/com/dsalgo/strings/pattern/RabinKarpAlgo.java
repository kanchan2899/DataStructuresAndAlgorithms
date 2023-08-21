package com.dsalgo.strings.pattern;

// https://www.geeksforgeeks.org/rabin-karp-algorithm-for-pattern-searching/
public class RabinKarpAlgo {
    static final int d = 256;
    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEKS";
        int q = 101;    // prime number
        search(text, pattern, q);
    }

    private static void search(String text, String pattern, int q) {
        int m = pattern.length();
        int n = text.length();
        int i, j;
        int p = 0;       // hash value of pattern
        int t = 0;       // hash value of text
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for(i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // calculate the hash value of pattern and first window of text
        for(i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // slide the pattern over text one by one
        for(i = 0; i <= n - m; i++) {
            // check the hash value of current window of text and pattern. If the hash values match,
            // then only check for characters one by one
            if(p == t) {
                for(j = 0; j < m; j++) {
                    if(text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }

                if(j == m) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // calculate hash value for next window of text, remove leading digit, add trailing digit
            if(i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;

                if(t < 0) {
                    t = (t + q);
                }
            }
        }
    }
}
