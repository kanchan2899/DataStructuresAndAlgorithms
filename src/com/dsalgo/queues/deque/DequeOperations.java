package com.dsalgo.queues.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeOperations {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerLast(4);
        System.out.println(deque);
        deque.pollFirst();
        System.out.println(deque.peekFirst());
        System.out.println(deque.peekLast());
        System.out.println(deque.pollLast());
        System.out.println(deque);
    }
}
