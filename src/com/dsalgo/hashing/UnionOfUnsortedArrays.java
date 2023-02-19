package com.dsalgo.hashing;

// https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*  a[] = {15, 20, 5, 15}
    b[] = {15, 15, 20, 15, 20, 10}
    O/P: {15, 20, 5, 10}
 */
public class UnionOfUnsortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {4, 5, 6};

        System.out.println("Using Bruteforce: " + unionOfArrays1(a, b));
        System.out.println("Using HashSet: " + unionOfArrays2(a, b));
    }


    /**
     * Using Bruteforce: Create a new array c and copy all elements from a and b to c.
     * Start a loop i in c array. Initialize a flag to false.
     * Start another loop j from 0 to i and check if the element has been visited before.
     * If so, skip it. Otherwise, check the flag is false and add the element to arraylist.
     * Return arraylist
     *
     * Time complexity: O((m + n)^2)
     * Space complexity: O(m + n)
     * @param a unsorted array with duplicate elements
     * @param b unsorted array with duplicate elements
     * @return ArrayList of Integers that is the union of a and b arrays
     */
    private static ArrayList<Integer> unionOfArrays1(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < a.length; i++) {
            c[i] = a[i];
        }
        for(int j = 0; j < b.length; j++) {
            c[a.length + j] = b[j];
        }

        for(int i = 0; i < c.length; i++) {
            boolean flag = false;
            for(int j = 0; j < i; j++) {
                if(c[i] == c[j]) {
                    flag = true;
                    break;
                }
            }
            if(flag == false) {
                al.add(c[i]);
            }
        }
        return al;
    }


    /**
     * Using HashSet: Create a HashSet. Add elements to hashset from both arrays a and b.
     * Convert HashSet to ArrayList and return arraylist.
     *
     * Time complexity: O((m + n))
     * Space complexity: O(m + n)
     * @param a unsorted array with duplicate elements
     * @param b unsorted array with duplicate elements
     * @return ArrayList of Integers that is the union of a and b arrays
     */
    private static ArrayList<Integer> unionOfArrays2(int[] a, int[] b) {
        HashSet<Integer> unionSet = new HashSet<>();
        for(int i = 0; i < a.length; i++) {
            unionSet.add(a[i]);
        }
        for(int i = 0; i < b.length; i++) {
            unionSet.add(b[i]);
        }
        return new ArrayList<>(unionSet);
    }
}
