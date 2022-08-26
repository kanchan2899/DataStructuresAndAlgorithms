package com.dsalgo.patterns;

/*
      1
    2 1 2
  3 2 1 2 3
4 3 2 1 2 3 4

*/
public class Triangle_15 {
    public static void main(String[] args) {
        int n = 6;
        triangle(n);
    }

    private static void triangle(int n) {
        for(int row = 1; row <= n; row++){
            for(int i = 1; i <= 2 * (n - row); i++){
                System.out.print(" ");
            }
            for(int i = row; i >= 1; i--){
                System.out.print(i + " ");
            }
            for (int i = 2; i <= row; i++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
