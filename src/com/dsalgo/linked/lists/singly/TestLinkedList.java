package com.dsalgo.linked.lists.singly;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        System.out.print("Initial LinkedList ====== ");
        list.display();
        System.out.print("Insert 2 at first index ======= ");
        list.insertFirst(2);
        list.display();
        System.out.print("Insert 4 at first index ======= ");
        list.insertFirst(4);
        list.display();
        System.out.print("Insert 6 at first index ======= ");
        list.insertFirst(6);
        list.display();
        System.out.print("Insert 7 at last index ======= ");
        list.insertLast(7);
        list.display();
        System.out.print("Insert 9 at index 2 ======= ");
        list.insertAtIndex(9, 2);
        list.display();
        System.out.println("Deleted first node value: " + list.deleteFirst());
        list.display();
        System.out.println("Deleted last node value: " + list.deleteLast());
        list.display();
        System.out.println("Deleted node at index 2: " + list.deleteAtIndex(2));
        list.display();
        System.out.println("Find node with value 2: " + list.find(2));

    }
}
