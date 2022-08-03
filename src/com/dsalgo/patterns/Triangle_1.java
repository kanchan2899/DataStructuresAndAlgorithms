package com.dsalgo.patterns;
/*
Here outer for loop will run 5 times
For every row, number of columns  = row number

*
* *
* * *
* * * *
* * * * *

*/
public class Triangle_1 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int row = 1; row <= n; row++){
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
