package com.dsalgo.queues;


import java.util.Deque;
import java.util.LinkedList;

// https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        slidingWindowMax(arr, k);
        System.out.println();
        slidingWindowMax1(arr, k);
    }

    /**
     * Using Deque: Create a Deque, Qi of capacity K, that stores only useful elements of current
     * window of K elements. An element is useful if it is in current window and is greater than
     * all other elements on right side of it in current window. Process all array elements one
     * by one and maintain Qi to contain useful elements of current window and these useful
     * elements are maintained in sorted order. The element at front of the Qi is the largest
     * and element at rear/back of Qi is the smallest of current window.
     *
     * 1. Create a deque to store K elements.
     * 2. Run a loop and insert the first K elements in the deque. Before inserting the element,
     * check if the element at the back of the queue is smaller than the current element, if
     * it is so remove the element from the back of the deque until all elements left in
     * the deque are greater than the current element. Then insert the current element,
     * at the back of the deque.
     * 3. Now, run a loop from K to the end of the array.
     * 4. Print the front element of the deque.
     * 5. Remove the element from the front of the queue if they are out of the current window.
     * 6. Insert the next element in the deque. Before inserting the element, check if
     * the element at the back of the queue is smaller than the current element, if it is
     * so remove the element from the back of the deque until all elements left in the deque
     * are greater than the current element. Then insert the current element, at the back of the deque.
     * 7. Print the maximum element of the last window.
     *
     * TC: O(n)
     * SC: O(k)
     *
     * @param arr
     * @param k
     */
    private static void slidingWindowMax1(int[] arr, int k) {

        // Create a Double Ended Queue that will store indexes of array elements.
        // The queue will store indexes of useful elements in every window, and it will
        // maintain decreasing order of values from front to rear in deque, i.e.,
        // arr[deque.front[]] to arr[Qi.rear()] are sorted in decreasing order
        Deque<Integer> deque = new LinkedList<>();

        int i;
        // process first k elements of array
        for(i = 0; i < k; i++) {
            // For every element, the previous smaller elements are useless so remove them from deque
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                // Remove from rear
                deque.removeLast();
            }
            // Add new element at rear of queue
            deque.addLast(i);
        }

        // process the rest of the elements
        for(; i < arr.length; i++) {
            // The element at the front of the queue is the largest element of previous window,
            // so print it
            System.out.print(arr[deque.peek()] + " ");

            // remove the elements which are out of the window
            while (!deque.isEmpty() && deque.peek() <= i - k)
                deque.removeFirst();

            // remove all elements smaller than the currently being added element (remove useless elements)
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);
        }
        System.out.print(arr[deque.peek()]);
    }

    /**
     * Bruteforce: The idea is very basic run a nested loop, the outer loop which will mark the
     * starting point of the subarray of length K, the inner loop will run from the starting
     * index to index+K, and print the maximum element among these K elements.
     *
     * 1. Create a nested loop, the outer loop from starting index to N – Kth elements.
     * The inner loop will run for K iterations.
     * 2. Create a variable to store the maximum of K elements traversed by the inner loop.
     * 3. Find the maximum of K elements traversed by the inner loop.
     * 4. Print the maximum element in every iteration of the outer loop
     *
     * TC: O(n * k)
     * SC :O(1)
     *
     * @param arr
     * @param k
     */
    private static void slidingWindowMax(int[] arr, int k) {
        int j, max;

        for(int i = 0; i < arr.length - k + 1; i++) {
            max = arr[i];
            for(j = i + 1; j < i + k; j++) {
                max = Math.max(max, arr[j]);
            }
            System.out.print(max + " ");
        }
    }
}
