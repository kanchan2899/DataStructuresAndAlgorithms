package com.dsalgo.patterns;
/*
Here outer for loop will run N times
For every row, number of columns  = N

    *
   * *
  * * *
 * * * *
  * * *
   * *
    *

*/

public class Parallelogram_1 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int row = 1; row <= 2*n - 1; row++){
            int totalColsInRow = row > n ? 2 * n - row + 1 : row;
            int spaces = n - totalColsInRow + 1;
            for(int s = 1; s <= spaces; s++){
                System.out.print(" ");
            }
            for (int col = 1; col <= totalColsInRow - 1 ; col++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
