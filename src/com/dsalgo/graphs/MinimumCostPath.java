package com.dsalgo.graphs;

import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/videos/minimum-cost-path-problem/
public class MinimumCostPath {

    public static void main(String[] args) {
        int[][] grid = {{9,4,9,9},{6,7,6,4},{8,3,3,7},{7,4,9,10}};
        System.out.println(minimumCostPath(grid));
    }
    static int INF = Integer.MAX_VALUE;

    public static boolean isSafe(int[][] grid, int row, int col) {
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0) {
            return false;
        }
        return true;
    }
    //Function to return the minimum cost to react at bottom
    //right cell from top left cell.
    public static int minimumCostPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = INF;
            }
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.dist - b.dist));

        pq.add(new Pair(0, 0, grid[0][0]));
        dist[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            int curr_row = curr.row;
            int curr_col = curr.col;
            int curr_dist = curr.dist;

            for (int i = 0; i < 4; i++) {
                int newr = curr_row + dr[i];
                int newc = curr_col + dc[i];

                if (isSafe(grid, newr, newc)) {
                    if (grid[newr][newc] + curr_dist < dist[newr][newc]) {
                        dist[newr][newc] = grid[newr][newc] + curr_dist;
                        pq.add(new Pair(newr, newc, dist[newr][newc]));
                    }
                }
            }
        }

        return dist[n - 1][m - 1];
    }
}

class Pair {
    int row;
    int col;
    int dist;

    Pair(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
