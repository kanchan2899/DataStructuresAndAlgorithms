package com.dsalgo.queues;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
public class QueueUsingLinkedList {
    Node front, rear;
    int size = 0;

    QueueUsingLinkedList() {
        front = rear = null;
    }

    void enqueue(int x) {
        Node temp = new Node(x);
        size++;
        if(front == null) {
            front = temp;
            rear = temp;
            return;
        }

        rear.next = temp;
        rear = temp;
    }

    void dequeue() {
        if(front == null)
            return;

        size--;

        front = front.next;

        if(front == null) {
            rear = null;
        }
    }
}
