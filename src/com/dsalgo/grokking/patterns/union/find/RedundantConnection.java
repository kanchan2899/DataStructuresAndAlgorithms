package com.dsalgo.grokking.patterns.union.find;

import java.util.Arrays;

// https://leetcode.com/problems/redundant-connection/
class UnionFind {
    public int[] parent;
    public int[] rank;

    public UnionFind(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 0; i <= n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // function to find which subset a particular element belongs to
    public int find(int v) {
        if(parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    // function to join two subsets into a single subset
    public boolean union(int v1, int v2) {
        // find the root parents of v1 and v2
        int p1 = find(v1);
        int p2 = find(v2);

        // if both parents are same, a cycle exists and v1, v2 is the redundant edge
        if(p1 == p2) {
            return false;
        }

        // updates the parent and rank lists otherwise
        else if (rank[p1] > rank[p2]) {
            parent[p2] = p1;
            rank[p1] += rank[p2];
        }
        else {
            parent[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}
public class RedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        System.out.println(Arrays.toString(findRedundantConnection(edges)));
    }

    public static int[] findRedundantConnection(int[][] edges) {
        UnionFind connections = new UnionFind(edges.length);

        // traverse the edges of the graph to check for the redundant edge
        for(int[] edge: edges) {
            int v1 = edge[0];
            int v2 = edge[1];

            if(!connections.union(v1, v2)) {
                return edge;
            }
        }
        return new int[] {};
    }
}
