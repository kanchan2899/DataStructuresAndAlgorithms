package com.dsalgo.queues;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class StackUsingDoublyEndedQueue {
    Deque<Integer> deque = new LinkedList<>();

    void push(int x) {
        deque.addLast(x);
    }

    int pop() {
        int item = deque.getLast();
        deque.removeLast();
        return item;
    }

    int size() {
        return deque.size();
    }

    boolean isEmpty() {
        return deque.isEmpty();
    }

    int top() {
        if(deque.isEmpty()) {
            return -1;
        }
        return deque.getLast();
    }

    void printStack() {
        Iterator iterator = deque.iterator();

        while (iterator.hasNext()) {
            int element = (int) iterator.next();
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        StackUsingDoublyEndedQueue stack = new StackUsingDoublyEndedQueue();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Stack size " + stack.size());
        stack.printStack();
        System.out.println();
        System.out.println("Deleted item from stack " + stack.pop());
        System.out.println("Stack size " + stack.size());
        stack.printStack();
    }
}
