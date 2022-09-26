package com.dsalgo.maths;

import java.util.ArrayList;

public class FactorsOfNumber {
    public static void main(String[] args) {
        int n = 20;
        factors(n);
        System.out.println();
        factors1(n);
        System.out.println();
        factors2(n);
        System.out.println();
        factors3(n);
    }

    private static void factors3(int n) {
        ArrayList<Integer>  list = new ArrayList<>();
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                if(n / i == i) {
                    System.out.print(i + " ");
                } else {
                    System.out.print(i + " ");
                    list.add(n/i);
                }
            }
        }
        for (int i = list.size() - 1; i >= 0; i-- ) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static void factors1(int n) {
        for(int i = 1; i * i <= n; i++) {
            if(n % i == 0) {
                if(n/i == i){
                    System.out.print(i + " ");
                }
                System.out.print(i + " ");
                System.out.print(n / i + " ");
            }
        }
    }

    private static void factors2(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                if(n/i == i){
                    System.out.print(i + " ");
                }
                System.out.print(i + " ");
                list.add(n/i);
            }
        }
        for(int i = list.size() - 1; i >= 0; i--) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static void factors(int n) {
        for(int i = 1; i <= n; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
            }
        }
    }
}
