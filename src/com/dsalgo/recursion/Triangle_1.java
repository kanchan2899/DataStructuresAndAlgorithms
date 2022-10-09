package com.dsalgo.recursion;
/*

* * * *
* * *
* *
*

 */
public class Triangle_1 {
    public static void main(String[] args) {
        int n = 5;
        triangle_1(n, 0);
        triangle_2(n, 0);
    }

    private static void triangle_2(int row, int col) {
        if(row == 0)
            return;
        if(col < row) {
            triangle_2(row, col + 1);
            System.out.print("* ");
        } else {
            triangle_2(row - 1, 0);
            System.out.println();
        }
    }

    private static void triangle_1(int row, int col) {
        if(row == 0)
            return;
        if(col < row) {
            System.out.print("* ");
            triangle_1(row, col + 1);
        } else {
            System.out.println();
            triangle_1(row - 1, 0);
        }
    }
}
