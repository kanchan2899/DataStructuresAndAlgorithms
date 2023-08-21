package com.dsalgo.strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/a-program-to-check-if-strings-are-rotations-of-each-other/
public class AreRotationsOfEachOther {
    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "CDBA";
        System.out.println(areRotationsOfEachOther(s1, s2));
        System.out.println(areRotationsOfEachOther1(s1, s2));
        System.out.println(areRotationsOfEachOther2(s1, s2));
        System.out.println(areRotationsOfEachOther3(s1, s2));
    }

    /**
     * Using comparing the prefix and suffix:
     *
     * 1. Check if size of two strings are same. If not, return false
     * 2. Check if ith character is equal to the first character of s2
     *      a. check prefix of s1 with suffix of s2
     *      b. check suffix of s2 with prefix of s1
     * 3. If none of the above cases satisfy, then answer is no. Else yes
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean areRotationsOfEachOther3(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        } else {
            for(int i = 0; i < s1.length(); i++) {
                // checking character at ith index with first character of s2
                if(s1.charAt(i) == s2.charAt(0)) {
                    // checking prefix of s2 with suffix of s1
                    if(s1.substring(i).equals(s2.substring(0, s1.length() - i))) {
                        // checking prefix of s1 with suffix of s2
                        if(s1.substring(0, i).equals(s2.substring(s1.length() - i))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Using a temp string:
     *
     * 1. Create a temporary string and concatenate s1 and s2 in it
     * 2. If s2 is a substring of temp, then s1 and s2 are rotations of each other
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean areRotationsOfEachOther2(String s1, String s2) {
        System.out.println((s1 + s2).indexOf(s2));
        return ((s1.length() == s2.length()) &&
                (s1 + s1).indexOf(s2) != -1);
    }

    /**
     * Using queue:
     *
     * 1. If the size of both strings is not equal, return false
     * 2. Push the original string into the queue q1
     * 3. Push s2 into the queue q2
     * 4. Keep popping q2's and pushing it back into it till the number of such operations is less
     * than the size of the string
     * 5. If q2 becomes equal to q1 at any point during these operations, it is possible. Else not.
     *
     * TC: O(n^2)
     * SC: O(n)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean areRotationsOfEachOther1(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        Queue<Character> q1 = new LinkedList<>();
        for(char c : s1.toCharArray()) {
            q1.add(c);
        }

        Queue<Character> q2 = new LinkedList<>();
        for(char c : s2.toCharArray()) {
            q2.add(c);
        }

        int k = s2.length();

        while (k > 0) {
            k--;
            char ch = q2.peek();
            q2.remove();
            q2.add(ch);
            if(q2.equals(q1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Bruteforce:
     *
     * 1. Find all the postions of the first character of the s1 in s2
     * 2. For every position found, consider it to be the starting index of s2
     * 3. Beginning from the new starting index, compare both strings and check whether they are equal or not
     * 4. Check s1[i] == s2[j+1] % n, return false if any character mismatch is found, else return true.
     * 5. Repeat step 3 for all positions found
     *
     * @param s1
     * @param s2
     * @return
     */
    private static boolean areRotationsOfEachOther(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        } else {
            ArrayList<Integer> indexes = new ArrayList<>();
            int n = s1.length();
            char firstChar = s1.charAt(0);

            for(int i = 0; i < n; i++) {
                if(s2.charAt(i) == firstChar) {
                    indexes.add(i);
                }
            }
            boolean isRotation = false;

            for(int idx : indexes) {
                isRotation = checkStrings(s1, s2, idx, n);
                if(isRotation) {
                    break;
                }
            }

            if(isRotation) {
                return true;
            } else {
                return false;
            }
        }
    }

    private static boolean checkStrings(String s1, String s2, int idx, int n) {
        for(int i = 0; i < n; i++) {
            if(s1.charAt(i) != s2.charAt((idx + i) % n)) {
                return false;
            }
        }
        return true;
    }
}
