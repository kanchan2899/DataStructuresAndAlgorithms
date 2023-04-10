package com.dsalgo.recursion.maze;

import java.util.ArrayList;
import java.util.List;

public class MazePaths {
    public static void main(String[] args) {
        printMazePaths("", 3, 3);
        System.out.println();
        System.out.println(mazePaths("", 3, 3));
        System.out.println(printMazePathsDiagonals("", 3, 3));


    }

    // Can only go right and bottom and diagonally
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

        // For Right
        if(c > 1) {
            pathsIncludingDiagonal.addAll(printMazePathsDiagonals(processed + "R", r, c - 1));
        }

        return pathsIncludingDiagonal;
    }

    // Can only go right and down
    public static void printMazePaths(String processed, int row, int col) {
        if(row == 1 && col == 1) {
            System.out.print(processed + " ");
            return;
        }
        if(row > 1) {
            printMazePaths(processed + "D", row - 1, col);
        }
        if(col > 1) {
            printMazePaths(processed + "R", row, col - 1);
        }

    }

    // Can only go right and down
    public static List<String> mazePaths(String processed, int row, int col) {
        if(row == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> paths = new ArrayList<>();
        if(row > 1) {
            paths.addAll(mazePaths(processed + "D", row - 1, col));
        }
        if(col > 1) {
            paths.addAll(mazePaths(processed + "R", row, col - 1));
        }
        return paths;
    }
}
