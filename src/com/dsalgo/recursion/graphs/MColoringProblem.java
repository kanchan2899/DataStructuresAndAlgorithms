package com.dsalgo.recursion.graphs;

// https://www.geeksforgeeks.org/m-coloring-problem/
public class MColoringProblem {
    final int V = 4;
    int[] color;

    // check if the current color assignment is safe for vertex v
    boolean isSafe(int v, int[][] graph, int[] color, int c) {
        for(int i = 0; i < v; i++) {
            if(graph[v][i] == 1 && c == color[i]) {
                return false;
            }
        }
        return true;
    }

    boolean graphColoring(int[][] graph, int m) {
        color = new int[V];

        // Call graphColoringUtil() for vertex 0
        if(!graphColoringUtil(graph, m, color, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printSolution(color);
        return true;
    }

    private void printSolution(int[] color) {
        System.out.println("Solution Exists: Following are the assigned colors");
        for(int i = 0; i < V; i++) {
            System.out.print(" " + color[i] + " ");
        }
        System.out.println();
    }

    // recursive utility function  to solve m coloring  problem
    private boolean graphColoringUtil(int[][] graph, int m, int[] color, int v) {
        if(v == V) {
            return true;
        }

        // Consider this vertex v and try different colors
        for (int c = 1; c <= m; c++) {
            // Check if assignment of color c to v is fine
            if(isSafe(v, graph, color, c)) {
                color[v] = c;

                // recur to assign colors to rest of the vertices
                if(graphColoringUtil(graph, m, color, v + 1)) {
                    return true;
                }

                // If assigning color c doesn't lead to a solution then remove it
                color[v] = 0;
            }
        }

        // If no color can be assigned to this vertex then return false
        return false;
    }

    public static void main(String[] args) {
        MColoringProblem coloringProblem = new MColoringProblem();

        /* Create following graph and test whether it is 3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */

        int[][] graph = {{0, 1, 1, 1}, {1, 0, 1, 0}, {1, 1, 0, 1}, {1, 0, 1, 0}};
        int m = 3;

        coloringProblem.graphColoring(graph, m);

    }
}
