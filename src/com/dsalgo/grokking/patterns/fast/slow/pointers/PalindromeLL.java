package com.dsalgo.grokking.patterns.fast.slow.pointers;

public class PalindromeLL {
    class Node {
        Node next;
        int data;
    }

    static boolean isPalindromeLL(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node reversedLL = reverse(slow);

        return isEqual(head, reversedLL);
    }

    private static boolean isEqual(Node head1, Node head2) {
        while (head1 != null && head2 != null) {
            if(head1.data != head2.data) {
                return false;
            } else {
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        return true;
    }

    static Node reverse(Node head) {
        Node prev = null, next = null, curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
