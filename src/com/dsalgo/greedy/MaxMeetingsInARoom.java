package com.dsalgo.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// https://www.geeksforgeeks.org/find-maximum-meetings-in-one-room/
public class MaxMeetingsInARoom {
    static class Meeting {
        int start;
        int end;
        Meeting(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    static class Comp implements Comparator<Meeting> {
        public int compare(Meeting a, Meeting b) {
            return a.end - b.end;
        }
    }

    /**
     * Using greedy approach:
     * 1. Sort all pairs(Meetings) in increasing order of each pair’s second number(Finish time).
     * 2. Select the first meeting of the sorted pair as the first Meeting in the room and push
     * it into the result vector and set a variable time_limit(say) with the second value(Finishing
     * time) of the first selected meeting.
     * 3. Iterate from the second pair to the last pair of the array and if the value of the first
     * element(Starting time of meeting) of the current pair is greater than the previously
     * selected pair’s finish time (time_limit) then select the current pair and update the result
     * vector (push selected meeting number into result vector) and variable time_limit.
     * 4. Print the Order of meeting from the result vector.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     */
    public static int maxMeetings(int start[], int end[], int n) {
        ArrayList<Meeting> meetings = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        Collections.sort(meetings, new Comp());
        int count = 1;
        int endP = meetings.get(0).end;

        for(int i = 1; i < n; i++) {
            if(meetings.get(i).start > endP) {
                endP = meetings.get(i).end;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        System.out.println(maxMeetings(start, end, start.length));
    }
}
