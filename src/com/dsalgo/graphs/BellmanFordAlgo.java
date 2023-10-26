package com.dsalgo.graphs;

// https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
public class BellmanFordAlgo {
    int  V, E;
    class Edge {
        int src, dest, weight;
        Edge() {
            src = dest = weight = 0;
        }
    };

    Edge edge[];

    BellmanFordAlgo(int v, int e) {
        this.V = v;
        this.E = e;

        edge = new Edge[e];

        for(int i = 0; i < e; i++) {
            edge[i] = new Edge();
        }
    }

    /**
     *
     * 1. This step initializes distances from source to all vertices as infinite and distance
     * to source itself as 0. Create an array dist[] of size |V| with all values as infinite except
     * dist[src] where src is source vertex.
     * 2. This step calculates shortest distances. Do following |V|-1 times where |V| is the number
     * of vertices in given graph. Do following for each edge u-v:
     *      - If dist[v] > dist[u] + weight of edge uv, then update dist[v] as:
     *      dist[v] = dist[u] + weight of edge uv.
     * 3. This step reports if there is a negative weight cycle in graph. Do following for each
     * edge u-v. If dist[v] > dist[u] + weight of edge uv, then "Graph contains negative weight cycle".
     *
     *
     * TC: O(V * E)
     * SC: O(V)
     *
     * @param graph
     * @param src
     */

    void bellmanFord(BellmanFordAlgo graph, int src) {
        int V = graph.V, E = graph.E;
        int[] dist = new int[V];

        // Step 1: Initialize distances from src to all other vertices as INFINITE
        for(int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        // Step 2: Relax all edges |V| - 1 times. A simple shortest path from src to any other
        // vertex can have at-most |V| - 1 edges
        for(int i = 1; i < V; i++) {
            for(int j = 0; j < E; j++) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;

                if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Step 3: check for negative-weight cycles.  The above step guarantees the shortest distances
        // if graph doesn't contain negative weight cycle. If we get a shorter path, then there is a cycle.
        for(int j = 0; j < E; j++) {
            int u = graph.edge[j].src;
            int v = graph.edge[j].dest;
            int weight = graph.edge[j].weight;
            if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                dist[v] = dist[u] + weight;
            }
        }

        printArr(dist, V);
    }

    private void printArr(int[] dist, int v) {
        System.out.println("Vertex distance from source");
        for(int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 5;
        int E = 8;

        BellmanFordAlgo graph = new BellmanFordAlgo(V, E);

        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].weight = -1;

        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].weight = 4;

        graph.edge[2].src = 1;
        graph.edge[2].dest = 2;
        graph.edge[2].weight = 3;

        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].weight = 2;

        graph.edge[4].src = 1;
        graph.edge[4].dest = 4;
        graph.edge[4].weight = 2;

        graph.edge[5].src = 3;
        graph.edge[5].dest = 2;
        graph.edge[5].weight = 5;

        graph.edge[6].src = 3;
        graph.edge[6].dest = 1;
        graph.edge[6].weight = 1;

        graph.edge[7].src = 4;
        graph.edge[7].dest = 3;
        graph.edge[7].weight = -3;


        graph.bellmanFord(graph, 0);
    }
}
