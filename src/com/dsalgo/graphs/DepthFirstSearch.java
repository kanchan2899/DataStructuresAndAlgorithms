package com.dsalgo.graphs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
public class DepthFirstSearch {
    int V;
    LinkedList<Integer> adjacencyList[];

    DepthFirstSearch(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    void helper(int source, boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");
        Iterator<Integer> iterator = adjacencyList[source].listIterator();

        while (iterator.hasNext()) {
            int n = iterator.next();
            if(!visited[n]) {
                helper(n, visited);
            }
        }
    }

    /**
     * Depth First Traversal
     *
     * TC: O(V + E)
     * SC: O(V + E)
     *
     * @param v
     */
    void dfs(int v) {
        boolean[] visited = new boolean[V];
        helper(v, visited);
    }

    public static void main(String[] args) {

        DepthFirstSearch graph = new DepthFirstSearch(4);
        graph.addEdge(0, 1);
        graph.addEdge( 0, 2);
        graph.addEdge( 1, 2);
        graph.addEdge( 2, 0);
        graph.addEdge( 2, 3);
        graph.addEdge( 3, 3);
        graph.addEdge( 1, 3);

        graph.dfs(2);
    }

}
