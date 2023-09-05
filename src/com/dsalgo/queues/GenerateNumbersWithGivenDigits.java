package com.dsalgo.queues;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * digits: {5, 6}
 * if n = 4, output should be 5, 6, 55, 56 (n numbers containing given digits)
 */
public class GenerateNumbersWithGivenDigits {
    public static void main(String[] args) {
        int n = 10;
        printNumbers(n);
    }

    /**
     * Using queue: Append given digits to the queue. Run a loop till n, first print the current element
     * in the queue, then remove and append digits to the current element.
     *
     * TC: O(n)
     * SC: O(n)
     */
    private static void printNumbers(int n) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("5");
        queue.add("6");

        for(int count = 0; count < n; count++) {
            String current = queue.peek();
            System.out.print(current + " ");
            queue.remove();
            queue.add(current + "5");
            queue.add(current + "6");
        }
    }
}
