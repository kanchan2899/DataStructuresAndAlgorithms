package com.dsalgo.grokking.patterns.two.heaps;

import java.util.*;

// https://www.geeksforgeeks.org/median-of-sliding-window-in-an-array/
public class SlidingWindowMedian {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, -1, 0, 5, 8};
        int k = 4;
        System.out.println(Arrays.toString(slidingWindowMedian(arr, k)));
    }

    private static double[] slidingWindowMedian(int[] arr, int k) {
        // to store the medians
        List<Double> medians = new ArrayList<>();

        // to keep track of the numbers that need to be removed from the heaps
        HashMap<Integer, Integer> outgoingNumber = new HashMap<>();

        // max-heap
        PriorityQueue<Integer> smallList = new PriorityQueue<>(Collections.reverseOrder());

        // min-heap
        PriorityQueue<Integer> largeList = new PriorityQueue<>();

        // initialize the max heap
        for(int i = 0; i < k; i++) {
            smallList.offer(arr[i]);
        }

        // transfer the top 50% of the numbers from max-heap to min-heap
        for(int i = 0; i < k / 2; i++) {
            largeList.offer(smallList.poll());
        }

        // variable to keep the heaps balanced
        int balance = 0;

        int i = k;
        while (true) {
            // if the window size is odd
            if((k & 1) == 1) {
                medians.add((double) (smallList.peek()));
            } else {
                medians.add((double) (smallList.peek() + largeList.peek()) * 0.5);
            }

            // break the loop if all elements have been processed
            if(i >= arr.length) {
                break;
            }

            // outgoing number
            int outNum = arr[i - k];

            // incoming number
            int inNum = arr[i];
            i++;

            // if the outgoing number is from max-heap
            if(outNum <= smallList.peek()) {
                balance -= 1;
            } else {
                balance += 1;
            }
            // add/update the outgoing number in the hash map
            if(outgoingNumber.containsKey(outNum)) {
                outgoingNumber.put(outNum, outgoingNumber.get(outNum) + 1);
            } else {
                outgoingNumber.put(outNum, 1);
            }

            // if the incoming number is less than the top of the max heap, add it in that heap
            // otherwise, add it in the min heap
            if(smallList.size() > 0 && inNum <= smallList.peek()) {
                balance += 1;
                smallList.offer(inNum);
            } else {
                balance -= 1;
                largeList.offer(inNum);
            }

            // re-balance the heap
            if(balance < 0) {
                smallList.offer(largeList.poll());
            } else if (balance > 0){
                largeList.offer(smallList.poll());
            }

            // since the heaps have been rebalanced, we reset the balance variable to 0
            // this ensures that the two heaps contain the correct elements for the calculations
            // to be performed on the elements in the next window.
            balance = 0;

            // remove invalid numbers present in the hash map from top of max-heap
            while (smallList.size() > 0 && outgoingNumber.containsKey(smallList.peek()) &&
            outgoingNumber.get(smallList.peek()) > 0) {
                outgoingNumber.put(smallList.peek(), outgoingNumber.get(smallList.poll()) - 1);
            }

            // remove invalid numbers present in the hash map from top of min-heap
            while (largeList.size() > 0 && outgoingNumber.containsKey(largeList.peek())
                    && outgoingNumber.get(largeList.peek()) > 0) {
                outgoingNumber.put(largeList.peek(), outgoingNumber.get(largeList.poll()) - 1);
            }
        }
        double[] mediansArr = medians.stream().mapToDouble(Double::doubleValue).toArray();
        return mediansArr;
    }
}
