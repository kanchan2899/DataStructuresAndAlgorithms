package com.dsalgo.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Vector;

// https://www.geeksforgeeks.org/concatenated-string-uncommon-characters-two-strings/
public class RemoveCommonCharsAndConcatenate {
    public static void main(String[] args) {
        String s1 = "abcs";
        String s2 = "cxzca";

        System.out.println(concatenatedString(s1, s2));
        System.out.println(concatenatedString1(s1, s2));
        System.out.println(concatenatedString2(s1, s2));
        System.out.println(concatenatedString3(s1, s2));
    }

    /**
     * Using concatenated string
     *
     * TC: O(m + n)
     * SC: O(m + n)
     * @param s1
     * @param s2
     * @return
     */
    private static String concatenatedString3(String s1, String s2) {
        String concatenatedStr = "";
        String str = s1 + s2;
        for(int i = 0; i < str.length(); i++) {
            String a = "" + str.charAt(i);
            if(s1.contains(a) && s2.contains(a)) {
                continue;
            } else {
                concatenatedStr += a;
            }
        }

        if(concatenatedStr.length() == 0) {
            return "-1";
        }
        return concatenatedStr;
    }

    /**
     * Using count array:
     *
     * 1. Create two arrays, count1 and count2, of size 26 (assuming lowercase English alphabets)
     * initialized with zeros. These arrays will be used to count the occurrences of each character
     * in s1 and s2, respectively.
     * 2. Iterate over each character in s1 and increment the corresponding count in count1.
     * 3. Iterate over each character in s2 and increment the corresponding count in count2.
     * 4. Create an empty string, modified, to store the modified string.
     * 5. Iterate over each character in s1:
     *  a. If the count of the character in count2 is 0, it is an uncommon character. Append it
     *  to modified.
     * 6. Iterate over each character in s2:
     *  a. If the count of the character in count1 is 0, it is an uncommon character. Append it
     *  to modified.
     * 7. If modified is empty, return -1. Otherwise, return modified.
     *
     * TC: O(m + n)
     * SC: O(1)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static String concatenatedString2(String s1, String s2) {
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        StringBuilder ans = new StringBuilder();

        for(char ch : s1.toCharArray()) {
            count1[ch - 'a']++;
        }

        for(char ch : s2.toCharArray()) {
            count2[ch - 'a']++;
        }

        for(char ch : s1.toCharArray()) {
            if(count2[ch - 'a'] == 0) {
                ans.append(ch);
            }
        }

        for(char ch : s2.toCharArray()) {
            if(count1[ch - 'a'] == 0) {
                ans.append(ch);
            }
        }

        if(ans.length() == 0) {
            return "-1";
        }

        return ans.toString();
    }

    /**
     * Using set:
     *
     * 1. Initialize the result as an empty string.
     * 2. Add all characters of S2 string in a set.
     * 3. Traverse S1 string and append all those characters to result that are not present
     * in the set.
     * 4. Return the result.
     *
     * TC: O(m + n)
     * SC: O(n)
     *
     * @param s1
     * @param s2
     * @return
     */
    private static String concatenatedString1(String s1, String s2) {
        String concatenatedStr = "";

        HashSet<Character> set = new HashSet<>();

        for(char ch : s2.toCharArray()) {
            set.add(ch);
        }

        for(char ch : s1.toCharArray()) {
            if(!set.contains(ch)) {
                concatenatedStr += ch;
            } else {
                set.remove(ch);
            }
        }

        for(char ch : set) {
            concatenatedStr += ch;
        }

        return concatenatedStr;
    }

    /**
     * Using HashMap: The idea is to use Hashmap where the key is a character and the value is
     * an integer i.e. number of strings in which the character is present. If a character is
     * present in one string, then the count is 1, else if the character is present in both
     * strings, the count is 2.
     *
     * 1. Initialize the result as an empty string.
     * 2. Push all characters of S2 string in map with count as 1.
     * 3. Traverse first string and append all those characters to result that are not
     * present in map then make their count 2.
     * 4. Traverse second string and append all those characters to result whose count is 1.
     *
     * TC: O(m + n)
     * SC: O(max(m, n))
     *
     * @param s1
     * @param s2
     * @return
     */
    private static String concatenatedString(String s1, String s2) {
        String concatenatedStr = "";
        int i;

        HashMap<Character, Integer> map = new HashMap<>();

        for(i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i), map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for(i = 0; i < s1.length(); i++) {
            if(!map.containsKey(s1.charAt(i))) {
                concatenatedStr += s1.charAt(i);
            } else {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            }
        }

        for(i = 0; i < s2.length(); i++) {
            if(map.get(s2.charAt(i)) == 1) {
                concatenatedStr += s2.charAt(i);
            }
        }
        return concatenatedStr;
    }
}
