package com.dsalgo.grokking.patterns.dynamic.programming;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change/
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 3, 4, 5};
        int total = 7;
        System.out.println(coinsChange(coins, total));
    }

    private static int coinsChange(int[] coins, int total) {
        if(total < 1) {
            return 0;
        }
        int[] counter = new int[total];
        Arrays.fill(counter, Integer.MAX_VALUE);
        return calculateMinimumCoins(coins, total, counter);
    }

    private static int calculateMinimumCoins(int[] coins, int rem, int[] counter) {
        int result = 0;
        if(rem < 0)
            return -1;
        if(rem == 0)
            return 0;
        if(counter[rem - 1] != Integer.MAX_VALUE)
            return counter[rem - 1];
        int minimum = Integer.MAX_VALUE;
        for (int j = 0; j < coins.length; j++)
        {
            result = calculateMinimumCoins(coins, rem - coins[j], counter);
            if(result >= 0 && result < minimum)
                minimum = 1 + result;
        }
        if(minimum != Integer.MAX_VALUE)
            counter[rem - 1] = minimum;
        else
            counter[rem - 1] = -1;
        return counter[rem -1];
    }
}
