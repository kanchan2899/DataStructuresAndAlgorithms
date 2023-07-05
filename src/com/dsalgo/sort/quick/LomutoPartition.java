package com.dsalgo.sort.quick;

import java.util.Arrays;

public class LomutoPartition {
    public static void main(String[] args) {
        int[] arr = {3, 8, 6, 12, 10, 7, 6, 9};
       // Lomuto partition assumes partition at last index

        System.out.println(Arrays.toString(lomutoPartition(arr, 0, arr.length - 1)));

    }

    /**
     * Lomuto Partition: In this partition, The last element chooses as a pivot in this partition.
     * The pivot acquires its required position after partition but more comparison takes place in
     * this partition.
     *
     * Steps:
     * 1. pivot = arr[hi]
     * 2. i = lo     // place for swapping
     * 3. for j := lo to hi – 1 do
     *        if arr[j] <= pivot then
     *            swap arr[i] with arr[j]
     *            i = i + 1
     * 4. swap arr[i] with arr[hi]
     * 5. return i
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int[] lomutoPartition(int[] arr, int start, int end) {
        int pivot = arr[end];

        int index = start - 1;
        int temp = 0;

        for(int i = start; i < end; i++) {
            if(arr[i] < pivot) {
                index++;

                // swap arr[i] with arr[index]
                temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }

        index++;

        temp = arr[index];
        arr[index] = arr[end];
        arr[end] = temp;

        return arr;
    }
}
