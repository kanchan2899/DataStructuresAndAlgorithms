package com.dsalgo.strings;

// https://practice.geeksforgeeks.org/problems/the-modified-string-1587115621/1
public class TheModifiedString {
    public static void main(String[] args) {
        String str = "aaaaa";
        System.out.println(modified(str));
    }

    public static long modified(String a) {
        long modificationCount = 0;
        long consecutiveCount = 1;

        for(int i = 1; i < a.length(); i++) {
            boolean b = a.charAt(i) == a.charAt(i - 1);
            if(consecutiveCount == 2 && b) {
                modificationCount++;
                consecutiveCount = 1;
            } else if(b) {
                consecutiveCount++;
            } else {
                consecutiveCount = 1;
            }
        }
        return modificationCount;
    }
}
