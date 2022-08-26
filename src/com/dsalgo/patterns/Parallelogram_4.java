package com.dsalgo.patterns;
/*
      1
    2 1 2
  3 2 1 2 3
4 3 2 1 2 3 4
  3 2 1 2 3
    2 1 2
      1
 */
public class Parallelogram_4 {
    public static void main(String[] args) {
        int n = 6;
        triangle(n);
    }

    private static void triangle(int n) {
        for(int row = 1; row <= 2 * n - 1; row++){
            int col = row >= n ? 2 * n - row : row;
            for(int i = 1; i <= 2 * (n - col); i++){
                System.out.print(" ");
            }
            for(int i = col; i >= 1; i--){
                System.out.print(i + " ");
            }
            for (int i = 2; i <= col; i++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
