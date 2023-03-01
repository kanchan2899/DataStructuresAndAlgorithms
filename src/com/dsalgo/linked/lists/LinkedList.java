package com.dsalgo.linked.lists;

public class LinkedList {
    Node head = null;
    static int size = 0;

    public void insert(int data) {
        Node new_node = new Node(data);

        // If the list is empty, make the new node as head
        if(head == null) {
            head = new_node;
        }
        // Else Traverse the list till the last node and insert the new_node at last
        else{
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }
        size++;
    }

    boolean is_present(int data) {
        Node current_pointer = head;
        while(current_pointer != null) {
            if(current_pointer.data == data) {
                return true;
            }
            current_pointer = current_pointer.next;
        }
        return false;
    }

    public void print() {
        Node current_pointer = head;
        while (current_pointer != null) {
            System.out.print(current_pointer.data + " ");
            current_pointer = current_pointer.next;
        }
    }
}
