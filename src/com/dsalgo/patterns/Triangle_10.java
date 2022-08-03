package com.dsalgo.patterns;
/*
Here outer for loop will run n times
For every row, spaces should be n - r + 1 and col should be r - 1

* * * *
 * * *
  * *
   *

*/

public class Triangle_10 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }
    private static void printPattern(int n) {
        for(int row = 1; row <= n; row++){
            for(int s = 1; s <= (row - 1); s++){
                System.out.print(" ");
            }
            for(int column = 1; column <= n - row + 1; column++){
                System.out.print("*");
                if(column != n - row + 1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
