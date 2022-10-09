package com.dsalgo.recursion.backtracking;

public class MazePaths {
    public static void main(String[] args) {
        printMazePaths("", 3, 3);

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
