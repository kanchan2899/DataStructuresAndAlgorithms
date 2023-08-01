package com.dsalgo.search;

public class TernarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int x = 7;
        System.out.println(ternarySearch(arr, 0, arr.length - 1, x));
    }

    /**
     * Ternary Search: It is a Divide and Conquer Algorithm used to perform search operation
     * in a sorted array. This algorithm is similar to the Binary Search algorithm but rather
     * than dividing the array into two parts, it divides the array into three equal parts.
     * In this algorithm, the given array is divided into three parts and the key (element
     * to be searched) is compared to find the part in which it lies and that part is
     * further divided into three parts.
     *
     * Steps:
     * 1. First, we compare the key with the element at mid1. If found equal, we return mid1.
     * 2. If not, then we compare the key with the element at mid2. If found equal, we return mid2.
     * 3. If not, then we check whether the key is less than the element at mid1. If yes, then recur to the first part.
     * 4. If not, then we check whether the key is greater than the element at mid2. If yes, then recur to the third part.
     * 5. If not, then we recur to the second (middle) part.
     *
     * TC: O(log3 n)
     * SC: O(log3 n)
     *
     * @param arr
     * @param low
     * @param high
     * @param x
     * @return
     */
    private static int ternarySearch(int[] arr, int low, int high, int x) {
        if(high >= low) {
            // Find mid1 and mid2
            int mid1 = low + (high - low) / 2;
            int mid2 = high - (high - low) / 2;

            // Check if key is present at any mid
            if(arr[mid1] == x) {
                return mid1;
            }
            if(arr[mid2] == x) {
                return mid2;
            }
            // Since key is not present at mid, check in which region it is present
            // then repeat the Search operation in that region
            if(x < arr[mid1]) {
                // The key lies in between low and mid1
                return ternarySearch(arr, low, mid1 - 1, x);
            }

            else if(x > arr[mid2]) {
                // The key lies in between mid2 and high
                return ternarySearch(arr, mid2 + 1, high, x);
            }

            else {
                // The key lies in between mid1 and mid2
                return ternarySearch(arr, mid1 + 1, mid2 + 1, x);
            }

        }
        // Key not found
        return -1;
    }


}
