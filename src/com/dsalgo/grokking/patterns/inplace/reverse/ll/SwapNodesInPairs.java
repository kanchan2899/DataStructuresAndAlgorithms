package com.dsalgo.grokking.patterns.inplace.reverse.ll;

public class SwapNodesInPairs {
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
        head = Node.insertAtBeginning(head, 13);
        Node.display(head);
        head = swapNodesInPairs(head);
        Node.display(head);
    }

    private static Node swapNodesInPairs(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        // initialize previous and current pointers
        Node prev = head;
        Node curr = head.next;

        // change head before proceeding
        head = curr;

        while (true) {
            Node next = curr.next;
            curr.next = prev;       // change next of current as previous node

            // if next node is null or next is the last node
            if(next == null || next.next == null) {
                prev.next = next;
                break;
            }

            // change next of previous to next's next
            prev.next = next.next;

            // update previous and curr
            prev = next;
            curr = prev.next;
        }

        return head;
    }
}
