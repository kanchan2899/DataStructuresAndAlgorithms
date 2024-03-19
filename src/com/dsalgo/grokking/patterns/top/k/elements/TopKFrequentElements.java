package com.dsalgo.grokking.patterns.top.k.elements;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/description/
public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }

    static public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // find frequency of each element
        for(int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> topKElements = new PriorityQueue<>(
                (e1, e2) -> e1.getValue() - e2.getValue());


        // go through all numbers of the frequency map and push them into topKElements, which will have
        // the top k frequent numbers. If the heap size is more than k, remove the smallest (top) number

        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            topKElements.add(entry);
            if(topKElements.size() > k) {
                topKElements.poll();
            }
        }

        // create a list of top k elements
        int[] topNumbers = new int[k];
        int i = k - 1;

        while (!topKElements.isEmpty()) {
            topNumbers[i--] = topKElements.poll().getKey();
        }

        return topNumbers;
    }
}
