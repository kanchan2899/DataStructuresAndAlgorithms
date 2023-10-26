package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/find-if-there-is-a-path-between-two-vertices-in-an-undirected-graph/
public class FindWhetherPathExists {
    static class Graph {
        int V;
        int[][] g;

        public Graph(int V) {
            this.V = V;
            g = new int[V + 1][V + 1];

            // initializing node to itself as it is always reachable
            for(int i = 1; i <= V; i++) {
                g[i][i] = 1;
            }
        }

        // function to add edge between nodes
        void addEdge(int v, int w) {
            g[v][w] = 1;
            g[w][v] = 1;
        }

        /**
         * Using Floyd-Warshall's algorithm: Try out all intermediate vertices ranging [1, N] and
         * check:
         *
         * 1. If there is a direct edge already which exists between the two nodes.
         * 2. Or we have a path from node i to intermediate node k and from node k to node j.
         *
         * TC: O(V ^ 3)
         * SC: O(V ^ 2)
         *
         * @param s
         * @param d
         * @return
         */
        boolean isReachable(int s, int d) {
            return g[s][d] == 1 ? true : false;
        }

        void computePaths() {

            for(int k = 1; k <= V; k++) {
                // try every vertex as an intermediate vertex to check if a path exists
                for(int i = 1; i <= V; i++) {
                    for(int j = 1; j <= V; j++) {
                        g[i][j] = g[i][j] | ((g[i][k] != 0) && g[k][j] != 0 ? 1 : 0);
                    }
                }
            }
        }

    }

    static class Graph1 {
        int V;

        ArrayList<ArrayList<Integer>> adjacencyList;

        Graph1(int V) {
            this.V = V;
            adjacencyList = new ArrayList<>();
            for(int i = 0; i < V; i++) {
                adjacencyList.add(new ArrayList<>());
            }
        }

        void addEdge(int v, int w) {
            adjacencyList.get(v).add(w);
            adjacencyList.get(w).add(v);
        }


        /**
         * USing BFS
         *
         * TC: O(V + E)
         * SC: O(V)
         *
         * @param s
         * @param d
         * @return
         */
        boolean isReachable(int s, int d) {
            if(s == d) {
                return true;
            }

            boolean[] visited = new boolean[V];
            Queue<Integer> queue = new LinkedList<>();

            visited[s] = true;
            queue.add(s);

            while (!queue.isEmpty()) {
                s = queue.remove();
                for(int i = 0; i < adjacencyList.get(s).size(); i++) {
                    if(adjacencyList.get(s).get(i) == d) {
                        return true;
                    }
                    if(!visited[adjacencyList.get(s).get(i)]) {
                        visited[adjacencyList.get(s).get(i)] = true;
                        queue.add(adjacencyList.get(s).get(i));
                    }
                }
            }
            return false;
        }

        boolean isReachable1(int[][] edges, int start, int end) {
            ArrayList<Integer>[] adj = new ArrayList[V];
            for(int i = 0; i < V; i++) {
                adj[i] = new ArrayList<>();
            }

            for(int i = 0; i < edges.length; i++) {
                int u = edges[i][0];
                int v = edges[i][1];
                adj[u].add(v);
                adj[v].add(u);
            }

            ArrayList<Integer> visited = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                visited.add(0);
            }

            for(int i = 0; i < V; i++) {
                if(visited.get(i) == 0) {
                    if(dfs(adj, visited, start, end)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean dfs(ArrayList<Integer>[] adj, ArrayList<Integer> visited, int start, int end) {
            if(start == end) {
                return true;
            }

            visited.set(start, 1);

            for(int it : adj[start]) {
                if(visited.get(it) == 0) {
                    if(dfs(adj, visited, it, end)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 4);

        g.computePaths();

        int u = 4, v = 3;

        System.out.println(g.isReachable(u, v));

        Graph1 graph1 = new Graph1(4);
        graph1.addEdge(0, 1);
        graph1.addEdge(0, 2);
        graph1.addEdge(1, 2);
        graph1.addEdge(2, 0);
        graph1.addEdge(2, 3);
        graph1.addEdge(3, 3);

        u = 1;
        v = 3;

        System.out.println(graph1.isReachable(u, v));

        System.out.println(graph1.isReachable1(new int[][]{{0, 1}, {0, 2}, {1, 2}, {2, 0}, {2, 3}, {3, 3}}, u, v));
    }
}
