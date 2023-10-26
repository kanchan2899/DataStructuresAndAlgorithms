package com.dsalgo.graphs;

import java.util.ArrayList;

public class AdjacencyList {

    // add an edge in an undirected graph
    static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList, int u, int v) {
        adjacencyList.get(u).add(v);
        adjacencyList.get(v).add(v);
    }

    // print the adjacency list representation of graph
    static void printGraph(ArrayList<ArrayList<Integer>> adjacencyList) {
        for(int i = 0; i < adjacencyList.size(); i++) {
            System.out.print("Adjacency list of vertex " + i);
            for(int j = 0; j < adjacencyList.get(i).size(); j++) {
                System.out.print(" -> " + adjacencyList.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(v);

        for(int i = 0; i < v; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 0, 4);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 3, 4);

        printGraph(adjacencyList);

    }
}
