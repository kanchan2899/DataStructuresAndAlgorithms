package com.dsalgo.sort.bucket;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BucketSort {
    public static void main(String[] args) {
        int[] arr = {20, 88, 70, 85, 75, 95, 18, 82, 60};
        int buckets = 5;
        bucketSort(arr, buckets);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Bucket sort: It is mainly useful when input is uniformly distributed over a range. For eg,
     * sort a large set of floating point numbers which are in range from 0.0 to 1.0 and are uniformly
     * distributed across the range.
     *
     * Algorithm:
     * 1. Create n empty buckets (or lists)
     * 2. Do the following for every array element arr[i]
     *      a. Insert arr[i] into bucket[n * arr[i]]
     * 3. Sort individual buckets using insertion sort
     * 4. Concatenate all sorted buckets
     *
     * TC: O(n) if all numbers are uniformly distributed
     * @param arr
     * @param bucketsNum
     */
    private static void bucketSort(int[] arr, int bucketsNum) {
        int n = arr.length;
        int max_val = arr[0];

        for(int i = 1; i < n; i++) {
            max_val = Math.max(max_val, arr[i]);
        }

        max_val++;

        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>();

        for(int i = 0; i < bucketsNum; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < n; i++) {
            int bucketIndex = (bucketsNum * arr[i]) / max_val;
            buckets.get(bucketIndex).add(arr[i]);
        }

        for(int i = 0; i < bucketsNum; i++) {
            Collections.sort(buckets.get(i));
        }

        int index = 0;

        for(int i = 0; i < bucketsNum; i++) {
            for(int j = 0; j < buckets.get(i).size(); j++) {
                arr[index++] = buckets.get(i).get(j);
            }
        }
    }
}
