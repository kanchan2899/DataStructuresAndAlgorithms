package com.dsalgo.grokking.patterns.inplace.reverse.ll;

public class SwappingNodesInLL {
    static class Node {
        int data;
        Node next;

        Node (int data) {
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

        public static void main(String[] args) {
            Node head =  null;
            head = Node.insertAtBeginning(null, 3);
            head = Node.insertAtBeginning(head, 5);
            head = Node.insertAtBeginning(head, 7);
            head = Node.insertAtBeginning(head, 9);
            head = Node.insertAtBeginning(head, 11);
            Node.display(head);
            head = swapKthNode(head, 2);
            Node.display(head);
        }

        private static Node swapKthNode(Node head, int k) {
            if(head == null) {
                return null;
            }

            int count = 0;

            // front and end pointers will be used to track the kth node from the start and end
            // of the linked list, respectively
            Node front = null, end = null, curr = head;

            while (curr != null) {
                count += 1;
                // if end is not null, it means the kth node from the beginning has been found,
                // we can start moving the end pointer to find the kth node from the end of ll
                if(end != null) {
                    end = end.next;
                }
                // if the count has become equal to k, it means the curr is pointing to the
                // kth node from the beginning of the ll
                if(count == k) {
                    front = curr;
                    end = head;
                }
                curr = curr.next;
            }

            int temp = front.data;
            front.data = end.data;
            end.data = temp;

            return head;
        }
    }
}
