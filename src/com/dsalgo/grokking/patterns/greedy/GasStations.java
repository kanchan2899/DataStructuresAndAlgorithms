package com.dsalgo.grokking.patterns.greedy;

import java.util.Arrays;

public class GasStations {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(gasStationJourney(gas, cost));
    }

    private static int gasStationJourney(int[] gas, int[] cost) {
        // check if it is possible to complete the journey based on total gas and cost
        if(Arrays.stream(cost).sum() > Arrays.stream(gas).sum()) {
            return  -1;
        }
        int currentGas = 0;
        int startingIndex = 0;

        // iterate over all gas stations in the list
        for(int i = 0; i < gas.length; i++) {
            // update current gas level by adding gas and subtracting cost at current station
            currentGas += gas[i] - cost[i];

            // if current gas level is negative, reset it to zero and update the starting index
            if(currentGas < 0) {
                currentGas = 0;
                startingIndex = i + 1;
            }
        }
        return startingIndex;
    }
}
