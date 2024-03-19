package com.dsalgo.grokking.patterns.know.what.to.track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/design-tic-tac-toe/
public class DesignTicTacToe {
    List<Integer> rows;
    List<Integer> cols;

    int diagonal;
    int antiDiagonal;

    // TicTacToe class contains rows, cols, diagonal, and anti_diagonal to create a board.
    // Constructor is used to create board of size n * n
    public DesignTicTacToe(int n) {
        this.rows = new ArrayList<>(Collections.nCopies(n, 0));
        this.cols = new ArrayList<>(Collections.nCopies(n, 0));
        this.diagonal = 0;
        this.antiDiagonal = 0;
    }

    // move function will allow the players to play the game by placing their mark at the row
    // and col of their choice
    public int move(int row, int col, int player) {
        int currentPlayer = -1;

        if(player == 1) {
            currentPlayer = 1;
        }

        int n = rows.size();

        rows.set(row, rows.get(row) + currentPlayer);
        cols.set(col, cols.get(col) + currentPlayer);

        if(row == col) {
            diagonal += currentPlayer;
        }
        if(col == (n - row - 1)) {
            antiDiagonal += currentPlayer;
        }

        if(Math.abs(rows.get(row)) == n ||
                Math.abs(cols.get(col)) == n ||
                Math.abs(diagonal) == n || Math.abs(antiDiagonal) == n){
            return player;
        }
        return 0;
    }

}
