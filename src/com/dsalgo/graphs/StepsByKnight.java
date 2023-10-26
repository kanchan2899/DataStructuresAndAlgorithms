package com.dsalgo.graphs;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/minimum-steps-reach-target-knight/
public class StepsByKnight {
    static class Cell {
        int x, y, dist;

        Cell(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        int n = 30;
        int[] knightPos = {1, 1};
        int[] targetPos = {30, 30};

        System.out.println(minStepsToReachTarget(n, knightPos, targetPos));

    }

    static boolean isInside(int x, int y, int n) {
        if(x >= 1 && x <= n && y >= 1 && y <= n) {
            return true;
        }
        return false;
    }

    /**
     * Using BFS: Try all 8 possible positions where a Knight can reach from its position.
     * If the reachable position is not already visited and is inside the board, push this state
     * into the queue with a distance 1 more than its parent state. During the BFS traversal,
     * if the current position is target position then return the distance of the target position.
     *
     *
     *
     * TC: O(n ^ 2)
     * SC: O(n ^ 2)
     *
     * @param n
     * @param knightPos
     * @param targetPos
     * @return
     */
    private static int minStepsToReachTarget(int n, int[] knightPos, int[] targetPos) {
        // x and y direction, where a knight can move
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};

        // queue for storing states of knight in  board
        Queue<Cell> queue = new LinkedList<>();

        // push starting position of knight with 0 direction
        queue.add(new Cell(knightPos[0], knightPos[1], 0));

        Cell t;
        int x, y;

        boolean[][] visited = new boolean[n + 1][n + 1];

        // visit starting state
        visited[knightPos[0]][knightPos[1]] = true;

        // loop until we have one element in queue
        while (!queue.isEmpty()) {
            t = queue.poll();

            // if current cell is equal to target cell, return its direction
            if(t.x == targetPos[0] && t.y == targetPos[1]) {
                return t.dist;
            }

            // loop for all reachable states
            for(int i = 0; i < 8; i++) {
                x = t.x + dx[i];
                y = t.y + dy[i];

                if(isInside(x, y, n) && !visited[x][y]) {
                    visited[x][y] = true;
                    queue.add(new Cell(x, y, t.dist+1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
}
