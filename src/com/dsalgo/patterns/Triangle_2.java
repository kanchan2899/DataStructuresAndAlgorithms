package com.dsalgo.patterns;
/*
Here outer for loop will run N times
For every row, number of columns  = N - row

* * * * *
* * * *
* * *
* *
*

*/
public class Triangle_2 {
    public static void main(String[] args) {
        int n = 6;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int row = 1; row <= n; row++){
            for(int col = 1; col <= n-row+1; col++){
                System.out.print("*");
                if(col != n-row+1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}
