package com.dsalgo.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

// https://www.geeksforgeeks.org/strongly-connected-components/
public class StronglyConnectedComponentsKosarajuAlgo {
    private int V;
    private LinkedList<Integer> adj[];

    StronglyConnectedComponentsKosarajuAlgo(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        int n;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> iterator = adj[v].iterator();
        while (iterator.hasNext()) {
            n = iterator.next();
            if(!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }

    StronglyConnectedComponentsKosarajuAlgo getTranspose() {
        StronglyConnectedComponentsKosarajuAlgo graph = new StronglyConnectedComponentsKosarajuAlgo(V);
        for(int i = 0; i < V; i++) {
            // Recur for all the vertices adjacent to this vertex
            Iterator<Integer> iterator = adj[i].listIterator();
            while (iterator.hasNext()) {
                graph.adj[iterator.next()].add(i);
            }
        }
        return graph;
    }

    void fillOrder(int v, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited and print it
        visited[v] = true;
        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].iterator();
        while (i.hasNext()) {
            int n = i.next();
            if(!visited[n]) {
                fillOrder(n, visited, stack);
            }
        }

        // All vertices reachable from v are processed by now, push v to Stack
        stack.push(v);
    }

    void printSCCs() {
        Stack<Integer> stack = new Stack<>();
        boolean visited[] = new boolean[V];

        // ill vertices in stack according to their finishing times
        for(int i = 0; i < V; i++) {
            if(visited[i] == false) {
                fillOrder(i, visited, stack);
            }
        }

        // Create a reversed graph
        StronglyConnectedComponentsKosarajuAlgo graph = getTranspose();

        // Mark all the vertices as not visited (For second DFS)
        for(int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Now process all vertices in order defined by Stack
        while (!stack.isEmpty()) {
            // pop a vertex from stack
            int v = stack.pop();

            // Print Strongly connected component of the popped vertex
            if(!visited[v]) {
                graph.DFSUtil(v, visited);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        StronglyConnectedComponentsKosarajuAlgo graph = new StronglyConnectedComponentsKosarajuAlgo(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println("Following are the strongly connected components");
        graph.printSCCs();
    }
}
