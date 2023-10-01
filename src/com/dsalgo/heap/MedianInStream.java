package com.dsalgo.heap;

import java.util.Collections;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
public class MedianInStream {
    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 11, 12};
        System.out.println(median(arr));
    }

    /**
     * Using priority queue: We can use a max heap on the left side to represent elements that are less than
     * effective median, and a min-heap on the right side to represent elements that are greater
     * than effective median.
     *
     * After processing an incoming element, the number of elements in heaps differs utmost by
     * 1 element. When both heaps contain the same number of elements, we pick the average of
     * heaps root data as effective median. When the heaps are not balanced, we select effective
     * median from the root of the heap containing more elements.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static double median(int[] arr) {
        PriorityQueue<Double> g = new PriorityQueue<>();
        PriorityQueue<Double> s = new PriorityQueue<>();
        double median = 0d;
        for (int i = 0; i < arr.length; i++) {

            // Negation for treating it as max heap
            s.add(-1.0 * arr[i]);
            g.add(-1.0 * s.poll());
            if (g.size() > s.size())
                s.add(-1.0 * g.poll());

            if (g.size() != s.size())
                median = -1.0 * s.peek();
            else
                median = (g.peek() - s.peek()) / 2;
        }
        return median;
    }
}
