package com.dsalgo.grokking.patterns.topological.sort;

import java.util.*;

// https://leetcode.com/problems/course-schedule-ii/description/
public class CourseScheduleII {
    public static void main(String[] args) {
        int n = 5;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1},{4, 3}};
        System.out.println(findOrder(n, prerequisites));
    }

    /**
     *
     * 1. Initialization:
     *  - We store the graph in adjacency lists, where each parent vertex has a list containing
     *  all of its children. We do this using a hash map, where the key is the parent vertex
     *  number, and the value is a list containing the children’s vertex numbers.
     *  - To find the sources, we keep a hash map to count the in-degrees, which is the count
     *  of incoming vertices’ edges. Any vertex with a 0 in-degree is a source.
     *
     * 2. Build the graph and find in-degrees of all vertices:
     *  - We build the graph from the input and populate the in-degrees hash map.
     * 3. Find all sources:
     *  - Our sources are all the vertices with 0 in degrees, and we store them in a queue.
     * 4. Sort:
     *  - For each source, we do the following:
     *      - Add it to the sorted list.
     *      - Retrieve all of its children from the graph.
     *      - Decrement the in-degree of each child by 1
     *      - If a child’s in-degree becomes 0, add it to the source queue.
     *   - Repeat the first step until the source queue is’nt empty.
     * @param n
     * @param prerequisites
     * @return
     */
    private static List<Integer> findOrder(int n, int[][] prerequisites) {
        List<Integer> sortedOrder = new ArrayList<>();

        // if n is smaller than or equal to 0, return the empty array
        if(n <= 0) {
            return sortedOrder;
        }

        // store the count of incoming prerequisites in a hashmap
        HashMap<Integer, Integer> inDegree = new HashMap<>();

        // a. initialize the graph
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            inDegree.put(i, 0);
            graph.put(i, new ArrayList<>());
        }

        // b. build the graph
        for(int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1], child = prerequisites[i][0];
            // put the child into its parent's list
            graph.get(parent).add(child);
            // increment child's indegree
            inDegree.put(child, inDegree.get(child) + 1);
        }

        // c. find all sources i.e., all n with 0 in-degrees
        Queue<Integer> sources = new LinkedList<>();
        // traverse in inDegree using key
        for(Map.Entry<Integer, Integer> entry: inDegree.entrySet()) {
            if(entry.getValue() == 0) {
                sources.add(entry.getKey());
            }
        }

        // d. for each sources, add it to the sortedOrder and subtract one from all of its children's
        // in-degrees if a child's in-degree becomes zero, add it to the sources queue
        while (!sources.isEmpty()) {
            // pop an element from the start of the sources and store the element in vertex
            int vertex = sources.poll();
            // append the vertex at the end of the sorted_order
            sortedOrder.add(vertex);
            // get the node's children to decrement their in-degrees
            List<Integer> children = graph.get(vertex);
            // traverse in graph[vertex] using child get the node's children to decrement their in-degrees
            for(int child: children) {
                inDegree.put(child, inDegree.get(child) - 1);
                // if inDegree[child] is 0, append the child in the deque sources
                if(inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }

        // topological sort is not possible as the graph has a cycle
        if(sortedOrder.size() != n) {
            return new ArrayList<>();
        }
        return sortedOrder;
    }
}
