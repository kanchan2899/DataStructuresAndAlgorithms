package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

import static com.dsalgo.graphs.AdjacencyList.addEdge;

// https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
public class ShortestPathInUnweightedGraph {
    public static void main(String[] args) {
        int V = 8;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 2);
        addEdge(adj, 3, 4);
        addEdge(adj, 3, 7);
        addEdge(adj, 4, 5);
        addEdge(adj, 4, 6);
        addEdge(adj, 4, 7);
        addEdge(adj, 5, 6);
        addEdge(adj, 6, 7);

        printShortestDistance(adj, 0, 7, V);
    }

    private static void printShortestDistance(ArrayList<ArrayList<Integer>> adj, int s, int d, int v) {
        int[] predecessor = new int[v];
        int[] distance = new int[v];

        if(!bfs(adj, s, d, v, predecessor, distance)) {
            System.out.println("Given source and destination are not connected");
        }

        LinkedList<Integer> path = new LinkedList<>();
        int crawl = d;
        path.add(crawl);

        while (predecessor[crawl] != -1) {
            path.add(predecessor[crawl]);
            crawl = predecessor[crawl];
        }

        System.out.println("Shortest path is " + distance[d]);

        System.out.println("The path is :: ");
        for (int i = path.size()-1; i >= 0; i--) {
            System.out.print(path.get(i) + " ");
        }
    }

    private static boolean bfs(ArrayList<ArrayList<Integer>> adj, int s, int d, int v, int[] predecessor, int[] distance) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[v];

        for(int i = 0; i < v; i++) {
            visited[i] = false;
            distance[i] = Integer.MAX_VALUE;
            predecessor[i] = -1;
        }

        visited[s] = true;
        distance[s] = 0;
        queue.add(s);

        while (!queue.isEmpty()) {
            int u = queue.remove();

            for(int i = 0; i < adj.get(u).size(); i++) {
                if(!visited[adj.get(u).get(i)]) {
                    visited[adj.get(u).get(i)] = true;
                    distance[adj.get(u).get(i)] = distance[u] + 1;
                    predecessor[adj.get(u).get(i)] = u;
                    queue.add(adj.get(u).get(i));

                    if(adj.get(u).get(i) == d) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
