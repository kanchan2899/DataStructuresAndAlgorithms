package com.dsalgo.linked.lists.doubly;

public class DoublyLinkedList {
    Node head;
    int size;

    public DoublyLinkedList() {
        this.size = 0;
    }

    public void insertFirst(int val) {
        Node new_node = new Node(val);
        new_node.next = head;
        new_node.prev = null;
        if(head != null) {
            head.prev = new_node;
        }
        head = new_node;
        size++;
    }

    public Node get(int index) {
        Node temp = head;
        int i = 1;
        while(i < index) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public Node find(int val) {
        Node temp = head;
        while(temp != null) {
            if(temp.val == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public void insertLast(int val) {
        Node new_node = new Node(val);
        Node last = get(size);
        if(last == null) {
            insertFirst(val);
            return;
        }
        if(last != null) {
            last.next = new_node;
        }
        new_node.prev = last;
        new_node.next = null;
    }

    public void insertAtIndex(int val, int index) {
        Node new_node = new Node(val);
        if(size == 1) {
            insertFirst(val);
        }
        if(size == index) {
            insertLast(val);
        }
        Node prev = get(index - 1);
        new_node.prev = prev;
        new_node.next = prev.next;
        prev.next.prev = new_node;
        prev.next = new_node;
    }

    public void insertAfter(int after, int val) {
        Node prev = find(after);
        if(prev == null) {
            return;
        }
        Node new_node = new Node(val);
        new_node.next = prev.next;
        prev.next = new_node;
        new_node.prev = prev;
        if(new_node.next != null) {
            new_node.next.prev = new_node;
        }
    }

    public void display() {
        Node temp = head;
        Node last = null;
        while(temp != null) {
            last = temp;
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");

        System.out.print("Display DLL in reverse order ====== ");
        while (last != null) {
            System.out.print(last.val + " -> ");
            last = last.prev;
        }
        System.out.println("null");
    }

    // TODO Add a last pointer and complete this function
    public void displayReverse() {

    }
    private class Node {
        int val;
        Node next;
        Node prev;

        private Node(int val) {
            this.val = val;
        }

        private Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

}
