package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/problems/maximum-occured-integer4602/1
public class MaximumOccurredInteger {
    public static void main(String[] args) {
        int[] l = {1,5,9,13,21};
        int[] r = {15,8,12,20,30};
        System.out.println(maxOccurred(l, r, l.length, 30));
    }

    /**
     *
     * Create an array that stores the frequency of element till the max element in the right array.
     *
     * Start a loop i from 0 to n to traverse through both l and r arrays. Start an inner loop
     * j from l[i] to r[i] (both inclusive), update frequency array count.
     * Initialize max_occurred to 0. Start a loop i from 1 to max element in the right array
     * If freq[i] > freq[max_occurred], update max_occurred to i.
     * Return max_occurred.
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param l
     * @param r
     * @param n
     * @param maxx
     * @return
     */
    public static int maxOccurred(int l[], int r[], int n, int maxx){
        int[] freq = new int[maxx+1];
        for(int i = 0; i < n; i++) {
            for(int j = l[i]; j <= r[i]; j++) {
                freq[j] = freq[j] + 1;
            }
        }
        int max_occurred = 0;
        for(int i = 1; i <= maxx; i++) {
            if(freq[i] > freq[max_occurred]) {
                max_occurred = i;
            }
        }
        return max_occurred;
    }
}
