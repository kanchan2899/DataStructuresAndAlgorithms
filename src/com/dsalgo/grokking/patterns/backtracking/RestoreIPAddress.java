package com.dsalgo.grokking.patterns.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/restore-ip-addresses/
public class RestoreIPAddress {
    static int n;
    static String s;
    static List<String> result;

    static List<String> ips;
    static LinkedList<String> segments;

    public static void main(String[] args) {
        String ipString = "25525511135";
        System.out.println(restoreIPAddress(ipString));
        System.out.println(restoreIPAddress1(ipString));
    }

    private static List<String> restoreIPAddress1(String ipString) {
        ips = new ArrayList<>();
        n = ipString.length();
        recur(ipString, 0, "", 0);
        return ips;
    }

    private static void recur(String ipString, int index, String ip, int dot) {
        if(dot == 3) {
            if(isIP(ipString.substring(index))) {
                ip += ipString.substring(index);
                ips.add(ip);
            }
            return;
        }
        for(int i = index; i < n; i++) {
            if(isIP(ipString.substring(index, i + 1))) {
                int k = ipString.substring(index, i + 1).length();
                ip += ipString.substring(index, i + 1) + ".";
                recur(ipString, i + 1, ip, dot + 1);
                ip = ip.substring(0, ip.length() - k - 1);
            }
        }
    }

    private static boolean isIP(String ip) {
        if(ip.length() > 3 || ip.length() == 0) {
            return false;
        }
        if(ip.length() > 1 && ip.charAt(0) == '0') {
            return false;
        }
        if(ip.length() > 0 && Integer.parseInt(ip) > 255) {
            return false;
        }
        return true;
    }

    private static List<String> restoreIPAddress(String ipString) {
        n = ipString.length();
        s = ipString;

        result = new ArrayList<>();
        segments = new LinkedList<>();

        backtrack(-1, 3);
        return result;
    }

    private static void backtrack(int prevDot, int dots) {
        // prevDot: the position of the previously placed dot
        // dots: number of dots to place

        // the current dot currDot could be placed in a range from prevDot + 1 to prevDot + 4
        // The dot couldn't be placed after the last character in the string

        int maxPos = Math.min(n - 1, prevDot + 4);
        for(int currDot = prevDot + 1; currDot < maxPos; currDot++) {
            String segment = s.substring(prevDot + 1, currDot + 1);
            if(valid(segment)) {
                // place dot
                segments.add(segment);
                // if all 3 dots are placed, add the solution to result
                if(dots - 1 == 0) {
                    updateSegment(currDot);
                } else {
                    // continue to place the dots
                    backtrack(currDot, dots - 1);
                }
                // remove the last placed dot
                segments.removeLast();
            }
        }
    }

    // append the current list of segments to the list of results
    private static void updateSegment(int currDot) {
        String segment = s.substring(currDot + 1, n);
        // if the segment is acceptable
        if(valid(segment)) {
            // add it to the list of segments
            segments.add(segment);
            // Utility function to concat the entries of the segments list
            // separated by the dot delimiter.
            String ip = String.join(".", segments);
            result.add(ip);
            // remove the top segment
            segments.removeLast();

        }
    }

    private static boolean valid(String segment) {
        int m = segment.length();
        // each segment's length should be less than 3
        if(m > 3) {
            return false;
        }

        // check if the current segment is valid for either one of the following scenarios:
        // 1. check if the current segment is less than equal to 255
        // 2. check if the length of the segment is 1. The first character of segment can be '0' only
        // of the length of the segement is 1
        return (segment.charAt(0) != '0' ? (Integer.valueOf(segment) <= 255) : m == 1);
    }
}
