package com.dsalgo.linked.lists;

import java.util.Stack;

// https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-list/
public class AddTwoNumbers {
    static Node head1, head2, head;

    AddTwoNumbers() {
        head = null;
    }

    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /**
     * Add preceding zeroes: Traverse both lists to the end and add preceding zeros in the list with lesser digits.
     * Then call a recursive function on the start nodes of both lists which calls itself for
     * the next nodes of both lists till it gets to the end. This function creates a node for
     * the sum of the current digits and returns the carry.
     *
     * 1. Traverse the two linked lists in order to add preceding zeros in case a list is having
     * lesser digits than the other one.
     * 2. Start from the head node of both lists and call a recursive function for the next nodes.
     * 3. Continue it till the end of the lists.
     * 4. Creates a node for current digits sum and returns the carry.
     *
     * TC: O(m + n)
     * SC: O(m + n), temporary list to store the output
     *
     * @param first
     * @param second
     */
    void addTwoLists(Node first, Node second) {
        Node start1 = new Node(0);
        start1.next = first;
        Node start2 = new Node(0);
        start2.next = second;

        addPrecedingZeroes(start1, start2);
        Node result = new Node(0);

        if(sumTwoNodes(start1.next, start2.next, result) == 1) {
            Node node = new Node(1);
            node.next = result.next;
            result.next = node;
        }

        printList(result.next);
    }

    private void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.print("null");
    }

    // append preceding zeroes in case a list is having lesser nodes than the other ones
    private void addPrecedingZeroes(Node start1, Node start2) {
        Node next1 = start1.next;
        Node next2 = start2.next;

        while (next1 != null && next2 != null) {
            next1 = next1.next;
            next2 = next2.next;
        }

        if(next1 == null && next2 != null) {
            while (next2 != null) {
                Node node = new Node(0);
                node.next = start1.next;
                start1.next = node;
                next2 = next2.next;
            }
        } else if(next1 != null && next2 == null) {
            while (next1 != null) {
                Node node = new Node(0);
                node.next = start2.next;
                start2.next = node;
                next1 = next1.next;
            }
        }
    }

    // add lists and return the carry
    private int sumTwoNodes(Node first, Node second, Node result) {
        if(first == null) {
            return 0;
        }

        int number = first.data + second.data + sumTwoNodes(first.next, second.next, result);
        Node node = new Node(number % 10);
        node.next = result.next;
        result.next = node;
        return number / 10;
    }


    /**
     * we have two linked list we just get it into number form if 1->2->3 then number is 123
     * using while loop and simple math here is how we get toward second last node of linked list
     * and just add to number and multiply by 10. then at last node outside the while loop we
     * add last node value and we get the number in linked list form to number/integer.also do
     * similar task for second linked list and then add both number and form a third number.
     * and then we use again simple mathnand while loop to get number in last digit(by %10 and /10)
     * and then push a node form every digit in new Linked list at the end here we have our
     * new/resultant linked list.
     *
     * TC: O(m + n)
     * SC: O(m + n)
     *
     * @param first, second
     *
     */
    void addTwoLists1(Node first, Node second) {
        // check gfg for implementation
    }

    /**
     *
     * Using stacks:
     *
     * 1. Create 3 stacks namely s1,s2,s3.
     * 2. Fill s1 with Nodes of list1 and fill s2 with nodes of list2.
     * 3. Fill s3 by creating new nodes and setting the data of new nodes to the sum of s1.top(),
     * s2.top() and carry until list1 and list2 are empty.
     *      a. If the sum is greater than 9, set carry 1
     *      b. Else, set carry 0
     * 4. Create a Node(say prev) that will contain the head of the sum List.
     * 5. Link all the elements of s3 from top to bottom.
     * 6. Return prev node as the result.
     *
     * @param l1
     * @param l2
     */
    void addTwoLists2(Node l1, Node l2) {
        Node prev = null;

        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        Stack<Node> s3 = new Stack<>();

        // fill first stack with first list elements
        while (l1 != null) {
            s1.add(l1);
            l1 = l1.next;
        }

        // fill the second stack with second list elements
        while (l2 != null) {
            s2.add(l2);
            l2 = l2.next;
        }

        int carry = 0;

        // fill the third stack with the sum of first and second stack
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.peek().data + s2.peek().data + carry;
            Node temp = new Node(sum % 10);
            s3.add(temp);

            if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            s1.pop();
            s2.pop();
        }

        while (!s1.isEmpty()) {
            int sum = carry + s1.peek().data;
            Node temp = new Node(sum % 10);
            s3.add(temp);

            if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            s1.pop();
        }

        while (!s2.isEmpty()) {
            int sum = carry + s2.peek().data;
            Node temp = new Node(sum % 10);
            s3.add(temp);

            if(sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            s2.pop();
        }

        // If carry is still present create a new node with value 1 and push it to the third stack
        if(carry == 1) {
            Node temp = new Node(1);
            s3.add(temp);
        }

        // Link all the elements inside third stack with each other
        if(!s3.isEmpty()) {
            prev = s3.peek();
        }
        while (!s3.isEmpty()) {
            Node temp = s3.peek();
            s3.pop();

            if(s3.size() == 0) {
                temp.next = null;
            } else {
                temp.next = s3.peek();
            }
        }

        printList(prev);
    }


    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        head1 = new Node(7);
        head1.next = new Node(5);
        head1.next.next = new Node(9);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(6);

        System.out.print("First list is ");
        addTwoNumbers.printList(head1);
        System.out.println();

        head2 = new Node(8);
        head2.next = new Node(4);

        System.out.print("Second list is ");
        addTwoNumbers.printList(head2);
        System.out.println();

        addTwoNumbers.addTwoLists(head1, head2);
        System.out.println();

        addTwoNumbers.addTwoLists2(head1, head2);




    }
}
