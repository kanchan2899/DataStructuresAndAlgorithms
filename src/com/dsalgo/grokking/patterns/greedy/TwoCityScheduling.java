package com.dsalgo.grokking.patterns.greedy;

import java.util.Arrays;

// https://leetcode.com/problems/two-city-scheduling/description/
public class TwoCityScheduling {
    public static void main(String[] args) {
        int[][] costs = {{259,770}, {448,54}, {926,667}, {184,139}, {840,118}, {577,469}};
        System.out.println(twoCityScheduling(costs));
    }

    private static int twoCityScheduling(int[][] costs) {
        // initialize the total cost to 0
        int totalCost = 0;

        // Sort the cost array in ascending order based on the difference between the costs of
        // sending someone to city A vs city B
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));

        // get the length of the costs array
        int costLength = costs.length;

        // for each pair of cities, add the cost of sending one person to city A and the other
        // person to city B to the total cost
        for(int i = 0; i < costLength / 2; i++) {
            totalCost += costs[i][0] + costs[costLength - i - 1][1];
        }
        return totalCost;
    }
}
