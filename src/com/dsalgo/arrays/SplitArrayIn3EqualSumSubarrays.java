package com.dsalgo.arrays;

// https://www.geeksforgeeks.org/split-array-three-equal-sum-subarrays/
// Consider an array A of n integers. Determine if array A can be split into three consecutive
// parts such that sum of each part is equal. If yes then print any index pair(i, j)
// such that sum(arr[0..i]) = sum(arr[i+1..j]) = sum(arr[j+1..n-1]), otherwise print -1.

public class SplitArrayIn3EqualSumSubarrays {
    public static void main(String[] args) {
        int[] arr = {5, 2, 6, 1, 1, 1, 1, 4};
        findSplit(arr);
    }

    /**
     * First find the sum of all elements. Check if sum is divisible by 3 or not as if it is not
     * divisible by 3, then the array cannot be divided into 3 subsets. If there are 3 contiguous
     * subarrays with equal sum, then sum of each subarray is sum/3. Suppose the required pair of
     * indices is (i, j) such that sum(arr[0..i]) = sum(arr[i+1..j]) = sum/3. Also sum(arr[0..i])
     * = prefix_sum[i] and sum(arr[i+1..j]) = prefix_sum[j] - prefix_sum[i]. This gives
     * prefix_sum[i] = prefix_sum[j] - prefix_sum[i] = sum/3. This gives prefix_sum[j] =
     * 2*prefix_sum[i]. Thus, the problem reduces to find two indices i and j such that prefix_sum[i]
     * = sum/3 and prefix_sum[j] = 2*sum/3. For finding these two indices, traverse the array and store
     * sum upto current element in a variable prefix_sum. Check if prefix_sum is sum/3 and 2*sum/3
     *
     *
     * 1. The first step is to find the sum of the entire array and store it in the variable S.
     * 2. Check if the sum of the array S is divisible by 3.
     * If not, return 0, indicating that the array cannot be split into three equal sum sets.
     * 3. Calculate S/3 and store it in the variable S1 and calculate 2 * (S/3)
     * and store it in the variable S2. These variables represent the sum of each of the three sets.
     * 4. Initialize the variables ind1 and ind2 to store the indices which have prefix sum
     * divisible by S/3. Set these variables to -1 initially.
     * 5. Loop through the elements of the array, keeping track of the prefix sum,
     * until the second last index. This is because the S2 should not be at the last index.
     * 6. If the prefix sum is equal to S/3, store the current index in ind1.
     * If the prefix sum is equal to 2 * (S/3), store the current index in ind2.
     * If both ind1 and ind2 are found, break out of the loop.
     * 7. If both indices ind1 and ind2 are found, print them as the two indices
     * which divide the array into three equal sum sets.
     * Return 1, indicating that the array can be split into three equal sum sets.
     * 8. If the indices ind1 and ind2 are not found, return 0,
     * indicating that the array cannot be split into three equal sum sets.
     * 9. Finally, in the main function, call the findSplit function with the given array
     * and its size. If the function returns 0, print -1.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param arr
     */
    static void findSplit(int[] arr) {
        int n = arr.length;
        int i, prefix_sum = 0, sum = 0;

        // variables to store indices which have prefix_sum divisible by S/3
        int idx1 = -1, idx2 = -1;

        for(i = 0; i < n; i++) {
            sum += arr[i];
        }

        // check if array can be split in three equal sum sets or not
        if(sum % 3 != 0) {
            System.out.println(-1);
        }

        // store sum/3 and 2*sum/3
        int s1 = sum / 3;
        int s2 = 2 * s1;

        // loop until second last index as s2 should not be at the last
        for(i = 0; i < n - 1; i++) {
            prefix_sum += arr[i];

            // if prefix_sum is equal to sum/3, store current index
            if(prefix_sum == s1 && idx1 == -1) {
                idx1 = i;
            }

            // if prefix_sum is equal to 2*sum/3, store current index
            if(prefix_sum == s2 && idx1 != -1) {
                idx2 = i;
                break;      // come out of the loop as both indices are found
            }
        }

        if(idx1 != -1 && idx2 != -1) {
            System.out.println(idx1 + " " + idx2);
            return;

        }
        System.out.println(-1);
    }
}
