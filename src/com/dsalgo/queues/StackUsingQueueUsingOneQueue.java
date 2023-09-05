package com.dsalgo.queues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class StackUsingQueueUsingOneQueue {
    Queue<Integer> queue = new ArrayDeque<>();

    void push(int x) {
        // Get previous size of queue
        int s = queue.size();

        // Push the current element
        queue.add(x);

        // Pop all the previous elements and put them after current element
        for(int i = 0; i < s; i++) {
            queue.add(queue.remove());
        }
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
        StackUsingQueueUsingOneQueue stack = new StackUsingQueueUsingOneQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Queue size " + stack.size());
        stack.printQueue();
        System.out.println();
        System.out.println("Dequeued element " + stack.pop());
        System.out.println("Queue size " + stack.size());
        stack.printQueue();
    }
}
