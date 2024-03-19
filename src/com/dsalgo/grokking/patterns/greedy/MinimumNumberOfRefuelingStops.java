package com.dsalgo.grokking.patterns.greedy;

import java.util.Collections;
import java.util.PriorityQueue;

public class MinimumNumberOfRefuelingStops {
    public static void main(String[] args) {
        int target = 120;
        int startFuel = 10;
        int[][] stations = {{10, 60},{20, 25},{30, 30},{60, 40}};
        System.out.println(minRefuelStops(stations, target, startFuel));
    }

    private static int minRefuelStops(int[][] stations, int target, int startFuel) {
        // if starting fuel is already greater than or equal to target, no need to refuel
        if(startFuel >= target) {
            return 0;
        }

        // create a max heap to store the fuel capacities of stations in such a way that maximum
        // fuel capacity is at the top of the heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        int n = stations.length;
        int stops = 0;
        int maxDistance = startFuel;

        // loop until the car reach the target or the car is out of fuel
        while (maxDistance < target) {
            // if there are still stations and the next one is within range, add its fuel capacity
            // to the max heap
            if(i < n && stations[i][0] <= maxDistance) {
                maxHeap.add(stations[i][1]);
                i++;
            }
            // if there are no more stations and we can't reach the target, return -1
            else if (maxHeap.isEmpty()) {
                return -1;
            }

            // otherwise, fill up at the station with the highest fuel capacity and increment stops
            else {
                maxDistance += maxHeap.poll();
                stops++;
            }
        }
        return stops;
    }
}
