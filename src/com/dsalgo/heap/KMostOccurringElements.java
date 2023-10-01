package com.dsalgo.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
public class KMostOccurringElements {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};
        int k = 2;
        System.out.println(kMostFrequent(arr, arr.length, k));
    }
    static int kMostFrequent(int arr[], int n, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(Map.Entry<Integer, Integer> m : map.entrySet()) {
            pq.add(m.getValue());
        }
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += pq.poll();
        }

        return sum;
    }
}
