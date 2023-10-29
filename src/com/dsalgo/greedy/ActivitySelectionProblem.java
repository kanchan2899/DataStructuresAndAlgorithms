package com.dsalgo.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/activity-selection-problem-greedy-algo-1/
public class ActivitySelectionProblem {

    static class Activity {
        int start;
        int end;

        Activity(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    static class ActivityComparator implements Comparator<Activity> {

        @Override
        public int compare(Activity o1, Activity o2) {
            return o1.end - o2.end;
        }
    }

    /**
     * Using greedy approach:
     *
     * 1. Sort the activities according to their finishing time
     * 2. Select the first activity from the sorted array and print it
     * 3. Do the following for the remaining activities in the sorted array
     *      - If the start time of this activity is greater than or equal to the finish time of the
     *      previously selected activity then select this activity and print it
     *
     * TC: O(n * log n)
     * SC: O(1)
     *
     * @param activities
     * @return
     */
    static int maxActivity(Activity[] activities) {
        Arrays.sort(activities, new ActivityComparator());
        int maxActivities = 1;
        int prev = 0;

        System.out.println("(" + activities[0].start + ", " + activities[0].end + ")");

        for(int curr = 1; curr < activities.length; curr++) {
            if(activities[curr].start >= activities[prev].end) {
                maxActivities++;
                prev = curr;
                System.out.println("(" + activities[curr].start + ", " + activities[curr].end + ")");
            }
        }
        return maxActivities;
    }

    public static void main(String[] args) {
        int n = 6;
        Activity[] arr = new Activity[n];

        arr[0] = new Activity(5, 9);
        arr[1] = new Activity(1, 2);
        arr[2] = new Activity(3, 4);
        arr[3] = new Activity(0, 6);
        arr[4] = new Activity(5, 7);
        arr[5] = new Activity(8, 9);

        System.out.println("Max activities performed by a machine is " + maxActivity(arr));

        int[] start = {5, 1, 3, 0, 5, 8};
        int[] end = {9, 2, 4, 6, 7, 9};

        System.out.println("Max activites performed by a machine is " + maxActivity1(start, end));
    }


    /**
     * Using greedy and priority queue: We can use Min-Heap to get the activity with minimum finish time.
     * Min-Heap can be implemented using priority-queue
     *
     * 1. Create a priority queue (Min-Heap) and push the activities into it.
     * 2. Push the top of the priority queue into the answer vector and set the variable start
     * to the start time of the first activity and end to the finish time of the activity
     * 3. While priority is not empty do the following:
     *      - Take the top of the priority queue and check
     *      - If the start time of this activity is greater than or equal to the finish time of
     *      the last chosen activity then push this activity into the answer vector
     *      - Else ignore it
     * 4. Print the activities chosen, stored in the answer vector
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param start
     * @param end
     * @return
     */
    private static int maxActivity1(int[] start, int[] end) {
        ArrayList<Activity> activities = new ArrayList<>();

        // Minimum Priority Queue to sort activities in ascending order of finishing time (f[i]).
        PriorityQueue<Activity> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.end));

        for(int i = 0; i < start.length; i++) {
            // Pushing elements in priority queue where the key is f[i]
            priorityQueue.add(new Activity(start[i], end[i]));
        }

        Activity activity = priorityQueue.poll();

        int s = activity.start;
        int e = activity.end;

        activities.add(new Activity(s, e));

        while (!priorityQueue.isEmpty()) {
            Activity activity1 = priorityQueue.poll();
            if(activity1.start >= e) {
                s = activity1.start;
                e = activity1.end;
                activities.add(new Activity(s, e));
            }
        }

        for(Activity act : activities) {
            System.out.println("(" + act.start + ", " + act.end + ")");
        }

        return activities.size();
    }
}
