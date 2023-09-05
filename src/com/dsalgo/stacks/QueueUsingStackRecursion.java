package com.dsalgo.stacks;

import java.util.Iterator;
import java.util.Stack;

// https://www.geeksforgeeks.org/queue-using-stacks/
public class QueueUsingStackRecursion {
    Stack<Integer> stack;

    QueueUsingStackRecursion() {
        stack = new Stack<>();
    }

    void push(Stack<Integer> top_ref, int x) {
        top_ref.push(x);
    }

    int pop(Stack<Integer> top_ref) {
        if(top_ref == null) {
            return -1;
        }
        return top_ref.pop();
    }

    void enqueue(QueueUsingStackRecursion queue, int x) {
        push(queue.stack, x);
    }

    int dequeue(QueueUsingStackRecursion queue) {
        int x, element = 0;

        if(queue.stack.isEmpty()) {
            return -1;
        } else if(queue.stack.size() == 1) {
            return pop(queue.stack);
        } else {
            // pop an item from the stack
            x = pop(queue.stack);
            // store the last deQueued item
            element = dequeue(queue);
            // push everything back to stack
            push(queue.stack, x);

            return element;
        }
    }

    void printQueue() {
        Iterator iterator = stack.iterator();

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueUsingStackRecursion queue = new QueueUsingStackRecursion();

        queue.enqueue(queue, 1);
        queue.enqueue(queue, 2);
        queue.enqueue(queue, 3);
        queue.enqueue(queue, 4);
        queue.printQueue();
        System.out.println("Dequeued element " + queue.dequeue(queue));
        System.out.println("Dequeued element " + queue.dequeue(queue));
        queue.printQueue();
    }
}
