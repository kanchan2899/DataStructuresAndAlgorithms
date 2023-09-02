package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://www.geeksforgeeks.org/the-stock-span-problem/
public class StockSpan {
    public static void main(String[] args) {
        int[] stockPrices = {13, 15, 12, 14, 16, 8, 6, 4, 10, 30};
        System.out.println(Arrays.toString(stockSpan(stockPrices)));
        System.out.println(Arrays.toString(stockSpan1(stockPrices)));
    }

    /**
     * Bruteforce algo: Start from 0 to n - 1. Start another loop j and go to the left side of the
     * array, increment span if jth element is less than current element.
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param stockPrices
     * @return
     */
    private static int[] stockSpan(int[] stockPrices) {
        int[] spans = new int[stockPrices.length];
        for(int i = 0; i < stockPrices.length; i++) {
            int span = 1;
            for(int j = i - 1; j >= 0 && stockPrices[j] <= stockPrices[i]; j--) {
                span += 1;
            }
            spans[i] = span;
        }
        return spans;
    }

    /**
     * Using stack:
     *
     * 1. Create a stack of type int and push 0 in it
     * 2. Set the answer of day 1 as 1 and run a for loop to traverse the days
     * 3. While the stack is not empty and the price of st.top is less than or equal to the price
     * of the current day, pop out the top value
     * 4. Set the answer of the current day as i+1 if the stack is empty else equal to i - st.top
     * 5. Push the current day into the stack
     * 6. Print the answer using the answer array
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param stockPrices
     * @return
     */
    private static int[] stockSpan1(int[] stockPrices) {
        int[] spans = new int[stockPrices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);      // index of first item
        spans[0] = 1;       // span of first item is 1

        for(int i = 1; i < stockPrices.length; i++) {
            while (!stack.isEmpty() && stockPrices[stack.peek()] <= stockPrices[i]) {
                stack.pop();
            }

            spans[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
        return spans;
    }
}
