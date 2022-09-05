package com.dsalgo.recursion;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NumberOfStepsToReduceNumberToZero {
    public static void main(String[] args) {
        int[] n = {14, 8, 123};
        for (int num: n) {
            System.out.println(numberOfSteps(num));
        }
    }
    public static int numberOfSteps(int num) {
        if(num == 0)
            return 0;
        int mod = num % 2;
        if(mod == 0){
            return 1 + numberOfSteps(num / 2);
        }
        else {
           return 1 + numberOfSteps(num - 1);
        }
    }
}
