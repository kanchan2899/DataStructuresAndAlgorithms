package com.dsalgo.grokking.patterns.sliding.window;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;

// https://www.geeksforgeeks.org/find-subarray-with-given-sum/
// https://practice.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
public class SubarrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,7,5};
        int sum = 12;
        System.out.println("Subarray indexes are using sliding window: "
                + subarraySum(arr, arr.length, sum));
        System.out.println("Subarray indexes are using nested loops: "
                + subarraySum1(arr, arr.length, sum));
        System.out.println("Subarray indexes are using HashSet: "
                + subarraySum2(arr, arr.length, sum));
    }

    /**
     * Using HashSet:
     * 1. Initialize a variable ‘sum’ to 0, and create an empty unordered set ‘s’.
     * 2. Traverse through the array and add each element to ‘sum’.
     * 3. If the current element equals the given sum, then the subarray starts from the
     * beginning of the array and ends at the current index. Return the subarray.
     * 4. If ‘sum’ exceeds the given sum, check whether ‘sum’ minus the given sum is present
     * in the set or not. If it is present, then the subarray starts after the index where the
     * element that makes ‘sum’ minus the given sum was found in the set, and ends at the
     * current index. Return the subarray.
     * 5. If ‘sum’ does not exceed the given sum, insert ‘sum’ into the set.
     * 6. If no subarray is found, return an empty array.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @param n
     * @param sum
     * @return
     */
    private static ArrayList<Integer> subarraySum2(int[] arr, int n, int sum) {
        int current_sum = 0;
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++) {
            current_sum += arr[i];
            if(sum == current_sum) {
                list.add(1);
                list.add(i + 1);
            }
            if(set.contains(sum - current_sum)) {
                list.add(i + 1);
            }
        }
        list.add(-1);
        return list;
    }

    /**
     * Using nested loops: The idea is to consider all subarrays one by one and
     * check the sum of every subarray. Following program implements the given idea.
     * Run two loops: the outer loop picks a starting point i and the inner loop tries
     * all subarrays starting from i.
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @param sum
     * @return
     */
    private static ArrayList<Integer> subarraySum1(int[] arr, int n, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int current_sum = arr[i];
            if(current_sum == sum) {
                list.add(i+1);
                return list;
            } else {
                for(int j = i + 1; j < n; j++) {
                    current_sum += arr[j];
                    if(current_sum == sum) {
                        list.add(i + 1);
                        list.add(j + 1);
                        return list;
                    }
                }
            }
        }
        list.add(-1);
        return list;
    }


    /**
     * Using Sliding window: The idea is simple as we know that all the elements in subarray
     * are positive so, If a subarray has sum greater than the given sum then there is no
     * possibility that adding elements to the current subarray will be equal to the given sum.
     * So the Idea is to use a similar approach to a sliding window.
     *
     * 1. Start with an empty subarray
     * 2. add elements to the subarray until the sum is less than x( given sum ).
     * 3. If the sum is greater than x, remove elements from the start of the current subarray.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @param sum
     * @return
     */
    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if(sum == 0) {
            list.add(-1);
            return list;
        }
        int start = 0;
        int current_sum = 0;
        for(int end = 0; end < n; end++) {
            current_sum += arr[end];
            while (sum < current_sum) {
                current_sum -= arr[start];
                start++;
            }
            if(current_sum == sum) {
                list.add(start+1);
                list.add(end+1);
                return list;
            }
        }
        list.add(-1);
        return list;
    }
}
