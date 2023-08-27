package com.dsalgo.linked.lists.circular;

public class CircularLinkedList2 {
    public static void main(String[] args) {
        Node head = new Node(5);
        head.next = new Node(10);
        head.next.next = new Node(15);
        head.next.next.next = head;
        printCLL(head);

        head = insertAtBeginning(head, 20);
        System.out.println();
        printCLLDoWhile(head);

        head = insertAtBeginningUsingSwapping(head, 25);
        System.out.println();
        printCLLDoWhile(head);

        head = insertAtEnd(head, 30);
        System.out.println();
        printCLL(head);

        head = insertAtEndUsingSwapping(head, 35);
        System.out.println();
        printCLL(head);

        head = deleteHead(head);
        System.out.println();
        printCLL(head);

        head = deleteKthNode(head, 2);
        System.out.println();
        printCLL(head);

        head = deleteHeadNodeByRemovingLink(head);
        System.out.println();
        printCLL(head);
    }

    /**
     * Traverse CLL using do while loop
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     */
    public static void printCLLDoWhile(Node head) {
        if(head == null) return;

        Node temp = head;

        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.print("null");
    }

    /**
     * Traverse CLL
     *
     * TC: O(n)
     * SC: O(1)
     * @param head
     */
    public static void printCLL(Node head) {
        if(head == null) {
            return;
        }

        System.out.print(head.data + " -> ");

        for(Node r = head.next; r != head; r = r.next) {
            System.out.print(r.data + " -> ");
        }
        System.out.print("null");
    }

    /**
     * Insert at the beginning: Create a new node, traverse the whole list to find the last node.
     * Change next of the last node to new node. New node's next should be head. Make temp as head.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @param d
     * @return
     */
    public static Node insertAtBeginning(Node head, int d) {
        Node temp = new Node(d);

        if(head == null) {
            temp.next = temp;
            return temp;
        }
        Node current = head;

        while (current.next != head) {
            current = current.next;
        }

        current.next = temp;
        temp.next = head;

        return temp;
    }

    /**
     * Insert at the beginning: Insert the new node after head. Swap the data of head and new node
     * Return head as it remains unchanged
     *
     * TC: O(1)
     * SC: O(1)
     *
     * @param head
     * @param d
     * @return
     */
    public static Node insertAtBeginningUsingSwapping(Node head, int d) {
        Node temp = new Node(d);

        if(head == null) {
            temp.next = temp;
            return temp;
        }

        // insert the new node after head
        temp.next = head.next;
        head.next = temp;

        // swap data of head and temp nodes
        int t = head.data;
        head.data = temp.data;
        temp.data = t;

        // head remains same
        return head;
    }

    /**
     * Insert at the end: Create a new node, traverse the whole list to find the last node.
     * Change next of the last node to new node. Head remains unchanged.
     *
     * TC: O(n)
     * SC: O(1)
     * @param head
     * @param x
     * @return
     */
    public static Node insertAtEnd(Node head, int x) {
        Node temp = new Node(x);

        if(head == null) {
            temp.next = temp;
            return temp;
        }

        Node current = head;

        while (current.next != head) {
            current = current.next;
        }

        current.next = temp;
        temp.next = head;

        return head;
    }

    /**
     * Insert at end: Insert the new node after head. Swap the data of head and new node
     * Make temp as head.
     *
     * TC: O(1)
     * SC: O(1)
     *
     * @param head
     * @param d
     * @return
     */
    public static Node insertAtEndUsingSwapping(Node head, int d) {
        Node temp = new Node(d);

        if(head == null) {
            temp.next = temp;
            return temp;
        }

        // insert the new node after head
        temp.next = head.next;
        head.next = temp;

        // swap data of head and temp nodes
        int t = head.data;
        head.data = temp.data;
        temp.data = t;

        // temp becomes head
        return temp;
    }

    /**
     * Delete head node of CLL
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public static Node deleteHead(Node head) {
        if(head == null || head.next == null) {
            return null;
        }

        Node current = head;

        while (current.next != head) {
            current = current.next;
        }

        current.next = head.next;
        return current.next;
    }

    /**
     *
     * Delete head node of CLL by removing copying the head's next node data to head node
     * and changing the link of head.next to head.next.next
     *
     * TC: O(1)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public static Node deleteHeadNodeByRemovingLink(Node head) {
        if(head == null || head.next == null) {
            return null;
        }

        head.data = head.next.data;
        head.next = head.next.next;

        return head;
    }

    /**
     * Delete kth node in CLL
     *
     * Assumption: number of nodes > k
     * @param head
     * @return
     */
    public static Node deleteKthNode(Node head, int k) {
        if(head == null) {
            return null;
        }
        if(k == 1) {
            // return deleteHeadNodeByRemovingLink(head);
            if(head.next == null) {
                return null;
            }
            head.data = head.next.data;
            head.next = head.next.next;
            return head;
        }
        Node temp = head;
        int count = 0;
        while (count < k - 2) {
            temp = temp.next;
            count++;
        }
        temp.next = temp.next.next;
        return head;
    }
}


class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
