package com.dsalgo.linked.lists;

/*
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-list-using-merge-sort/
    https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-list-using-hashing/

    I/P: List1 = 1 -> 2 -> 3 -> 4, List2 = 3 -> 4 -> 8 -> 10
    O/P: 1 -> 2 -> 3 -> 4 -> 8 -> 10



 */

public class UnionOfTwoLinkedLists {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(2);

        LinkedList list2 = new LinkedList();
        list2.insert(2);
        list2.insert(3);
        list2.insert(4);

        System.out.print("Using Bruteforce: ");
        getUnion(list1, list2).print();
        System.out.println();
    }

    /**
     *  Using Bruteforce:Initialize a new list and store first and
     *  second list data to set to remove duplicate data.
     *  and then store it into our new list ans and return its head.
     *
     *  Time complexity = O(m * n)
     *  Space complexity = O(m + n)
     */
    static LinkedList getUnion(LinkedList head1, LinkedList head2){
        LinkedList union = head1;
        LinkedList pointer2 = head2;

        while(pointer2.head != null){
            if(!head1.is_present(pointer2.head.data)){
                union.insert(pointer2.head.data);
            }
            pointer2.head = pointer2.head.next;
        }
        return union;
    }
}
