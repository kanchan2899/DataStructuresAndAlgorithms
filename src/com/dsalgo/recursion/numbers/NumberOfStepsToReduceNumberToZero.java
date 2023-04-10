package com.dsalgo.recursion.numbers;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
public class NumberOfStepsToReduceNumberToZero {
    public static void main(String[] args) {
        int[] n = {14, 8, 123};
        for (int num: n) {
            System.out.println(numberOfSteps1(num));
            System.out.println(numberOfSteps2(num));
        }
    }

    private static int numberOfSteps2(int num) {
        return helper(num, 0);
    }

    private static int helper(int num, int steps) {
        if(num == 0)
            return steps;
        if(num % 2 == 0)
            return helper(num/2, steps+1);
        return helper(num - 1, steps+1);
    }

    public static int numberOfSteps1(int num) {
        if(num == 0)
            return 0;
        int mod = num % 2;
        if(mod == 0){
            return 1 + numberOfSteps1(num / 2);
        }
        else {
           return 1 + numberOfSteps1(num - 1);
        }
    }
}
