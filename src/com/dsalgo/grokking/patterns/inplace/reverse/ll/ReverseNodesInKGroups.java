package com.dsalgo.grokking.patterns.inplace.reverse.ll;

// https://www.geeksforgeeks.org/reverse-a-linked-list/
public class ReverseNodesInKGroups {
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static Node reverseKGroups(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node current = dummy;

        while (current != null) {
            Node temp = current;
            for(int i = 0; i < k; i++) {
                if(current == null) {
                    break;
                }
                current = current.next;
            }

            if(current == null) {
                break;
            }

            Node[] updatedNodes = reverse(current.next, k);
            Node previous = updatedNodes[0];
            Node curr = updatedNodes[1];

            Node lastNodeOfReversedGroup = current.next;
            lastNodeOfReversedGroup.next = curr;
            current.next = previous;
            current = lastNodeOfReversedGroup;
        }
        return dummy.next;
    }

    public static Node[] reverse(Node head, int k) {

        Node previous = null, current  = head, next = null;

        for(int i = 0; i < k; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return new Node[] {previous, current};
    }

}
