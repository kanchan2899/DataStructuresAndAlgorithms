package com.dsalgo.grokking.patterns.top.k.elements;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/reorganize-string/description/
public class RearrangeString {
    public static void main(String[] args) {
        String str = "aaab";
        System.out.println(rearrangeString(str));
    }

    /**
     * Time Complexity: As we iterate through the heap, every popped element may be pushed back
     * onto the heap. This process is repeated until we have considered all the characters in
     * the input string. Therefore, the iteration runs O(n) times, where n is the number of
     * characters in the string. The worst-case time complexity of the push operation is O(log c),
     * where c is the number of distinct characters in the string. Now, the time complexity becomes
     * O(n * log c). Since the upper bound on c is the size of the alphabet, which is 26, the (log c)
     * term is effectively a constant. As a result, we may say that the overall time complexity is O(n)
     *
     * @param str
     * @return
     */
    private static String rearrangeString(String str) {
        // initialize the hash map
        Map<Character, Integer> charCount = new HashMap<>();

        // calculate the frequency of each character in string
        for(char ch : str.toCharArray()) {
            charCount.put(ch, charCount.getOrDefault(ch, 0) + 1);
        }

        // initialize max heap
        PriorityQueue<Map.Entry<Character, Integer>> maxFreqChars = new PriorityQueue<>(
                (item1, item2) -> item2.getValue() - item1.getValue());

        // store all characters with their frequencies to the max heap
        maxFreqChars.addAll(charCount.entrySet());

        Map.Entry<Character, Integer> previous = null;
        StringBuilder result = new StringBuilder(str.length());

        while (!maxFreqChars.isEmpty() || previous != null) {

            if(previous != null && maxFreqChars.isEmpty()) {
                return "";
            }
            Map.Entry<Character, Integer> currentEntry = maxFreqChars.poll();

            // decrement the character count
            int count = currentEntry.getValue() - 1;
            result.append(currentEntry.getKey());

            // pushing the char back to heap
            if(previous != null) {
                maxFreqChars.add(previous);
                previous = null;
            }

            // setting previous to the most recently used char
            if(count != 0) {
                previous = new AbstractMap.SimpleEntry<>(currentEntry.getKey(), count);
            }
        }
        return result.toString();
    }
}
