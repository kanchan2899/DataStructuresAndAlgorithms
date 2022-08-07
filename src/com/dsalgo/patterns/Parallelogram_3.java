package com.dsalgo.patterns;

/*

   *
  * *
 *   *
*     *
 *   *
  * *
   *

 */

public class Parallelogram_3 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int row = 1; row <= 2 * n - 1; row++){
            int spaces = row <= n ? n - row : row - n;
            int col = row <= n ? (2 * (row - 1) + 1) : 2 * (2 * n - row) - 1;
            for (int s = 1; s <= spaces; s++) {
                System.out.print(" ");
            }
            for (int column = 1; column <= col; column++) {
                if(column == 1 || column == col){
                    System.out.print("*");
                }
                if(column != 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
