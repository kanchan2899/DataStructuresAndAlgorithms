package com.dsalgo.grokking.patterns.mege.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {2, 5};
        System.out.println(Arrays.deepToString(insertInterval(intervals, newInterval)));
    }

    public static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        // Read the starting and ending time of the new interval, into separate variables
        int newStart = newInterval[0];
        int newEnd = newInterval[1];

        // Initialize variables to help in iterating over the existing intervals list
        int i = 0;
        int n = intervals.length;

        // Initialize an empty list to store the output
        List<int[]> output = new ArrayList<>();

        // Append all intervals that start before the new interval to the output list
        while (i < n && intervals[i][0] < newStart) {
            output.add(intervals[i]);
            i++;
        }

        // If the new interval starts after the end of the last interval appended to the output list.
        // just append the new interval to the output list
        if(output.size() == 0 || output.get(output.size() - 1)[1] < newStart) {
            output.add(newInterval);
        } else {
            // otherwise, merge the two intervals
            output.get(output.size() - 1)[1] = Math.max(output.get(output.size() - 1)[1], newEnd);
        }


        // Copy the remaining intervals to the output list, similarly merging any overlapping
        // intervals as we go
        while (i < n) {
            int[] existingInterval = intervals[i];
            int start = existingInterval[0];
            int end = existingInterval[1];

            if(output.get(output.size() - 1)[1] < start) {
                output.add(existingInterval);
            } else {
                output.get(output.size() - 1)[1] = Math.max(output.get(output.size() - 1)[1], end);
            }
            i += 1;
        }

        return output.toArray(new int[][] {});
    }
}
