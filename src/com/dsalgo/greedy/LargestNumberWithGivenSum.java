package com.dsalgo.greedy;

// https://www.geeksforgeeks.org/find-the-largest-number-with-given-number-of-digits-and-sum-of-digits/
public class LargestNumberWithGivenSum {
    public static void main(String[] args) {
        int s = 9, n = 2;
        System.out.println(findLargest(n, s));
    }

    private static String findLargest(int n, int s) {
        StringBuilder res = new StringBuilder();

        // If sum of digits is 0, then a number is possible only if number of digits is 1
        if(s == 0) {
            return n == 1 ? "0" : "-1";
        }

        // Sum greater than the maximum possible sum
        if(s > 9 * n) {
            return "-1";
        }

        while(s >= 9) {
            res.append("9");
            s -= 9;
        }

        if(res.length() > n) {
            return "-1";
        }

        if(res.length() < n) {
            while(res.length() < n) {
                res.append("0");
            }
        }

        return res.toString();
    }
}
