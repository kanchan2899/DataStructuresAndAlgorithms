package com.dsalgo.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/find-k-closest-elements-given-value/
public class KClosestNumber {
    public static void main(String[] args) {
        int[] arr  = {10, 30, 32, 33, 36, 67};
        int x = 38;
        int k = 3;

        System.out.println(kClosestElements(arr, x, k));
        System.out.println(kClosestElements1(arr, x, k));
    }

    /**
     * Using priority Queue: This approach uses a priority queue (max heap) to maintain the k
     * closest numbers to x. It iterates over the elements in the array and calculates their
     * absolute differences from x. The pairs of absolute differences and negative values are
     * pushed into the max heap. If the size of the max heap exceeds k, the element with the
     * maximum absolute difference is removed. Finally, the top k elements from the max heap
     * are extracted and stored in a result vector. The vector is then reversed to obtain the
     * closest numbers in ascending order before being returned as the result.
     *
     * @param arr
     * @param x
     * @param k
     * @return
     */
    private static List<Integer> kClosestElements1(int[] arr, int x, int k) {
        List<Integer> kclosest = new ArrayList<>();
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>();

        for(int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - x);

            if(diff != 0) {
                maxHeap.add(new Pair(diff, i));
            }

            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        while (!maxHeap.isEmpty()) {
            kclosest.add(arr[maxHeap.poll().index]);
        }

        return kclosest;
    }

    /**
     *
     * Using a visited array: Initialize visited array as false. Start a loop till k, for k elements.
     * Initialize min_diff as max value and min_diff_index. Start an inner loop from 0 to n-1, check
     * if the absolute difference between current element and x is smaller than min_diff. If so,
     * update the min_diff and its index.
     *
     * If min_diff_index is not -1, add the min_diff_index to the list. Return list at the end
     *
     *
     *
     * TC: O(n * k)
     * SC: O(n)
     *
     * @param arr
     * @param x
     * @param k
     * @return
     */
    private static List<Integer> kClosestElements(int[] arr, int x, int k) {
        boolean[] visited = new boolean[arr.length];
        List<Integer> kClosest = new ArrayList<>();

        for(int i = 0; i < k; i++) {
            int min_diff = Integer.MAX_VALUE;
            int min_diff_index = -1;

            for(int j = 0; j < arr.length; j++) {
                if(!visited[j] && Math.abs(arr[j] - x) <= min_diff) {
                    min_diff = Math.abs(arr[j] - x);
                    min_diff_index = j;
                }
            }
            if(min_diff_index != -1) {
                kClosest.add(arr[min_diff_index]);
                visited[min_diff_index] = true;
            }
        }
        return kClosest;
    }
}

class Pair implements Comparable<Pair> {
    int absDiff;
    int index;

    Pair(int f, int s) {
        absDiff = f;
        index = s;
    }

    @Override
    public int compareTo(Pair o) {
        if(absDiff == o.absDiff) {
            return index - o.index;
        } else {
            return o.absDiff - absDiff;
        }
    }
}

