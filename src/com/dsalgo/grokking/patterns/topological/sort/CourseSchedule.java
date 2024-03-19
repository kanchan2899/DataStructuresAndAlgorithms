package com.dsalgo.grokking.patterns.topological.sort;

import java.util.*;

// https://leetcode.com/problems/course-schedule/description/
public class CourseSchedule {
    public static void main(String[] args) {
        int n = 5;
        int[][] prerequisites = new int[][]{};

        System.out.println(canFinish(n, prerequisites));
    }

    private static boolean canFinish(int n, int[][] prerequisites) {

        int counter = 0;
        if(n <= 0) {
            return false;
        }

        // initialize the graph, count of incoming prerequisites
        HashMap<Integer, Integer> inDegree = new HashMap<>();
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // build the graph
        for(int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][0], child = prerequisites[i][1];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // find all sources, i.e. all vertices with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();

        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());

            }
        }

        // for each source, increment the counter and subtract one from all of it's children's in-degrees
        // if a child's in-degrees becomes zero, add it to the source queue
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            counter++;

            // get the node's children to decrement their in-degrees
            List<Integer> children = graph.get(vertex);
            for(int child : children) {
                inDegree.put(child, inDegree.get(child) - 1);
                if(inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        return counter == n;
    }
}
