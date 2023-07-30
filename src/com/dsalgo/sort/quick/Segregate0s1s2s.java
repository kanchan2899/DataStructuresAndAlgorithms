package com.dsalgo.sort.quick;

import java.util.Arrays;

public class Segregate0s1s2s {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 2, 1, 0, 1, 2, 1, 0, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] arr1 = {0, 2, 1, 2, 1, 0, 1, 2, 1, 0, 0};
        sort1(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    /**
     * Bruteforce: Count the number of 0s, 1s and 2s in the array. Then store all the 0s in the
     * beginning followed by all the 1s and then 2s.
     *
     * Algorithm:
     * 1. Keep three counter c0 to count 0s, c1 to count 1s and c2 to count 2s
     * 2. Traverse through the array and increase the count of c0 if the element is 0, increase the
     * count of c1 if the element is 1 and increase the count iof c2 if the element is 2.
     * 3. Now again traverse the array and replace first c0 elements with 0, next c1 elements with 1
     * and next c2 elements with 2.
     *
     * TC: O(n) - two traversals
     * SC: O(1)
     *
     * @param arr1
     */
    private static void sort1(int[] arr1) {
        int i, cnt0 = 0, cnt1 = 0, cnt2 = 0;

        for(i = 0; i < arr1.length; i++) {
            switch (arr1[i]) {
                case 0: {
                    cnt0++;
                    break;
                }
                case 1: {
                    cnt1++;
                    break;
                }
                case 2: {
                    cnt2++;
                    break;
                }
            }
        }

        // Update the array
        i = 0;
        // Store all the 0s in the beginning
        while (cnt0 > 0) {
            arr1[i++] = 0;
            cnt0--;
        }

        // Then all the 1s
        while (cnt1 > 0) {
            arr1[i++] = 1;
            cnt1--;
        }

        // Finally all the 2s
        while (cnt2 > 0) {
            arr1[i++] = 2;
            cnt2--;
        }
    }


    /**
     * Dutch National Flag Problem: The problem is similar to "Segregate 0s and 1s".
     * The problem is posed with 3 colors, here 0s, 1s and 2s. The array is divided into four
     * sections:
     * 1. a[0 .. low - 1] -> zeros
     * 2. a[low .. mid - 1] -> ones
     * 3. a[mid .. hi] -> unknowns
     * 4. a[hi+1 .. n] -> twos
     * 5. If the ith element is 0, then swap the element to the low range, thus shrinking the
     * unknown range.
     * 6. Similarly, if the element is 1, the keep it as it is but shrink the unknown range.
     * 7. If the element is 2, then swap it with an element in the hi range.
     *
     * Algorithm:
     * 1. Keep three indices low = 1, mid = 1 and high = n and there are four ranges, 1 to low (the
     * range containing 0), low to mid (the range containing 1), mid to high (the range containing
     * unknown elements) and high to n (the range containing 2)
     * 2. Traverse the array from start to end and mid is less than high. (loop counter is i)
     * 3. If the element is 0, then swap the element with the element at index low and update
     * low = low + 1 and mid = mid + 1
     * 4. If the element is 1, then update mid = mid + 1
     * 5. If the element is 2, then swap the element with the element at index high and update high =
     * high - 1 and update i = i - 1 as swapped element is not processed.
     *
     * TC: O(n) - one traversal
     * SC: O(1)
     *
     * @param arr
     */
    static void sort(int[] arr){
        int n = arr.length;
        int low = 0, mid = 0, high = n - 1;

        while (mid <= high) {
            if(arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if(arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
