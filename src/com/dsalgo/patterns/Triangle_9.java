package com.dsalgo.patterns;

/*
Here outer for loop will run n times
For every row, spaces should be n - r and col should be r - 1

   *
  * *
 * * *
* * * *

*/

public class Triangle_9 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }
    private static void printPattern(int n) {
        for(int row = 1; row <= n; row++){
            for(int s = 1; s <= (n - row); s++){
                System.out.print(" ");
            }
            for(int column = 1; column <= row; column++){
                System.out.print("*");
                if(column != row){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
