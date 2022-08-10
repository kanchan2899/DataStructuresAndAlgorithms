package com.dsalgo.patterns;
/*
Here outer for loop will run n times
For every row, spaces should be r - 1 and col should be 2 * n - 2 * r + 1

* * * * * * *
  * * * * *
    * * *
      *

*/

public class Triangle_8 {
    public static void main(String[] args) {
        int n = 4;
        printPattern(n);
    }
    private static void printPattern(int n) {
        for(int row = 1; row <= n; row++){
            for(int s = 1; s <= (row - 1); s++){
                System.out.print("  ");
            }
            for(int column = 1; column <= ((2 * n) - (2 * row) + 1); column++){
                System.out.print("*");
                if(column != ((2 * n) - (2 * row) + 1)){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
