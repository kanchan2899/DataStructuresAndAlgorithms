package com.dsalgo.recursion.strings.subsequence;

public class AllPermutationsStrings {
    public static void main(String[] args) {
        String str = "abc";
        permute(str);
    }

    private static void permute(String str) {
        helper(str, 0);
    }

    /**
     * Using recursion: Fix each character at index 0 and make different combination with the
     * rest of the characters
     *
     * TC: O(2 ^ n)
     * SC: O(n)
     * @param str
     * @param i
     */
    private static void helper(String str, int i) {
        if(i == str.length() - 1) {
            System.out.println(str);
            return;
        }
        for(int j = i ; j < str.length(); j++) {
            str = swap(str, i, j);
            helper(str, i + 1);
            str = swap(str, i, j);
        }
    }

    private static String swap(String s, int i, int j) {
        char[] ch = s.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }
}
