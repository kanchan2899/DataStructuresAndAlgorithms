package com.dsalgo.linked.lists.singly;

public class TestLinkedList {
    public static void main(String[] args) {
        System.out.println("********************************************************************");
        crudOperationsLL();
        System.out.println("********************************************************************");
        removeDuplicatesInSortedLL();
        System.out.println("********************************************************************");
        mergeTwoSortedLL();
        System.out.println("********************************************************************");
        middleOfLL();
        System.out.println("********************************************************************");
        rotateLL1();
        System.out.println("********************************************************************");
        rotateLL2();
        System.out.println("********************************************************************");
        partitionList();
        System.out.println("********************************************************************");
        reverseBetween();
        System.out.println("********************************************************************");
        reorderList();
    }

    private static void crudOperationsLL() {
        LinkedList ll1 = new LinkedList();
        System.out.println("{{ CRUD Operations in singly linked list }}");
        System.out.print("Initial LinkedList ====== ");
        ll1.display();
        System.out.print("Insert 2 at first index ======= ");
        ll1.insertFirst(2);
        ll1.display();
        System.out.print("Insert 4 at first index ======= ");
        ll1.insertFirst(4);
        ll1.display();
        System.out.print("Insert 6 at first index ======= ");
        ll1.insertFirst(6);
        ll1.display();
        System.out.print("Insert 7 at last index ======= ");
        ll1.insertLast(7);
        ll1.display();
        System.out.print("Insert 9 at index 2 ======= ");
        ll1.insertAtIndex(9, 2);
        ll1.display();
        System.out.print("Deleted first node value: ======= " + ll1.deleteFirst());
        ll1.display();
        System.out.print("Deleted last node value: ======= " + ll1.deleteLast());
        ll1.display();
        System.out.print("Deleted node at index 2: =======" + ll1.deleteAtIndex(2));
        ll1.display();
        System.out.println("Find node with value 2: ======= " + ll1.find(2));
        System.out.print("Insert 13 at index 2 using recursion ======= ");
        ll1.insertUsingRecursion(13, 2);
        ll1.display();
        System.out.print("Insert 12 at index 1 using recursion ======= ");
        ll1.insertUsingRecursion(14, 1);
        ll1.display();
        System.out.print("Insert 19 at index 3 using recursion ======= ");
        ll1.insertUsingRecursion(19, 3);
        ll1.display();
    }

    private static void removeDuplicatesInSortedLL() {
        LinkedList ll2 = new LinkedList();
        ll2.insertFirst(5);
        ll2.insertFirst(5);
        ll2.insertFirst(3);
        ll2.insertFirst(1);
        ll2.insertFirst(1);
        System.out.println("{{ REMOVE DUPLICATES FROM SORTED LINKED LIST }}");
        System.out.print("Initial sorted linked list ====== ");
        ll2.display();
        System.out.print("Delete duplicates from sorted linked list ====== ");
        ll2.removeDuplicatesInSortedList();
        ll2.display();
    }

    private static void mergeTwoSortedLL() {
        System.out.println("{{ MERGE TWO SORTED LINKED LISTS }}");
        LinkedList ll1 = new LinkedList();
        ll1.insertFirst(7);
        ll1.insertFirst(4);
        ll1.insertFirst(4);
        ll1.insertFirst(3);
        System.out.print("First sorted LL ======== ");
        ll1.display();

        LinkedList ll2 = new LinkedList();
        ll2.insertFirst(5);
        ll2.insertFirst(4);
        ll2.insertFirst(3);
        ll2.insertFirst(3);
        ll2.insertFirst(2);
        ll2.insertFirst(1);
        System.out.print("Second sorted LL ======== ");
        ll2.display();

        LinkedList merged = ll1.mergeTwoSortedLinkedLists(ll2);
        System.out.print("Merged sorted LL ======= ");
        merged.display();
    }

    private static void middleOfLL() {
        System.out.println("{{ MIDDLE OF A LINKED LISTS }}");
        LinkedList ll1 = new LinkedList();
        ll1.insertFirst(7);
        ll1.insertFirst(4);
        ll1.insertFirst(5);
        ll1.insertFirst(6);
        ll1.insertFirst(3);
        System.out.print("LL is =========== ");
        ll1.display();
        System.out.println("Mid node of linked list is " + ll1.middleNode());
    }

    private static void rotateLL1() {
        System.out.println("{{ ROTATE THE LINKED LISTS BY K STEPS}}");

        LinkedList ll1 = new LinkedList();
        ll1.insertFirst(1);
        ll1.insertFirst(2);
        ll1.insertFirst(3);
        ll1.insertFirst(4);
        ll1.insertFirst(5);
        System.out.print("LL is =========== ");
        ll1.display();
        ll1.rotateList1(2);
        System.out.print("Rotated LL is  ======= ");
        ll1.display();
    }


    private static void rotateLL2() {
        System.out.println("{{ ROTATE THE LINKED LISTS BY K STEPS}}");

        LinkedList ll1 = new LinkedList();
        ll1.insertFirst(1);
        ll1.insertFirst(2);
        ll1.insertFirst(3);
        ll1.insertFirst(4);
        ll1.insertFirst(5);
        System.out.print("LL is =========== ");
        ll1.display();
        ll1.rotateList2(2);
        System.out.print("Rotated LL is  ======= ");
        ll1.display();
    }

    private static void partitionList() {

        System.out.println("{{ PARTITION LIST }}");

        LinkedList ll1 = new LinkedList();
        ll1.insertFirst(1);
        ll1.insertFirst(4);
        ll1.insertFirst(3);
        ll1.insertFirst(2);
        ll1.insertFirst(5);
        ll1.insertFirst(2);
        System.out.print("LL is =========== ");
        ll1.display();
        ll1.partition(3);
        System.out.print("Rotated LL is  ======= ");
        ll1.display();
    }

    private static void reverseBetween() {
        LinkedList ll1 = new LinkedList();
        ll1.insertFirst(1);
        ll1.insertFirst(4);
        ll1.insertFirst(3);
        ll1.insertFirst(2);
        ll1.insertFirst(5);
        ll1.insertFirst(2);
        System.out.print("LL is =========== ");
        ll1.display();
        ll1.reverseBetween(2, 5);
        System.out.print("Rotated LL is  ======= ");
        ll1.display();
    }

    private static void reorderList() {
        LinkedList ll1 = new LinkedList();
        ll1.insertFirst(1);
        ll1.insertFirst(2);
        ll1.insertFirst(3);
        ll1.insertFirst(4);
        ll1.insertFirst(5);
        ll1.insertFirst(6);
        System.out.print("LL is =========== ");
        ll1.display();
        ll1.reorderList();
        System.out.print("Reordered LL is  ======= ");
        ll1.display();
    }

}
