package com.dsalgo.graphs;

import java.util.LinkedList;

// https://www.geeksforgeeks.org/connected-components-in-an-undirected-graph/
public class StronglyConnectedComponentInUndirectedGraph {
    int V;
    LinkedList<Integer>[] adj;

    StronglyConnectedComponentInUndirectedGraph(int v) {
        this.V = v;
        adj = new LinkedList[V];

        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for(int x : adj[v]) {
            if(!visited[x]) {
                DFSUtil(x, visited);
            }
        }
    }

    /**
     * Using DFS:
     *
     * 1) Initialize all vertices as not visited.
     * 2) Do following for every vertex 'v'.
     *        (a) If 'v' is not visited before, call DFSUtil(v)
     *        (b) Print new line character
     *
     * // This Function performs DFS traversal
     * // of vertex v.
     * DFSUtil(v)
     * 1) Mark 'v' as visited.
     * 2) Print 'v'
     * 3) Do following for every adjacent 'u' of 'v'.
     *      If 'u' is not visited, then recursively call DFSUtil(u)
     *
     *  TC: O(v + e)
     *  SC: O(v)
     */
    void connectedComponents() {
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                DFSUtil(i, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        StronglyConnectedComponentInUndirectedGraph graph = new StronglyConnectedComponentInUndirectedGraph(5);

        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);

        System.out.println("Following are the connected components in undirected graph");
        graph.connectedComponents();
    }
}
