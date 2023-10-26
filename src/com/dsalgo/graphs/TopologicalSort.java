package com.dsalgo.graphs;

import java.util.*;

// https://www.geeksforgeeks.org/topological-sorting/
public class TopologicalSort {
    int V;
     List<Integer> adj[];

    TopologicalSort(int V) {
        this.V = V;
        adj = new ArrayList[V];

        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    void addEdge(int u, int v) {
        adj[u].add(v);
    }


    /**
     *
     * Topological Sort
     *
     * 1. Create a stack to store the nodes.
     * 2. Initialize visited array of size N to keep the record of visited nodes.
     * 3. Run a loop from 0 till N
     *      1. if the node is not marked True in visited array
     *          1. Call the recursive function for topological sort and perform the following steps.
     *              1. Mark the current node as True in the visited array.
     *              2. Run a loop on all the nodes which has a directed edge to the current node
     *                  1. if the node is not marked True in the visited array:
     *                      1. Recursively call the topological sort function on the node
     *              3. Push the current node in the stack.
     * 4. Print all the elements in the stack.
     *
     * TC: O(V + E)
     * SC: O(V)
     *
     */
    void topologicalSort() {
        int indegree[] = new int[V];

        for(int i = 0; i < V; i++) {
            ArrayList<Integer> temp = (ArrayList<Integer>) adj[i];

            for(int node : temp) {
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(indegree[i] == 0) {
                queue.add(i);
            }
        }

        // count of visited vertices
        int count = 0;

        Vector<Integer> topologicalOrder = new Vector<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();

            topologicalOrder.add(u);

            for(int node : adj[u]) {
                if(--indegree[node] == 0) {
                    queue.add(node);
                }
            }
            count++;
        }

        if(count != V) {
            System.out.println("There exists a cycle in the graph");
            return;
        }

        System.out.println(topologicalOrder);
    }

    public static void main(String[] args) {
        TopologicalSort graph = new TopologicalSort(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.topologicalSort();
    }
}
