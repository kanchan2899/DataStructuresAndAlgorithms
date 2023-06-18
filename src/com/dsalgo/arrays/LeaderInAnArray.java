package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.Collections;

// https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1
public class LeaderInAnArray {
    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 10, 6, 5, 2};
        System.out.println(leaders(arr, arr.length));
    }

    /**
     * Bruteforce: Traverse the array from 0 to n. Initialize boolean flag to true for every element
     * Start another loop from i + 1 to n. If arr[j] >= arr[i], make boolean false and break the inner
     * loop. In i loop, if flag == true, add it to the array list. Return the list at the end.
     *
     * TC: O(n^2)
     * SC: O(1)
     * @param arr
     * @param n
     * @return
     */
    static ArrayList<Integer> leaders(int[] arr, int n) {
        ArrayList<Integer> leaders = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            boolean flag = false;
            for(int j = i + 1; j < n; j++) {
                if(arr[j] >= arr[i]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) {
                leaders.add(arr[i]);
            }
        }
        return leaders;
    }

    /**
     * Start from the last element of the array, which should always be a leader.
     * Add the last element to the array list. Initialize current_element with arr[n - 1] i.e. last element
     * Start a loop i from n - 2 to 0.
     * Check if current element is greater than the current_element. If so, update the current_element
     * to arr[i]. Add current_element to the list.
     * Return the list at the end.
     *
     * TC: O(n)
     * SC: O(1)
     * @param arr
     * @param n
     * @return
     */
    static ArrayList<Integer> leaders1(int[] arr, int n) {
        ArrayList<Integer> leaders = new ArrayList<>();
        int current_leader = arr[n - 1];
        leaders.add(current_leader);

        for(int i = n - 2; i >= 0; i--) {
            if(arr[i] > current_leader) {
                current_leader = arr[i];
                leaders.add(current_leader);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
