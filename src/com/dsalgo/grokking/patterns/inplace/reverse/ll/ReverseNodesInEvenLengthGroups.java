package com.dsalgo.grokking.patterns.inplace.reverse.ll;

public class ReverseNodesInEvenLengthGroups {
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
        head = reverseNodesInEvenLengthGroups(head);
        Node.display(head);
    }

    private static Node reverseNodesInEvenLengthGroups(Node head) {
        // node immediately before the current group
        Node prev = head;
        Node node, reverse, currNext, curr, prevNext = null;

        // the head doesn't need to be reversed since it's a group of one node, so starts with length 2
        int groupLen = 2;
        int numNodes = 0;

        while (prev.next != null) {
            node = prev;
            numNodes = 0;

            // traverse all the nodes of the current group
            for(int i = 0; i < groupLen; i++) {
                if(node.next == null) {
                    break;
                }
                numNodes += 1;
                node = node.next;
            }

            // odd length
            if(numNodes % 2 != 0) {
                prev = node;
            }

            // even length
            else {
                reverse = node.next;
                curr = prev.next;

                for(int j = 0; j < numNodes; j++) {
                    currNext = curr.next;
                    curr.next = reverse;
                    reverse = curr;
                    curr = currNext;
                }

                // update the prev pointer after reversal of the even group
                prevNext = prev.next;
                prev.next = node;
                prev = prevNext;
            }
            // increment one by one and move to the next group
            groupLen += 1;
        }


        return head;
    }
}
