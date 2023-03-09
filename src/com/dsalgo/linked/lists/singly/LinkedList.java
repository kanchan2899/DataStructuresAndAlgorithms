package com.dsalgo.linked.lists.singly;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size = 0;

    public LinkedList() {
        this.size = 0;
    }

    public Node getNext() {
        return head.next;
    }

    public int getVal() {
        return head.val;
    }

    public Node getHead() {
        return head;
    }

    public void insertFirst(int val) {
        Node new_node = new Node(val);
        new_node.next = head;
        head = new_node;

        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if(tail == null) {
            insertFirst(val);
            return;
        }
        Node new_node = new Node(val);
        tail.next = new_node;
        tail = new_node;
    }

    public void insertAtIndex(int val, int index) {
        if(size == 1) {
            insertFirst(val);
            return;
        }
        if(size == index) {
            insertLast(val);
            return;
        }
        int i = 1;
        Node temp = head;
        while(i < index - 1) {
            temp = temp.next;
            i++;
        }
        // Node new_node = new Node(val, temp.next);
        Node new_node = new Node(val);
        new_node.next = temp.next;
        temp.next = new_node;
        size++;
    }

    public Node get(int index) {
        Node temp = head;
        int i = 1;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public Node find(int val) {
        Node temp = head;
        while (temp != null) {
            if(temp.val == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public int deleteFirst() {
        int val = head.val;
        head = head.next;
        if(head == null)
            tail = null;

        size++;
        return val;
    }

    public int deleteAtIndex(int index) {
        if(index == 1) {
            return deleteFirst();
        }
        if(index == size) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public int deleteLast() {
        if(size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.val;
        tail = secondLast;
        tail.next = null;

        size--;
        return val;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
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
