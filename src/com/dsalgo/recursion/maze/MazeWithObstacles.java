package com.dsalgo.recursion.maze;

// Given boolean matrix where false means a river - you cannot go further

import java.util.ArrayList;
import java.util.List;

// NOTE: When you land on a new cell, check if it is a river or not.
// If you land on a river, stop the recursion for that call and return
public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] obstacles = { {true, true, true}, {true, false, true}, {true, true, true}};
        pathWithObstacles("", obstacles, 0, 0);
        System.out.println(pathWithObstaclesInList("", obstacles, 0, 0));
    }

    private static List<String> pathWithObstaclesInList(String processed,
                                                        boolean[][] obstacles,
                                                        int row, int col) {
        if(row == obstacles.length - 1 && col == obstacles[0].length - 1) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> paths = new ArrayList<>();

        if(!obstacles[row][col]) {
            return paths;
        }

        if(row < obstacles.length - 1) {
            paths.addAll(pathWithObstaclesInList(processed + "D", obstacles, row + 1, col));
        }

        if(col < obstacles[0].length - 1) {
            paths.addAll(pathWithObstaclesInList(processed + "R", obstacles, row, col + 1));
        }

        return paths;
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
