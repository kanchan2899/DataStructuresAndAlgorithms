package com.dsalgo.arrays;

import java.util.Arrays;

// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
public class AverageSalary {
    public static void main(String[] args) {
        int[] salary = {4000,3000,1000,2000};
        System.out.println(average(salary));
    }
    public static double average(int[] salary) {
        double sum = 0d;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int s : salary) {
            min = Math.min(min, s);
            max = Math.max(max, s);
            sum += s;
        }
        return (sum - min - max) / (salary.length - 2);
    }
}
