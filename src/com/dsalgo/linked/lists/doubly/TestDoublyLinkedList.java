package com.dsalgo.linked.lists.doubly;

public class TestDoublyLinkedList {
    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();
        System.out.print("Initial DLL ======== ");
        dll.display();
        System.out.print("Insert 4 at first index ======== ");
        dll.insertFirst(4);
        dll.display();
        System.out.print("Insert 9 at first index ======== ");
        dll.insertFirst(9);
        dll.display();
        System.out.print("Insert 3 at first index ======== ");
        dll.insertFirst(3);
        dll.display();
        System.out.print("Insert 5 at first index ======== ");
        dll.insertFirst(5);
        dll.display();
        System.out.print("Insert 7 at last index ======== ");
        dll.insertLast(7);
        dll.display();
        System.out.print("Insert 1 at last 2 index ======== ");
        dll.insertAtIndex(1, 2);
        dll.display();
        System.out.print("Insert 2 after 1 ======== ");
        dll.insertAfter(1, 2);
        dll.display();
    }
}
