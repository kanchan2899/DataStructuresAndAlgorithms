package com.dsalgo.maths;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/print-pattern3549/1
public class PrintPattern {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(pattern(n));
    }
    static List<Integer> pattern(int n){
        List<Integer> list = new ArrayList<>();
        helper(n, list);
        return list;
    }

    static void helper(int n, List<Integer> list) {
        if(n <= 0) {
            list.add(n);
            return;
        }

        list.add(n);
        helper(n - 5, list);
        list.add(n);
    }
}
