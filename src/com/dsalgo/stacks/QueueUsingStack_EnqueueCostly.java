package com.dsalgo.stacks;

import java.util.Iterator;
import java.util.Stack;

// https://www.geeksforgeeks.org/queue-using-stacks/
public class QueueUsingStack_EnqueueCostly {
    Stack<Integer> stack = new Stack<>();

    Stack<Integer> tempStack = new Stack<>();

    void enqueue(int x) {
        // Move all elements from stack to tempStack
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        // push item to stack
        stack.push(x);

        // push everything back to stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    int dequeue() {
        if(stack.isEmpty()) {
            return -1;
        }

        int x = stack.peek();
        stack.pop();
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
        QueueUsingStack_EnqueueCostly queue = new QueueUsingStack_EnqueueCostly();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.printQueue();
        System.out.println(queue.dequeue());
        queue.printQueue();
    }
}
