package com.dsalgo.grokking.patterns.mege.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervalsArray {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {3, 5}, {6, 8}, {9, 12}};
        System.out.println(Arrays.deepToString(mergeIntervals(intervals)));
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        if(intervals.length == 0) {
            return result.toArray(new int[][] {});
        }

        // Add the first pair to the result
        result.add(new int[] {intervals[0][0], intervals[0][1]});

        for(int i = 1; i < intervals.length; i++) {
            // getting the recent added interval in the result list
            int[] lastAddedInterval = result.get(result.size() - 1);

            // getting and initializing input pair
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            // getting the ending timestamp of the previous interval
            int prevEnd = lastAddedInterval[1];

            // overlapping intervals
            if(currStart <= prevEnd) {
                result.get(result.size() - 1)[1] = Math.max(currEnd, prevEnd);
            } else {
                result.add(new int[] {currStart, currEnd});
            }
        }
        return result.toArray(new int[][]{});
    }
}
