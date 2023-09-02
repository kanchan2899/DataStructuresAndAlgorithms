package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Stack/problem/removing-consecutive-duplicates-2-1587115621
public class RemoveConsecutiveDuplicates2 {
    public static void main(String[] args) {
        String str = "aaabbaaccd";
        System.out.println(removePair(str));
    }

    public static String removePair(String str)
    {
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder pair = new StringBuilder();

        int n = str.length();

        for(int i = n - 1; i >= 0; i--) {
            if(stack.isEmpty() || stack.peek() != str.charAt(i)) {
                stack.push(str.charAt(i));
            } else {
                stack.pop();
            }
        }

        while(!stack.isEmpty()) {
            pair.append(stack.pop());
        }
        return pair.toString();
    }
}
