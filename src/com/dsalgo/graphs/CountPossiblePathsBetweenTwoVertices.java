package com.dsalgo.graphs;

import java.util.Iterator;
import java.util.LinkedList;

// https://www.geeksforgeeks.org/count-possible-paths-two-vertices/
public class CountPossiblePathsBetweenTwoVertices {
    int V;
    LinkedList<Integer> adj[];

    CountPossiblePathsBetweenTwoVertices(int V) {
        this.V = V;
        adj = new LinkedList[V];

        for(int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int u, int w) {
        adj[u].add(w);
    }


    /**
     *
     * Using backtracking:
     *
     * 1. Create a recursive function that takes the index of a node of a graph and the destination
     * index. Keep a global or a static variable count to store the count.
     * 2. Keep a record of the nodes visited using a visited array and while returning mark the
     * current node to be unvisited to discover other paths.
     *      a. If the current node is the destination then increase the count.
     *      b.  Else for all the adjacent nodes, i.e. nodes that are accessible from the current node,
     * call the recursive function with the index of the adjacent node and the destination.
     * 5. Print the Count as the required answer
     *
     *
     * TC: O(2 ^ n)
     * SC: O(n)
     *
     * @param s
     * @param d
     * @return
     */

    int countPaths(int s, int d) {
        int paths = 0;
        paths = helper(s, d, paths);
        return paths;
    }

    private int helper(int s, int d, int paths) {
        if(s == d) {
            paths++;
        } else {
            Iterator<Integer> i = adj[s].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                paths = helper(n, d, paths);
            }
        }
        return paths;
    }

    public static void main(String[] args) {
        CountPossiblePathsBetweenTwoVertices graph = new CountPossiblePathsBetweenTwoVertices(5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        System.out.println(graph.countPaths(0, 3));
    }
}
