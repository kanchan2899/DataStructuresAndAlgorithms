package com.dsalgo.grokking.patterns.k.way.merge;

import java.util.Arrays;
import java.util.List;

// https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
public class MergeKLinkedLists {

    static class LinkedListNode {
        LinkedListNode next;
        int data;

        public LinkedListNode(int data) {
            this.data = data;
            this.next = null;
        }

        public static LinkedListNode insertBefore(LinkedListNode head, int data) {
            LinkedListNode temp = new LinkedListNode(data);
            temp.next = head;
            head = temp;
            return head;
        }

        public static void printList(LinkedListNode head) {
            LinkedListNode temp = head;

            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.print("null");
            System.out.println();
        }
    }



    public static void main(String[] args) {
        LinkedListNode head1 = LinkedListNode.insertBefore(null, 13);
        head1 = LinkedListNode.insertBefore(head1, 12);
        head1 = LinkedListNode.insertBefore(head1, 10);

        LinkedListNode.printList(head1);

        LinkedListNode head2 = LinkedListNode.insertBefore(null, 9);
        head2 = LinkedListNode.insertBefore(head2, 8);
        head2 = LinkedListNode.insertBefore(head2, 7);

        LinkedListNode.printList(head2);

        LinkedListNode head3 = LinkedListNode.insertBefore(null, 7);
        head3 = LinkedListNode.insertBefore(head3, 5);

        LinkedListNode.printList(head3);

        LinkedListNode head = mergeKLinkedLists(Arrays.asList(head1, head2, head3));
    }

    private static LinkedListNode mergeKLinkedLists(List<LinkedListNode> inputLists) {
        int temp = 0;
        if(inputLists.size() > 0) {
            int step = 1;

            while (step < inputLists.size()) {
                for(int i = 0; i < inputLists.size() - step; i += step * 2) {
                    // inputLists.get(i).head = merge2Lists(inputLists.get(i).head, inputLists.get(i + step).head);
                }
                step *= 2;
            }
            // return inputLists.get(0).head;
            return inputLists.get(0);
        } else {
            return null;
        }
    }

    public static LinkedListNode merge2Lists(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode dummy = new LinkedListNode(-1);

        // set prev node to dummy node
        LinkedListNode prev = dummy;

        // traverse over the lists until both or one of them becomes null
        while (head1 != null && head2 != null) {
            // if l1 value is <= l2 value, add l1 to the list
            if(head1.data <= head2.data) {
                prev.next = head1;
                head1 = head1.next;
            } else {
                prev.next = head2;
                head2 = head2.next;
            }
            prev = prev.next;
        }

        if(head1 == null) {
            prev.next = head2;
        } else {
            prev.next = head1;
        }

        return dummy.next;
    }
}
