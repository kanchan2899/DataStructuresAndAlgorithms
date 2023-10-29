package com.dsalgo.greedy;

import java.util.Arrays;

// https://www.geeksforgeeks.org/fractional-knapsack-problem/
public class FractionalKnapSack {

    static class Item implements Comparable<Item> {
        int weight;
        int value;

        Item(int w, int v) {
            this.weight = w;
            this.value = v;
        }

        @Override
        public int compareTo(Item i) {
            return (this.weight * i.value) - (value * i.weight);
        }
    }
    public static void main(String[] args) {
        Item[] arr = {new Item(10, 60), new Item(40, 40), new Item(20, 100), new Item(30, 120)};
        int knapsack_capacity = 50;
        System.out.println(fractionalKnapSack(arr, knapsack_capacity));
    }

    /**
     *
     * Using greedy approach
     *
     * 1. Calculate the ratio (profit/weight) for each item.
     * 2. Sort all the items in decreasing order of the ratio.
     * 3. Initialize res = 0, curr_cap = given_cap.
     * 4. Do the following for every item i in the sorted order:
     *      - If the weight of the current item is less than or equal to the remaining capacity
     *      then add the value of that item into the result
     *      - Else add the current item as much as we can and break out of the loop.
     * 5. Return res.
     *
     * TC: O(n * log n)
     * SC: O(1)
     *
     * @param arr
     * @param knapsack_capacity
     * @return
     */
    private static double fractionalKnapSack(Item[] arr, int knapsack_capacity) {
        Arrays.sort(arr);
        double maxValue = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i].weight <= knapsack_capacity) {
                maxValue += arr[i].value;
                knapsack_capacity -= arr[i].weight;
            } else {
                maxValue += arr[i].value * (double)(knapsack_capacity / arr[i].weight);
                break;
            }
        }
        return maxValue;
    }
}
