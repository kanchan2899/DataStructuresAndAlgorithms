package com.dsalgo.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

// https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
public class ArticulationPoint {
    int V;
    LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    ArticulationPoint(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // A recursive function that find articulation points using DFS
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ap[] --> Store articulation points
    void APUtil(int u, boolean[] visited, int disc[], int[] low, int[] parent, boolean[] ap) {
        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices aadjacent to this
        Iterator<Integer> iterator = adj[u].iterator();
        while (iterator.hasNext()) {
            int v = iterator.next();

            // If v is not visited yet, then make it a child of u in DFS tree and recur for it

            if(!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap);

                // Check if the subtree rooted with v has a connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // u is an articulation point in following cases
                // (1) u is root of DFS tree and has two or more children.

                if(parent[u] == NIL && children > 1) {
                    ap[u] = true;
                }

                // (2) If u is not root and low value of one of its child is more than discovery value of u.
                if(parent[u] != NIL && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            } else if(v != parent[u]){
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    /**
     *
     * TC: O(V + E)
     *
     */
    void articulationPoints() {
        // mark all the vertices as not visited
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] ap = new boolean[V];

        Arrays.fill(parent, NIL);

        // Call the recursive helper function to find articulation points in DFS tree rooted with vertex 'i'
        for(int i = 0; i < V; i++) {
            if(!visited[i]) {
                APUtil(i, visited, disc, low, parent, ap);
            }
        }

        //  Now ap[] contains articulation points, print them
        for(int i = 0; i < V; i++) {
            if(ap[i]) {
                System.out.print(i + "\t");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("AP in first graph");

        ArticulationPoint g1 = new ArticulationPoint(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.articulationPoints();

        System.out.println();

        System.out.println("AP in second graph");
        ArticulationPoint g2 = new ArticulationPoint(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.articulationPoints();

        System.out.println();
    }
}
