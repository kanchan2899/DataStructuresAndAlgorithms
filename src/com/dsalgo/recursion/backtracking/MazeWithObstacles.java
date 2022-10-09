package com.dsalgo.recursion.backtracking;

// Given boolean matrix where false means a river - you cannot go further

// NOTE: When you land on a new cell, check if it is a river or not.
// If you land on a river, stop the recursion for that call and return
public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] obstacles = { {true, true, true}, {true, false, true}, {true, true, true}};
        pathWithObstacles("", obstacles, 0, 0);
    }

    static void pathWithObstacles(String processed, boolean[][] obstacles, int r, int c) {
         if(r == obstacles.length - 1 && c == obstacles[0].length - 1) {
             System.out.println(processed);
             return;
         }

         if(!obstacles[r][c]) {
             return;
         }

         if(r < obstacles.length - 1) {
             pathWithObstacles(processed + "D", obstacles, r + 1, c);
         }

         if(c < obstacles[0].length - 1) {
             pathWithObstacles(processed + "R", obstacles, r , c + 1);
         }
    }
}
