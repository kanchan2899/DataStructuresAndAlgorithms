package com.dsalgo.stacks;

import java.util.Iterator;
import java.util.Stack;

// https://www.geeksforgeeks.org/queue-using-stacks/
public class QueueUsingStack_DequeueCostly {
    Stack<Integer> stack;
    Stack<Integer> tempStack;

    QueueUsingStack_DequeueCostly() {
        stack = new Stack<>();
        tempStack = new Stack<>();
    }

    void push(Stack<Integer> top_ref, int x) {
        top_ref.push(x);
    }

    int pop(Stack<Integer> top_ref) {
        if(top_ref.isEmpty()) {
            return -1;
        }

        return top_ref.pop();
    }

    void enqueue(QueueUsingStack_DequeueCostly queue, int x) {
        push(queue.stack, x);
    }

    int dequeue(QueueUsingStack_DequeueCostly queue) {
        int x;

        if(stack.isEmpty() && tempStack.isEmpty()) {
            return -1;
        }

        // Move elements from stack to tempStack only if tempStack is empty
        if(queue.tempStack.isEmpty()) {
            while (!queue.stack.isEmpty()) {
                x = pop(queue.stack);
                push(queue.tempStack, x);
            }
        }

        x = pop(queue.tempStack);
        return x;
    }

    void printQueue() {
        Iterator iterator = stack.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingStack_DequeueCostly queue = new QueueUsingStack_DequeueCostly();
        queue.enqueue(queue, 1);
        queue.enqueue(queue, 2);
        queue.enqueue(queue, 3);
        queue.printQueue();
        System.out.println("Dequeued element " + queue.dequeue(queue));
        System.out.println("Dequeued element " + queue.dequeue(queue));
        queue.printQueue();
    }
}
