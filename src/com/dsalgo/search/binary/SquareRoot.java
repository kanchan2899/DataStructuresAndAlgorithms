package com.dsalgo.search.binary;

import java.util.Scanner;
import java.util.stream.IntStream;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println("Square root of " + num + " is " + squareRoot(num));
        System.out.println("Square root of " + num + " is " + squareRoot1(num));
    }

    /**
     * Linear Search: To find the floor of the square root, try with all-natural numbers starting
     * from 1. Continue incrementing the number until the square of that number is greater than
     * the given number.
     *
     * 1. Initialize i to 1.
     * 2. Start a while loop till i*i <= num, and increment i.
     * 3. Return i-1
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param num
     * @return
     */
    private static int squareRoot1(int num) {
        int i = 1;
        while (i * i <= num) {
            i++;
        }
        return i-1;
    }

    /**
     * Binary Search: The idea is to find the largest integer i whose square is less than or equal
     * to the given number. The values of i * i is monotonically increasing, so the problem can be
     * solved using binary search.
     *
     * 1. Base cases for the given problem are when the given number is 0 or 1, then return X;
     * 2. Create some variables, for storing the lower bound say l = 0, and for upper bound r = X / 2
     * (i.e, The floor of the square root of x cannot be more than x/2 when x > 1).
     * 3. Run a loop until l <= r, the search space vanishes
     * 4. Check if the square of mid (mid = (l + r)/2 ) is less than or equal to X, If yes then search
     * for a larger value in the second half of the search space, i.e l = mid + 1, update ans = mid
     * 5. Else if the square of mid is more than X then search for a smaller value in the first half
     * of the search space, i.e r = mid – 1
     * 6. Finally, Return the ans
     *
     * TC: O(log n)
     * SC: O(1)
     *
     * @param num
     * @return
     */
    private static int squareRoot(int num) {
        int start = 1;
        int end = num;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid * mid == num) return mid;
            else if(mid * mid > num) end = mid - 1;
            else start = mid + 1;
        }
        return start - 1;
    }
}
