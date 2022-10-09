package com.dsalgo.recursion.backtracking;

import java.util.ArrayList;

// Can only go right and down
public class MazePaths {
    public static void main(String[] args) {
        printMazePaths("", 3, 3);
        System.out.println(printMazePathsDiagonals("", 3, 3));

    }

    private static ArrayList<String> printMazePathsDiagonals(String processed, int r, int c) {
        if(r == 1 && c == 1) {
            ArrayList<String> path = new ArrayList<>();
            path.add(processed);
            return path;
        }
        ArrayList<String> pathsIncludingDiagonal = new ArrayList<>();

        // For diagonal
        if(r > 1 && c > 1) {
            pathsIncludingDiagonal.addAll(printMazePathsDiagonals(processed + "D", r - 1, c - 1));
        }
        // For Bottom
        if(r > 1) {
            pathsIncludingDiagonal.addAll(printMazePathsDiagonals(processed + "B", r - 1, c));
        }

        if(c > 1) {
            pathsIncludingDiagonal.addAll(printMazePathsDiagonals(processed + "R", r, c - 1));
        }

        return pathsIncludingDiagonal;
    }

    public static void printMazePaths(String processed, int row, int col) {
        if(row == 1 && col == 1) {
            System.out.println(processed);
            return;
        }
        if(row > 1) {
            printMazePaths(processed + "D", row - 1, col);
        }
        if(col > 1) {
            printMazePaths(processed + "R", row, col - 1);
        }

    }
}
