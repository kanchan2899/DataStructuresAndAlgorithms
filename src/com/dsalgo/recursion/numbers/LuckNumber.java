package com.dsalgo.recursion.numbers;

// https://practice.geeksforgeeks.org/problems/lucky-numbers2911/1
public class LuckNumber {
    public static void main(String[] args) {
        int n = 5;
        System.out.println("Is " + n + " a lucky Number?: " + isLucky(n));
    }
    public static boolean isLucky(int n) {
        return helper(n, 2);
    }
    static boolean helper(int n, int counter) {
        if(counter > n) {
            return true;
        }

        if(n % counter == 0) {
            return false;
        }

        n = n - (n / counter);
        return helper(n, counter + 1);
    }
}
