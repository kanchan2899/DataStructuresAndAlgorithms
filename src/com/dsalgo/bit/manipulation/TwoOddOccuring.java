package com.dsalgo.bit.manipulation;

public class TwoOddOccuring {
    public static void main(String[] args) {
        int[][] arr = {
                {3, 4, 3, 4, 5, 4, 4, 6, 7, 7},
                {1, 3, 2, 3, 3, 1}
        };
        for(int[] a: arr) {
            System.out.print("Using bruteforce: ");
            oddOccurring(a);
            System.out.println();
            System.out.print("Using XOR: ");
            oddOccurring1(a);
            System.out.println();
        }
    }

    private static void oddOccurring1(int[] a) {
        int x = a[0];
        for(int i = 1; i < a.length; i++) {
            x = x ^ a[i];
        }

        int k = x & (~(x - 1));
        int res1 = 0, res2 = 0;
        for(int i = 0; i < a.length; i++) {
            if((a[i] & k) != 0) {
                res1 = res1 ^ a[i];
            } else {
                res2 = res2 ^ a[i];
            }
        }
        System.out.print(res1 + " " + res2);
    }

    /**
     * Using bruteforce: Traverse through the array, count occurrences of every number.
     * If the count is off, print the number
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param a
     * @return
     */
    private static void oddOccurring(int[] a) {
        for(int i = 0; i < a.length; i++) {
            int count = 0;
            for(int j = 0; j < a.length; j++) {
                if(a[i] == a[j]) {
                    count++;
                }
            }
            if(count % 2 != 0) {
                System.out.print(a[i] + " ");
            }
        }
    }
}
