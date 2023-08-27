package com.dsalgo.linked.lists.doubly;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int d) {
        data = d;
        next = prev = null;
    }
}

class DoublyLinkedList1 {

    public static void main(String[] args) {
        Node head = null;

        head = insertBeginning(head, 3);
        printDLL(head);
        System.out.println();

        head = insertBeginning(head, 4);
        printDLL(head);
        System.out.println();

        head = insertEnd(head, 1);
        printDLL(head);
        System.out.println();

        head = reverseDLL(head);
        printDLL(head);
        System.out.println();

        head = removeHeadNodeOfDLL(head);
        printDLL(head);
        System.out.println();

        head = insertEnd(head, 2);
        printDLL(head);
        System.out.println();

        head = insertEnd(head, 9);
        printDLL(head);
        System.out.println();

        head = removeLastNodeofDLL(head);
        printDLL(head);
        System.out.println();

        head = sortDoublyLL(head);
        printDLL(head);
        System.out.println();
    }
    /**
     *
     * Insert at the beginning of the DLL
     *
     * TC: O(1)
     * SC: O(1)
     *
     * @param head
     * @param data
     * @return
     */
    public static Node insertBeginning(Node head, int data) {
        // allocate node and put in the data
        Node temp = new Node(data);

        // make new node's next as temp and prev as null
        temp.prev = null;
        temp.next = head;

        // change prev of head node to new node
        if(head != null) {
            head.prev = temp;
        }

        // move the head to point to the new node
        head = temp;
        return head;
    }

    public static void printDLL(Node head) {
        if(head == null) {
            System.out.print("null");
        }
        Node curr = head;
        while (curr != null){
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    /**
     *
     * Insert at the end of a DLL
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @param data
     * @return
     */
    public static Node insertEnd(Node head, int data) {
        Node temp = new Node(data);

        if(head == null) {
            return temp;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.next = temp;
        temp.prev = current;

        return head;
    }

    /**
     * Reverse a DLL:
     *
     * 1. Traverse the linked list using a pointer
     * 2. Swap the prev and next pointers for all nodes
     * 3. At last, change the head pointer of the doubly linked list
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     */
    public static Node reverseDLL(Node head) {
        Node temp = null;
        Node current = head;

        // swap next and prev for all nodes of doubly linked list
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            current = current.prev;
        }

        // Before changing head, check for the cases like empty list and list with only one node
        if(temp != null) {
            head = temp.prev;
        }
        return head;
    }

    /**
     *
     * Remove head node of a DLL
     *
     * TC: O(1)
     * SC: O(1)
     *
     */
    public static Node removeHeadNodeOfDLL(Node head) {
        if(head == null || head.next == null) {
            return null;
        } else {
            head = head.next;
            head.prev = null;
            return head;
        }
    }

    /**
     *
     * Remove the last node of DLL
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public static Node removeLastNodeofDLL(Node head) {
        if(head == null || head.next == null) {
            return null;
        }

        Node current = head;

        while (current.next != null) {
            current = current.next;
        }

        current.prev.next = null;
        return head;
    }

    public static Node sortDoublyLL(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node mid = slow;
        Node beforeMid = slow.prev;


        beforeMid.next = null;
        mid.prev = null;

        Node left = sortDoublyLL(head);
        Node right = sortDoublyLL(mid);

        return mergeDoublyLL(left, right);
    }

    private static Node mergeDoublyLL(Node a, Node b) {
        if(a  == null) {
            return b;
        }
        if(b == null) {
            return a;
        }

        Node head = null, tail = null, temp = null;

        if(a.data <= b.data) {
            head = a;
            tail = a;
            a = a.next;
        } else {
            head = b;
            tail = b;
            b = b.next;
        }

        while (a != null && b != null) {
            if(a.data <= b.data) {
                tail.next = a;
                temp = tail;
                tail = a;
                tail.prev = temp;
                a = a.next;
            } else {
                tail.next = b;
                temp = tail;
                tail = b;
                tail.prev = temp;
                b = b.next;
            }
        }

        if(a == null) {
            tail.next = b;
            temp = tail;
            tail = b;
            tail.prev = temp;
        }

        if(b == null) {
            tail.next = a;
            temp = tail;
            tail = a;
            tail.prev = temp;
        }

        return head;
    }
}


