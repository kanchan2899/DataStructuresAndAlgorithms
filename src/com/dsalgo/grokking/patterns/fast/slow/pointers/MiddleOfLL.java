package com.dsalgo.grokking.patterns.fast.slow.pointers;

public class MiddleOfLL {
    class Node {
        int data;
        Node next;
    }

    Node middleOfLL(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
