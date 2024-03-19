package com.dsalgo.grokking.patterns.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/implement-stack-using-queues/
public class QueueUsingStack {
    Deque<Integer> input;
    Deque<Integer> output;
    public QueueUsingStack() {
         input = new ArrayDeque<>();
         output = new ArrayDeque<>();
    }
    public void push(int x) {
        input.push(x);
    }
    public int pop() {
        peek();
        return output.pop();
    }

    public int peek() {
        if(output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
        return output.peek();
    }

    public boolean isEmpty() {
        return input.isEmpty() && output.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.push(10);
        queue.push(20);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        queue.push(30);
        System.out.println(queue.peek());
    }
}
