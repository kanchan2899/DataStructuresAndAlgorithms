package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/sum-of-all-substrings-of-a-string-representing-a-number/
public class SumOfAllPossibleSubstrings {
    public static void main(String[] args) {
        String s = "1234";
        System.out.println(sumOfAllSubstrings(s));
        System.out.println(sumOfAllSubstrings1(s));
    }

    private static int sumOfAllSubstrings1(String s) {
        int n = s.length();
        int prev = s.charAt(0) - '0';
        int sum = prev;
        int current = 0;

        for(int i = 1; i < n; i++) {
            int numi = s.charAt(i) - '0';
            current = (i + 1) * numi + 10 * prev;
            sum += current;
            prev = current;
        }
        return sum;
    }

    /**
     * Using DP - Tabulation
     *
     * 1. Declare an array of size n to store the sum of previous digits, processed so far, and a variable result
     * 2. Traverse over the string and for every character
     *      - Set sumOfDigit[i] = (i + 1) * toDigit(num[i]) + 10 * sumOfDigit[i-1]
     *      - Add the value of sumOfDigit[i] to result
     * 3. Return result
     *
     * TC: O()
     * SC: O()
     *
     * @param s
     * @return
     */
    private static int sumOfAllSubstrings(String s) {
        int n = s.length();

        int sumOfDigits[] = new int[n];
        sumOfDigits[0] = s.charAt(0) - '0';

        int sum = sumOfDigits[0];

        for(int i = 1; i < n; i++) {
            int numi = s.charAt(i) - '0';

            sumOfDigits[i] = (i + 1) * numi + 10 * sumOfDigits[i - 1];

            sum += sumOfDigits[i];
        }
        return sum;
    }
}
