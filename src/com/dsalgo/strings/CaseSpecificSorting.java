package com.dsalgo.strings;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Vector;

// https://www.geeksforgeeks.org/case-specific-sorting-of-strings/
public class CaseSpecificSorting {
    public static void main(String[] args) {
        String str = "gEeksfOrgEEkS";
        System.out.println(getSortedString(str));
        System.out.println(getSortedString1(str));
        System.out.println(getSortedString2(str));
    }

    /**
     * Using Priority Queue:
     *
     * 1. Two priority queue are created to store lowercase and uppercase characters separately in
     * ascending order.
     * 2. Iterate through input string and insert each character into the appropriate queue based on its
     * case.
     * 3. Iterate through the input string again and replace character with the next lowest or highest
     * character in the appropriate queue. If the character is lowercase, replace it with the next
     * lowest character in the lower queue. If the character is uppercase, replace it with the
     * next lowest character in the upper queue.
     * 4. Return the sorted string
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static String getSortedString2(String str) {
        PriorityQueue<Character> lower = new PriorityQueue<>();
        PriorityQueue<Character> upper = new PriorityQueue<>();

        for(int i = 0; i < str.length(); i++) {
            if(Character.isLowerCase(str.charAt(i))) {
                lower.add(str.charAt(i));
            } else {
                upper.add(str.charAt(i));
            }
        }

        char[] sortedStr = new char[str.length()];

        for(int i = 0; i < str.length(); i++) {
            if(Character.isLowerCase(str.charAt(i))) {
                sortedStr[i] = lower.poll();
            } else {
                sortedStr[i] = upper.poll();
            }
        }
        return String.valueOf(sortedStr);
    }

    /**
     * Using count of character of a=each case: The idea is to store lowercase and uppercase characters
     * count in the two different int array of size 26. Maintain two pointers in uppercase and lowercase
     * count array and then traverse again the input string. Check if currentChar is lowercase then update
     * it with the first available lowercase from count array of lowercase and decrement count of that
     * lowercase character and same thing to be done for uppercase letter/
     *
     *  TC: O(n)
     *  SC: O(n)
     *
     * @param str
     * @return
     */
    private static String getSortedString1(String str) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                lowercase[ch - 'a']++;
            } else {
                uppercase[ch - 'A']++;
            }
        }

        StringBuilder sortedStr = new StringBuilder("");

        int loIndex = 0, upIndex = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z') {
                if(loIndex < 26 && lowercase[loIndex] > 0) {
                    sortedStr.append((char) ('a' + loIndex));
                    lowercase[loIndex]--;
                } else {
                    while (loIndex < 26 && lowercase[loIndex] == 0) {
                        loIndex++;
                    }
                    if(loIndex < 26) {
                        sortedStr.append((char) ('a'  + loIndex));
                        lowercase[loIndex]--;
                    }
                }
            } else {
                if(upIndex < 26 && uppercase[upIndex] > 0) {
                    sortedStr.append((char) ('A' + upIndex));
                    uppercase[upIndex]--;
                } else {
                    while (upIndex < 26 && uppercase[upIndex] == 0) {
                        upIndex++;
                    }

                    if(upIndex < 26) {
                        sortedStr.append((char) ('A' + upIndex));
                        uppercase[upIndex]--;
                    }
                }
            }
        }

        return sortedStr.toString();
    }

    /**
     * Using Builtin functions: The idea is to store lower case characters and upper case characters
     * in two different vectors and sort both the vectors. Then use the sorted vectors to get the
     * sorted string while traversing the given string.
     *
     * 1. Create two vectors to store the uppercase and lowercase letter separately.
     * 2. Sort both the vectors.
     * 3. Traverse the string str and create two ints i and j with value 0
     *  a. If while traversing you found an uppercase letter then change the value with the element
     *  present at index i in the uppercase vector
     *  b. If while traversing a lowercase letter was found, change the value with the element present
     *  at index j in the lowercase vector
     * 4. Return the sorted string.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static String getSortedString(String str) {
        Vector<Character> upperCaseVector = new Vector<>();
        Vector<Character> lowerCaseVector = new Vector<>();
        StringBuilder sortedString = new StringBuilder(str);

        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                lowerCaseVector.add(str.charAt(i));
            }
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                upperCaseVector.add(str.charAt(i));
            }
        }

        Collections.sort(upperCaseVector);
        Collections.sort(lowerCaseVector);

        int i = 0, j = 0;

        for(int k = 0; k < str.length(); k++) {
            char ch = str.charAt(k);
            if(ch >= 'a' && ch <= 'z') {
                sortedString.setCharAt(k, lowerCaseVector.elementAt(i));
                i++;
            } else if (ch >= 'A' && ch <= 'Z') {
                sortedString.setCharAt(k, upperCaseVector.elementAt(j));
                j++;
            }
        }
        return sortedString.toString();
    }
}
