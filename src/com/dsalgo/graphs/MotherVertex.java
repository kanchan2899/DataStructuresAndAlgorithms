package com.dsalgo.graphs;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
public class MotherVertex {
    public static void main(String[] args) {
        int V = 7;
        int E = 8;

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        addEdge(0, 1, adjacencyList);
        addEdge(0, 2, adjacencyList);
        addEdge(1, 3, adjacencyList);
        addEdge(4, 1, adjacencyList);
        addEdge(6, 4, adjacencyList);
        addEdge(5, 6, adjacencyList);
        addEdge(5, 2, adjacencyList);
        addEdge(6, 0, adjacencyList);

        System.out.println("A mother vertex is " + motherVertex(adjacencyList, V));

    }

    /**
     * Using Kosaraju's Strongly Connected Algo:  In a graph of strongly connected components,
     * mother vertices are always vertices of the source components in the component graph.
     * The idea is based on the fact: If there exists a mother vertex (or vertices), then one of
     * the mother vertices is the last finished vertex in DFS. (Or a mother vertex has the maximum
     * finish time in DFS traversal). A vertex is said to be finished in DFS if a recursive call
     * for its DFS is over, i.e., all descendants of the vertex have been visited.
     *
     * 1. Do DFS traversal of the given graph. While doing traversal keep track of the last
     * finished vertex ‘v’. This step takes O(V+E) time.
     * 2. If there exists a mother vertex (or vertices), then v must be one (or one of them). Check
     * if v is a mother vertex by doing DFS/BFS from v. This step also takes O(V+E) time.
     *
     * Time Complexity: O(V + E)
     * Auxiliary Space: O(V)
     *
     * @param adjacencyList
     * @param V
     * @return
     */
    private static int motherVertex(ArrayList<ArrayList<Integer>> adjacencyList, int V) {

        // visited[] is used for DFS. Initially all are initialized as not visited
        boolean[] visited = new boolean[V];

        // to store last finished vertex or mother vertex
        int v = -1;

        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                helper(adjacencyList, i, visited);
                v = i;
            }
        }

        // if there exist mother vertex (or vertices) in given graph, then v must be one (or one of them)
        // now check if v is actually a mother vertex (or graph has a mother vertex). We basically check
        // if every vertex is reachable from v or not.
        // reset all values in visited[] as false and do DFS beginning from v to check if all vertices
        // are reachable from it or not.
        boolean[] check = new boolean[V];

        helper(adjacencyList, v, check);

        for(boolean val : check) {
            if(!val) {
                return -1;
            }
        }
        return v;
    }

    private static void helper(ArrayList<ArrayList<Integer>> adjacencyList, int v, boolean[] visited) {
        visited[v] = true;

        for(int x : adjacencyList.get(v)) {
            if(!visited[x]) {
                helper(adjacencyList, x, visited);
            }
        }
    }

    private static void addEdge(int i, int j, ArrayList<ArrayList<Integer>> adjacencyList) {
        adjacencyList.get(i).add(j);
    }
}
