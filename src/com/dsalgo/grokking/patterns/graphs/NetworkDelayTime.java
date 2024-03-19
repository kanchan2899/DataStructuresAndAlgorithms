package com.dsalgo.grokking.patterns.graphs;

// https://leetcode.com/problems/network-delay-time

import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = {{2, 1, 1}, {3, 2, 1}, {3, 4, 2} };
        int n = 4;
        int k = 3;

        System.out.println(networkDelayTime(times, n, k));
    }

    /**
     *
     * 1. Create an adjacency dictionary to store the information of the nodes and their edges.
     * 2. Use a priority queue to store the nodes and their delay times. Initialize the queue with the source node and a delay time of 0.
     * 3. Use a visited set to track the nodes that have already been processed.
     * 4. Process the nodes from the priority queue by first visiting the node with the smallest delay time and updating the delay time if necessary.
     * 5. Add the unvisited neighbors of the processed node to the priority queue with their new delay times.
     * 6. Return the delay time if all nodes have been processed. Otherwise, return -1.
     *
     * TC: O(E * log V)
     * SC: O(V + E)
     *
     * @param times
     * @param n
     * @param k
     * @return
     */
    private static int networkDelayTime(int[][] times, int n, int k) {
        // create adjacency list

        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();

        // store source as key, and destination and times as values
        for(int[] time: times) {
            int source = time[0];
            int destination = time[1];
            int travelTime = time[2];

            adjacencyList.computeIfAbsent(source, key -> new ArrayList<>()).add(new int[]{destination, travelTime});
        }

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        priorityQueue.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int delays = 0;

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int time = current[0];
            int node = current[1];

            if(visited.contains(node)) {
                continue;
            }

            visited.add(node);
            delays = Math.max(delays, time);

            List<int[]> neighbours = adjacencyList.getOrDefault(node, new ArrayList<>());

            for(int[] neighbour: neighbours) {
                int neighbourNode = neighbour[0];
                int neighbourTime = neighbour[1];

                if(!visited.contains(neighbourNode)) {
                    int newTime = time + neighbourTime;
                    priorityQueue.offer(new int[]{newTime, neighbourNode});
                }
            }
        }

        if(visited.size() == n) {
            return delays;
        }

        return -1;
    }
}
