package com.dsalgo.grokking.patterns.mege.intervals;

// https://www.geeksforgeeks.org/merging-intervals/
/**
 * Bruteforce: Start from the first interval and compare it with all other intervals for overlapping.
 * If it overlaps with any other interval, then remove the other interval from the list and merge
 * the other into the first interval. Repeat the same steps for the remaining intervals after
 * the first.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Interval {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[0] = new Interval(6, 8);
        intervals[1] = new Interval(1, 9);
        intervals[2] = new Interval(2, 4);
        intervals[3] = new Interval(4, 7);

        mergeIntervals(intervals);
        System.out.println();
        mergeIntervals1(intervals);
    }

    /**
     * Optimized approach: Here merge operation is not in-place and requires stack. First sort
     * the intervals, and push first interval onto the stack. Traverse through rest of the intervals
     * If merging condition stasfies with the topmost stack interval, merge the intervals and push
     * the merged interval onto the stack. Otherwise, directly push the interval onto the stack.
     *
     * Algorithm:
     * 1. Sort the intervals based on the increasing order of the starting time.
     * 2. Push the first interval into a stack.
     * 3. For each interval, do the following:
     *      a. If the current interval does not overlap with the top of the stack then, push the current
     *      interval into the stack.
     *      b. If the current interval overlap with the top of the stack then, update the stack top with
     *      the ending time of the current interval.
     * 4. The end stack contains the merged intervals.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param intervals
     */
    public static void mergeIntervals(Interval[] intervals) {
        if(intervals.length <= 0) {
            return;
        }

        Stack<Interval> stack = new Stack<>();

        // sort the intervals in increasing order of start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start = i2.start;
            }
        });

        // push the first interval to stack
        stack.push(intervals[0]);

        // start from the next interval and merge if necessary
        for(int i = 1; i < intervals.length; i++) {

            // get the interval from stack top
            Interval top = stack.peek();

            // if current element is not overlapping with stack top, push it to the stack
            if(top.end < intervals[i].start) {
                stack.push(intervals[i]);
            }

            // otherwise update the ending time of top if ending of current interval is more
            else if(top.end < intervals[i].end) {
                top.end = intervals[i].end;
                stack.pop();
                stack.push(top);
            }
        }

        System.out.print("The merged intervals are: ");
        while (!stack.empty()) {
            Interval t = stack.pop();
            System.out.print("[" + t.start + ", " + t.end + "]");
        }

    }

    /**
     * Optimized in-place solution:
     * 1. Sort all the intervals in increasing order of start time.
     * 2. Traverse sorted intervals starting from the first interval
     * 3. Do the following for every interval:
     *      a. If the current interval is not the first interval and it overlaps with the previous
     *      interval, then merge it with the previous interval. Keep doing it while the interval
     *      overlaps with the previous one.
     *      b. Otherwise, add the current interval to the output list of intervals.
     *
     * TC: O(n * log n)
     * SC: O(1)
     */
    public static void mergeIntervals1(Interval[] intervals) {
        // sort the intervals in increasing order of start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        // stores the index of the last element in output array
        int index = 0;

        // traverse all intervals
        for(int i = 1; i < intervals.length; i++) {
            // if this is not the first interval and overlaps with the previous one
            if(intervals[index].end >= intervals[i].start) {
                // merge previous and current intervals
                intervals[index].end = Math.max(intervals[index].end, intervals[i].end);
            } else {
                index++;
                intervals[index] = intervals[i];
            }
        }

        // intervals[0 .. index] stores the merged intervals
        System.out.print("The merged intervals are: ");
        for(int i = 0 ; i <= index; i++) {
            System.out.print("[" + intervals[i].start + ", " + intervals[i].end + "]");
        }
    }
}
