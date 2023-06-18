package com.dsalgo.bit.manipulation;

public class MaximumANDValue {
    public static void main(String[] args) {
        int[][] arr = {{4, 8, 12, 16},
                       {4, 8, 16, 2}};
        for (int[] a: arr) {
            System.out.println("Using Bruteforce " + findMaximumAnd(a));
            System.out.println("Using Bitwise " + findMaximumAnd1(a));
        }
    }

    /**
     * Using bitwise: The answer should have its MSB as far as possible. So if two elements are
     * considered as a pair, then their MSB should be set to as much left as possible. So since
     * this constraint permit till 10^4, hence the & value will also be less than that.
     * 10^4 will range from 2^0 to 2^14, which means we need to start the check from 15th bit.
     * Initially we loop from 15 to 0 and check for the count of numbers whose that particular bit is set.
     * Once we get the count more than 2, the answer will have that bit set, and for the next bit
     * from the left to be set, we need to check for both the previous all bits and ith bit.
     * The previos bits can be added to the current bit using OR operator. In this way, we can get
     * all the positions of bits which are set, which can be easily represented as a number.
     *
     * TC: O(n * log m), where m is the maximum element from the array and n is array size
     * SC: O(1)
     * @param a
     * @return
     */
    private static int findMaximumAnd1(int[] a) {
        int res = 0, count;
        for(int i = 31; i >= 0; i--) {      // i can be initialized to 17 if 1 <= n <= 10^5
            count = checkBit(res | (1 << i), a);

            if(count >= 2) {
                res = res | (1 << i);
            }
        }
        return res;
    }

    private static int checkBit(int pattern, int[] arr) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if((pattern & arr[i]) == pattern) {
                count++;
            }
        }
        return count;
    }

    /**
     * Bruteforce: Iterate for all the pairs using two for loops and check for maximum & of any pair.
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    static int findMaximumAnd(int[] arr) {
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++)
                max = Math.max(max, arr[i] & arr[j]);
        }
        return max;
    }

}
