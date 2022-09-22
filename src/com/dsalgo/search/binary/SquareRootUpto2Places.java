package com.dsalgo.search.binary;

// https://www.geeksforgeeks.org/find-square-root-number-upto-given-precision-using-binary-search/
public class SquareRootUpto2Places {
    public static void main(String[] args) {
        int n = 40;
        int p = 3;
        System.out.println(sqrt(n, p));
    }

    private static double sqrt(int n, int p) {
        int s = 0;
        int e = n;
        double root = 0.0;
        while(s <= e) {
            int m = s + (e - s) / 2;
            if(m * m == n) {
                root = m;
                return root;
            }
            if(m * m > n) {
                e = m - 1;
            } else
                s = m + 1;
        }
        double increment = 0.1;
        for(int i = 0; i < p; i++){
            while (root * root <= n) {
                root += increment;
            }
            root -= increment;
            increment /= 10;
        }
        return root;
    }
}
