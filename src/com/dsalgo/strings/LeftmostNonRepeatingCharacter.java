package com.dsalgo.strings;

import java.util.Arrays;

public class LeftmostNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(leftmostNonRepeatingChar(str));
        System.out.println(leftmostNonRepeatingChar1(str));
        System.out.println(leftmostNonRepeatingChar2(str));
    }

    /**
     * Using count array and one traversal
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    private static char leftmostNonRepeatingChar2(String str) {
        int[] firstIndex = new int[256];
        Arrays.fill(firstIndex, -1);

        for(int i = 0; i < str.length(); i++) {
            if(firstIndex[str.charAt(i)] == -1) {
                firstIndex[str.charAt(i)] = i;
            } else {
                firstIndex[str.charAt(i)] = -2;
            }
        }
        int nrIndex = Integer.MAX_VALUE;

        for(int i = 0; i < 256; i++) {
            if(firstIndex[i] >= 0) {
                nrIndex = Math.min(nrIndex, firstIndex[i]);
            }
        }
        return (nrIndex == Integer.MAX_VALUE) ? '$' : str.charAt(nrIndex);
    }

    /**
     * Using char array:
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static char leftmostNonRepeatingChar1(String str) {
        int[] count = new int[256];
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        for(int i = 0; i < str.length(); i++) {
            if(count[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '$';
    }

    /**
     * Bruteforce:
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     * @param str
     * @return
     */
    private static char leftmostNonRepeatingChar(String str) {

        for(int i = 0; i < str.length(); i++) {
            boolean flag = false;
            for(int j = 0; j < str.length(); j++) {
                if(i != j && str.charAt(i) == str.charAt(j)) {
                    flag = true;
                    break;
                }
            }

            if(flag == false) {
                return str.charAt(i);
            }
        }
        return '$';
    }
}
