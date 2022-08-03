package com.dsalgo.patterns;
/*
Here outer for loop will run 2N - 1 times
If row number is less than equal to N, columns  = row number
Else column = 2*N - row number

*
* *
* * *
* * * *
* * * * *
* * * *
* * *
* *
*

*/
public class Triangle_4 {
    public static void main(String[] args) {
        int n = 5;
        printPattern(n);
    }

    private static void printPattern(int n) {
        for(int row = 1; row <= 2*n - 1; row++){
            int x = row <= n ? row : 2 * n - row;
            for(int col = 1; col <= x; col++){
                System.out.print("*");
                 if(col != x){
                    System.out.print(" ");
                 }
            }
//            for (int col = 1; col <= x; col++){
//                System.out.print("*");
//                 if(col != 2*n - 1){
//                    System.out.print(" ");
//                 }
//            }

            System.out.println();
        }
    }
}
