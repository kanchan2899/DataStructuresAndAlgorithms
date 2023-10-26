package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/prims-minimum-spanning-tree-mst-greedy-algo-5/
public class PrimsMinimumSpanningTree {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static int V = 5;

    // to find the vertex with minimum key value, from the set of vertices not yet included in MST
    int minKey(int[] key, boolean[] mstSet) {
        // Initialize min value
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for(int v = 0; v < V; v++) {
            if(mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }
        }

        return min_index;
    }

    // print the constructed MST stored in parent[]
    void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge Weight");
        for(int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    /**
     * 1. Create a set mstSet that keeps track of vertices already included in MST.
     * 2. Assign a key value to all vertices in the input graph. Initialize all key values as
     * INFINITE. Assign key value as 0 for the first vertex so that it is picked first.
     * 3. While mstSet doesn't include all vertices:
     *      a. Pick a vertex u which is not there in mstSet and has minimum key value.
     *      b. Include u to mstSet.
     *      c. Update key value of all adjacent vertices of u. To update the key values, iterate
     *      through all adjacent vertices. For every adjacent vertex v, if weight of edge u-v is
     *      less than the previous key value of v, update the key value as weight of u-v.
     *
     * TC: O(V ^ 2)
     * SC: O(V)
     *
     * @param graph
     */
    void primMST(int[][] graph) {
        // array to store constructed MST
        int[] parent = new int[V];

        // key values used to pick minimum weight edge in cut
        int[] key = new int[V];

        // to represent set of vertices not yet included in MST
        boolean mstSet[] = new boolean[V];

        // initialize all keys as infinite
        for(int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // always include first 1st vertex in MST
        key[0] = 0;     // make key[0] as 0 so that this vertex is picked as first vertex

        // picked as first vertex
        parent[0] = -1;    // first node is always root of MST

        // the MST will have V vertices
        for(int count = 0; count < V - 1; count++) {
            // pick the minimum key vertex from the set of vertices not yet included in MST
            int u = minKey(key, mstSet);

            // add the picked vertex to the MST set
            mstSet[u] = true;

            // update key value and parent index of the adjacent vertices of the picked vertex.
            // consider only those vertices which are not yet included in MST
            for(int v = 0; v < V; v++) {
                // graph[u][v] is non zero only for adjacent vertices of m
                // msetSet[v] is false for vertices not yet included in MST
                // update the key only if graph[u][v] is smaller than key[v]

                if(graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }

    int primMST1(int[][] edges, int V) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y) -> x.weight - y.weight);
        int[] visited = new int[V];
        int sum = 0;
        pq.add(new Pair(0 , 0));

        while(!pq.isEmpty())
        {
            //System.out.println(pq.peek());
            int node = pq.peek().node;
            int w = pq.peek().weight;
            pq.remove();
            if(visited[node] == 1)continue;

            visited[node] = 1;
            sum += w;

            for(Pair it : adj.get(node))
            {
                int newNode = it.node;
                if(visited[newNode] == 0)
                {
                    pq.add(new Pair( newNode , it.weight));

                }
            }

        }
        return sum;
    }

    public static void main(String[] args) {
        PrimsMinimumSpanningTree mst = new PrimsMinimumSpanningTree();
        int[][] graph = new int[][] {{0, 2, 0, 6, 0}, {2, 0, 3, 8, 5},
                                    {0, 3, 0, 0, 7}, {6, 8, 0, 0, 9}, {0, 5, 7, 9, 0}};

        mst.primMST(graph);

        System.out.println(mst.primMST1(graph, V));
    }
}
