package com.dsalgo.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

// https://www.geeksforgeeks.org/strongly-connected-components/
public class StronglyConnectedComponentsTarjanAlgo {
    private int V;
    private LinkedList<Integer> adj[];

    private int time;

    StronglyConnectedComponentsTarjanAlgo(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
        time = 0;
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void SCCUtil(int u, int[] low, int[] disc, boolean[] stackMember, Stack<Integer> stack) {
        // Initialize discovery time and low value
        disc[u] = time;
        low[u] = time;
        time += 1;
        stackMember[u] = true;
        stack.push(u);

        int n;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> iterator = adj[u].iterator();
        while (iterator.hasNext()) {
            n = iterator.next();

            if(disc[n] == -1) {
                SCCUtil(n, low, disc, stackMember, stack);
                // Check if the subtree rooted with v has a connection to one of the ancestors of u
                // Case 1 - Disc and Low value
                low[u] = Math.min(low[u], low[n]);
            } else if(stackMember[n]) {
                // Update low value of 'u' only if 'v' is still in stack (i.e. it's a back edge,
                //  not cross edge).
                //  Case 2 - Disc and Low value
                low[u] = Math.min(low[u], disc[n]);
            }
        }
        int w = -1;
        if(low[u] == disc[u]) {
            while (w != u) {
                w = stack.pop();
                System.out.print(w + " ");
                stackMember[w] = false;
            }
            System.out.println();
        }
    }

    /**
     * Tarjan's algo: It is based on the following facts:
     * 1. DFS search produces a DFS tree/forest
     * 2. Strongly Connected Components form subtrees of the DFS tree.
     * 3. If we can find the head of such subtrees, we can print/store all the nodes in that
     * subtree (including the head) and that will be one SCC.
     * 4. There is no back edge from one SCC to another (There can be cross edges, but cross
     * edges will not be used while processing the graph).
     *
     *
     *
     *
     * TC: O(V + E)
     * SC: O(V)
     *
     * @param v
     */
    void SCC(int v) {
        int[] disc = new int[v];
        int[] low = new int[v];

        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        boolean[] stackMember = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        // Call the recursive helper function to find articulation points
        // in DFS tree rooted with vertex 'i'

        for(int i = 0; i < v; i++) {
            if(disc[i] == -1) {
                SCCUtil(i, low, disc, stackMember, stack);
            }
        }
    }

    public static void main(String[] args) {
        StronglyConnectedComponentsTarjanAlgo graph = new StronglyConnectedComponentsTarjanAlgo(5);
        graph.addEdge(1, 0);
        graph.addEdge(0, 2);
        graph.addEdge(2, 1);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);

        System.out.println("Following are the strongly connected components");
        graph.SCC(5);
    }
}
