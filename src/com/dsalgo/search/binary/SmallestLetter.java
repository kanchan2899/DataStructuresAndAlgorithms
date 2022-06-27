package com.dsalgo.search.binary;

// https://leetcode.com/problems/find-smallest-letter-greater-than-target/
public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'a', 'c', 'g', 'i', 'k', 'n'};
        char target = 'p';
        System.out.println(smallestLetter(letters, target));
    }

    private static char smallestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(letters[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return letters[start % letters.length];
    }
}
