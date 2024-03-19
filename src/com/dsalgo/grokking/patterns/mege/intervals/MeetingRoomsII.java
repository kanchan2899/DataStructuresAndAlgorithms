package com.dsalgo.grokking.patterns.mege.intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoomsII {
    public static void main(String[] args) {
        int[][] meetings = { { 0, 30 }, { 5, 10 }, { 15, 20 } };
        System.out.println(minRooms(meetings));
        System.out.println(minRooms1(meetings));
    }

    private static int minRooms1(int[][] meetings) {
        if(meetings.length == 0)
            return 0;

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int rooms = 0;
        for(int i = 0; i < meetings.length; i++) {
            pq.offer(meetings[i][1]);
            if(meetings[i][0] < pq.peek())
                rooms++;
            else
                pq.poll();
        }
        return rooms;
    }

    private static int minRooms(int[][] meetings) {
        int n = meetings.length;
        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = meetings[i][0];
            end[i] = meetings[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int i = 1, j = 0, curr = 1;
        int answer = 1;

        while (i < start.length && j < end.length) {
            if(start[i] < end[j]) {
                curr++;
                i++;
            } else {
                curr--;
                j++;
            }
            answer = Math.max(answer, curr);
        }
        return answer;
    }
}
