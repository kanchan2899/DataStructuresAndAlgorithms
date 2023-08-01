package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1

/**
 * The basic intuition is as follow:
 *  1. An element of the array can store water if there are higher bars on the left and the right.
 *  2. The amount of water to be stored in every position can be found by finding the heights of
 *  bars on the left and right sides.
 *  3. The total amount of water stored is the summation of the water stored in each index.
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] blockHeight = {8, 8, 2, 4, 5, 5, 1};
        System.out.println(trappingWater(blockHeight, blockHeight.length));
        System.out.println(trappingWater1(blockHeight, blockHeight.length));
    }

    /**
     * Pre-calculation: For every element, pre-calculate and store the highest bar on the left
     * and on the right (stored in left[] and right[] arrays)
     * Then iterate the array and use the pre-calculated values to find the amount of water stored
     * in this index, which is min(left[i], right[i]) - arr[i]
     *
     * 1. Create two arrays lmax[] and rmax[] of size n. Create a variable max to store the maximum
     * found till a certain index during traversal.
     * 2. Run one loop from start to end. In each iteration, update max found till now and
     * also assign lmax[i] = max
     * 3. Run another loop from end to start. In each iteration, update max found till now
     * and also assign rmax[i] = max
     * 4. Traverse the array from start+1 to end-1. The amount of water that will be stored
     * in this column is min(lmax[i], rmax[i]) - arr[i]
     * 5. Return total amount of water stored.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param blockHeight
     * @param n
     * @return
     */
    private static int trappingWater1(int[] blockHeight, int n) {
        int units = 0;
        int[] lmax = new int[n];
        int[] rmax = new int[n];

        lmax[0] = blockHeight[0];
        for(int i = 1; i < n; i++) {
            lmax[i] = Math.max(blockHeight[i], lmax[i-1]);
        }

        rmax[n-1] = blockHeight[n-1];
        for(int i = n-2; i >= 0; i--) {
            rmax[i] = Math.max(blockHeight[i], rmax[i+1]);
        }

        for(int i = 1; i < n-1; i++) {
            units = units + Math.min(lmax[i], rmax[i]) - blockHeight[i];
        }
        return units;
    }

    /**
     * Bruteforce: Traverse every array element and find the highest bars on the left and the right.
     * Take the smaller of two heights. The difference between the smaller height and the height
     * of the current element is the amount of water that can be stored in this array element.
     *
     * 1. Traverse the array from start to end
     *      a. For every element:
     *          Traverse the array from start to that index and find the maximum height a
     *          Traverse the array from that index to end and find the maximum height b
     * 2. The amount of water that will be stored in this column is min(a, b) - arr[i], add this
     * value to the total amount of water stored.
     * 3. Return the total amount of water stored
     *
     *
     * TC:O(n^2)
     * SC: O(1)
     *
     * @param blockHeight
     * @param n
     * @return
     */
    static long trappingWater(int blockHeight[], int n) {
        int units = 0;

        for(int i = 1; i < n - 1; i++) {
            int lmax = blockHeight[i];
            for(int j = 0; j < i; j++) {
                lmax = Math.max(blockHeight[j], lmax);
            }

            int rmax = blockHeight[i];
            for(int j = i + 1; j < n; j++) {
                rmax = Math.max(blockHeight[j], rmax);
            }

            units = units + (Math.min(lmax, rmax) - blockHeight[i]);
        }
        return units;
    }
}
