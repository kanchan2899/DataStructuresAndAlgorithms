package com.dsalgo.grokking.patterns.two.pointers;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {

    }

    /**
     * Using Bruteforce:
     *
     * 1. Get the size of the linked size
     * 2. Compute x as size - n - 1
     * 3. Traverse the list till x node
     * 4. Relink the current node's next with node's next of next
     * 5. Return head
     *
     * TC: O(n), 2 traversals of LL
     * SC: O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public Node removeNthNodeFromEnd1(Node head, int n) {
        int size = getSize(head);
        Node temp = head;
        if(size < n) {
            return head;
        }
        int x = size - n - 1;
        if(x == -1) {
            return temp.next;
        }
        while(x > 0) {
            temp = temp.next;
            x--;
        }
        temp.next = temp.next.next;
        return head;
    }

    private int getSize(Node head) {
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    /**
     * Using Two pointers:
     *
     * 1. Set two pointers, fast and slow, at the head of the linked list
     * 2. Move the fast pointer n steps forward
     * 3. Move both the pointers forward until the right pointer reaches the last node. At this point,
     * the slow pointer will be pointing to the node behind the nth last node
     * 4. Relink the slow node to the node next to the slow's next node.
     * 5. Return the head of the linked list
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public Node removeNthNodeFromEnd(Node head, int n) {
        Node fast = head, slow = head;

        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if(fast == null) {
            return head.next;
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    class Node {
        Node next;
        int data;
    }
}
