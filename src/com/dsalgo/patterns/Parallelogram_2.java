package com.dsalgo.patterns;
/*
Here outer for loop will run n times
For every row, spaces should be n - r and col should be 2 * n - 1

    *********
   *********
  *********
 *********
*********

*/

public class Parallelogram_2 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }
    private static void printPattern(int n) {
        for (int row = 1; row <= n; row++) {
            int col = 2 * n - 1;
            int spaces = n - row;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int column = 1; column <= col; column++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
