package com.dsalgo.grokking.patterns.know.what.to.track;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String a = "cbaebabacd";
        String b = "abc";
        System.out.println(findAnagrams(a, b));
    }

    private static List<Integer> findAnagrams(String a, String b) {
        // list to return th output, i.e., start indexes of all anagrams of string b in string a
        List<Integer> anagramsIndexes = new ArrayList<>();

        // if length of string b is greater than string a, return an empty list
        if(b.length() > a.length()) {
            return anagramsIndexes;
        }

        // create hash maps
        Map<Character, Integer> hashA = new HashMap<>();
        Map<Character, Integer> hashB = new HashMap<>();

        // populate hashB with the count of characters in string b
        for(char ch : b.toCharArray()) {
            hashB.put(ch, hashB.getOrDefault(ch, 0) + 1);
        }

        int	windowEnd = 0;
        // traverse string a: in each iteration, move the window rightward by one character
        while (windowEnd < a.length()) {

            // to move the window rightward, add a new element in it, i.e.,
            // add this new element and its count in the hash map, hashA
            if (!hashA.containsKey(a.charAt(windowEnd))) hashA.put(a.charAt(windowEnd), 1);
            else hashA.put(a.charAt(windowEnd), hashA.get(a.charAt(windowEnd)) + 1);

            // index of the left-most element in the sliding window
            int windowStart = windowEnd - b.length();

            // if the length of the sliding window exceeds the length of string b,
            // make it equal to the length of string b by removing the left most element from the window, i.e.,
            // remove the left most element from the hash map, hashA
            if (windowEnd >= b.length())

                // if the count of left-most element is 1, it means it is safe to delete it from the hash map, hashA
                if (hashA.get(a.charAt(windowStart)) == 1)
                    hashA.remove(a.charAt(windowStart));

                    // if the count is greater than 1, then just remove one occurence of it from the hash map, hashA
                else
                if (!hashA.containsKey(a.charAt(windowStart))) hashA.put(a.charAt(windowStart), 1);
                else hashA.put(a.charAt(windowStart), hashA.get(a.charAt(windowStart)) - 1);

            windowEnd++;

            // if the count of characters in hashA equals the hashA, we got the anagram,
            // so append its start index to the output list
            if (hashA.equals(hashB)) {
                anagramsIndexes.add(windowEnd - b.length());
            }
        }
        return anagramsIndexes;
    }

}
