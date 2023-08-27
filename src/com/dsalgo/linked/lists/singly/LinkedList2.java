package com.dsalgo.linked.lists.singly;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;

public class LinkedList2 {

    public static void main(String[] args)
    {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        head = push(head, 0);
        printLL(head);
        System.out.println();

        head = insertAfter(head, head.next.next.next.next, 5);
        printLL(head);
        System.out.println();

        head = append(head, 6);
        printLLUsingRecursion(head);
        System.out.println();

        System.out.println("# of nodes are " + getCount(head));

        head = deleteFirstNode(head);
        printLL(head);
        System.out.println();

        head = deleteLastNode(head);
        printLL(head);
        System.out.println();

        System.out.println("Found 4? " + (search(head, 4) == -1 ? "No" : "Yes"));

        System.out.println("Found 4 recursively? " + (searchRecursive(head, 4) == -1 ? "No" : "Yes"));

        head = reverseSLL(head);
        printLL(head);
        System.out.println();

        head = reverseSLLUsingRecursion(head, null);
        printLL(head);
        System.out.println();

        head = swapKthNode(head, 2);
        printLL(head);
        System.out.println();

        head = swapKthNodeSwapData(head, 2);
        printLL(head);
        System.out.println();

        deleteWithoutHead(head.next.next);
        printLL(head);
        System.out.println();

        head = reverseSLL(head);
        printLL(head);
        System.out.println();

        head = sortedInsert(head, 3);
        printLL(head);
        System.out.println();

        head = sortedInsert(head, 2);
        printLL(head);
        System.out.println();

        head = removeDuplicateFromSortedSLL(head);
        printLL(head);
        System.out.println();

        System.out.println("Mid node in the LL is " + middleNode(head));
        System.out.println("Mid node in the LL is " + middleNodeUsingFastSlowPointers(head));

        head = insertInMid(head, 11);
        printLL(head);
        System.out.println();

        head = insertInMidUsingFastSlowPointers(head, 12);
        printLL(head);
        System.out.println();

        System.out.println("Nth node's data from the end of SLL is " + nthNodeFromEndOfSLL(head, 2));

        System.out.println("Nth node's data from the end of SLL is " +
                nthNodeFromEndOfSLLUsingTwoPointers(head, 2));

        head = reverseSLLUsingArrayList(head);
        printLL(head);
        System.out.println();

        head = reverseSLLInGroupsOfKUsingRecursion(head, 3);
        printLL(head);
        System.out.println();

        head = reverseSLLInGroupsOfKIteratively(head, 3);
        printLL(head);
        System.out.println();

        head = rotate(head, 3);
        printLL(head);
        System.out.println();

        head = rotate1(head, 3);
        printLL(head);
        System.out.println();

        head = segregateEvenOddNodes1(head);
        printLL(head);
        System.out.println();

        head = segregateEvenOddNodes(head);
        printLL(head);
        System.out.println();

        head = pairwiseSwap(head);
        printLL(head);
        System.out.println();

        head = pairwiseSwap1(head);
        printLL(head);
        System.out.println();

        head = mergeSort(head);
        printLL(head);
        System.out.println();

    }

    /**
     * Insert at the beginning
     *
     * TC: O(1)
     * SC: O(1)
     *
     * @param data
     */
    public static Node push(Node head, int data) {
        // allocate the node and put in the data
        Node new_node = new Node(data);

        // make next of new node as head
        new_node.next = head;

        // move the head to point to new node
        head = new_node;

        return head;
    }

    /**
     * Insert after a node
     *
     * TC: O(1), average time
     * SC: O(1)
     * @param prev_node
     * @param new_data
     */
    public static Node insertAfter(Node head, Node prev_node, int new_data) {
        // check if the previous node is null
        if(prev_node == null) {
            System.out.println("The given previous node cannot be null");
            return head;
        }
        // allocate the node and put in the data
        Node new_node = new Node(new_data);

        // make next of new_node as next of prev_node
        new_node.next = prev_node.next;

        // make next of prev_node as new_node
        prev_node.next = new_node;

        return head;
    }

