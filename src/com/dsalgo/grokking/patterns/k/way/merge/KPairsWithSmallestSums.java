package com.dsalgo.grokking.patterns.k.way.merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSums {
    static class Pair {
        int sum;
        int i;
        int j;

        public Pair(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }

    public static void main(String[] args) {
        int[][] list1 = {{2, 8, 9},
                {1, 2, 300},
                {1, 1, 2},
                {4, 6},
                {4, 7, 9},
                {1, 1, 2}};

        int[][] list2 = {
                {1, 3, 6},
                {1, 11, 20, 35, 300},
                {1, 2, 3},
                {2, 3},
                {4, 7, 9},
                {1}};

        int[] k = {9, 30, 1, 2, 5, 4};

        for(int i=0; i<k.length; i++){
            List<List<Integer>> result = kSmallestPairs(list1[i], list2[i], k[i]);
            System.out.println("Pairs with smallest sum are: "+ result);
        }
    }

    private static List<List<Integer>> kSmallestPairs(int[] list1, int[] list2, int k) {
        List<List<Integer>> pairs = new ArrayList<>();

        // storing the length of lists to use it in a loop later
        int listLength = list1.length;

        // declare a min-heap to keep track of the smallest sums
        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> a.sum - b.sum);

        // iterate over the length of list1
        for(int i = 0; i < Math.min(k, listLength); i++) {
            // computing sum of pairs all elements of list1 with first index of list2 and placing
            // it in the min-heap
            minHeap.add(new Pair(list1[i] + list2[0], i, 0));
        }

        int counter = 1;

        // iterate over elements of min-heap and only go upto k
        while (!minHeap.isEmpty() && counter <= k) {
            // placing sum of the top element of min-heap and its corresponding pairs in i and j
            Pair pair = minHeap.poll();

            int i = pair.i;
            int j = pair.j;

            // add pairs with the smallest sum in the new list
            pairs.add(Arrays.asList(list1[i], list2[j]));

            // increment the index for 2nd list, as we've compared all possible pairs with the 1st
            // index of list2
            int nextElement = j + 1;

            // if next element is available for list2 then add it to the heap
            if(list2.length > nextElement) {
                minHeap.add(new Pair(list1[i] + list2[nextElement], i, nextElement));
            }
            counter++;
        }

        return pairs;
    }
}
