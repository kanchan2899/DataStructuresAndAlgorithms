package com.dsalgo.linked.lists.singly;

public class LinkedList {
    public Node head;
    public Node tail;
    public int size = 0;

    public LinkedList() {
        this.size = 0;
    }

    public Node getNext() {
        return head.next;
    }

    public int getVal() {
        return head.val;
    }

    public Node getHead() {
        return head;
    }

    public void insertUsingRecursion(int val, int index) {
        head = insertUsingRecursion(val, index, head);
    }

    private Node insertUsingRecursion(int val, int index, Node node) {
        if(index == 1) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }
        node.next = insertUsingRecursion(val, --index, node.next);
        return node;
    }

    public void insertFirst(int val) {
        Node new_node = new Node(val);
        new_node.next = head;
        head = new_node;

        if(tail == null) {
            tail = head;
        }
        size++;
    }

    public void insertLast(int val) {
        if(tail == null) {
            insertFirst(val);
            return;
        }
        Node new_node = new Node(val);
        tail.next = new_node;
        tail = new_node;
    }

    public void insertAtIndex(int val, int index) {
        if(size == 1) {
            insertFirst(val);
            return;
        }
        if(size == index) {
            insertLast(val);
            return;
        }
        int i = 1;
        Node temp = head;
        while(i < index - 1) {
            temp = temp.next;
            i++;
        }
        // Node new_node = new Node(val, temp.next);
        Node new_node = new Node(val);
        new_node.next = temp.next;
        temp.next = new_node;
        size++;
    }

    public Node get(int index) {
        Node temp = head;
        int i = 1;
        while (i < index) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public Node find(int val) {
        Node temp = head;
        while (temp != null) {
            if(temp.val == val) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public int deleteFirst() {
        int val = head.val;
        head = head.next;
        if(head == null)
            tail = null;

        size++;
        return val;
    }

    public int deleteAtIndex(int index) {
        if(index == 1) {
            return deleteFirst();
        }
        if(index == size) {
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.val;
        prev.next = prev.next.next;
        size--;
        return val;
    }

    public int deleteLast() {
        if(size <= 1) {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.val;
        tail = secondLast;
        tail.next = null;

        size--;
        return val;
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    /*  https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     *  I/P: head = [1, 1, 2]
     *  O/P: [1, 2]
     *
     *  I/P: head = [1, 1, 2, 3, 3, 3]
     *  O/P: [1, 2, 3]
     *
     */
    public void removeDuplicatesInSortedList() {
        Node temp = head;
        if(temp == null || temp.next == null) {
            return;
        }
        while (temp != null && temp.next != null) {
            if(temp.val == temp.next.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    /*
        https://leetcode.com/problems/merge-two-sorted-lists/

        I/P: list1 = [1, 2, 4] and list2 = [1, 3, 4]
        O/P: [1, 1, 2, 3, 4, 4]

     */
    public LinkedList mergeTwoSortedLinkedLists(LinkedList l2) {
        LinkedList merged = new LinkedList();
        Node head1 = head, head2 = l2.head;
        while (head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                merged.insertLast(head1.val);
                head1 = head1.next;
            } else {
                merged.insertLast(head2.val);
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            merged.insertLast(head1.val);
            head1 = head1.next;
        }
        while (head2 != null) {
            merged.insertLast(head2.val);
            head2 = head2.next;
        }

        return merged;
    }

    /*
        https://leetcode.com/problems/linked-list-cycle/
        I/P: head = [3, 2, 0, -4], pos = 1 (-4's next is 2)
        Internally, pos is used to denote the index of the node that tail's next pointer is
        connected to. Note that pos is not passed as a parameter.
        O/P: true
     */
    public boolean detectCycle() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    protected class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}
