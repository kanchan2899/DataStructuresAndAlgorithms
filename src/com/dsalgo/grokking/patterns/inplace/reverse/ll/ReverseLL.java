package com.dsalgo.grokking.patterns.inplace.reverse.ll;

public class ReverseLL {
    static class Node {
        Node next;
        int data;
        Node (int data) {
            next = null;
            this.data = data;
        }
    }

    Node reverseLL(Node head) {
        Node prev = null;
        Node next = null;
        Node curr = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        return head;
    }
}
