package com.dsalgo.linked.lists.circular;

public class CircularLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public CircularLinkedList() {
        this.size = 0;
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        Node node = new Node(val);
        if(head == null) {
            head = node;
            tail = node;
            size++;
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;
        size++;
    }

    public void display() {
        Node temp = head;
        if(head != null) {
            do {
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            } while (temp != head);
            System.out.println("HEAD");
        }
    }

    public void delete(int val) {
        Node node = head;
        if(node == null) {
            return;
        }
        if(node.val == val) {
            head = head.next;
            tail.next = head;
        }

        do {
            Node n = node.next;
            if(n.val == val) {
                node.next = n.next;
                break;
            }
            node = node.next;
        } while (node != head);
    }

    protected class Node {
        private int val;
        private Node next;
        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
