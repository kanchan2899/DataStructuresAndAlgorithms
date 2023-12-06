package com.dsalgo.dynamic.programming;

public class EqualSumPartition {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(isEqualSumPartitionPossible(arr));
        System.out.println(isEqualSumPartitionPossible1(arr));
    }

    /**
     * Using DP - Tabulation
     *
     * 1. First, check if the sum of the elements is even or not
     * 2. Declare a 2-D array part[][] of size (sum/2)+1 * (N + 1)
     * 3. Run a for loop for 0 <= i <= n and set part[0][i] equal to true as zero-sum is always
     * possible
     * 4. Run a for loop for 1 <= i <= sum/2 and set part[i][0] equal to zero as any sum with zero
     * elements is never possible
     * 5. Run a nested for loop for 1 <= i <= sum/2 and 1 <= j <= N
     *      - Set part[i][j] equal to part[i][j-1]
     *      - If i is greater than or equal to arr[j-1], if part[i – arr[j-1]][j-1] is true then
     *      set part[i][j] as true
     * 6. Print the answer
     *
     * TC: O(n * sum)
     * SC: O(n * sum)
     *
     * @param arr
     * @return
     */
    private static boolean isEqualSumPartitionPossible1(int[] arr) {
        int sum = 0;
        int n = arr.length;
        int i, j;

        for(i = 0; i < n; i++) {
            sum += arr[i];
        }
        if(sum % 2 != 0) {
            return false;
        }

        boolean part[][] = new boolean[sum / 2 + 1][n + 1];

        // initialize top row as true
        for(i = 0; i <= n; i++) {
            part[0][i] = true;
        }

        // initialize leftmost column, except part[0][0], as 0
        for(i = 1; i <= sum / 2; i++) {
            part[i][0] = false;
        }

        // Fill the partition table in bottom up manner
        for(i = 1; i <= sum/2; i++) {
            for (j = 1; j <= n; j++) {
                part[i][j] = part[i][j - 1];
                if(i >= arr[j - 1]) {
                    part[i][j] = part[i][j] || part[i - arr[j - 1]][j - 1];
                }
            }
        }
        return part[sum/2][n];
    }

    /**
     * Using Recursion:
     *
     *
     * 1. First, check if the sum of the elements is even or not
     * 2. After checking, call the recursive function isSubsetSum with parameters as input array,
     * array size, and sum/2
     *      - If the sum is equal to zero then return true (Base case)
     *      - If n is equal to 0 and sum is not equal to zero then return false (Base case)
     *      - Check if the value of the last element is greater than the remaining sum then call
     *      this function again by removing the last element
     *      - else call this function again for both the cases stated above and return true, if
     *      anyone of them returns true
     * 3. Print the answer
     *
     * TC: O(2 ^ n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static boolean isEqualSumPartitionPossible(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        // If sum is odd, there cannot be two subsets with equal sum
        if(sum % 2 != 0) {
            return false;
        }

        return helper(arr, arr.length, sum / 2);
    }

    private static boolean helper(int[] arr, int n, int sum) {
        if(sum == 0) {
            return true;
        }
        if(n == 0 || sum != 0) {
            return false;
        }

        // If last element is greater than sum, then ignore it
        if(arr[n - 1] > sum) {
            return helper(arr, n - 1, sum);
        }
        // else, check if sum can be obtained by any of the following
        //   (a) including the last element
        //   (b) excluding the last element

        return helper(arr, n - 1, sum) || helper(arr, n - 1, sum - arr[n - 1]);
    }
}
