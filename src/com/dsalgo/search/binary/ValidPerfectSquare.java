package com.dsalgo.search.binary;


// https://leetcode.com/problems/valid-perfect-square/
public class ValidPerfectSquare {
    public static void main(String[] args) {
        int x = 808201;
        System.out.println("Is num " + x + " a perfect square?: " + isPerfectSquare(x));
    }
    public static boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        long start = 2;
        long end = num;
        while(start < end){
            long mid = start + (end - start)/2;
            System.out.println("mid is " + mid);
            long sqrt = (mid * mid);
            System.out.println("sqrt is " + sqrt);
            if(sqrt == num) {
                System.out.println("In first if");
                return true;
            }
            if(sqrt > num){
                System.out.println("In second if");
                end = mid;
            }
            else {
                System.out.println("In else");
                start = mid + 1;
            }
        }
        System.out.println("Out of loop");
        return false;
    }
}
