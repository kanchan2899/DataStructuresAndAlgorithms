package com.dsalgo.graphs;

import java.util.*;

public class DetectCycleInDirectedGraph {
    int V;
    List<List<Integer>> adj;

    DetectCycleInDirectedGraph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    boolean isCycleUtil(int i, boolean[] visited, boolean[] recursionStack) {
        if(recursionStack[i]) {
            return true;
        }

        if(visited[i]) {
            return false;
        }

        visited[i] = true;
        recursionStack[i] = true;

        List<Integer> children = adj.get(i);

        for(Integer c : children) {
            if(isCycleUtil(c, visited, recursionStack)) {
                return true;
            }
        }

        recursionStack[i] = false;

        return false;
    }

    /**
     * Using DFS:
     *
     * 1. Create the graph using the given number of edges and vertices.
     * 2. Create a recursive function that initializes the current vertex, visited array,
     * and recursion stack.
     * 3. Mark the current node as visited and also mark the index in the recursion stack.
     * 4. Find all the vertices which are not visited and are adjacent to the current node and
     * recursively call the function for those vertices
     *      1. If the recursive function returns true, return true.
     *      2. If the adjacent vertices are already marked in the recursion stack then return true.
     * 5. Create a wrapper function, that calls the recursive function for all the vertices, and
     *      1. If any function returns true return true.
     *      2. Else if for all vertices the function returns false return false.
     *
     *  TC: O(V + E)
     *  SC: O(V)
     *
     * @return
     */
    boolean isCyclic() {
        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        for(int i = 0; i < V; i++) {
            if(isCycleUtil(i, visited, recursionStack)) {
                return true;
            }
        }
        return false;
    }

    void addEdge(int source, int dest) {
        adj.get(source).add(dest);
    }

    public static void main(String[] args) {
        DetectCycleInDirectedGraph graph = new DetectCycleInDirectedGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(graph.isCyclic());

        System.out.println(graph.isCyclic1());
    }

    /**
     * Using Kahn's algo:
     *
     * 1. Store indegree of every vertex
     * 2. Create a queue, q
     * 3. Add all 0 indegree vertices to the q
     * 4. count = 0;
     * 5. while (q is not empty)
     *      a. u = q.pop()
     *      b. For every adjacent v of u
     *          - Reduce indegree of v by 1
     *          - If indegree of v becomes 0, push v to the q
     *      c. count++;
     * 6. return count != v
     *
     * TC: O(V + E)
     * SC: O(V)
     *
     * @return
     */
    private boolean isCyclic1() {
        int[] indegree = new int[V];

        Arrays.fill(indegree, 0);

        // traverse adjacency list to fill indegrees of vertices
        for(int u = 0; u < V; u++) {
            for(int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        // create a queue and enqueue all vertices with indegree 0
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        // initialize count of visited vertices
        int count = 0;

        // create a vector to store result (a topological ordering of vertices)
        Vector<Integer> top_order = new Vector<>();

        // one by one dequeue vertices from queue and enqueue adjacents if indegree of adjacent becomes 0
        while (!q.isEmpty()) {

            // extract front of queue (or perform dequeue) and add it to topological order
            int u = q.poll();
            top_order.add(u);

            // iterate through all its neighbouring nodes of dequeued node u and decrease their indegrees
            // by 1

            for(int itr : adj.get(u)) {
                if(--indegree[itr] == 0) {
                    q.add(itr);
                }
            }
            count++;
        }

        return count != V ? true : false;
    }

}
