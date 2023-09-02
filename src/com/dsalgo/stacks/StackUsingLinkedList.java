package com.dsalgo.stacks;


class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
public class StackUsingLinkedList {
    Node head;

    int size;

    StackUsingLinkedList(){
        head = null;
        size = 0;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void push(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }

    int pop() {
        if(head == null) {
            return Integer.MAX_VALUE;
        }
        int element = head.data;
        head = head.next;
        size--;
        return element;
    }

    int peek() {
        if(head == null) {
            return Integer.MAX_VALUE;
        }
        return head.data;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
