package com.dsalgo.hashing;

import java.util.HashMap;

public class CheckIfArraysAreSame {
    public static void main(String[] args) {
        long[] a = {1, 2, 5, 4, 0};
        long[] b = {2, 4, 5, 0, 1};
        System.out.println(check(a, b, a.length));
    }

    /**
     * Using hashing: Put all elements of array 1 and array 2 into hashmaps. Use equals method to check
     * if they are equal
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param a
     * @param b
     * @param n
     * @return
     */
    public static boolean check(long a[],long b[],int n)
    {
        HashMap<Long, Integer> mapA = new HashMap<>();
        HashMap<Long, Integer> mapB = new HashMap<>();

        for(long x : a) {
            mapA.put(x, mapA.getOrDefault(x, 0) + 1);
        }

        for(long x : b) {
            mapB.put(x, mapB.getOrDefault(x, 0) + 1);
        }
        return mapA.equals(mapB);
    }
}
