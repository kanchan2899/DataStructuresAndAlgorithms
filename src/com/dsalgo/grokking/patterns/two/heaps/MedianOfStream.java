package com.dsalgo.grokking.patterns.two.heaps;

import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/median-of-stream-of-integers-running-integers/
public class MedianOfStream {
    PriorityQueue<Integer> maxHeapForSmallNum;  // contains first half of numbers
    PriorityQueue<Integer> minHeapForLargeNum;  // contains second half of numbers

    public MedianOfStream() {
        maxHeapForSmallNum = new PriorityQueue<>((a, b) -> b - a);
        minHeapForLargeNum = new PriorityQueue<>((a, b) -> a - b);
    }

    public void insertNum(int num) {
        if(maxHeapForSmallNum.isEmpty() || maxHeapForSmallNum.peek() >= num) {
            maxHeapForSmallNum.add(num);
        } else {
            minHeapForLargeNum.add(num);
        }

        // either both the heaps will have equal number of elements or max-heap will have one more
        // element than the min-heap
        if (maxHeapForSmallNum.size() > minHeapForLargeNum.size() + 1) {
            minHeapForLargeNum.add(maxHeapForSmallNum.poll());
        } else if (maxHeapForSmallNum.size() < minHeapForLargeNum.size()){
            maxHeapForSmallNum.add(minHeapForLargeNum.poll());
        }
    }

    public double findMedian() {
        if(maxHeapForSmallNum.size() == minHeapForLargeNum.size()) {
            // we have even number of elements, take the average of middle two elements
            return (maxHeapForSmallNum.peek() / 2.0) + (minHeapForLargeNum.peek() / 2.0);
        }
        // because max-heap will have one more element than the min-heap
        return maxHeapForSmallNum.peek();
    }

    public static void main(String[] args) {
        int[] nums = {35, 22, 30, 25, 1, 20};
        MedianOfStream medianOfStream = null;

        for(int i = 0; i < nums.length; i++) {
            medianOfStream = new MedianOfStream();
            for(int j = 0; j <= i; j++) {
                if(j != i) {
                    medianOfStream.insertNum(nums[j]);
                }
            }
            System.out.println(medianOfStream.findMedian());
        }


    }
}
