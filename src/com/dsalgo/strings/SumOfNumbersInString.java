package com.dsalgo.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://www.geeksforgeeks.org/calculate-sum-of-all-numbers-present-in-a-string/
public class SumOfNumbersInString {
    public static void main(String[] args) {
        String str = "1abc23";
        System.out.println(findSum(str));
        System.out.println(findSum1(str));
    }

    /**
     * Using regex:
     *
     * TC: O(n)
     * SC: O(1)
     *
     *
     * @param str
     * @return
     */
    private static long findSum1(String str) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher  = pattern.matcher(str);
        long sum = 0;

        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
            str = matcher.replaceFirst("");
            matcher = pattern.matcher(str);
        }
        return sum;
    }


    /**
     *
     * Bruteforce: create a temp string with "0" value. Traverse the string. If a digit is found,
     * add it to temp. Otherwise, add the parse int value to sum
     *
     * 1. Create an empty string temp and an integer sum.
     * 2. Iterate over all characters of the string.
     * 3. If the character is a numeric digit add it to temp.
     * 4. Else convert temp string to number and add it to sum, empty temp.
     * 5. Return sum + number obtained from temp.
     *
     *  TC: O(n)
     *  SC: O(n)
     *
     * @param str
     * @return
     */
    public static long findSum(String str) {
        String temp = "0";
        long sum = 0;

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(Character.isDigit(ch)) {
                temp += ch;
            } else {
                sum += Integer.parseInt(temp);
                temp = "0";
            }
        }
        return sum + Integer.parseInt(temp);
    }
}
