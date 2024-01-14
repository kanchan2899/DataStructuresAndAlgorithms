package com.dsalgo.grokking.patterns.sliding.window;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int maxCurr = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCurr = Math.max(0, maxCurr += prices[i] - prices[i - 1]);
            maxSoFar = Math.max(maxCurr, maxSoFar);
        }

        return maxSoFar;
    }
}
