package com.dsalgo.linked.lists;


/*
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-list-using-merge-sort/
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-list-using-hashing/

    I/P: List1 = 1 -> 2 -> 3 -> 4, List2 = 3 -> 4 -> 8 -> 10
    O/P: 1 -> 2 -> 3 -> 4 -> 8 -> 10



 */

import com.dsalgo.linked.lists.singly.LinkedList;

public class UnionOfTwoLinkedLists extends LinkedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertFirst(1);
        list1.insertFirst(2);

        LinkedList list2 = new LinkedList();
        list2.insertFirst(2);
        list2.insertFirst(3);
        list2.insertFirst(4);
        list2.insertFirst(1);

        LinkedList union = getUnion(list1, list2);
        union.display();
    }

    /**
     *  Using Bruteforce:Initialize a new list and store first and
     *  second list data to set to remove duplicate data.
     *  and then store it into our new list ans and return its head.
     *
     *  Time complexity = O(m * n)
     *  Space complexity = O(m + n)
     */
    static LinkedList getUnion(LinkedList list1, LinkedList list2){
        LinkedList union = list1;
        LinkedList pointer2 = list2;

        while(pointer2.getHead() != null){
            if(list1.getHead() != null && list1.find(pointer2.getVal()) == null){
                union.insertFirst(pointer2.getVal());
            }
            pointer2.head = pointer2.getNext();
        }
        return union;
    }
}
