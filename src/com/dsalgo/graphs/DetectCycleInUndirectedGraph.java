package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

// https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
public class DetectCycleInUndirectedGraph {

    int v;
    LinkedList<Integer> adj[];

    DetectCycleInUndirectedGraph(int V) {
        v = V;
        adj = new LinkedList[v];

        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public static void main(String[] args) {
        DetectCycleInUndirectedGraph graph = new DetectCycleInUndirectedGraph(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println(graph.detectCycle());

        graph = new DetectCycleInUndirectedGraph(3);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        System.out.println(graph.detectCycle());
    }

    /**
     *
     * 1. Iterate over all the nodes of the graph and Keep a visited array visited[] to track
     * the visited nodes.
     * 2. Run a Depth First Traversal on the given subgraph connected to the current node and
     * pass the parent of the current node. In each recursive
     *      a. Set visited[root] as 1.
     *      b. Iterate over all adjacent nodes of the current node in the adjacency list
     *          - If it is not visited then run DFS on that node and return true if it returns true.
     *          - Else if the adjacent node is visited and not the parent of the current node then
     *          return true.
     * 3. Return false.
     *
     * TC: O(V + E)
     * SC: O(V)
     *
     * @return
     */
    boolean detectCycle() {
        boolean[] visited = new boolean[v];

        for(int u = 0; u < v; u++) {
            if(!visited[u]) {
                if(isCycleUtil(u, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCycleUtil(int u, boolean[] visited, int parent) {
        visited[u] = true;
        int i;

        Iterator<Integer> it = adj[u].iterator();

        while(it.hasNext()) {
            i = it.next();

            if(!visited[i]) {
                if(isCycleUtil(i, visited, u)) {
                    return true;
                }
            } else if(i != parent) {
                return true;
            }
        }
        return false;
    }
}
