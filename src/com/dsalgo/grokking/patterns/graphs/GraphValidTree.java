package com.dsalgo.grokking.patterns.graphs;

// https://leetcode.com/problems/graph-valid-tree/

import com.dsalgo.maths.FactorsOfNumber;

import java.util.*;

/**
 * Given n as the number of nodes and an array of the edges of a graph, find out if the graph
 * is a valid tree. The nodes of the graph are labeled from 0 to n−1, and edges[i]=[x,y]
 * represents an undirected edge connecting the nodes x and y of the graph.
 *
 * A graph is a valid tree when all the nodes are connected and there is no cycle between them.
 */
public class GraphValidTree {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}};
        int n = 4;
        System.out.println(validTree(n, edges));
    }

    private static boolean validTree(int n, int[][] edges) {
        // check if n - 1 edges exists
        if(edges.length != n - 1) {
            return false;
        }

        // create an adjacency list of length n
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // populate the adjacency list with all the connected nodes
        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];

            adjacencyList.get(x).add(y);
            adjacencyList.get(y).add(x);
        }

        // to check if all graph nodes are connected or not, initialize a set and stack
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        visited.add(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            // pop the node from the stack
            int node = stack.pop();

            // iterate over the neighbours of the popped node
            for(int neighbour: adjacencyList.get(node)) {
                // continue if neighbour already exists in visited set
                if(visited.contains(neighbour)) {
                    continue;
                }

                // add a neighbour to the visited set and stack if it doesn't exist in the set
                visited.add(neighbour);
                stack.push(neighbour);
            }
        }
        return visited.size() == n;
    }
}
