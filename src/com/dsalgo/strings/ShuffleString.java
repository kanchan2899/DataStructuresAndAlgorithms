package com.dsalgo.strings;

// https://leetcode.com/problems/shuffle-string/
public class ShuffleString {
    public static void main(String[] args) {
        String s = "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString(s, indices));
    }

    public static String restoreString(String s, int[] indices) {
        char[] c = s.toCharArray();
        char[] n = new char[c.length];
        for(int i = 0; i < indices.length; i++){
            n[indices[i]] = c[i];
        }
        return String.valueOf(n);
    }
}
