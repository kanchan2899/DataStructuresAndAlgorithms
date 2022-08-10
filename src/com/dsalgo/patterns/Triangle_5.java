package com.dsalgo.patterns;
/*
Here outer for loop will run n times
For every row, spaces should be n - row and col should be row

      *
    * *
  * * *
* * * *

*/

public class Triangle_5 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int row = 1; row <= n; row++){
            int spaces = n - row;
            for(int s = 1; s <= spaces; s++){
                System.out.print("  ");
            }
            for( int column = 1; column <= row; column++){
                System.out.print("*");
                if(column != row){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
