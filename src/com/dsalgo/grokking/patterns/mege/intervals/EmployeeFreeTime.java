package com.dsalgo.grokking.patterns.mege.intervals;

import java.util.*;

// https://leetcode.com/problems/employee-free-time/solutions/
public class EmployeeFreeTime {
    static class Interval{
        int start;
        int end;
        boolean closed;

        public Interval(int start, int end)
        {
            this.start = start;
            this.end = end;
            this.closed = true; // by default, the interval is closed
        }

        // set the flag for closed/open
        public void setClosed(boolean closed)
        {
            this.closed = closed;
        }
    }
    public static void main(String[] args) {
        List<Interval> employeeA = Arrays.asList(new Interval(1, 2),
                new Interval(5, 6));
        List<Interval> employeeB = Arrays.asList(new Interval(1, 3));
        List<Interval> employeeC = Arrays.asList(new Interval(4, 10));

        List<Interval> result = employeeFreeTime(Arrays.asList(employeeA, employeeB, employeeC));
        System.out.println(display(result));

    }

    private static String display(List<Interval> l1) {
        if (l1.size() == 0) {
            return "[]";
        }

        String resultStr = "[";

        for (int i = 0; i < l1.size() - 1; i++) {
            resultStr += "[" + l1.get(i).start + ", ";
            resultStr += l1.get(i).end + "], ";
        }

        resultStr += "[" + l1.get(l1.size() - 1).start + ", ";
        resultStr += l1.get(l1.size() - 1).end + "]";
        resultStr += "]";

        return resultStr;
    }

    private static List<Interval> employeeFreeTime(List<List<Interval>> schedules) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // iterate for all employees' schedule and add start of each schedule's first
        // interval along with its index value and a value 0;
        for(int i = 0; i < schedules.size(); i++) {
            List<Interval> employeeSchedule = schedules.get(i);
            Interval interval = employeeSchedule.get(0);
            heap.offer(new int[] {interval.start, i, 0});
        }

        // take an empty list to store results
        List<Interval> result = new ArrayList<>();

        // set 'previous' to the start time of the first interval in heap
        int previous = schedules.get(heap.peek()[1]).get(heap.peek()[2]).start;

        // iterate until the heap is empty
        while (!heap.isEmpty()) {
            // poll an element from the heap and get values i and j
            int[] tuple = heap.poll();
            int i = tuple[1];
            int j = tuple[2];

            // select an interval
            Interval interval = schedules.get(i).get(j);

            // if the selected interval's start value is greater than the previous value, it means that
            // this interval is free. So, add the interval (previous, interval's end value) into the result.
            if(interval.start > previous) {
                result.add(new Interval(previous, interval.start));
            }

            // update the previous as the maximum and interval's end value
            previous = Math.max(previous, interval.end);

            // if there is another interval in the current employee's schedule, push that into the heap.
            if(j + 1 < schedules.get(i).size()) {
              Interval nextInterval = schedules.get(i).get(j + 1);
              heap.offer(new int[] {nextInterval.start, i, j + 1});
            }
        }
        // when the heap is empty
        return result;
    }
}
