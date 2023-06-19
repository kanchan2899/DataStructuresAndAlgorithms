package com.dsalgo.arrays;

// https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1
public class StockBuyAndSell {
    public static void main(String[] args) {
        int[] stocks = {1, 5, 3, 8, 12};
        System.out.println(maxProfit(stocks, 0, stocks.length - 1));
        System.out.println(maxProfit1(stocks));
    }

    /**
     * The idea is to add the profit if the current element is greater than the previous element.
     *
     * TC: O(n)
     * TC: O(1)
     * @param stocks
     * @return
     */
    private static int maxProfit1(int[] stocks) {
        int profit = 0;
        for(int i = 1; i < stocks.length; i++) {
            if(stocks[i] > stocks[i - 1]) {
                profit += (stocks[i] - stocks[i-1]);
            }
        }
        return profit;
    }

    private static int maxProfit(int[] stocks, int start, int end) {
        if(end <= start) {
            return 0;
        }

        int profit = 0;

        for(int i = start; i < end; i++) {
            for(int j = i + 1; j <= end; j++) {
                if(stocks[j] > stocks[i]) {
                    int current_profit = stocks[j] - stocks[i]
                            + maxProfit(stocks, start, i - 1)
                            + maxProfit(stocks, j + 1, end);
                    profit = Math.max(profit, current_profit);
                }
            }
        }
        return profit;
    }
}
