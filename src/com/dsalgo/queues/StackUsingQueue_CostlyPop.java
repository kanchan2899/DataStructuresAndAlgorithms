package com.dsalgo.queues;


import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;

public class StackUsingQueue_CostlyPop {
    Queue<Integer> queue;
    Queue<Integer> tempQueue;
    int size;

    StackUsingQueue_CostlyPop() {
        size = 0;
        queue = new ArrayDeque<>();
        tempQueue = new ArrayDeque<>();
    }

    /**
     * 1. One by one dequeue everything except the last element from q1 and enqueue to q2.
     * 2. Dequeue the last item of q1, the dequeued item is the result, store it.
     * 3. Swap the names of q1 and q2
     * 4. Return the item stored in step 2.
     *
     * TC: O(n)
     *
     * @return
     */
    int remove() {
        if(queue.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        // Leave one element in q1 and push others in q2.
        while (queue.size() != 1) {
            tempQueue.add(queue.peek());
            queue.remove();
        }

        // pop the only left element from q1
        int item = queue.remove();
        size--;

        // swap the name of the queues
        Queue<Integer> temp = queue;
        queue = tempQueue;
        tempQueue = temp;

        return item;
    }

    // Enqueue x to q1 (assuming the size of q1 is unlimited).
    void add(int x) {
        size++;
        queue.add(x);
    }

    int top() {
        if(queue.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        size--;
        while (queue.size() != 1) {
            tempQueue.add(queue.remove());
        }

        // last pushed element
        int temp = queue.peek();

        // to empty the auxiliary queue after last operation
        queue.remove();

        tempQueue.add(temp);

        Queue<Integer> q = queue;
        queue = tempQueue;
        tempQueue = q;

        return temp;
    }

    int size() {
        return size;
    }

    void printStack() {
        Iterator iterator = queue.iterator();

        while (iterator.hasNext()) {
            int element = (int) iterator.next();
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        StackUsingQueue_CostlyPop stack = new StackUsingQueue_CostlyPop();

        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        System.out.println("Stack size " + stack.size());
        stack.printStack();
        System.out.println();
        System.out.println("Deleted item from stack " + stack.remove());
        System.out.println("Stack size " + stack.size());
        stack.printStack();
        System.out.println();
        System.out.println("Top of stack is " + stack.top());
    }
}
