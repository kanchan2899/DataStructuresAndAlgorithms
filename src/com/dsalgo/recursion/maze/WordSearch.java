package com.dsalgo.recursion.maze;

public class WordSearch {
    public static void main(String[] args) {
        char[][] matrix = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(wordSearch(matrix, word));
    }

    public static boolean wordSearch(char[][] board, String word) {
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                // Find the first letter and then call method to check its surroundings
                if(board[row][col] == word.charAt(0) && helper(board, word, 0, row, col)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, String word, int start, int row, int col) {
        if(word.length() <= start) {
            return true;
        }

        //If off bounds, letter is seen, letter is unequal to word.charAt(0) return false
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length
        || board[row][col] == '0' || board[row][col] != word.charAt(start)) {
            return false;
        }

        // Mark the position as visited
        char temp = board[row][col];
        board[row][col] = '0';

        // Recursion on all 4 sides for next letter, if works, return true
        if(helper(board, word, start + 1, row + 1, col) ||
           helper(board, word, start + 1, row - 1, col) ||
           helper(board, word, start + 1, row, col + 1) ||
           helper(board, word, start + 1, row, col - 1)) {
            return true;
        }
        // backtrack to reset the changes
        board[row][col] = temp;
        return false;
    }
}
