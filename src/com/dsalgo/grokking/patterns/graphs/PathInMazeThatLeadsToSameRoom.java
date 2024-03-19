package com.dsalgo.grokking.patterns.graphs;

// https://leetcode.com/problems/paths-in-maze-that-lead-to-same-room/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A maze consists of n rooms numbered from 1-n, and some rooms are connected by corridors.
 * You are given a 2D integer array, corridors, where corridors[i] = [room1, room2] indicates
 * that there is a corridor connecting room1 and room2, allowing a person in the maze to go from
 * room1 to room2 and vice versa.
 *
 * The designer of the maze wants to know how confusing the maze is. The confusion score of
 * the maze is the number of different cycles of length 3.
 *
 * For example, 1→2→3→1 is a cycle of length 3, but 1→2→3→4 and 1→2→3→2→1 are not.
 *
 * Two cycles are considered to be different if one or more of the rooms visited in the first
 * cycle is not in the second cycle.
 *
 * Return the confusion score of the maze.
 *
 */
public class PathInMazeThatLeadsToSameRoom {
    public static void main(String[] args) {
        int n = 5;
        int[][] corridors = {{1, 2}, {5, 2}, {4, 1}, {2, 4}, {3, 1}, {3, 4}};
        System.out.println(numberOfPaths(n, corridors));
    }

    /**
     * 1. Initialize a map, neighbors, to store the neighbor rooms of every room and a variable,
     * cycles, to store the number of cycles
     * 2. Start iterating over corridors and store the neighbors of room1 and room2 at
     * neighbors[room1] and neighbors[room2], respectively.
     * 3. Take the intersection of neighbors[room1] and neighbors[room2] and add the length of
     * the result to cycles.
     *
     * TC: O(n * m)
     * SC: O(n ^ 2)
     *
     * @param n
     * @param corridors
     * @return
     */
    private static int numberOfPaths(int n, int[][] corridors) {
        // create a map to store neighbours of each room
        Map<Integer, Set<Integer>> neighbours = new HashMap<>();

        // counter to store the number of cycles
        int cycles = 0;

        // iterate over each corridor
        for(int[] corridor: corridors) {
            int room1 = corridor[0];
            int room2 = corridor[1];

            // add the neighbour rooms
            neighbours.putIfAbsent(room1, new HashSet<>());
            neighbours.putIfAbsent(room2, new HashSet<>());

            neighbours.get(room1).add(room2);
            neighbours.get(room2).add(room1);

            // take the intersection of the two neighbours sets, the size of which will be equal to
            // the number of cycles containing these two rooms
            cycles += intersectionLength(neighbours.get(room1), neighbours.get(room2));
        }

        return cycles;
    }

    private static int intersectionLength(Set<Integer> set1, Set<Integer> set2) {
        int count = 0;

        for(int element: set1) {
            if(set2.contains(element)) {
                count++;
            }
        }

        return count;
    }
}
