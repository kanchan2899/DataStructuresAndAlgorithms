package com.dsalgo.dynamic.programming;

import java.util.Arrays;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[][] prices = {{7,1,5,3,6,4}, {7,6,4,3,1}};
        for(int[] x: prices){
            System.out.println("Maximum profit for prices " + Arrays.toString(x) + " is " + maxProfit(x));
        }
    }
    public static int maxProfit(int[] prices) {
        /* Solution 1 - Brute Force - O(n * n)
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = prices.length - 1; j > i; j--)
            if(prices[j] - prices[i] > max){
                max = prices[j] - prices[i];
            }
        }
        return max;
        */

        // Solution 2 - Dynamic Programming
        int minSoFar = prices[0];
        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            if(minSoFar > prices[i]){
                minSoFar = prices[i];
            }
            int currentProfit = prices[i] - minSoFar;
            if(currentProfit > maxProfit){
                maxProfit = currentProfit;
            }
        }
        return maxProfit;
    }
}
