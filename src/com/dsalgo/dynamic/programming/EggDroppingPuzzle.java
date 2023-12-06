package com.dsalgo.dynamic.programming;

// https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
public class EggDroppingPuzzle {
    public static void main(String[] args) {
        int eggs = 2;
        int floors = 10;
        System.out.println(eggsPuzzle(eggs, floors));
        System.out.println(eggsPuzzle1(eggs, floors));
    }

    private static int eggsPuzzle1(int eggs, int floors) {
        int[][] dp = new int[floors + 1][eggs + 1];
        for(int i = 1; i <= eggs; i++) {
            dp[1][i] = 1;
            dp[0][i] = 0;
        }

        for(int j = 1; j <= floors; j++) {
            dp[j][1] = j;
        }

        for(int i = 2; i <= floors; i++) {
            for(int j = 2; j <= eggs; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for(int x = 1; x <= i; x++) {
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x - 1][j - 1], dp[i - x][j]));
                }
            }
        }
        return dp[floors][eggs];
    }

    /**
     * Using recursion: The solution is to try dropping an egg from every floor(from 1 to K) and
     * recursively calculate the minimum number of droppings needed in the worst case. The floor
     * which gives the minimum value in the worst case is going to be part of the solution.
     * In the following solutions, we return the minimum number of trials in the worst case;
     * these solutions can be easily modified to print the floor numbers of every trial also.
     *
     * What is worst case scenario?
     * Worst case scenario gives the user the surety of the threshold floor. For example- If we
     * have ‘1’ egg and ‘K’ floors, we will start dropping the egg from the first floor till the
     * egg breaks suppose on the ‘Kth’ floor so the number of tries to give us surety is ‘K’.
     *
     *
     * 1. If the egg breaks after dropping from ‘xth’ floor, then we only need to check for floors
     * lower than ‘x’ with remaining eggs as some floors should exist lower than ‘x’ in which the egg
     * would not break, so the problem reduces to x-1 floors and n-1 eggs.
     * 2. If the egg doesn’t break after dropping from the ‘xth’ floor, then we only need to check for
     * floors higher than ‘x’; so the problem reduces to ‘k-x’ floors and n eggs.
     *
     *
     * @param eggs
     * @param floors
     * @return
     */
    private static int eggsPuzzle(int eggs, int floors) {
        // If there are no floors, then no trials needed.
        // OR if there is one floor, one trial needed.
        if(floors == 1 || floors == 0) {
            return floors;
        }

        if(eggs == 1) {
            return floors;
        }

        int min = Integer.MAX_VALUE;
        int x, trials;

        for(x = 1; x <= floors; x++) {
            trials = Math.max(eggsPuzzle(eggs - 1, x - 1), eggsPuzzle(eggs, floors - x));
            if(trials < min) {
                min = trials;
            }
        }
        return min + 1;
    }
}
