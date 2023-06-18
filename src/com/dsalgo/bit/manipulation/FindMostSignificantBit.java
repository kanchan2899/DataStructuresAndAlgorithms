package com.dsalgo.bit.manipulation;

public class FindMostSignificantBit {
    public static void main(String[] args) {
        int n = 19;
        System.out.println(msb(n));
        System.out.println(msb1(n));
        System.out.println(msb2(n));
        System.out.println(msb3(n));
    }

    /**
     * Find the MSB position using log2(n), then right left shift 1 by k times.
     *
     * TC: O(log n)
     * SC: O(1)
     *
     * @param n
     * @return
     */
    private static int msb3(int n) {
        int k = (int)(Math.log(n) / Math.log(2));
        return 1 << k;
    }

    /**
     * For a fixed 32 bit integer, count the number of leading zeroes by using the
     * built-in function and subtract it from 31 to get the position of MSB from left,
     * then return the MSB using left shift operation on 1.
     *
     * TC: O(1)
     * SC: O(1)
     * @param n
     * @return
     */
    private static int msb2(int n) {
        // Calculate the number of leading zeroes
        int k = Integer.numberOfLeadingZeros(n);

        // To return the value of the number with set bit at (31 - k)th position
        // assuming 32 bits are used.
        return 1 << (31 - k);
    }

    /**
     *  For a fixed size integer (32 bits), one by one set bits, then add 1 so that only the bit
     *  after MSB is set. Finally, right shift by 1 and return the answer.
     *
     * TC: O(1)
     * SC: O(1)
     * @param n
     * @return
     */
    private static int msb1(int n) {
        // These steps set bits after MSB (including MSB)
        n = n | n >> 1;
        n = n | n >> 2;
        n = n | n >> 4;
        n = n | n >> 8;
        n = n | n >> 16;
        // Increment n by 1 so that there is only one set bit which is just before original MSB
        n = n + 1;
        // Return original MSB after shifting
        return (n >> 1);
    }

    /**
     * Bruteforce approach: Divide the number by 2 first. Start a while loop until n != 0
     * Increment count and divide n by 2. At the end, you'll get (n - 1) bits count except MSB
     *
     * Return (1 << count)
     *
     * TC: O(log n)
     * SC: O(1)
     * @param n
     * @return
     */
    private static int msb(int n) {
        if(n  == 0) {
            return 0;
        }
        int msb = 0;
        n = n / 2;
        while (n != 0) {
            n = n / 2;
            msb++;
        }
        return (1 << msb);
    }
}
