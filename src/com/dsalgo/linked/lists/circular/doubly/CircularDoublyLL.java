package com.dsalgo.linked.lists.circular.doubly;

public class CircularDoublyLL {

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    public static void main(String[] args) {
        Node head = null;

        head = insertAtTheBeginning(head, 0);
        printCDLL(head);
        System.out.println();

        head = insertAtTheEnd(head, 2);
        printCDLL(head);
        System.out.println();
    }

    /**
     * Insert at the beginning
     *
     * TC: O(1)
     * SC: O(1)
     *
     * @param head
     * @param d
     * @return
     */
    public static Node insertAtTheBeginning(Node head, int d) {

        if(head == null) {
            Node new_node = new Node(d);
            new_node.next = new_node.prev = new_node;
            head = new_node;
            return head;
        }
        Node last = head.prev;

        Node new_node = new Node(d);
        new_node.next = head;
        new_node.prev = last;

        last.next = new_node;
        head.prev = new_node;

        head = new_node;

        return head;
    }

    public static Node insertAtTheEnd(Node head, int d) {
        if(head == null) {
            Node new_node = new Node(d);
            new_node.next = new_node;
            new_node.prev = new_node;
            return new_node;
        }

        Node last = head.prev;

        Node new_node = new Node(d);

        new_node.next = head;
        head.prev = new_node;

        new_node.prev = last;
        last.next = new_node;

        return head;
    }

    public static void printCDLL(Node head) {
        if(head == null) {
            System.out.print("null");
        }
        Node temp = head;
        while (temp != head) {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.print("null");
    }
}
