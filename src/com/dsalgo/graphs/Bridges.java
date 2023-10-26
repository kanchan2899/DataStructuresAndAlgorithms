package com.dsalgo.graphs;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

// https://www.geeksforgeeks.org/bridge-in-a-graph/
public class Bridges {
    int V;
    LinkedList<Integer> adj[];
    int time = 0;
    static final int NIL = -1;

    Bridges(int v) {
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

    // A recursive function that find bridges using DFS
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ap[] --> Store articulation points
    void bridgeUtil(int u, boolean[] visited, int disc[], int[] low, int[] parent) {

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices adjacent to this
        Iterator<Integer> iterator = adj[u].iterator();
        while (iterator.hasNext()) {
            int v = iterator.next();

            // If v is not visited yet, then make it a child of u in DFS tree and recur for it
            if(!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);

                // Check if the subtree rooted with v has a connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                //If the lowest vertex reachable from subtree under v is below u in DFS tree,
                // then u-v is a bridge if(parent[u] == NIL && children > 1)
                if(low[v] > disc[u]){
                    System.out.println(u + "\t" + v);
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
    void bridges() {
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
                bridgeUtil(i, visited, disc, low, parent);
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
        System.out.println("Bridges in first graph");

        Bridges g1 = new Bridges(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        g1.bridges();

        System.out.println();

        System.out.println("Bridges in second graph");
        Bridges g2 = new Bridges(4);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2, 3);
        g2.bridges();

        System.out.println();
    }
}
