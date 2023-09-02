package com.dsalgo.stacks;

import java.util.Arrays;

// https://www.geeksforgeeks.org/efficiently-implement-k-stacks-single-array/
public class KStacksInAnArray {

    // Array of size n to store actual content to be stored in stacks
    int[] arr;

    // Array of size k to store indexes of top elements of stacks
    int[] top;

    // Array of size n to store next entry in all stacks and free list
    int[] next;
    int k, capacity;

    // To store beginning index of free list
    int free_top = 0;

    KStacksInAnArray(int n, int k) {
        this.k = k;
        capacity = n;
        arr = new int[n];
        top = new int[k];
        next = new int[n];

        // Initialize all stacks as empty
        Arrays.fill(top, -1);

        // Initialize all spaces as free
        for(int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;  // -1 is used to indicate end of free list
    }

    void push(int sn, int x) {
        // Store index of first free slot
        int i = free_top;

        // Update index of free slot to index of next slot in free list
        free_top = next[i];

        // Update next of top and then top for stack number 'sn'
        next[i] = top[sn];
        top[sn] = i;

        // Put the item in array
        arr[i] = x;
    }

    int pop(int sn) {
        // Find index of top item in stack number 'sn'
        int i = top[sn];
        // Change top to store next of previous top
        top[sn] = next[i];
        // Attach the previous top to the beginning of free list
        next[i] = free_top;
        free_top = i;
        // Return the previous top item
        return arr[i];
    }

    // To check whether stack number 'sn' is empty or not
    boolean isEmpty(int sn) {
        return top[sn] == -1;
    }
    public static void main(String[] args) {
        int k = 3, n = 10;
        KStacksInAnArray kStacksInAnArray = new KStacksInAnArray(k, n);

        kStacksInAnArray.push(15, 2);
        kStacksInAnArray.push(45, 2);

        kStacksInAnArray.push(17, 1);
        kStacksInAnArray.push(49, 1);
        kStacksInAnArray.push(39, 1);

        kStacksInAnArray.push(11, 0);
        kStacksInAnArray.push(22, 0);
        kStacksInAnArray.push(33, 0);

        System.out.println("Popped element from stack 2 is " + kStacksInAnArray.pop(2));
        System.out.println("Popped element from stack 1 is " + kStacksInAnArray.pop(1));
        System.out.println("Popped element from stack 0 is " + kStacksInAnArray.pop(0));
    }
}