    /**
     * Insert at the end
     *
     * TC: O(n) if only head pointer is maintained and O(1) if tail pointer is maintained
     * SC: O(1)
     * @param new_data
     */
    public static Node append(Node head, int new_data) {
        // allocate the Node and put in the data and set next as null
        Node new_node = new Node(new_data);

        // if the LL is empty, then make the new_node as head
        if(head == null) {
            head = new Node(new_data);
            return head;
        }

        // this new_node is going to be the last node, so make the next of it as null
        new_node.next = null;

        // else traverse till the last node
        Node last = head;

        while (last.next != null) {
            last = last.next;
        }

        // change the next of the last node
        last.next = new_node;
        return head;
    }

    /**
     * Traverse a LL
     *
     * TC: O(n)
     * SC: O(1)
     */
    public static void printLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public static void printLLUsingRecursion(Node head) {
        if(head == null) {
            System.out.print("null");
            return;
        }
        System.out.print(head.data + " -> ");
        printLLUsingRecursion(head.next);
    }

    /**
     * Count nodes in a LL
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @return
     */
    public static int getCount(Node head) {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    /**
     * Find length of the cycle in a LL: First find the
     * @return
     */
    public int lengthOfCycle(Node head) {
        int count = 0;
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) {
                Node temp = fast;
                while (temp.next != slow) {
                    count++;
                    temp = temp.next;
                }
                return count+1;
            }
        }
        return count;
    }

    /**
     * Delete first node in a LL
     * 
     * TC: O(1)
     * SC: O(1)
     * 
     * @param head
     * @return
     */
    public static Node deleteFirstNode(Node head) {
        if(head == null) {
            return null;
        }
        // Move the head pointer to the next node and return head
        head = head.next;
        return head;
    }

    /**
     * Delete last node in a LL
     *
     * TC: O(n)
     * SC: O(1)
     * @param head
     * @return
     */
    public static Node deleteLastNode(Node head) {
        if(head == null) {
            return null;
        }
        if(head.next == null) {
            return null;
        }
        Node current = head;

        while (current.next.next != null) {
            current = current.next;
        }

        current.next = null;
        return head;
    }

    /**
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @param x
     * @return
     */
    public static int search(Node head, int x) {
        int pos = 1;
        Node current = head;

        while (current != null) {
            if(current.data == x) {
                return pos;
            } else {
                pos++;
                current = current.next;
            }
        }
        return -1;
    }

    public static int searchRecursive(Node head, int x) {
        if(head == null) {
            return -1;
        }
        if(head.data == x) {
            return 1;
        } else {
            int pos = search(head.next, x);
            if(pos == -1) {
                return -1;
            } else {
                return pos + 1;
            }
        }
    }

    public static Node reverseSLL(Node head) {
        Node current = head;
        Node prev = null, forward = null;

        if(head == null) {
            return null;
        }

        while (current != null) {
            forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        head = prev;
        return head;
    }

    /**
     * Reverse SLL using recursion
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param node
     * @return
     */
    public static Node reverseSLLUsingRecursion(Node head, Node node) {
        if(node == null) {
            return head;
        }
        if(node.next == null) {
            head = node;
            return node;
        }

        Node temp = reverseSLLUsingRecursion(head, node.next);
        temp.next = node;
        node.next = null;
        return node;
    }

    /**
     * Reverse the SLL using extra space
     *
     * TC: O(n)
     * SC: O(n)
     * @param head
     * @return
     */
    public static Node reverseSLLUsingArrayList(Node head) {
        ArrayList<Integer> list = new ArrayList<>();

        for(Node current = head; current != null; current = current.next) {
            list.add(current.data);
        }

        for(Node current = head; current != null; current = current.next) {
            current.data = list.remove(list.size() - 1);
        }
        return head;
    }

    /**
     * Reverse SLL in groups of k length recursively
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @param k
     * @return
     */
    public static Node reverseSLLInGroupsOfKUsingRecursion(Node head, int k) {
        Node prev = null, next = null;
        Node current = head;

        int count = 0;

        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if(next != null) {
            Node rest_head = reverseSLLInGroupsOfKUsingRecursion(next, k);
            head.next = rest_head;
        }
        return prev;
    }

    /**
     * Reverse SLL in groups of k length iteratively
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @param k
     * @return
     */
    public static Node reverseSLLInGroupsOfKIteratively(Node head, int k) {
        Node current = head, prevFirst = null;
        boolean isFirstPass = true;

        while (current != null) {
            Node first = current, prev = null;
            int count = 0;

            while (current != null && count < k) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            if(isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else {
                prevFirst.next = prev;
            }

            prevFirst = first;
        }
        return head;
    }

    /**
     * Detect cycle in SLL using hashing: Traverse the list one by one and keep putting the node
     * addresses in a Hash Table. At any point, if NULL is reached then return false and if next
     * of current node points to any of the previously stored nodes in Hash then return true.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param head
     * @return
     */
    public static boolean detectCycle(Node head) {
        Node current = head;
        HashSet<Node> set = new HashSet<>();

        while (current != null) {
            if(set.contains(current)) {
                return true;
            }
            set.add(current);
            current = current.next;
        }
        return false;
    }

    /**
     * Detect a cycle by modifying the LL
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public static boolean detectCycle1(Node head) {
        Node temp = new Node(-1);
        Node current = head;

        while (current != null) {
            if(current.next == null) {
                return false;
            }
            if(current.next == temp) {
                return true;
            }
            Node current_next = current.next;
            current.next = temp;
            current = current_next;
        }
        return false;
    }

    /**
     * Detect cycle using Floyd’s Cycle-Finding Algorithm:
     * Traverse linked list using two pointers. Move one pointer by one step and another pointer
     * by two-step. If these pointers meet at the same node then there is a loop. If pointers do
     * not meet then linked list doesn’t have a loop.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public static boolean detectCycleUsingFloydsCycleAlgo(Node head) {
        Node fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * Detect and remove the loop from the LL
     * 
     */
    public static Node detectAndRemoveLoop(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if(slow != fast) {
            return head;
        }

        slow = head;

        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        return head;
    }

    /**
     * Find intersecting node using count difference:
     *
     * 1. Get count of the nodes in the first list, let count be c1.
     * 2. Get a count of the nodes in the second list, let count be c2.
     * 3. Get the difference of counts d = abs(c1 – c2).
     * 4. Now traverse the bigger list from the first node till d nodes so that from here
     * onwards both the lists have equal no of nodes.
     * 5. Then we can traverse both the lists in parallel till we come across a common node.
     * (Note that getting a common node is done by comparing the address of the nodes)
     *
     * TC: O(m + n)
     * SC: O(1)
     *
     * @param head1
     * @param head2
     * @return
     */
    public static int findIntersectingNode(Node head1, Node head2) {
        Node curr1 = head1;
        Node curr2 = head2;

        int c1 = getCount(head1);
        int c2 = getCount(head2);

        if(c1 > c2) {
            int d = c1 - c2;
            return utility(d, curr1, curr2);
        } else {
            int d = c2 - c1;
            return utility(d, curr1, curr2);
        }
    }

    /**
     * Find intersecting node using hashing
     *
     * TC: O(m + n)
     * SC: O(m + n)
     * @param head1
     * @param head2
     * @return
     */
    public static int findIntersectingNodeUsingHashing(Node head1, Node head2) {
        HashSet<Node> set = new HashSet<>();

        for(Node current = head1; current != null; current = current.next) {
            set.add(current);
        }

        for(Node current = head2; current != null; current = current.next) {
            if(set.contains(current)) {
                return current.data;
            }
        }
        return -1;
    }

    public static int utility(int d, Node head1, Node head2) {
            Node curr1 = head1;
            Node curr2 = head2;

            for(int i = 0; i < d; i++) {
                if(curr1 == null) {
                    return -1;
                }
                curr1 = curr1.next;
            }

            while (curr1 != null && curr2 != null) {
                if(curr1 == curr2) {
                    return curr1.data;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            return -1;
        }


    /**
     * Swap kth node from end in the LL
     *
     * https://www.geeksforgeeks.org/swap-kth-node-from-beginning-with-kth-node-from-end-in-a-linked-list/
     *
     * The idea is very simple to find the kth node from the start and the kth node from the
     * last is n-k+1th node from start. Swap both nodes. However, there are some corner cases,
     * which must be handled:
     *
     * 1. Y is next to X
     * 2. X is next to Y
     * 3. X and Y are the same
     * 4. X and Y don’t exist (k is more than the number of nodes in the linked list)
     *
     * @param head
     * @param k
     * @return
     */
    public static Node swapKthNode(Node head, int k) {
        int n = getCount(head);

        // check if k is valid
        if(n < k) {
            return head;
        }

        // if x (kth node from the start) and y (kth node from the end) are same
        if(2 * k - 1 == n) {
            return head;
        }

        // find the kth node from the beginning of LL. We also find previous of kth node
        // because we need to update next pointer of the previous.

        Node x = head;
        Node x_prev = null;

        for(int i = 1; i < k; i++) {
            x_prev = x;
            x = x.next;
        }

        // similarly, find the kth node from the end and its previous. kth node from end is
        // (n - k + 1)th node from the beginning

        Node y = head;
        Node y_prev = null;
        for(int i = 1; i < n - k + 1; i++) {
            y_prev = y;
            y = y.next;
        }


        // if x_prev exists, then new next of it will be y. Consider the case when y.next is x,
        // in this case, x_prev and y are the same. So the statement "x_prev.next = y" will create
        // a self loop. This loop will be broken when we change y to y.next

        if(x_prev != null) {
            x_prev.next = y;
        }
        if(y_prev != null) {
            y_prev.next = x;
        }

        // swap the next pointers of x and y. These statements also break self loops if x.next is y
        // or y.next is x

        Node temp = x.next;
        x.next = y.next;
        y.next = temp;

        //change head pointers when k is 1 or n
        if(k == 1) {
            head = y;
        }
        if(k == n) {
            head = x;
        }
        return head;
    }

    public static Node swapKthNodeSwapData(Node head, int k) {
        int n = getCount(head);

        // check if k is valid
        if(n < k) {
            return head;
        }

        // if x (kth node from the start) and y (kth node from the end) are same
        if(2 * k - 1 == n) {
            return head;
        }

        Node x = head;

        for(int i = 1; i < k; i++) {
            x = x.next;
        }

        Node y = head;

        for(int i = 1; i < n - k + 1; i++) {
            y = y.next;
        }

        int temp = x.data;
        x.data = y.data;
        y.data = temp;

        return head;
    }

    /**
     * Delete without head pointer: If we had a pointer to A, we could have deleted B easily.
     * But here we will copy the data field of C to the data field of B.
     * Then we will move forward.
     *
     * Now we are at C and we have a pointer to B i.e. the previous pointer. So we will delete C.
     *
     * That’s how node B will be deleted.
     *
     * @param del
     */
    public static void deleteWithoutHead(Node del) {
        if(del == null) {
            return;
        } else {
            if(del.next == null) {
                System.out.println("This is the last node, require head, can't be freed");
                return;
            }
        }

        // copy the data of the next node to current node
        del.data = del.next.data;

        // move the pointer of del node to the next of next node
        del.next = del.next.next;
    }

    /**
     * Sorted insert in the SLL
     *
     * TC: O(n)
     * SC: O(1)
     * @param head
     * @param x
     * @return
     */
    public static Node sortedInsert(Node head, int x) {
        Node temp = new Node(x);
        if(head == null) {
            return temp;
        }

        if(x <= head.data) {
            temp.next = head;
            return temp;
        }

        Node current = head;

        while (current.next != null && current.next.data < x) {
            current = current.next;
        }

        temp.next = current.next;
        current.next = temp;

        return head;
    }

    /**
     *
     * Remove a duplicate node from sorted SLL
     *
     * TC: O(n)
     * SC: O(1)
     * @param head
     * @return
     */
    public static Node removeDuplicateFromSortedSLL(Node head) {
        Node temp = head;

        while (temp.next != null) {
            if(temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * Remove all duplicate nodes from a sorted SLL
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public static Node removeDuplicatesFromSortedSLL(Node head) {
        Node temp = head;

        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * Remove all duplicate nodes from an unsorted SLL
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param head
     * @return
     */
    public static Node removeDuplicatesFromUnsortedSLL(Node head) {
        if(head == null || head.next == null) {
            return head;
        }
        HashSet<Integer> set = new HashSet<>();

        Node temp = head;
        Node prev = null;

        while (temp != null) {
            if(set.contains(temp.data)) {
                temp = temp.next;
                prev.next = temp;
            } else {
                set.add(temp.data);
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }

    /**
     * Check whether 2 SLL are identical
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head1
     * @param head2
     * @return
     */
    public static boolean isIdentical (Node head1, Node head2){
        Node t1 = head1, t2 = head2;
        while(t1 != null && t2 != null) {
            if(t1.data != t2.data) {
                return false;
            }
            t1 = t1.next;
            t2 = t2.next;
        }

        if(t1 != null || t2 != null) {
            return false;
        }
        return true;
    }

    /**
     * Find the mid-node in SLL - requires two traversals of LL
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public static int middleNode(Node head) {
        if(head == null){
            return -1;
        }
        int count = getCount(head);

        Node current = head;

        for (int i = 0; i < count/2; i++) {
            current = current.next;
        }

        return current.data;
    }

    /**
     * Find the mid-node in SLL - using fast slow pointers
     *
     * TC: O(n)
     * SC: O(1)
     * @param head
     * @return
     */
    public static int middleNodeUsingFastSlowPointers(Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow.data;
    }

    /**
     * Insert in the middle of the LL:  first find the length of linked list and then
     * insert the x node after the half length of the linked list.
     *
     * TC: O(n)
     * SC: O(1)
     *
     */
    public static Node insertInMid(Node head, int data) {
        if(head == null) {
            head = new Node(data);
            return head;
        }
        Node new_node = new Node(data);
        int len = getCount(head);
        Node current = head;
        int count = (len % 2 == 0 ? len/2 : (len+1)/2);

        while (count-- > 1) {
            current = current.next;
        }

        new_node.next = current.next;
        current.next = new_node;

        return head;
    }

    public static Node insertInMidUsingFastSlowPointers(Node head, int data) {
        if(head == null) {
            head = new Node(data);
            return head;
        }

        Node new_node = new Node(data);

        Node slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        new_node.next = slow.next;
        slow.next = new_node;

        return head;
    }

    /**
     * Find nth node from the end of the SLL
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @param n
     * @return
     */
    public static int nthNodeFromEndOfSLL(Node head, int n) {
        int len = getCount(head);

        if(len < n){
            return -1;
        }
        Node current = head;

        for (int i = 1; i < len - n + 1; i++) {
            current = current.next;
        }
        return current.data;
    }

    public static int nthNodeFromEndOfSLLUsingTwoPointers(Node head, int n) {
        Node first = head, second = head;

        for(int i = 1; i <= n; i++) {
            if(first == null)
                return -1;
            first = first.next;
        }

        while (first != null) {
            second = second.next;
            first = first.next;
        }

        return second.data;
    }

    /**
     * Sort a LL of 0s, 1s and 2s using count
     *
     * 1. Traverse the list and count the number of 0s, 1s, and 2s.
     * Let the counts be n1, n2, and n3 respectively.
     * 2. Traverse the list again, fill the first n1 nodes with 0, then n2 nodes with 1,
     * and finally n3 nodes with 2.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param head
     * @return
     */
    public static Node sort0s1s2s(Node head) {
        int[] count = {0, 0, 0};
        Node temp = head;

        while (temp != null) {
            count[temp.data]++;
            temp = temp.next;
        }

        int i = 0;
        temp = head;

        while (temp != null) {
            if(count[i] == 0) {
                i++;
            } else {
                temp.data = i;
                --count[i];
                temp = temp.next;
            }
        }
        return head;
    }

    public static Node sort0s1s2sUsingStableSort(Node head) {
       if(head == null || head.next == null) {
           return head;
       }

       // create a dummy node 0 for three LLs of 0s, 1s and 2s
       Node zeroD = new Node(0);
       Node oneD = new Node(0);
       Node twoD = new Node(0);

       Node zero = zeroD;
       Node one = oneD;
       Node two = twoD;

       Node current = head;

       while (current != null) {
           if(current.data == 0) {
               zero.next = current;
               zero = zero.next;
               current = current.next;
           }
           else if(current.data == 1) {
               one.next = current;
               one = one.next;
               current = current.next;
           }
           else {
               two.next = current;
               two = two.next;
               current = current.next;
           }
       }

       zero.next = (oneD.next != null ? oneD.next : twoD.next);
       one.next = twoD.next;
       two.next = null;

       head = zeroD.next;
       return head;
    }

    /**
     * Rotate the LL by k nodes:
     *
     * To rotate the linked list, we need to change the next pointer of kth node to NULL,
     * the next pointer of the last node should point to the previous head node, and finally,
     * change the head to (k+1)th node. So we need to get hold of three nodes: kth node,
     * (k+1)th node, and last node.
     *
     * Traverse the list from the beginning and stop at kth node. store k’s next in a tem
     * pointer and point k’s next to NULL then start traversing from tem and keep traversing
     * till the end and point end node’s next to start node and make tem as the new head.
     *
     * 1. Initialize a count variable with 0 and pointer kthnode pointing to Null and
     * current pointing to head node.
     * 2. Move from current till k-1 and point kthnode to current’s next and current’s next
     * to NULL.
     * 3. Move current from kth node to end node and point current’s next to head.
     *
     * TC: O(n)
     * SC: O(1)
     *
     *
     * @param head
     * @param k
     * @return
     */
    public static Node rotate(Node head, int k) {
        if(k == 0) {
            return head;
        }

        Node current = head;
        int count = 1;

        while (count < k && current != null) {
            current = current.next;
            count++;
        }

        if(current == null) {
            return head;
        }

        Node kthNode = current;

        while (current.next != null) {
            current = current.next;
        }

        current.next = head;
        head = kthNode.next;
        kthNode.next = null;

        return head;
    }

    /**
     * Rotate the LL by k nodes: The idea is to traverse the given list to find the last
     * element and store it in a node. Now we need to make the next of last element as the
     * current head, which we can do by storing head in temporary node. Repeat the process k
     * time.
     *
     * 1. Return head if the head is NULL or k=0.
     * 2. Initialize a node last and make it point to the last node of the given list.
     * 3. Make a temporary node pointing to head.
     * 4. while k>0 run a loop :
     *      a. make temp as last node and head point to next of head.
     * @param head
     * @param k
     * @return
     */
    public static Node rotate1(Node head, int k) {
        Node last = head, temp = head;

        if(head == null || k == 0) {
            return head;
        }

        while (last.next != null) {
            last = last.next;
        }

        while (k != 0) {
            // Make head point to next of head
            head = head.next;
            // Making next of temp as null
            temp.next = null;

            // Making temp as last node
            last.next = temp;
            last = temp;

            // Point temp to head again for next rotation
            temp = head;
            k--;
        }

        return head;
    }

    /**
     * Segregate even and odd nodes in the LL
     *
     * 1. Find the last node pointer by doing a traversal.
     * 2. Traverse the LL again. For every odd node, insert it after the last node and make the
     * newly inserted node as the new last node
     *
     * TC: O(n)
     * SC: (1)
     */
    public static Node segregateEvenOddNodes(Node head) {
        Node last = head, prev = null, current = head;

        while (last.next != null) {
            last = last.next;
        }

        Node new_end = last;

        while (current.data % 2 != 0 && current != last) {
            new_end.next = current;
            current = current.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        if(current.data % 2 == 0) {
            head = current;

            while (current != last) {
                if(current.data % 2 == 0) {
                    prev = current;
                    current = current.next;
                } else {
                    prev.next = current.next;
                    current.next = null;
                    new_end.next = current;
                    new_end = current;
                    current = prev.next;
                }
            }
        } else {
            prev = current;
        }

        if(new_end != last && last.data % 2 != 0) {
            prev.next = last.next;
            last.next = null;
            new_end.next = last;
        }

        return head;
    }

    public static Node segregateEvenOddNodes1(Node head) {
        Node evenStart = null, evenEnd = null, oddStart = null, oddEnd = null;

        for(Node current = head; current != null; current = current.next) {
            int x = current.data;

            if(x % 2 == 0) {
                if(evenStart == null) {
                    evenStart = evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {
                if(oddStart == null) {
                    oddStart = oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
        }

        if(oddStart == null || evenStart == null) {
            return head;
        }

        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }


    /**
     * Pairwise swap - leave the last element if n is odd
     *
     * 1. Run a loop while we have at least onode ahead
     *      a. Swap data of current node with its next node
     *      b. Move current two nodes ahead.
     *
     * @param head
     * @return
     */
    public static Node pairwiseSwap(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node current = head;

        while (current != null && current.next != null) {
            int temp = current.data;
            current.data = current.next.data;
            current.next.data = temp;
            current = current.next.next;
        }

        return head;
    }

    public static Node pairwiseSwap1(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node current = head.next.next;
        Node prev = head;

        head = head.next;

        head.next = prev;

        while (current != null && current.next != null) {
            prev.next = current.next;
            prev = current;
            Node next = current.next.next;
            current.next.next = current;
            current = next;
        }

        prev.next = current;
        return head;
    }

    /**
     * Merge k sorted lists: nitialize the result as the first list. Now traverse all lists
     * starting from the second list. Insert every node of the currently traversed list into
     * the result in a sorted way.
     *
     * TC: O(N ^ k-1)
     * SC: O(1)
     */
    public static Node mergeKSortedLists(Node[] arr, int n) {
        // traverse from the second list to last
        for(int i = 1; i < n; i++) {
            while (true) {

                // head of both the lists, 0 and ith list
                Node head_0 = arr[0];
                Node head_i = arr[i];

                // break if list ended
                if(head_i == null) {
                    break;
                }

                // if smaller than the first element
                if(head_0.data >= head_i.data) {
                    arr[i] = head_i.next;
                    head_i.next = head_0;
                    arr[0] = head_i;
                } else {

                    // traverse the first list
                    while (head_0.next != null) {

                        // smaller than next element
                        if(head_0.next.data >= head_i.data) {
                            arr[i] = head_i.next;
                            head_i.next = head_0.next;
                            head_0.next = head_i;
                            break;
                        }

                        // go to next node
                        head_0 = head_0.next;

                        // if last node
                        if(head_0.next == null) {
                            arr[i] = head_i.next;
                            head_i.next = null;
                            head_0.next = head_i;
                            head_0.next.next = null;
                            break;
                        }
                    }
                }
            }
        }
        return arr[0];
    }

    /**
     * Merge k sorted lists using divide and conquer: pair up a sorted list after which K/2
     * list will be left to be merged and repeat this till all the lists gets merged.
     *
     * 1. Pair up K lists and merge each pair in linear time using O(N) space.
     * 2. After the first cycle, K/2 lists are left each of size 2*N.
     * After the second cycle, K/4 lists are left each of size 4*N and so on.
     * 3. Repeat the procedure until we have only one list left.
     *
     *  TC: O(n * k * log k)
     *  SC: O(n * k)
     */
    public static Node mergeKSortedListsUsingDivideAndConquer(Node[] arr, int n) {
        int last = n - 1;
        // repeat until only one list is left
        while (last != 0) {

            int i = 0, j = last;
            // (i, j) forms a pair
            while (i < j) {
                arr[i] = sortedMerge(arr[i], arr[j]);
                // consider next pair
                i++;
                j--;

                // if all pairs are merged, update n
                if(i >= j) {
                    last = j;
                }
            }
        }
        return arr[0];
    }

    private static Node sortedMerge(Node a, Node b) {
        Node merged = new Node(-1);
        Node temp = merged;

        while (a != null && b != null) {
            if(a.data <= b.data) {
                temp.next = a;
                a = a.next;
            } else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }

        while (a != null) {
            temp.next = a;
            a = a.next;
            temp = temp.next;
        }

        while (b != null) {
            temp.next = b;
            b = b.next;
            temp = temp.next;
        }
        return merged.next;
    }

    /**
     * Merge k sorted lists: select the minimum of top elements iteratively store that in
     * a new node and increment the pointer of the minimum element.
     *
     * 1. Find the node with the smallest value in all the K lists and
     * 2. Increment the current pointer to the next node of the list where the smallest
     * node is found.
     * 3. Now make a new node and append the node to the head node of the resultant list
     * and point the head list with this new node
     * 4. Repeat these steps till all nodes have been used.
     * @param arr
     * @param k
     * @return
     */
    public static Node mergeKSortedListsBySelectingMinOfTopElement(Node[] arr, int k) {
        Node head = null;
        while (true) {
            int a = 0;
            int z = 0;
            Node current = null;

            int min = Integer.MAX_VALUE;

            for(int i = 0; i < k; i++) {
                if(arr[i] != null) {
                    a++;
                    if(arr[i].data < min) {
                        min = arr[i].data;
                        z = i;
                    }
                }
            }
            if(a != 0) {
                arr[z] = arr[z].next;
                Node temp = new Node(min);

                if(head == null) {
                    head = temp;
                    current = temp;
                } else {
                    current.next = temp;
                    current = temp;
                }
            } else {
                return head;
            }
        }
    }

    /**
     *
     * Merge sort:
     *
     * 1. If the head is NULL or there is only one element in the Linked List then return.
     * 2. Else divide the linked list into two halves. FrontBackSplit(head, &a, &b);
     * 3. Sort the two halves a and b.
     *       MergeSort(a);
     *       MergeSort(b);
     * 4. Merge the sorted a and b (using SortedMerge()) and update the head pointer using headRef.
     *
     * TC: O(n * log n)
     * SC: O(log n)
     *
     * @param head
     * @return
     */
    private static Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node middle = getMiddle(head);

        Node nextOfMiddle = middle.next;

        middle.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);

        Node sortedList = sortedMerge(left, right);
        
        return sortedList;
    }

    private static Node getMiddle(Node head) {
        if(head == null) {
            return head;
        }

        Node slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * Check if the LL is palindrome using stack
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param head
     * @return
     */
    boolean isPalindrome(Node head) {
        Deque<Integer> stack = new ArrayDeque<Integer>();

        for(Node curr = head; curr != null; curr = curr.next) {
            stack.push(curr.data);
        }

        for(Node curr = head; curr != null; curr = curr.next) {
            if(stack.pop() != curr.data) {
                return false;
            }
        }
        return true;
    }

    /**
     * Check if the LL is palindrome by doing the reverse of half of the ll
     *
     * 1. find the second half and reverse it
     * 2. compare first half and reverse second half
     *
     * TC: O(n)
     * SC: O(1)
     *
     *
     * @param head
     * @return
     */
    boolean isPalindromeUsingReversal(Node head) {
        if(head == null) {
            return true;
        }

        Node slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node rev = reverseSLL(slow.next);

        Node current = head;

        while (rev != null) {
            if(rev.data != current.data) {
                return false;
            }
            rev = rev.next;
            current = current.next;
        }
        return true;
    }
}

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
