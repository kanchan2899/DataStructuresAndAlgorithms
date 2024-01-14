package com.dsalgo.grokking.patterns.fast.slow.pointers;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println(duplicateNumber(arr));
    }

    private static int duplicateNumber(int[] arr) {
        int slow = arr[0], fast = arr[0];
        while (true) {
            slow = arr[slow];
            fast = arr[arr[fast]];
            if(fast == slow) {
                break;
            }
        }

        slow = arr[0];

        while (fast != slow) {
            slow = arr[slow];
            fast = arr[fast];
        }
        return fast;
    }
}
