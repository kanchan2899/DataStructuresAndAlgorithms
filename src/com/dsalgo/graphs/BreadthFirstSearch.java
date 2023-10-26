package com.dsalgo.graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
public class BreadthFirstSearch {

    /**
     * BFS algo:
     *
     * 1. Create a boolean array say visited[] of size V+1 where V is the number of vertices in
     * the graph.
     * 2. Create a Queue, mark the source vertex visited as visited[s] = true and push it into the
     * queue.
     * 3. Until the Queue is non-empty, repeat the below steps:
     *      a. Pop an element from the queue and print the popped element.
     *      b. Traverse all of the vertices adjacent to the vertex poped from the queue.
     *      c. If any of the adjacent vertex is not already visited, mark it visited and push
     *      it to the queue.
     *
     * TC: O(V + E)
     * SC: O(V)
     *
     * @param adjacencyList
     * @param V
     * @param s
     */
    static void bfsWithSourceNode(ArrayList<ArrayList<Integer>> adjacencyList, int V, int s) {
        boolean[] visited = new boolean[V + 1];
        Queue<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for(int v : adjacencyList.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }
    }

    static void bfsWithNoSourceNode(ArrayList<ArrayList<Integer>> adjacencyList, int V) {
        boolean[] visited = new boolean[V + 1];

        for(int i = 1; i <= V; i++) {
            if(!visited[i]) {
                helper(adjacencyList, i, visited);
            }
        }
    }

    static private void helper(ArrayList<ArrayList<Integer>> adjacencyList, int s, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for(int v : adjacencyList.get(u)) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.add(v);
                }
            }
        }

    }

    static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0; i <= V; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 2, 4);
        addEdge(adjacencyList, 2, 5);
        addEdge(adjacencyList, 3, 5);
        addEdge(adjacencyList, 4, 5);
        addEdge(adjacencyList, 4, 6);
        addEdge(adjacencyList, 5, 6);

        System.out.print("BFS from given source node: ");
        bfsWithSourceNode(adjacencyList, V, 1);
        System.out.println();
        System.out.print("BFS with no source node: ");
        bfsWithNoSourceNode(adjacencyList, V);

        System.out.println();
        System.out.print("BFS of graph with no source node: " + bfsOfGraph(adjacencyList, V));

    }

    private static ArrayList<Integer> bfsOfGraph(ArrayList<ArrayList<Integer>> adjacencyList, int v) {
        boolean[] visited = new boolean[adjacencyList.size()];
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        q.add(1);

        visited[1] = true;

        while (!q.isEmpty()) {
            int n = q.poll();
            bfs.add(n);

            for(int i = 0; i < adjacencyList.get(n).size(); i++) {
                int val = adjacencyList.get(n).get(i);
                if(!bfs.contains(val) && !visited[val]) {
                    q.add(val);
                    visited[val] = true;
                }
            }
        }
        return bfs;
    }
}
