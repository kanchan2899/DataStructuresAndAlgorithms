package com.dsalgo.queues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class StackUsingQueueRecursion {
    Queue<Integer> queue = new ArrayDeque<>();

    void push(int x, int c) {
        // push the element first and after every recursion add the front element again
        queue.add(x);

        // return if size becomes 0
        if(c <= 0) {
            return;
        }

        // decrement size by 1 in every recursion
        c--;

        // remove front element from queue and return it using q1.remove() and call recursive function
        push(queue.remove(), c);
    }

    int pop() {
        if(queue.isEmpty()) {
            return -1;
        }
        return queue.remove();
    }

    int top() {
        if(queue.isEmpty()) {
            return -1;
        }
        return queue.peek();
    }

    int size() {
        return queue.size();
    }

    void printQueue() {
        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            int element = (int) iterator.next();
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        StackUsingQueueRecursion stack = new StackUsingQueueRecursion();

        stack.push(1, stack.size());
        stack.push(2, stack.size());
        stack.push(3, stack.size());
        stack.push(4, stack.size());
        System.out.println("Queue size " + stack.size());
        stack.printQueue();
        System.out.println();
        System.out.println("Dequeued element " + stack.pop());
        System.out.println("Queue size " + stack.size());
        stack.printQueue();
        System.out.println("Top of stack " + stack.top());
    }

}
