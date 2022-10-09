package com.dsalgo.recursion.backtracking;

public class MazePathsAllDirections {
    public static void main(String[] args) {
        boolean[][] maze = {{true, true, true}, {true, true, true}, {true, true, true}};
        mazeAllPaths("", maze, 0, 0);
    }

    static void mazeAllPaths(String processed, boolean[][] maze, int r, int c) {
        if(r == maze.length - 1 && c == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }
        if(!maze[r][c]) {
            return;
        }

        // I'm considering this block in my path
        maze[r][c] = false;

        if(r < maze.length - 1) {
            mazeAllPaths(processed + "D", maze, r + 1, c);
        }
        if(c < maze[0].length - 1) {
            mazeAllPaths(processed + "R", maze, r, c + 1);
        }
        if(r > 0) {
            mazeAllPaths(processed + "U", maze,r - 1, c);
        }
        if(c > 0) {
            mazeAllPaths(processed + "L", maze, r, c - 1);
        }

        // This line is where the function will be over
        // So before the function gets removed, also remove the changes made by that function call
        maze[r][c] = true;
    }
}
