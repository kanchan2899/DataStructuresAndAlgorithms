package com.dsalgo.recursion.numbers;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Recursion/problem/tower-of-hanoi-1587115621
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 4;
        // Move n discs from tower A to tower C using tower B
        towerOfHanoi(n, 'A', 'B', 'C');
        System.out.println("Steps to move " + n + " disks from A to C is " + toh(n, 'A', 'B', 'C'));
    }


    /**
     * Algorithm: Move (n - 1) discs from tower A to B using tower C. Then move nth disc from tower
     * A to C directly. Move (n - 1) discs from tower B to C using A. At the end, all the discs
     * will move from tower A to C.
     *
     * TC: O(2^n)
     * SC: O(n)
     *
     * @param n
     * @param a
     * @param b
     * @param c
     */
    private static void towerOfHanoi(int n, char a, char b, char c) {
        if(n == 1) {
            System.out.println("Move disc " + n + " from " + a + " to " + c);
            return;
        }
        towerOfHanoi(n - 1, a, c, b);
        System.out.println("Move disc " + n + " from " + a + " to " + c);
        towerOfHanoi(n - 1, b, a, c);

    }

    public static long toh(int N, int from, int to, int aux) {
        if(N == 1) {
            System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
            return 1;
        }
        long count = 0;
        count += toh(N - 1, from, aux, to);
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        count++;
        count += toh(N - 1, aux, to, from);
        return count;
    }
}
