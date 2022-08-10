package com.dsalgo.patterns;
/*
Here outer for loop will run N times
For every row, number of columns  = N

* * * * *
* * * * *
* * * * *
* * * * *
* * * * *

*/


public class Square_1 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= n; col++){
                System.out.print("*");
                if(col != n){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
