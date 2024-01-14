package com.dsalgo.grokking.patterns.sliding.window;

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
        String str1 = "abcdefghijklmnop";
        String str2 = "acfi";
        System.out.println(minWindow(str1, str2));
    }

    private static String minWindow(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // initialize minSublen to a very large number
        float minSublen = Float.POSITIVE_INFINITY;

        // initialize pointers to zero and the minsubsequence to an empty sequence
        int index1 = 0, index2 = 0;
        int start = 0, end = 0;

        String minSubsequence = "";

        // process every character of str1
        while (index1 < len1) {
            // check if the character pointed by the index1 in str1 is the same as the character
            // pointed by the index2 in str2
            if(str1.charAt(index1) == str2.charAt(index2)) {
                // if the pointed character is the same in both strings increment index2
                index2 += 1;

                // Check if index2 has reached the end of str2
                if(index2 == len2) {
                    // at this point the str1 contains all characters of str2
                    start = index1;
                    end = index1;

                    // initialize start to the index where all characters of str2 were present in str1
                    index2 -= 1;

                    // decrement pointer index2 and start a reverse loop
                    while (index2 >= 0) {
                        // decrement pointer index2 until all characters of str2 are found in str1
                        if(str1.charAt(start) == str2.charAt(index2)) {
                            index2 -= 1;
                        }
                        // decrement start pointer everytime to find the starting point of the required sequence
                        start -= 1;
                    }

                    start += 1;
                    // check if length of subsequence by start and end pointers is less than current min length
                    if((end - start + 1) < minSublen) {
                        // update minSublen if current subsequence is
                        minSublen = end - start + 1;

                        // update minimum subsequence string to this new shorter string
                        minSubsequence = str1.substring(start, end + 1);
                    }

                    // set index1 to start to continue checking in str1 after this discovered subsequence
                    index1 = start;
                    index2 = 0;
                }
            }

            // increment pointer index1 to check next character in str1
            index1 += 1;
        }
        return minSubsequence;
    }
}
