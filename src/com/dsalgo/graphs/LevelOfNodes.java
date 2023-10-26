package com.dsalgo.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/level-node-tree-source-node-using-bfs/
public class LevelOfNodes{

    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        int level = 0;
        boolean[] visited = new boolean[V];

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int s = q.remove();
                if(s == X) {
                    return level;
                } else {
                    for(int u : adj.get(s)) {
                        if(!visited[u]) {
                            visited[u] = true;
                            q.add(u);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LevelOfNodes graph = new LevelOfNodes();

    }
}
