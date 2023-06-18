package com.dsalgo.recursion.numbers;

import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/josephus-problem/1
public class JosephusProblem {
    public static void main(String[] args) {
        int n = 5, k = 3;
        System.out.println(josephus(n, k));
    }

    public static int josephus(int n, int k) {
        if(n == 1) {
            return 0;
        }
        return (josephus(n - 1, k) + k) % n;
    }

}
