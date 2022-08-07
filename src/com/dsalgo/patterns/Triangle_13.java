package com.dsalgo.patterns;

/*
Here outer for loop will run n times
For every row, spaces should be n - r and col should be 2 * (row - 1) + 1

*********
 *     *
  *   *
   * *
    *
*/

public class Triangle_13 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }
    private static void printPattern(int n) {
        for (int row = 1; row <= n; row++) {
            int col = 2 * (n - row) + 1;
            int spaces = row - 1;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int column = 1; column <= col; column++) {
                if(row == 1){
                    System.out.print("*");
                } else {
                    if(column == 1 || column == col){
                        System.out.print("*");
                    }
                    if(column != 1){
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }
    }
}
