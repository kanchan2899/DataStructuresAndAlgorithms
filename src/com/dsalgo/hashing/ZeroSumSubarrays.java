package com.dsalgo.hashing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Pair {
    int first, second;
    Pair(int a , int b) {
        this.first = a;
        this.second = b;
    }
}
// https://www.geeksforgeeks.org/print-all-subarrays-with-0-sum/
public class ZeroSumSubarrays {
    public static void main(String[] args) {
        int[] arr = {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
        System.out.println(countZeroSumSubarrays(arr));
        System.out.println(countZeroSumSubarrays1(arr));
    }

    /**
     * Bruteforce: Consider all subarrays one by one and check if sum of every subarray is equal
     * to 0 ot not.
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int countZeroSumSubarrays1(int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            int prefix = 0;
            for(int j = i; j < arr.length; j++) {
                prefix += arr[j];
                if(prefix == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Using Hashing:
     *
     * 1. Maintain sum of elements so far in a variable (say sum)
     * 2. If current sum is 0, we found a subarray starting from index 0 and ending at current index
     * 3. Check if current sum exists in the hash table or not
     * 4. If it exists, then it indicates that this sum was the sum of some sub-array elements
     * arr[0]...arr[i] and now the same sum is obtained for the current sub-array arr[0]..arr[j],
     * which means that the sum of the sub-array arr[i+1]..arr[j] must be 0.
     * 5. Insert the current sum into the hash table.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int countZeroSumSubarrays(int[] arr) {
        int prefix_sum = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Pair> out = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            prefix_sum += arr[i];
            // if sum is 0, we found a subarray starting from index 0 and ending at i
            if(prefix_sum == 0) {
                out.add(new Pair(0, i));
            }
            ArrayList<Integer> list = new ArrayList<>();
            // if sum already exists in the map, there exists at least one sub-array ending
            // at index i with 0 sum
            if(map.containsKey(prefix_sum)) {
                // map[prefix_sum] stores starting index of all subarrays
                list = map.get(prefix_sum);
                for(int j = 0; j < list.size(); j++) {
                    out.add(new Pair(list.get(j) + 1, i));
                }
            }
            list.add(i);
            map.put(prefix_sum, list);
        }

        return out.size();
    }
}
