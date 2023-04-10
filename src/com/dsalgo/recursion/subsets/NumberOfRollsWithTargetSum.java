package com.dsalgo.recursion.subsets;

import java.util.Arrays;

public class NumberOfRollsWithTargetSum {
    public static void main(String[] args) {
        System.out.println(diceRolls(1, 6, 3));
        System.out.println(diceRolls(2, 6, 7));
        System.out.println(diceRollsWithMemoization(1, 6, 3));
        System.out.println(diceRollsWithMemoization(2, 6, 7));
        System.out.println(diceRollsWithMemoization(10, 5, 180));
    }



    private static int diceRollsWithMemoization(int dices, int faces, int target) {
        int[][] mem = new int[dices + 1][target + 1];
        for(int[] a: mem) {
            Arrays.fill(a, -1);
        }
        return helper(dices, faces, target, mem);
    }

    private static int helper(int dices, int faces, int target, int[][] mem) {
        if(target == 0 && dices == 0)
            return 1;
        if(target < 0 || dices == 0)
            return 0;
        if(mem[dices][target] != -1)
            return mem[dices][target];
        int count = 0;
        for(int i = 1; i <= faces; i++) {
            count = (count + helper(dices - 1, faces, target - i, mem)) % ((int) Math.pow(10, 9) + 7);
        }
        return mem[dices][target] = count;
    }

    private static int diceRolls(int dices, int faces, int target) {
        int m = (int) Math.pow(10, 9) + 7;
        if(dices == 0 && target == 0) {
            return 1;
        }
        if(dices == 0 && target != 0) {
            return 0;
        }
        int count = 0;

        for(int i = 1; i <= faces; i++) {
            count = (count + diceRolls(dices - 1, faces, target - i)) % m;
        }
        return count;
    }
}
