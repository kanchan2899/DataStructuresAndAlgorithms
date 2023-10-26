package com.dsalgo.graphs;

import java.util.*;

// https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
public class DijkstraAlgo {

    static class Pair {
        int u, v;
        Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
    private int V;
    private List<List<Pair>> adj;

    DijkstraAlgo(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int w) {
        adj.get(u).add(new Pair(v, w));
        adj.get(v).add(new Pair(u, w));
    }

    /**
     * Dijkstra Algo:
     *
     * For Dijkstra’s algorithm, it is always recommended to use Heap (or priority queue) as the
     * required operations (extract minimum and decrease key) match with the specialty of the heap
     * (or priority queue). However, the problem is, that priority_queue doesn’t support the
     * decrease key. To resolve this problem, do not update a key, but insert one more copy of it.
     * So we allow multiple instances of the same vertex in the priority queue. This approach
     * doesn’t require decreasing key operations and has below important properties.
     *
     * Whenever the distance of a vertex is reduced, we add one more instance of a vertex in
     * priority_queue. Even if there are multiple instances, we only consider the instance with
     * minimum distance and ignore other instances.
     * The time complexity remains O(E * LogV) as there will be at most O(E) vertices in the priority
     * queue and O(logE) is the same as O(logV)
     *
     * @param source
     */
    void shortestPath(int source) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.u));
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        pq.add(new Pair(0, source));
        dist[source] = 0;

        while (!pq.isEmpty()) {
            int u = pq.poll().v;

            for(Pair v: adj.get(u)) {
                if(dist[v.u] > dist[u] + v.v) {
                    dist[v.u] = dist[u] + v.v;
                    pq.add(new Pair(dist[v.u], v.u));
                }
            }
        }

        System.out.println("Vertex distance from source");
        for(int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        int V = 9;
        DijkstraAlgo g = new DijkstraAlgo(V);

        g.addEdge(0, 1, 4);
        g.addEdge(0, 7, 8);
        g.addEdge(1, 2, 8);
        g.addEdge(1, 7, 11);
        g.addEdge(2, 3, 7);
        g.addEdge(2, 8, 2);
        g.addEdge(2, 5, 4);
        g.addEdge(3, 4, 9);
        g.addEdge(3, 5, 14);
        g.addEdge(4, 5, 10);
        g.addEdge(5, 6, 2);
        g.addEdge(6, 7, 1);
        g.addEdge(6, 8, 6);
        g.addEdge(7, 8, 7);

        g.shortestPath(0);
    }
}
