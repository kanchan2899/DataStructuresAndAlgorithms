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


    /*
        https://www.geeksforgeeks.org/find-length-of-loop-in-linked-list/
        I/P: head = [3, 2, 0, -4], pos = 1 (-4's next is 2)
        O/P: 3
     */
    public int cycleLength() {
        Node slow = head, fast = head;
        int len = 0;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                Node temp = slow;
                do {
                    len++;
                    temp = temp.next;
                } while (temp != fast);
            }
        }
        return len;
    }

    /*
        https://leetcode.com/problems/linked-list-cycle-ii/
        I/P: head = [3, 2, 0, -4], pos = 1 (-4's next is 2)
        O/P: tail connects to node index 1 (where the cycle is starting)

        Algo:
        1. Find the length of the cycle
        2. Move s ahead by length of the cycle times
        3. Move s and f one by one, it will meet at start of the cycle.
     */
    public int findStartOfCycle() {
        // Find cycle length
        int len = 0;
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                len = cycleLength();
                break;
            }
        }

        Node first = head, second = head;
        if(len == 0) return -1;

        // Move second ahead by length of cycle times
        while (len > 0) {
            second = second.next;
            len--;
        }

        // Move first and second forward until they are equal
        while (first != second) {
            first = first.next;
            second = second.next;
        }
        return second.val;
    }

    /*
        https://leetcode.com/problems/middle-of-the-linked-list/
        Input: head = [1,2,3,4,5]
        Output: [3,4,5]

     */
    public int middleNode() {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;    // return slow;
    }

    /*
        https://leetcode.com/problems/rotate-list/
        I/P: head = [1,2,3,4,5], k = 2
        O/P: [4,5,1,2,3]
     */
    public void rotateList1(int k) {
        Node temp = head, prev = null;
        if(temp == null) return;
        while(k > 0) {
            while (temp != null && temp.next != null) {
                prev = temp;
                temp = temp.next;
            }
            prev.next = null;
            temp.next = head;
            head = temp;
            k--;
        }
    }

    public void rotateList2(int k) {
        Node temp = head, x = head, y = head;
        if(temp == null || temp.next == null) return;

        int len = 0;
        while (x != null) {
            y = x;
            len++;
            x = x.next;
        }
        int steps = len - k % len;
        while (steps > 1) {
            temp = temp.next;
            steps--;
        }
        y.next = head;
        head = temp.next;
        temp.next = null;
    }

    /*
        https://leetcode.com/problems/partition-list/


     */
    public Node partition(int x) {
        Node l1 = new Node(-1, null), list1 = l1;
        Node l2 = new Node(-1, null), list2 = l2;
        Node temp = head;
        while(temp != null) {
            if (temp.val < x) {
                list1.next = temp;
                list1 = list1.next;
            } else {
                list2.next = temp;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        list2.next = null;
        list1.next = l2.next;
        return l1.next;
    }


    public void reverseBetween(int left, int right) {
        int x = 0;
        Node prev = null, temp1 = head, temp2 = null;
        Node reverse = null;
        while(x < left - 1) {
            prev = temp1;
            temp1 = temp1.next;
            x++;
        }
        temp2 = prev.next;
        while (x < right) {
            Node next = temp1.next;
            temp1.next = reverse;
            reverse = temp1;
            temp1 = next;
            x++;
        }
        temp2.next = temp1;
        prev.next = reverse;
    }


    public void reorderList() {
        Node p1 = head, p2 = head;

        // Find the mid of LL
        while(p2.next != null && p2.next.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }

        // Reverse second half of the list
        Node mid = p1;
        Node current = p1.next;

        while (current.next != null) {
            Node next = current.next;
            current.next = next.next;
            next.next = mid.next;
            mid.next = next;
        }

        // Reorder one by one
        p1 = head;
        p2 = mid.next;

        while (p1 != mid) {
            mid.next = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = p2.next;
            p2 = mid.next;
        }
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
