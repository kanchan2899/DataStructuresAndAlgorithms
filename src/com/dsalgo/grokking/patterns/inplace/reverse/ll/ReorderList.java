package com.dsalgo.grokking.patterns.inplace.reverse.ll;

public class ReorderList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }

        static Node insertAtBeginning(Node head, int data) {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
            return head;
        }

        static void display(Node head) {
            while (head != null) {
                System.out.print(head.data + " -> ");
                head = head.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node head =  null;
        head = Node.insertAtBeginning(null, 3);
        head = Node.insertAtBeginning(head, 5);
        head = Node.insertAtBeginning(head, 7);
        head = Node.insertAtBeginning(head, 9);
        head = Node.insertAtBeginning(head, 11);
        Node.display(head);
        head = reorderLL(head);
        Node.display(head);
    }

    public static Node reorderLL(Node head) {
        if(head == null) {
            return head;
        }

        // find the middle node
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the second part of the ll
        Node previous = null, next = null, current = slow;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        // merge the two sorted ll
        Node first = head;
        Node second = previous;
        Node temp = head;

        while (second.next != null) {
            temp = temp.next;
            first.next = second;
            second = second.next;
            first.next.next = temp;
            first = first.next.next;
        }
        return head;
    }
}
