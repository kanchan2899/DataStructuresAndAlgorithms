package com.dsalgo.linked.lists;

/*
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-list-using-merge-sort/
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-list-using-hashing/

    I/P: List1 = 1 -> 2 -> 3 -> 4, List2 = 3 -> 4 -> 8 -> 10
    O/P: 3 -> 4


 */

import com.dsalgo.linked.lists.singly.LinkedList;

public class IntersectionOfTwoLinkedLists extends LinkedList {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insertFirst(1);
        list1.insertFirst(2);

        LinkedList list2 = new LinkedList();
        list2.insertFirst(2);
        list2.insertFirst(3);
        list2.insertFirst(4);

        System.out.print("Using Bruteforce: ");
        LinkedList intersection = getIntersection1(list1, list2);
        intersection.display();
    }

    /**
     * Using Bruteforce: Initialize the result list as NULL.
     * Traverse list2 and look for every element in list1.
     * If the element is present in list1, add the element to the result.
     *
     * Time complexity: O(m * n)
     * Space complexity: O(min(m, n))
     */
    public static LinkedList getIntersection1(LinkedList list1, LinkedList list2){
        LinkedList intersection = new LinkedList(), pointer2 = list2;
        while(pointer2.getHead() != null) {
            if(list1.getHead() != null && list1.find(pointer2.getVal()) != null){
                intersection.insertFirst(pointer2.getVal());
            }
            pointer2.head = pointer2.getNext();
        }
        return intersection;
    }
}
