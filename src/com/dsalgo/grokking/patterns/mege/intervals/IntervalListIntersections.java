package com.dsalgo.grokking.patterns.mege.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.geeksforgeeks.org/find-intersection-of-intervals-given-by-two-lists/
public class IntervalListIntersections {
    public static void main(String[] args) {
        int[][] interval_a = {{3, 6}, {8, 16}, {17, 25}};
        int[][] interval_b = {{2, 3}, {10, 15}, {18, 23}};

        System.out.println(Arrays.deepToString(intervalsIntersection(interval_a, interval_b)));
    }

    private static int[][] intervalsIntersection(int[][] interval_a, int[][] interval_b) {
        // To store all intersecting intervals;
        List<int[]> intersections = new ArrayList<>();

        // Index i to iterate over the length of list a and index j to iterate over the length of list b
        int i = 0, j = 0;

        // while loop will break when either of the lists ends
        while (i < interval_a.length && j < interval_b.length) {
            // lets check of interval_a[i] intersects interval_b[j]
            // 1. start - the potential start point of the intersection
            // 2. end - the potential end point of the intersection
            int start = Math.max(interval_a[i][0], interval_b[j][0]);
            int end = Math.min(interval_a[i][1], interval_b[j][1]);


            // if there is an actual intersection, add it to the list
            if (start <= end) {
                intersections.add(new int[] {start, end});
            }

            // move forward in the list whose interval ends earlier
            if(interval_a[i][1] < interval_b[j][1]) {
                i += 1;
            } else {
                j += 1;
            }
        }
        return intersections.toArray(new int[0][]);
    }


}
