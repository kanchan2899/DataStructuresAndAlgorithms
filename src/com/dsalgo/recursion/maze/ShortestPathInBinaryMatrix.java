package com.dsalgo.recursion.maze;

import java.util.ArrayDeque;
import java.util.Queue;

// https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathInBinaryMatrix {
    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{1,1,0},{1,1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));
    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
       if(grid[0][0] == 1)
           return -1;

       var moves = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
       var n = grid.length;
       var seen = new boolean[n][n];

       var queue = new ArrayDeque<int[]>();

       queue.offer(new int[] {0, 0});

       for(var count = 1; !queue.isEmpty(); count++) {
           for(var i = queue.size(); i > 0; i--) {
               var cell = queue.poll();

               if(cell[0] == n - 1 && cell[1] == n - 1) {
                   return count;
               }

               for(var move: moves) {
                   var x = cell[0] + move[0];
                   var y = cell[1] + move[1];

                   if(x >= 0 && x < n && y >= 0 && y < n && !seen[x][y] && grid[x][y] == 0) {
                       seen[x][y] = true;
                       queue.offer(new int[] {x, y});
                   }
               }
           }
       }
       return -1;
    }

}
