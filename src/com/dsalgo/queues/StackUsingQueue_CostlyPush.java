package com.dsalgo.queues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

// https://www.geeksforgeeks.org/implement-stack-using-queue/
public class StackUsingQueue_CostlyPush {
    Queue<Integer> queue;
    Queue<Integer> tempQueue;
    int size;

    StackUsingQueue_CostlyPush() {
        queue = new ArrayDeque<>();
        tempQueue = new ArrayDeque<>();
        size = 0;
    }

    int top() {
        return queue.peek();
    }

    int size() {
        return queue.size();
    }

    int pop() {
        size--;
        return queue.poll();
    }

    void push(int x) {
        size++;
        while (!queue.isEmpty()) {
            tempQueue.offer(queue.peek());
            queue.poll();
        }

        queue.offer(x);

        while (!tempQueue.isEmpty()) {
            queue.offer(tempQueue.peek());
            tempQueue.poll();
        }
    }

    void printQueue() {
        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            int element = (int) iterator.next();
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        StackUsingQueue_CostlyPush stackUsingQueue = new StackUsingQueue_CostlyPush();

        stackUsingQueue.push(1);
        stackUsingQueue.push(2);
        stackUsingQueue.push(3);
        stackUsingQueue.push(4);
        System.out.println("Queue size " + stackUsingQueue.size);
        stackUsingQueue.printQueue();
        System.out.println();
        System.out.println("Dequeued element " + stackUsingQueue.pop());
        System.out.println("Queue size " + stackUsingQueue.size);
        stackUsingQueue.printQueue();
    }
}
