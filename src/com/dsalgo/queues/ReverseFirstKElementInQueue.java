package com.dsalgo.queues;

import java.util.*;

// https://www.geeksforgeeks.org/reversing-first-k-elements-queue/
public class ReverseFirstKElementInQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        int k = 5;
        Queue<Integer> reversedQueue = reverseFirstKElements(queue, k);
        System.out.println(reversedQueue);

        Queue<Integer> queue1 = new LinkedList<>();
        queue1.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(reverseFirstKElements1(queue1, k));

        Queue<Integer> queue2 = new LinkedList<>();
        queue2.addAll(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println(reverseFirstKElements2(queue2, k));

    }

    /**
     * Using Double-ended queue:
     *
     * 1. Dequeue the first k elements of the queue and push them onto a deque using the
     * push_front() function.
     * 2. Pop the elements from the deque one by one using the pop_front() function and enqueue
     * them back into the queue using the push() function.
     * 3. Dequeue the remaining elements from the queue and enqueue them back into the queue
     * using the push() and pop() functions.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param queue
     * @param k
     * @return
     */
    private static Queue<Integer> reverseFirstKElements2(Queue<Integer> queue, int k) {
        Deque<Integer> deque = new ArrayDeque<>();

        // Dequeue the first k elements of the queue and push them onto a deque
        for(int i = 0; i < k; i++) {
            deque.push(queue.poll());
        }

        // Pop the elements from the deque and enqueue them back into the queue
        while (!deque.isEmpty()) {
            queue.add(deque.poll());
        }

        // Dequeue the remaining elements from the queue and enqueue them back into the queue
        for(int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.poll());
        }
        return queue;
    }

    /**
     * Using auxiliary stack: The idea is to use an auxiliary stack. Store the first k elements
     * of the queue in a stack and pop it from the queue, then push it back to the queue and
     * perform pop operation for n-k times and again push the popped element.
     *
     * TC: O(n + k)
     * SC: O(n)
     * @param queue
     * @param k
     * @return
     */
    private static Queue<Integer> reverseFirstKElements1(Queue<Integer> queue, int k) {
        if(queue.isEmpty() || k > queue.size() || k <= 0) {
            return queue;
        }

        Stack<Integer> stack = new Stack<>();

        // Push the first K elements into a Stack
        for(int i = 0; i < k; i++) {
            stack.push(queue.remove());
        }

        //  Enqueue the contents of stack at the back of the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        // Remove the remaining elements and enqueue them at the end of the Queue
        for(int i = 0; i < queue.size() - k; i++) {
            queue.add(queue.peek());
            queue.remove();
        }
        return queue;
    }

    /**
     *
     * Using recursion:
     * 1. Reverse first k elements using recursion.
     * 2. Remove from front and add to back (N – K) elements.
     *
     * TC: O(n)
     * SC: O(n), for function call stack
     *
     * @param queue
     * @param k
     * @return
     */
    private static Queue<Integer> reverseFirstKElements(Queue<Integer> queue, int k) {
        helper(queue, k);
        int s = queue.size() - k;
        while (s > 0) {
            int x = queue.poll();
            queue.add(x);
            s--;
        }
        return queue;
    }

    private static void helper(Queue<Integer> queue, int k) {
        if(k == 0)
            return;

        int e = queue.poll();

        helper(queue, k - 1);

        queue.add(e);
    }
}
