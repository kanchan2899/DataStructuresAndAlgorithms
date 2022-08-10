package com.dsalgo.patterns;
/*
    1
   1 1
  1 2 1
 1 3 3 1
1 4 6 4 1

 */
public class Triangle_14 {
    public static void main(String[] args) {
        int n = 5;
        printPascalTriangle1(n);
        printPascalTriangle2(n);
    }

    private static void printPascalTriangle2(int n) {
        for(int row = 1; row <= n; row++){
            for(int space = 1; space <= n - row; space++){
                System.out.print(" ");
            }
            int c = 1;
            for(int col = 1; col <= row; col++){
                System.out.print(c + " ");
                c = c * (row - col) / col;
            }
            System.out.println();
        }
    }

    private static void printPascalTriangle1(int n) {
        for(int row = 0; row < n; row++){
            for(int space = 1; space < n - row; space++){
                System.out.print(" ");
            }
            for(int col = 0; col <= row; col++){
                int x = factorial(row) / (factorial(row - col) * factorial(col));
                System.out.print(x);
                if(col != row){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private static int factorial(int n) {
        if(n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }
}
