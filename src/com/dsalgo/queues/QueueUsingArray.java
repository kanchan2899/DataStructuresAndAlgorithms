package com.dsalgo.queues;

public class QueueUsingArray {
    int front, rear, size;
    int capacity;
    int arr[];

    public QueueUsingArray(int capacity) {
        this.capacity = capacity;
        front = this.size = 0;
        rear = capacity - 1;
        arr = new int[this.capacity];
    }

    // queue is full when the size becomes equal to the capacity
    boolean isFull(QueueUsingArray queue) {
        return (queue.size == queue.capacity);
    }

    // queue is empty when size is 0
    boolean isEmpty(QueueUsingArray queue) {
        return (queue.size == 0);
    }

    // add an item to the queue, it changes the rear and size
    void enqueue(int item) {
        if(isFull(this)) {
            return;
        }
        this.rear = getRear();
        this.arr[this.rear] = item;
        this.size = this.size + 1;
        System.out.println(item + " enqueued to the queue");
    }

    // remove an item from the queue, it changes front and size
    int dequeue() {
        if(isEmpty(this)) {
            return Integer.MIN_VALUE;
        }

        int item = this.arr[this.front];
        this.size -= 1;
        this.front = (this.front + 1) % this.capacity;
        return item;
    }

    // get front of the queue
    int getFront() {
        if(isEmpty(this)) {
            return Integer.MIN_VALUE;
        }
        return this.arr[this.front];
    }

    // get rear of the queue
    int getRear() {
        if(isEmpty(this)) {
            return Integer.MIN_VALUE;
        }
        return this.arr[(this.front + this.size - 1) % capacity];
    }
}

class QueueDriver {
    public static void main(String[] args) {
        QueueUsingArray queue = new QueueUsingArray(10);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        System.out.println(queue.dequeue() + " dequeued from the queue");
        System.out.println(queue.getFront() + " is the front item in the queue");
        System.out.println(queue.getRear() + " is the rear item in the queue");

    }
}
