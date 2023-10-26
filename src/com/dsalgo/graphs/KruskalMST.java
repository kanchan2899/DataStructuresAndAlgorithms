package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// https://www.geeksforgeeks.org/kruskals-minimum-spanning-tree-algorithm-greedy-algo-2/
public class KruskalMST {
    static class Edge {
        int src, dest, weight;
        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Subset {
        int parent, rank;
        public Subset(int parent, int rank) {
            this.parent = parent;
            this.rank = rank;
        }
    }

    public static void main(String[] args) {
        int V = 4;
        List<Edge> graphEdges = new ArrayList<>(
                List.of(new Edge(0, 1, 10), new Edge(0, 2, 6),
                        new Edge(0, 3, 5), new Edge(1, 3, 15),
                        new Edge(2, 3, 4)));

        graphEdges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        kruskals(V, graphEdges);
    }

    /**
     * Kruskal's algo:
     *
     * 1. Sort all the edges in non-decreasing order of their weight.
     * 2. Pick the smallest edge. Check if it forms a cycle with the spanning tree formed so far.
     * If the cycle is not formed, include this edge. Else, discard it.
     * 3. Repeat step#2 until there are (V-1) edges in the spanning tree.
     *
     * TC: O(E * logE) or O(E * logV)
     * SC: O(V ^ 2)
     * @param V
     * @param graphEdges
     */
    private static void kruskals(int V, List<Edge> graphEdges) {
        int j = 0;
        int noOfEdges = 0;

        // Allocate memory for creating V subsets
        Subset[] subsets = new Subset[V];

        // Allocate memory for results
        Edge[] results = new Edge[V];

        // Create V subsets with single elements
        for(int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        // Number of edges to be taken is equal to V-1
        while (noOfEdges < V - 1) {
            // Pick the smallest edge. And increment the index for next iteration
            Edge nextEdge = graphEdges.get(j);
            int x = findRoot(subsets, nextEdge.src);
            int y = findRoot(subsets, nextEdge.dest);

            // If including this edge doesn't cause cycle, include it in result and increment the
            // index of result for next edge
            if(x != y) {
                results[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }
            j++;
        }

        // Print the contents of result[] to display the built MST
        System.out.println("Following are the edges of the constructed MST:");
        int minCost = 0;
        for(int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].src + " -- " + results[i].dest + " = " + results[i].weight);
            minCost += results[i].weight;
        }

        System.out.println("Total cost of MST: " + minCost);
    }

    private static void union(Subset[] subsets, int x, int y) {
        int rootx = findRoot(subsets, x);
        int rooty = findRoot(subsets, y);

        if(subsets[rooty].rank < subsets[rootx].rank) {
            subsets[rooty].parent = rootx;
        } else if(subsets[rootx].rank < subsets[rooty].rank) {
            subsets[rootx].parent = rooty;
        } else {
            subsets[rooty].parent = rootx;
            subsets[rootx].rank++;
        }
    }

    private static int findRoot(Subset[] subsets, int y) {
        if(subsets[y].parent == y) {
            return subsets[y].parent;
        }
        subsets[y].parent = findRoot(subsets, subsets[y].parent);
        return subsets[y].parent;
    }


}
