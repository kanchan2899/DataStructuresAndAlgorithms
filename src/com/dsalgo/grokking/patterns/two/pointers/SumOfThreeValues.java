package com.dsalgo.grokking.patterns.two.pointers;
/*
    Given an array of integers, nums, and an integer value, target,
    determine if there are any three integers in nums whose sum equals the target.
    Return TRUE if three such integers are found in the array. Otherwise, return FALSE.

    https://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
    https://leetcode.com/problems/3sum/description/

 */

import com.dsalgo.linked.lists.singly.LinkedList;

import java.util.*;

public class SumOfThreeValues {
    public static void main(String[] args) {
        int[][] arr = {
            {12, 3, 4, 1, 6, 9},
            {1, 2, 3, 4, 5},
            {-1, 1, 0, 2, -2, 4},
            {0, 0, 0, 0},
            {-2,0,1,1,2}
        };
        int[] target = {
          24,
          9,
          9,
          0,
          3
        };
        for(int i = 0; i < arr.length; i++) {
            System.out.println("Does sum " + target[i] + " exist in the array using Bruteforce? "
                    + find3Numbers1(arr[i], target[i]));
            System.out.println("Does sum " + target[i] + " exist in the array using modified two-pointers? "
                    + find3Numbers2(arr[i], target[i]));
            System.out.println("Does sum " + target[i] + " exist in the array using modified hashing "
                    + find3Numbers3(arr[i], target[i]));
            System.out.println("Does sum 0 exist in the array using modified two-pointers? "
                    + threeSum(arr[i]));
            System.out.println("********************************");
        }

    }


    /**
     * Using Bruteforce: Generate all possible triplets using 3 loops
     * and compare the sum of every triplet with the target sum.
     *
     * Algorithm:
     * 1. Create three nested loops, first loop i runs from start to end
     * 2. Second loop j runs from i + 1 to end
     * 3. Third loop runs from j + 1 to end
     * 4. The counter of these loops represents the index of 3 elements of the triplets
     * 5. Find the sum of ith, jth and kth element
     * 6. If sum == target sum, return true. Else, return false
     *
     * Time complexity: O(n ^ 3)
     * Space complexity: O(1)
     *
     * @param a
     * @param target
     * @return
     */
    private static boolean find3Numbers1(int[] a, int target) {
        for(int i = 0; i < a.length; i++) {
            for(int j = i + 1; j < a.length; j++) {
                for(int k = j + 1; k < a.length; k++) {
                    if(a[i] + a[j] + a[k] == target)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Using modified two-pointer approach:  Because we need to find three numbers, we run a nested
     * version of this two-pointers approach. We start from one end of the array, fix one value at
     * a time, and run the two pointers algorithm on the remaining portion of the array, looking for
     * the remaining target value (after subtracting the value we have fixed).
     *
     * Algorithm:
     * 1. Sort the input array.
     * 2. Iterating over each element in the array using index i
     * 3. Initialize start to i + 1 and end to arr.length - 1
     * 4. Then in nested loop, use two pointers, to iterate over the array to find a triplet so
     *      that arr[start] + arr[end] + arr[i] == target
     * 5. If the sum of triplets is equal to the target, it's the solution
     * 6. Else if, sum of triplets > target, move end pointer forward.
     * 7. Else if, sum of triplets < target, move start pointer ahead.
     * 8. Repeat this process by fixing the index i at each location in the array, one at a time.
     *
     * Time complexity: O(n * log n) + O(n ^ 2) => O(n ^ 2)
     * Space complexity: O(1)
     *
     * @param a, input array
     * @param target
     * @return
     */
    private static boolean find3Numbers2(int[] a, int target) {
        Arrays.sort(a);
        for(int i = 0; i < a.length; i++) {
            int start = i + 1;
            int end = a.length - 1;
            while (start < end) {
                int sum = a[start] + a[end] + a[i];
                if (sum == target) {
                    return true;
                } else if (sum > target) {
                    end--;
                } else
                    start++;
            }
        }
        return false;
    }

    /**
     * https://leetcode.com/problems/3sum/description/ - find triplets with sum = 0
     *
     * Using two pointers: Sort the array. Start the loop i from 0 to nums.length - 2
     * because start = i + 1 and end = nums.length - 1 (worst case scenario)
     * Initialize two pointers, start = i + 1, end = nums.length - 1
     * Start a while loop till start >= end, check if 0 == nums[start] + nums[end] + nums[i]
     * If so, add triplets to the list, do start++ and end++ to search more triplets.
     * If sum of triplets > 0, do end--, else do start++
     *
     * TC: O(n * log n)
     *
     * @param nums
     * @return list of all triplets with sum 0
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while(start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if(sum == 0) {
                    result.add(Arrays.asList(nums[start++], nums[end--], nums[i]));
                } else if(sum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    /**
     * Using hashing: Start a loop i from 0 to nums.length - 2.
     * Initialize the hashset and current_sum = sum - nums[i]
     * Start another loop j from i + 1 to nums.length. If set contains current_sum - nums[j], return true
     * Otherwise, add nums[j] to the set. If no triplets found, return false
     *
     * Time complexity: O(n ^ 2)
     * Space complexity: O(n)
     *
     * @param nums
     * @param sum
     * @return
     */
    private static boolean find3Numbers3(int[] nums, int sum) {
        for(int i = 0; i < nums.length - 1; i++) {
            HashSet<Integer> set = new HashSet<>();
            int current_sum = sum - nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(set.contains(current_sum - nums[j])){
                    return true;
                }
                set.add(nums[j]);
            }
        }
        return false;
    }
}
