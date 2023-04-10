//package com.dsalgo.linked.lists.singly.sort;
//
//import com.dsalgo.linked.lists.singly.LinkedList;
//
//public class MergeSort extends LinkedList {
//    public Node head;
//
//    public Node sortedList(Node head) {
//        Node temp = head;
//        if(temp == null || temp.next == null) return temp;
//
//        Node mid = getMid(head);
//        Node left = sortedList(head);
//        Node right = sortedList(mid);
//        return merge(left, right);
//    }
//
//    private Node merge(Node ll1, Node ll2) {
//        Node dummyHead = new Node();
//        Node tail = dummyHead;
//        while (ll1 != null && ll2 != null) {
//            if(ll1.val < ll2.val) {
//                tail.next = ll1;
//            }
//        }
//    }
//
//    private Node getMid(Node head) {
//        Node slow = head, fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return slow;
//    }
//}
