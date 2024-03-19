package com.dsalgo.grokking.patterns.k.way.merge;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/find-m-th-smallest-value-in-k-sorted-arrays/
public class KthSmallestElementInMSortedLists {
    public static void main(String[] args) {
        List<List<Integer>> lists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 15),
                Arrays.asList(10, 11, 12, 13),
                Arrays.asList(5, 10));
        int k = 50;

        System.out.println(kthSmallest(lists, k));
    }

    private static int kthSmallest(List<List<Integer>> lists, int k) {
        int listLength = lists.size();

        // declare a min-heap to keep track of smallest elements
        PriorityQueue<int[]> kthSmallest = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(int i = 0; i < listLength; i++) {
            // if there are no elements in the input lists, continue
            if(lists.get(i).size() == 0) {
                continue;
            } else {
                // placing the first element of each list in the min-heap
                kthSmallest.offer(new int[] {lists.get(i).get(0), i, 0});
            }
        }

        // set a counter to match if our kth element equals to that counter, return that number
        int numbersChecked = 0, smallestNumber = 0;

        // iterating over the elements pushed in the min-heap
        // get the smallest number from top of the heap and its corresponding list and index
        while (!kthSmallest.isEmpty()) {
            int[] smallest = kthSmallest.poll();
            smallestNumber = smallest[0];
            int listIndex = smallest[1];
            int numIndex = smallest[2];
            numbersChecked++;

            if(numbersChecked == k) {
                break;
            }

            // if there are more elements in list of the top element, add the next element
            // of that list to the min-heap
            if(numIndex + 1 < lists.get(smallest[1]).size()) {
                kthSmallest.offer(new int[] {lists.get(listIndex).get(numIndex + 1), listIndex, numIndex + 1});
            }
        }

        return smallestNumber;

    }
}
