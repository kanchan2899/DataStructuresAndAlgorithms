//package com.dsalgo.linked.lists.sorting;
//
//import com.dsalgo.linked.lists.singly.LinkedList;
//
//import java.util.List;
//
///*
//    https://www.geeksforgeeks.org/merge-sort-for-linked-list/
//    Merge sort is often preferred for sorting a linked list. The slow random-access
//    performance of a linked list makes some other algorithms (such as quicksort) perform
//    poorly, and others (such as head sort) completely impossible.
// */
//public class MergeSort {
//    public static void main(String[] args) {
//        LinkedList list1 = new LinkedList();
//        list1.insert(4);
//        list1.insert(5);
//        list1.insert(2);
//        list1.insert(1);
//        list1.insert(3);
//
//        getMiddle(list1).print();
//    }
//
//    public static LinkedList mergeSort(LinkedList list) {
//        if(list.head == null || list.getNextNode() == null) {
//            return list;
//        }
//
//        return list;
//    }
//
//    public static LinkedList getMiddle(LinkedList list) {
//        if(list.head == null) {
//            return list;
//        }
//
//        LinkedList slow = list, fast = list;
//
//        while (fast != null && fast.getNextNode() != null) {
//            slow.head = slow.getNextNode();
//            fast.head = fast.getNextNode().next;
//        }
//        return slow;
//    }
//
//}
