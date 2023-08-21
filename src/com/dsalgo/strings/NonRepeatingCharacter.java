package com.dsalgo.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
public class NonRepeatingCharacter {
    static final int CHAR = 256;
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(nonRepeatingCharacter(str));
        System.out.println(nonRepeatingCharacter1(str));
        System.out.println(nonRepeatingCharacter2(str));
        System.out.println(nonRepeatingCharacter3(str));
        System.out.println(nonRepeatingCharacter4(str));
        System.out.println(nonRepeatingCharacter5(str));
    }

    /**
     * Using sorting and counting: use a sorting function to rearrange the string characters
     * in ascending order, which can make it easier to identify repeating characters.
     * Then, we can iterate through the sorted string and check for each character if it appears
     * only once in the string. The first such character we encounter will be the first
     * non-repeating character.
     *
     * TC: O(n * log n)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    private static char nonRepeatingCharacter5(String str) {
        char[] chars = str.toCharArray();

        Arrays.sort(chars);

        Map<Character, Integer> count = new HashMap<>();

        for(char ch : chars) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        for(char ch : chars) {
            if(count.get(ch) == 1) {
                return ch;
            }
        }
        return '$';
    }

    /**
     * Using HashMap: Store the character count in the hashmap. Traverse the string again, if the
     * count of the current character is 1, return it
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static char nonRepeatingCharacter4(String str) {
        HashMap<Character, Integer> countMap = new HashMap<>();

        for(char ch : str.toCharArray()) {
            countMap.put(ch, countMap.getOrDefault(ch, 0) + 1);
        }

        for(char ch : str.toCharArray()) {
            if(countMap.get(ch) == 1) {
                return ch;
            }
        }
        return '$';
    }

    /**
     * Using count array: The idea is to mark the repeated elements with some value let’s say -2
     * and the one who repeated one time will be marked with the current index.
     *
     * 1. Make a count array of a maximum number of characters(256) and initialize all the elements
     * in this array to -1.
     * 2. Then loop through the string character by character and check if the array element with
     * this character as the index is -1 or not.
     * 3. If it is -1 then change it to i and. If it is not -1, then this means that this
     * character already appeared before, so change it to -2.
     * 4. In the end, all the repeating characters will be changed to -2 and all non-repeating
     * characters will contain the index where they occur.
     * 5. Now, just loop through all the non-repeating characters and find the minimum index or
     * the first index.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static char nonRepeatingCharacter3(String str) {
        int[] firstIndex = new int[CHAR];

        Arrays.fill(firstIndex, -1);

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(firstIndex[ch] == -1) {
                firstIndex[ch] = i;
            } else {
                firstIndex[ch] = -2;
            }
        }

        int nonRepeatingCharIndex = Integer.MAX_VALUE;

        for(int i = 0; i < CHAR; i++) {
            if(firstIndex[i] >= 0) {
                nonRepeatingCharIndex = Math.min(nonRepeatingCharIndex, firstIndex[i]);
            }
        }

        return (nonRepeatingCharIndex == Integer.MAX_VALUE ? '$' : str.charAt(nonRepeatingCharIndex));
    }

    /**
     * Using HashMap: The idea is to make a count array instead of a hash_map of a maximum number
     * of characters(256). Augment the count array by storing not just counts but also the index
     * of the first time a character is encountered. So when it comes to finding the first
     * non-repeater, just have to scan the count array, instead of the string.
     *
     * 1. Make a count_array which will have two fields namely frequency, first occurrence of a
     * character.
     * 2. The size of count_array is 256.
     * 3. Traverse the given string using a pointer.
     * 4. Increase the count of current characters and update the occurrence.
     * 5. Now here’s a catch, the array will contain a valid first occurrence of the character
     * which has frequency of unity. Otherwise, the first occurrence keeps updating.
     * 6. Now traverse the count_array[] and find the character with the least first occurrence
     * value and frequency value as unity.
     * 7. Return that character.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static char nonRepeatingCharacter2(String str) {
        HashMap<Character, CountIndex> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i))) {
                map.get(str.charAt(i)).incCount();
            } else {
                map.put(str.charAt(i), new CountIndex(i));
            }
        }

        int result = Integer.MAX_VALUE, i;

        for(Map.Entry<Character, CountIndex> entry : map.entrySet()) {
            int c = entry.getValue().count;
            int index = entry.getValue().index;

            if(c == 1 && index < result) {
                result = index;
            }
        }
        return result == Integer.MAX_VALUE ? '$' : str.charAt(result);
    }

    /**
     * Using find() method: The idea is to search for the current character in the string just after
     * its first occurrence in the string. If the character is found in the remaining string then
     * return that character.
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param s
     * @return
     */
    private static char nonRepeatingCharacter1(String s) {
        for(int i = 0; i < s.length(); i++) {
            if(s.indexOf(s.charAt(i), s.indexOf(s.charAt(i)) + 1) == -1) {
                return s.charAt(i);
            }
        }
        return '$';
    }

    /**
     * Bruteforce: The idea is to loop over the string and for every character check the occurrence
     * of the same character in the string. If the count of its occurrence is 1 then return that
     * character. Otherwise, search for the remaining characters.
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    private static char nonRepeatingCharacter(String str) {
        int index = -1;
        char nonRepeatingChar = ' ';

        for(char i : str.toCharArray()) {
            if(str.indexOf(i) == str.lastIndexOf(i)) {
                nonRepeatingChar = i;
                break;
            } else {
                index += 1;
            }
        }

        if(index == str.length() - 1) {
            nonRepeatingChar = '$';
        }
        return nonRepeatingChar;
    }
}

class CountIndex {
    int count, index;

    // constructor for first occurrence
    public CountIndex(int index)
    {
        this.count = 1;
        this.index = index;
    }

    // method for updating count
    public void incCount() { this.count++; }
}
