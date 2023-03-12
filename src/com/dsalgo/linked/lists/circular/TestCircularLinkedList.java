package com.dsalgo.linked.lists.circular;

public class TestCircularLinkedList {

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        cll.insert(1);
        cll.insert(2);
        cll.insert(3);
        cll.insert(4);
        cll.insert(5);
        cll.display();
        System.out.println("Size of the CLL is " + cll.size);
        System.out.println("Delete node with value 4");
        cll.delete(4);
        cll.display();
    }
}
