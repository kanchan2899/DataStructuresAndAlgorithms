package com.dsalgo.graphs;

import java.util.*;

// https://www.geeksforgeeks.org/shortest-path-for-directed-acyclic-graphs/
public class ShortestPathInDAG {
    static final int INF = Integer.MAX_VALUE;

    class AdjacencyListNode {
        private int v;
        private int weight;

        AdjacencyListNode(int v, int w) {
            this.v = v;
            this.weight = w;
        }

        int getV() {
            return this.v;
        }

        int getWeight() {
            return this.weight;
        }
    }

    class Graph {
        private int V;
        private LinkedList<AdjacencyListNode>[] adj;

        Graph(int v) {
            V = v;
            adj = new LinkedList[V];
            for(int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        void addEdge(int u, int v, int weight) {
            AdjacencyListNode node = new AdjacencyListNode(v, weight);
            adj[u].add(node);
        }

        void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack) {
            // Mark the current node as visited.
            visited[v] = true;

            // Recur for all the vertices adjacent to this vertex
            Iterator<AdjacencyListNode> iterator = adj[v].iterator();

            while (iterator.hasNext()) {
                AdjacencyListNode node = iterator.next();
                if(!visited[node.getV()]) {
                    topologicalSortUtil(node.getV(), visited, stack);
                }
            }
            // Push current vertex to stack which stores result
            stack.push(v);
        }

        /**
         * Using topological sort: We initialize distances to all vertices as infinite and
         * distance to source as 0, then we find a topological sorting of the graph. Topological
         * Sorting of a graph represents a linear ordering of the graph. Once we have topological
         * order (or linear representation), we one by one process all vertices in topological
         * order. For every vertex being processed, we update distances of its adjacent using
         * distance of current vertex.
         *
         * 1. Initialize dist[] = {INF, INF, ….} and dist[s] = 0 where s is the source vertex.
         * 2. Create a topological order of all vertices.
         * 3. Do following for every vertex u in topological order.
         *      ..Do following for every adjacent vertex v of u
         *          if (dist[v] > dist[u] + weight(u, v))
         *              dist[v] = dist[u] + weight(u, v)
         *
         * TC: O(v + E)
         * SC: O(V + E)
         * @param s
         * @return
         */
        ArrayList<Integer> shortestPath(int s) {
            Stack<Integer> stack = new Stack<>();
            int[] dist = new int[V];

            // Mark all the vertices as not visited
            boolean[] visited = new boolean[V];
            Arrays.fill(visited, false);


            // Call the recursive helper function to store topological sort starting from all
            // vertices one by one
            for(int i = 0; i < V; i++) {
                if(!visited[i]) {
                    topologicalSortUtil(i, visited, stack);
                }
            }

            // initialize distances to all vertices as infinite and distance to source as 0
            for(int i = 0; i < V; i++) {
                dist[i] = INF;
            }
            dist[s] = 0;

            // process vertices in topological order
            while (!stack.isEmpty()) {
                int u = stack.pop();
                Iterator<AdjacencyListNode> it;
                // update distances of all adjacent vertices
                if(dist[u] != INF) {
                    it = adj[u].iterator();
                    while (it.hasNext()) {
                        AdjacencyListNode i = it.next();
                        if(dist[i.getV()] > dist[u] + i.getWeight()) {
                            dist[i.getV()] = dist[u] + i.getWeight();
                        }
                    }
                }
            }

            ArrayList<Integer> shortestDistance = new ArrayList<>(V);
            for(int i = 0; i < V; i++) {
                shortestDistance.add(dist[i]);
            }

            return shortestDistance;
        }
    }

    Graph newGraph(int num) {
        return new Graph(num);
    }

    public static void main(String[] args) {
        ShortestPathInDAG t = new ShortestPathInDAG();
        Graph graph = t.newGraph(6);

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 3, 6);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 4, 4);
        graph.addEdge(2, 5, 2);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, -1);
        graph.addEdge(4, 5, -2);

        int source = 1;

        System.out.println(graph.shortestPath(source));

    }

}
