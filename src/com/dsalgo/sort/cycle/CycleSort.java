package com.dsalgo.sort.cycle;

import java.util.Arrays;

// https://www.geeksforgeeks.org/cycle-sort/
public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {10, 30, 50, 20, 40};
        cycleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * Cycle sort: Cycle sort is an in-place, unstable sorting algorithm that is particularly useful
     * when sorting arrays containing elements with a small range of values. The basic idea of the
     * cycle sort is to divide input array into cycles, where each cycle consists of elements that
     * belong to the same position in the sorted output array. The algo then performs a series of swaps
     * to place each element in its correct position withing its cycle, until all cycles are complete
     * and the array is sorted.
     *
     * Steps:
     * 1. Start with an unsorted array of n elements.
     * 2. Initialise a variable, cycleStart, to 0.
     * 3. For each element in the array, compare it with every other element to its right. If there are
     * any elements that are smaller than the current element, increment cycleStart.
     * 4. If cycleStart still 0 after comparing the first element with all other elements, move to the
     * next element and repeat step 3.
     * 5. Once a smaller element is found, swap the current element with the first element in its cycle.
     * The cycle is then continued until the current element returns to its original position.
     * 6. Repeat steps 3-5 until all cycles have been completed.
     *
     * TC: O(n^2) in all cases
     * SC: O(1)
     *
     * @param arr
     */
    private static void cycleSort(int[] arr) {
        // count number of memory writes
        int writes = 0;

        // traverse the array elements and put them to the right place
        for(int cycle_start = 0; cycle_start < arr.length; cycle_start++) {
            // initialize item as starting point
            int item = arr[cycle_start];

            // find position where we put the item, we count all smaller elements on the right of item
            int pos = cycle_start;
            for(int i = cycle_start + 1; i < arr.length; i++) {
                if(arr[i] < item) {
                    pos++;
                }
            }

            // if the item is already in correct position
            if(pos == cycle_start) {
                continue;
            }

            // ignore all duplicate elements
            while (item == arr[pos]) {
                pos += 1;
            }

            // put the item to its right position
            if(pos != cycle_start) {
                int temp = item;
                item = arr[pos];
                arr[pos] = temp;
                writes++;
            }

            // rotate rest of the cycle
            while (pos != cycle_start) {
                pos = cycle_start;

                // find position where we put the element
                for(int i = cycle_start + 1; i < arr.length; i++) {
                    if(arr[i] < item) {
                        pos += 1;
                    }
                }

                // ignore all duplicate items
                while (item == arr[pos]) {
                    pos += 1;
                }

                // put the item to its right side
                if(item != arr[pos]) {
                    int temp = item;
                    item = arr[pos];
                    arr[pos] = temp;
                    writes++;
                }
            }
        }
    }
}
