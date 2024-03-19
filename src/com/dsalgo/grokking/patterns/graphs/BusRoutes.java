package com.dsalgo.grokking.patterns.graphs;

import java.util.*;

// https://leetcode.com/problems/bus-routes/
public class BusRoutes {
    public static void main(String[] args) {
        int[][] routes = {{1, 12}, {4, 5, 9}, {9, 19}, {10, 12, 13}};
        int src = 1, dest = 13;

        System.out.println(minimumBuses(routes, src, dest));
    }

    private static int minimumBuses(int[][] routes, int src, int dest) {
        // Create adjacency list for graph.
        Map <Integer, List <Integer>> adjList = new HashMap < > ();
        for (int i = 0; i < routes.length; i++) {
            for (int station: routes[i]) {
                if (!adjList.containsKey(station)) {
                    adjList.put(station, new ArrayList < > ());
                }
                adjList.get(station).add(i);
            }
        }

        // Create a queue with initial source and bus count of 0.
        Deque < int[] > queue = new ArrayDeque < > ();
        queue.add(new int[] {src, 0});

        // Create a set to contain visited routes of bus.
        Set < Integer > visitedBuses = new HashSet < > ();

        // Iterate till queue is empty.
        while (!queue.isEmpty()) {
            // Pop station and and number of buses taken and store in variables.
            int[] current = queue.peek();
            int station = current[0];
            int busesTaken = current[1];
            queue.poll();


            // If we have reached the destination station, return number of buses taken.
            if (station == dest) {
                return busesTaken;
            }

            // If station is in graph, then iterate over the stations in graph
            // and if it is not already visited, enqueue all the stations in that bus
            // route along with an incremented bus count and mark the bus visited.
            if (adjList.containsKey(station)) {
                for (int bus: adjList.get(station)) {
                    if (!visitedBuses.contains(bus)) {
                        for (int s: routes[bus]) {
                            queue.add(new int[] {
                                    s,
                                    busesTaken + 1
                            });
                        }
                        visitedBuses.add(bus);
                    }
                }
            }
        }

        // If the route is not found, return -1.
        return -1;
    }
}
