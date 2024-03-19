package com.dsalgo.grokking.patterns.hashmaps;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/next-greater-element-i/description/
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] nums1 = {4, 6, 3};
        int[] nums2 = {1, 3, 4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int n : nums2) {
            while (!stack.empty() && n > stack.peek()) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }

        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        int[] nextGreaterElement = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++) {
            nextGreaterElement[i] = map.get(nums1[i]);
        }
        return nextGreaterElement;
    }
}
