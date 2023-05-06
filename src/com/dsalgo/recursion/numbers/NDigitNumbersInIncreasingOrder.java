package com.dsalgo.recursion.numbers;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1
public class NDigitNumbersInIncreasingOrder {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(increasingNumbers(n));
    }

    // Not working
    static List<Integer> increasingNumbers(int n){
        List<Integer> numbers = new ArrayList<>();
        if(n == 1) {
            for(int i = 0; i <= 9; i++) {
                numbers.add(i);
            }
        } else {
            helper(n, 1, 0, numbers);
        }
        return numbers;
    }

    private static List<Integer> helper(int n, int start, int currentNum, List<Integer> numbers) {
        if(n == 0) {
            numbers.add(currentNum);
            return numbers;
        }
        for(int i = start; i <= 9; i++) {
            int c = currentNum * 10 + i;
            helper(n - 1, start + 1, c, numbers);
        }
        return numbers;
    }

}
