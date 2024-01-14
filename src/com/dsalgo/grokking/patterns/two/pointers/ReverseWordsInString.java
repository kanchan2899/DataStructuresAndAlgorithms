package com.dsalgo.grokking.patterns.two.pointers;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String s = "Hello Friends";
        System.out.println(reverseWords(s));
    }

    private static String reverseWords(String s) {

        char[] ch = s.toCharArray();

        s = cleanSpaces(ch, ch.length);

        StringBuilder stringBuilder = new StringBuilder(s.strip());

        stringReverse(stringBuilder, 0, stringBuilder.length() - 1);

        int n = stringBuilder.length();
        int start = 0, end = 0;

        while (start < n) {
            while (end < n && stringBuilder.charAt(end) != ' ') {
                end++;
            }
            stringReverse(stringBuilder, start, end - 1);
            start = end + 1;
            ++end;
        }
        return stringBuilder.toString();
    }

    private static String cleanSpaces(char[] ch, int length) {
        String str = new String(ch, 0, length);
        str = str.replace("\\s+", " ").trim();
        return str;
    }

    private static void stringReverse(StringBuilder stringBuilder, int start, int end) {
        while (start < end) {
            char temp = stringBuilder.charAt(start);
            stringBuilder.setCharAt(start++, stringBuilder.charAt(end));
            stringBuilder.setCharAt(end--, temp);
        }
    }
}
