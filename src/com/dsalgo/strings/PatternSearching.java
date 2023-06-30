package com.dsalgo.strings;

// https://practice.geeksforgeeks.org/problems/pattern-searching5231/1
public class PatternSearching {
    public static void main(String[] args) {
        String str = "ababdabacdababcabab";
        String pattern = "ababcaf";
        System.out.println(searchPattern(str, pattern));
        System.out.println(searchPattern1(str, pattern));
    }

    /**
     * Initialize n and m as string and pattern length respectively.
     * Initialize i = 0 (keep track of str index), j = 0 (keep track of pattern index),
     * count = 0 (count the matching pattern chars in str),
     * x = 0 (x to slide the window if pattern doesn't exist)
     *
     * Start a while loop till i < n and j < m
     * if str[i] == pat[i], increment i, j and count. Else, reset count to 0, j to 0 and i to x++
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param str
     * @param pat
     * @return
     */
    public static boolean searchPattern(String str, String pat) {
        int n = str.length();
        int m = pat.length();
        if(m > n) {
            return false;
        }

        int i = 0, j = 0, count = 0, x = 0;

        while (i < n && j < m) {
            if(str.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                count++;
            } else {
                count = 0;
                j = 0;
                i = x++;
            }
        }
        if(count == m) {
            return true;
        }
        return false;
    }

    /**
     * Bruteforce: Initialize n to string length + pattern length - 1 and m to patter length
     * Start a loop i from 0 to n-1, start and inner loop j from 0 to m.
     * If str[i+j] != pat[j], break out of loop. If they are equal, do nothing. If j == pat.length() - 1,
     * return true. Else return false.
     *
     * TC: O(n * m)
     * SC: O(1)
     *
     * @param str
     * @param pat
     * @return
     */
    public static boolean searchPattern1(String str, String pat) {
        int n = str.length() - pat.length() - 1;
        int m = pat.length();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(str.charAt(j+i) != pat.charAt(j)) {
                    break;
                } else if (j == pat.length() - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
