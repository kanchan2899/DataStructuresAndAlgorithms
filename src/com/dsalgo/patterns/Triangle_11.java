package com.dsalgo.patterns;
/*
Here outer for loop will run n times
For every row, spaces should be n - r + 1 and col should be r - 1

* * * *
 * * *
  * *
   *
  * *
 * * *
* * * *

*/

public class Triangle_11 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }
    private static void printPattern(int n) {
        for (int row = 1; row <= 2 * n - 1; row++) {
            int col = row <= n ? n - row + 1 : row - n + 1;
            int spaces = row <= n ? row - 1 : 2 * n - row - 1;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int column = 1; column <= col; column++) {
                System.out.print("*");
                if (column != col) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
