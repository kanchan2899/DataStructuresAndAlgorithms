package com.dsalgo.grokking.patterns.inplace.reverse.ll;

public class ReverseLLII {
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
        }
    }

    public static void main(String[] args) {
        Node head =  null;
        head = Node.insertAtBeginning(null, 3);
        head = Node.insertAtBeginning(head, 5);
        head = Node.insertAtBeginning(head, 7);
        head = Node.insertAtBeginning(head, 9);
        Node.display(head);

        head = reverseBetween(head, 2, 4);
        Node.display(head);

    }

    public static Node reverseBetween(Node head, int left, int right) {
        Node curr = head;
        Node lpn = null;   // previous node before the sublist/left
        Node right_n = null;       // node after the sublist/right
        Node reverse_head = null;   // head of the reversed sublist

        int count = 1;

        while (count < left && curr != null) {
            lpn = curr;
            curr = curr.next;
            count++;
        }

        if(curr != null) {
            Node rpn = curr;
            while (count <= right && rpn != null) {
                right_n = rpn;
                rpn = right_n.next;
                count++;
            }
            if(right_n != null) {
                reverse_head = reverse(curr, left, right);
            }

            // connects the previous node to the reversed sublist
            if(lpn != null) {
                lpn.next = reverse_head;
            }

            // connects the last node of the reversed sublist to the next node after the sublist
            if(rpn != null) {
                Node temp = reverse_head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = rpn;
            }
        }

        // returns the original head if there are nodes before the sublist else returns reversed sublist
        if(lpn != null) {
            return head;
        } else {
            return reverse_head;
        }

    }

    private static Node reverse(Node head, int left, int right) {
        Node prev = null;
        Node curr = head;

        while (right >= left) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            right--;
        }
        return prev;    // returns the head of the reversed list
    }
}
