package com.dsalgo.maths;

public class DivideAndSubtractGame {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(divAndSub(n));
    }
    static String divAndSub(int n) {
        if(n == 1) {
            return "Arya";
        }
        if(n < 5) {
            return "Jon";
        }

        int[] a = new int[n+1];

        for(int i = 1; i <= 5; i++) {
            a[i] = 1;
        }

        for(int i = 6; i <= n; i++) {
            if(a[i/2] == 0) {
                a[i] = 1;
            } else if(a[i-2] == 0) {
                a[i] = 1;
            }

            if(a[i/3] == 0) {
                a[i] = 1;
            } else if(a[i-3] == 0) {
                a[i] = 1;
            }

            if(a[i/4] == 0) {
                a[i] = 1;
            } else if(a[i-4] == 0) {
                a[i] = 1;
            }
            if(a[i/5] == 0) {
                a[i] = 1;
            } else if(a[i-5] == 0) {
                a[i] = 1;
            }
        }

        if(a[n] == 1) {
            return "Jon";
        }
        return "Arya";
    }
}
