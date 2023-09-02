package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://www.geeksforgeeks.org/previous-greater-element/
public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] arr = {15, 10, 18, 12, 4, 6, 2, 8};
        System.out.println(Arrays.toString(previousGreaterElement(arr)));
        System.out.println(Arrays.toString(previousGreaterElement1(arr)));
    }

    /**
     * Using bruteforce: A simple solution is to run two nested loops. The outer loop picks an
     * element one by one. The inner loop, find the previous element that is greater.
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int[] previousGreaterElement(int[] arr) {
        int[] previousGreaterArray = new int[arr.length];
        previousGreaterArray[0] = -1;
        for(int i = 1; i < arr.length; i++) {
            int j;
            for(j = i - 1; j >= 0; j--) {
                if(arr[j] > arr[i]) {
                    previousGreaterArray[i] = arr[j];
                    break;
                }
            }
            if(j == -1) {
                previousGreaterArray[i] = -1;
            }
        }
        return previousGreaterArray;
    }

    /**
     * Using stack: An efficient solution is to use stack data structure. If we take a closer look,
     * we can notice that this problem is a variation of stock span problem. We maintain previous
     * greater element in a stack.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int[] previousGreaterElement1(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] prevGreater = new int[arr.length];
        prevGreater[0] = -1;
        stack.push(arr[0]);

        for(int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            prevGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return prevGreater;
    }
}
