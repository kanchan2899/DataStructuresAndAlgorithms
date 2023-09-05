package com.dsalgo.queues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

// https://www.geeksforgeeks.org/reversing-a-queue/
public class ReverseAQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        System.out.println(queue);
        reverseQueue(queue);
        System.out.println(queue);
        reverseQueue1(queue);
        System.out.println(queue);
    }

    /**
     * Using recursion:
     *
     * Recursively perform the following steps:
     * 1. If the queue size is 0 return.
     * 2. Else pop and store the front element and recur for remaining queue.
     * 3. push the current element in the queue.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param queue
     */
    private static void reverseQueue1(Queue<Integer> queue) {
        if(queue.size() == 0) {
            return;
        }
        int element = queue.peek();
        queue.remove();
        reverseQueue(queue);
        queue.add(element);
    }


    /**
     * Using stack, Iterative solution: For reversing the queue one approach could be to store
     * the elements of the queue in a temporary data structure in a manner such that if we
     * re-insert the elements in the queue they would get inserted in reverse order. So now
     * our task is to choose such a data structure that can serve the purpose. According
     * to the approach, the data structure should have the property of ‘LIFO’ as the last
     * element to be inserted in the data structure should actually be the first element
     * of the reversed queue.
     *
     * 1. Pop the elements from the queue and insert into the stack now topmost element of the stack
     * is the last element of the queue.
     * 2. Pop the elements of the stack to insert back into the queue the last element is the first
     * one to be inserted into the queue.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param queue
     */
    private static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }
}
