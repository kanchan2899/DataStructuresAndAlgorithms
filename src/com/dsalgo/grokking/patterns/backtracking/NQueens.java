package com.dsalgo.grokking.patterns.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/n-queens/description/
public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(solveNQueens(n));
        System.out.println(solveNQueensIterative(n));
    }

    private static List<List<Integer>> solveNQueensIterative(int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> solution = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> solStack = new Stack<>();

        int row = 0;
        int col = 0;

        while (row < n) {
            // for the current state of the solution, check is a queen can be placed in any column
            // of this row
            while (col < n) {
                if(isValidMove(row, col, solution)) {
                    // if this is a safe position for a queen, save it to the current solution
                    // on the stack
                    solStack.push(col);
                    solution.set(row, col);
                    row++;
                    col = 0;
                    break;
                }
                col++;
            }
            // if we have checked all columns
            if(col == n) {
                // if we are working on a solution
                if(!solStack.isEmpty()) {
                    // backtracking, as current row does not offer a safe spot given the previous move,
                    // so get set up to check the previous row with the next column
                    col = solStack.peek() + 1;
                    solStack.pop();
                    row--;
                } else {
                    // if we backtracked all the way and found this to be a dead-end,break out of
                    // the inner loop as no more solutions exist
                    break;
                }
            }
            // if we have found a safe spot for a queen in each of the rows
            if(row == n) {
                // add the solution into results
                results.add(new ArrayList<>(solution));
                // backtrack to find the next solution
                row--;
                col = solStack.peek() + 1;
                solStack.pop();
            }
        }
        return results;
    }

    private static List<List<Integer>> solveNQueens(int n) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> solution = new ArrayList<>(Collections.nCopies(n, -1));
        solveNQueensRec(n, solution, 0, results);
        return results;
    }

    private static void solveNQueensRec(int n, List<Integer> solution, int row, List<List<Integer>> results) {
        if(row == n) {
            results.add(solution);
            return;
        }
        for(int i = 0; i < n; i++) {
            boolean valid = isValidMove(row, i, solution);
            if(valid) {
                solution.set(row, i);
                solveNQueensRec(n, solution, row + 1, results);
            }
        }
    }

    private static boolean isValidMove(int proposedRow, int proposedCol, List<Integer> solution) {
        int oldRow = 0, oldCol = 0, diagonalOffset = 0;
        for(int i = 0; i < proposedRow; i++) {
            oldRow = i;
            oldCol = solution.get(i);
            diagonalOffset = proposedRow - oldRow;

            if(oldCol == proposedCol || oldCol == proposedCol - diagonalOffset || oldCol == proposedCol + diagonalOffset) {
                return false;
            }
        }
        return true;
    }
}
