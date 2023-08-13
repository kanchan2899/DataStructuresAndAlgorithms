package com.dsalgo.hashing;

import java.util.HashMap;

// https://www.geeksforgeeks.org/count-subarrays-equal-number-1s-0s/
public class CountSubarraysWithEqual0sAns1s {
    public static void main(String[] args) {
        int[] arr = {1, 0, 0, 1, 1, 0, 0, 1};
        System.out.println(countSubarrWithEqualZeroAndOne(arr));
    }

    /**
     * Using HashMap:
     *
     * 1. Create a map
     * 2. Iterate over the length of the given array
     *  a. Check if arr[i] == 0, then replace it with -1.
     *  b. Keep calculating the number into sum till ith index.
     *  c. If sum = 0, it implies the number of 0’s and 1’s are equal from arr[0]..arr[i]
     *  d. if mp[sum] exists then add “frequency-1” to count
     *  e. if the frequency of “sum” is zero then we initialize that frequency to 1,
     *  f it’s not 0, we increment it
     * 3. Finally, return the count.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int countSubarrWithEqualZeroAndOne(int[] arr) {
        int count = 0;
        int presum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                arr[i] = -1;
            }

            presum += arr[i];
            if(presum == 0) {
                count++;
            }

            if(map.containsKey(presum)) {
                count += map.get(presum);
            }

            map.put(presum, map.getOrDefault(presum, 0) + 1);
        }

        return count;
    }
}
