package com.dsalgo.patterns;
/*
Here outer for loop will run n times
For every row, spaces should be n - row and col should be 2 * row - 1

      *
    * * *
  * * * * *
* * * * * * *

*/

public class Triangle_7 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }
    private static void printPattern(int n) {
        for(int row = 1; row <= n; row++){
            for(int s = 1; s <= n - row; s++){
                System.out.print("  ");
            }
            for( int column = 1; column <= 2 * row - 1; column++){
                System.out.print("*");
                if(column != 2 * row - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
