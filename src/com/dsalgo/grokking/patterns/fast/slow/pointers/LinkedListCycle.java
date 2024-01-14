package com.dsalgo.grokking.patterns.fast.slow.pointers;

public class LinkedListCycle {
    class Node {
        int data;
        Node next;
    }

    boolean detectCycle(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}
