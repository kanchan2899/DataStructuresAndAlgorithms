package com.dsalgo.linked.lists;

/*
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-list-using-merge-sort/
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-list-using-hashing/

    I/P: List1 = 1 -> 2 -> 3 -> 4, List2 = 3 -> 4 -> 8 -> 10
    O/P: 3 -> 4


 */

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(2);

        LinkedList list2 = new LinkedList();
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);

        System.out.print("Using Bruteforce: ");
        getIntersection1(list1, list2).print();
        System.out.println();
    }

    /**
     * Using Bruteforce: Initialize the result list as NULL.
     * Traverse list2 and look for every element in list1.
     * If the element is present in list1, add the element to the result.
     *
     * Time complexity: O(m * n)
     * Space complexity: O(min(m, n))
     */
    public static LinkedList getIntersection1(LinkedList head1, LinkedList head2){
        LinkedList intersection = new LinkedList(), pointer2 = head2;
        while(pointer2.head != null) {
            if(head1.is_present(pointer2.head.data)){
                intersection.insert(pointer2.head.data);
            }
            pointer2.head = pointer2.head.next;
        }
        return intersection;
    }
}
