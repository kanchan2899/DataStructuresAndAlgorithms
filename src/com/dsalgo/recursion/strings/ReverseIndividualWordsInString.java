package com.dsalgo.recursion.strings;

import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class ReverseIndividualWordsInString {
    public static void main(String[] args) {
        String s = "Hello World GREAT";
        System.out.println("Using recursion to reverse each word: " + reverseWordsInString1(s));
        System.out.print("Using stack: ");
        reverseWordsInString2(s);
        System.out.println();
        System.out.print("Using StringTokenizer: ");
        reverseWordsInString3(s);
        System.out.println();
        System.out.println("Using streams: " + reverseWordsInString4(s));
        ;
    }

    private static String reverseWordsInString4(String str) {
        String result = Arrays.asList(str.split(" "))
                .stream()
                .map(s -> new StringBuilder(s).reverse())
                .collect(Collectors.joining(" "));
        return result;
    }

    private static void reverseWordsInString3(String s) {
        String word;
        StringTokenizer tokenizer = new StringTokenizer(s);
        while (tokenizer.hasMoreTokens()) {
            word = tokenizer.nextToken();
            System.out.print(new StringBuilder(word).reverse() + " ");
        }
    }

    /**
     * Solution 2: Use a stack to push all words before space. As soon as, a space is found, empty
     * the stack.
     *
     * Time complexity: O(n)
     * Space complexity: O(1)
     *
     * @param s
     * @return
     */
    private static void reverseWordsInString2(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch != ' ') {
                stack.push(ch);
            } else {
                while (stack.isEmpty() == false){
                    System.out.print(stack.pop());
                }
                System.out.print(" ");
            }
        }
        while (stack.isEmpty() == false) {
            System.out.print(stack.pop());
        }
    }

    /**
     Solution 1: Generate all words separated by space. One by one reverse words and print them
     separated by space.

     Time complexity: O(n)
     Space complexity: O(n)

     */
    private static String reverseWordsInString1(String s) {
        if(s.length() == 0) return "";
        String[] words = s.split(" ");
        String reversedWords = "";
        for(String word : words) {
            reversedWords = reversedWords + " " + reverseWord(word);
        }
        return reversedWords;
    }

    private static String reverseWord(String s) {
        if(s.length() == 0) return s;

        return reverseWord(s.substring(1)) + s.charAt(0);
    }
}
