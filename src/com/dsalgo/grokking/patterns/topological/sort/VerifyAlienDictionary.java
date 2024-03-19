package com.dsalgo.grokking.patterns.topological.sort;

import javax.swing.plaf.TreeUI;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/verifying-an-alien-dictionary/description/
public class VerifyAlienDictionary {
    public static void main(String[] args) {
        String[] words = {"alpha", "bravo", "charlie", "delta"};
        String order = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(isAlienSorted(words, order));
    }

    /**
     * 1. We initialize a hash map to record the relations between each letter and its
     * ranking in the order list.
     * 2. We iterate over the words and compare each pair of adjacent words.
     *    - We find the first index in two consecutive words (words[i] and words[i + 1]) where
     *    the letter in the two words is different.
     *      - If words[i + 1] ends before words[i] and no different letters are found, then we need
     *      to return FALSE because words[i + 1] should come before words[i].
     *      - If we find the first different letter and the two letters are in the correct order,
     *      then we exit from the current iteration and proceed to the next pair of words.
     *      - If we find the first different letter and the two letters are in the wrong order,
     *      then we safely return FALSE.
     * 3. By the time we reach the end of the outer loop, we have examined all the pairs of adjacent
     * words and ensured that they are all sorted. Therefore, we return TRUE.
     *
     *
     * @param words
     * @param order
     * @return
     */
    private static boolean isAlienSorted(String[] words, String order) {
        // if there is only one word to check, this is a trivial case with not enough input,
        // i.e. minimum two words to run the algorithm. Return TRUE
        if(words.length == 1) {
            return true;
        }

        // declare a hashmap to store the characters of the words
        Map<Character, Integer> orderMap = new HashMap<>();

        // traverse order and store the rank of each letter in orderMap
        for(int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        for(int i = 0; i < words.length - 1; i++) {
            // traverse each character in a word
            for(int j = 0; j < words[i].length(); j++) {
                // if all the letters have matched so far, but the current word is longer than
                // the next one, the two are not in order and we return FALSE
                if(j >= words[i + 1].length()) {
                    return false;
                }
                // check if the letters in the same position in the two words are different
                if(words[i].charAt(j) != words[i + 1].charAt(j)) {
                    // check if the rank of the letter in the current word is greater than the
                    // rank in the same position in the next word
                    if(orderMap.get(words[i].charAt(j)) > orderMap.get(words[i + 1].charAt(j))) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        return true;
    }
}
