package com.dsalgo.strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

// https://www.geeksforgeeks.org/reverse-words-in-a-given-string/
public class ReverseWordsInString {
    public static void main(String[] args) {
        String str = "geeks quiz practice code";
        System.out.println(reverseWords(str));
        System.out.println(reverseWords1(str));
        System.out.println(reverseWords2(str));
        System.out.println(reverseWords3(str));
        System.out.println(reverseWords4(str));
        System.out.println(reverseWords5(str));
        System.out.println(reverseWords6(str));
    }

    /**
     * Without splitting the string:
     *
     * 1. If you find white space, there can be two possibilities.
     * 2. It might be end of a word or else extra trailing space in between the words.
     * 3. if it is not a white space, add the character to temporary word
     *
     * NOTE: we can even remove extra trailing spaces and in between the words also.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    private static String reverseWords6(String str) {
        StringBuilder reversedStr = new StringBuilder();

        String temp = "";

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == ' ') {
                if(!temp.equals("")) {
                    reversedStr.insert(0, temp + " ");
                }
                temp = "";
            } else {
                temp += ch;
            }
        }
        return reversedStr.substring(0, reversedStr.length() - 1);
    }

    /**
     * Using slicing and join functions:
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static String reverseWords5(String str) {
        String[] words = str.split(" ");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }

    /**
     * Using constant space:
     *
     * 1. Go through the string and mirror each word in the string,
     * 2. Then, in the end, mirror the whole string.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param str
     * @return
     */
    private static String reverseWords4(String str) {
        int left = 0, i = 0, n = str.length();

        while (str.charAt(i) == ' ') {
            i++;
        }

        left = i;

        while (i < n) {
            if(i + 1 == n || str.charAt(i) == ' ') {
                int j = i - 1;
                if(i + 1 == n) {
                    j++;
                }

                while (left < j) {
                    str = swap(str, left++, j--);
                }
                left = i + 1;
            }

            if(i > left && str.charAt(left) == ' ') {
                left = i;
            }
            i++;
        }

        return new StringBuilder(str).reverse().toString();
    }

    private static String swap(String str, int i, int j) {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    /**
     * Using swap operation: The above task can also be accomplished by splitting the words
     * separately and directlyswapping the string starting from the middle.
     *
     * 1. Store the string in the form of words
     * 2. Swap the words with each other starting from the middle
     * 3. Return the string
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static String reverseWords3(String str) {
        String[] words = str.split("\\s");
        String s = "";
        int l = words.length;
        if(l % 2 == 0) {
            int j = l / 2;
            while (j <= l - 1) {
                String temp;
                temp = words[l - j - 1];
                words[l - j - 1] = words[j];
                words[j] = temp;
                j += 1;
            }
        } else {
            int j = (l / 2) + 1;
            while (j <= l - 1) {
                String temp;
                temp = words[l - j - 1];
                words[l - j - 1] = words[j];
                words[j] = temp;
                j += 1;
            }
        }

        s = String.join(" ", words);
        return s;
    }

    /**
     * Splitting and reversing string: We can do the above task by splitting and saving the string
     * in a reverse manner.
     *
     * 1. Store the string in the form of words
     * 2. Run a for loop in reverse order to print the words accordingly
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static String reverseWords2(String str) {
        String s[] = str.split(" ");
        String ans = "";

        for(int i = s.length - 1; i >= 0; i--) {
            ans += s[i] + " ";
        }
        return ans.substring(0, ans.length() - 1);
    }

    /**
     * By reversing each word first and the reverse the whole string
     *
     * 1. Run a for loop to traverse the string and create a temporary string to store the words
     * 2. If the current character is a space then add the current string to the answer and empty
     * the string
     * 3. Else push the character into the string
     * 4. Print the answer array in reverse order
     *
     * NOTE: The above code doesn’t handle the cases when the string starts with space.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static String reverseWords1(String str) {
        String s = str;
        if(s.charAt(s.length() - 1) != ' ') {
           s = s + " ";
        }
        char[] p = s.toCharArray();

        int start = 0;
        for(int end = 0; end < p.length; end++) {
            if(p[end] == ' ') {
                reverse(p, start, end);
                start = end + 1;
            }
        }

        reverse(p, start, p.length - 1);

        reverse(p, 0, p.length - 1);
        return String.valueOf(p);
    }

    private static void reverse(char[] p, int start, int end) {
        char temp;
        while (start <= end) {
            temp = p[start];
            p[start] = p[end];
            p[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Bruteforce using a stack:
     *
     * 1. Create a stack
     * 2. Push words one by one to the stack
     * 3. Pop words from the stack and append to the output string.
     *
     * TC: O(n), n = number of words
     * SC: O(n), n = number of words
     *
     * @param str
     * @return
     */
    private static String reverseWords(String str) {
        Stack<String> stringStack = new Stack<>();
        String[] strings = str.split(" ");
        StringBuilder reversedString = new StringBuilder();

        stringStack.addAll(Arrays.asList(strings));

        while (!stringStack.empty()) {
            reversedString.append(stringStack.pop());
            reversedString.append(" ");
        }
        return reversedString.toString();
    }
}
