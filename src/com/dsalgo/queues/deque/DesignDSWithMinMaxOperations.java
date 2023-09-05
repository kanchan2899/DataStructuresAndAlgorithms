package com.dsalgo.queues.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/design-a-queue-data-structure-to-get-minimum-or-maximum-in-o1-time/
public class DesignDSWithMinMaxOperations {
    Deque<Integer> deque;
    Queue<Integer> queue;

    DesignDSWithMinMaxOperations() {
        deque = new ArrayDeque<>();
        queue = new LinkedList<>();
    }

   void enqueue(int data) {
        // remove all elements from deque which are greater than the current elements
       while (!deque.isEmpty() && deque.getLast() > data) {
           deque.removeLast();
       }

       // if the deque is empty, which loop is skipped
       deque.addLast(data);
       queue.add(data);
   }

   int deque() {
        // if min element is present at the front of the queue
       if(deque.getFirst() == queue.peek()) {
           deque.removeFirst();
       }
       return queue.remove();
   }

    int getMin() throws Exception {
        // if queue is empty, return Exception
        if(queue.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return deque.getFirst();
    }

    int getMax() throws Exception {
        if(queue.isEmpty()) {
            throw new Exception("Queue is empty");
        }
        return deque.getLast();
    }

    public static void main(String[] args) {
        DesignDSWithMinMaxOperations ds = new DesignDSWithMinMaxOperations();

        ds.enqueue(10);
        ds.enqueue(15);
        ds.enqueue(5);
        System.out.println(ds.deque);
        System.out.println("Max " + ds.deque());
        System.out.println("Min " + ds.deque());
        System.out.println(ds.deque);
        ds.enqueue(8);
        System.out.println(ds.deque);

    }
}
