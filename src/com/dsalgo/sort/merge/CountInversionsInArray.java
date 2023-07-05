package com.dsalgo.sort.merge;

public class CountInversionsInArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(countInversions(arr, arr.length));
        System.out.println(countInversions1(arr, arr.length));
    }

    /**
     * Using bruteforce: Traverse through the array, and for every index, find the number of smaller
     * elements on its right side of the array. This can be done using a nested loop. Sum up the
     * counts for all indices in the array and print the sum.
     *
     * 1. Traverse through the array from start to end
     * 2. For every element, find the count of elements smaller than the current number up to
     * that index using another loop.
     * 3. Sum up the count of inversion for every index.
     * 4. Print the count of inversions.
     *
     * TC: O(n^2)
     * SC: O(1)
     *
     * @param arr
     * @param n
     * @return
     */
    private static int countInversions(int[] arr, int n) {
        int inversionsCount = 0;
        for(int i = 0; i < n-1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] > arr[j]) {
                    inversionsCount++;
                }
            }
        }
        return inversionsCount;
    }

    /**
     * Using merge sort: Use Merge sort with modification that every time an unsorted pair is
     * found increment count by one and return count at the end.
     *
     * 1. The idea is similar to merge sort, divide the array into two equal or almost equal
     * halves in each step until the base case is reached.
     * 2. Create a function merge that counts the number of inversions when two halves of the
     * array are merged,
     *      a. Create two indices i and j, i is the index for the first half, and j is an index
     *      of the second half.
     *      b. If a[i] is greater than a[j], then there are (mid – i) inversions because left
     *      and right subarrays are sorted, so all the remaining elements in left-subarray
     *      (a[i+1], a[i+2] … a[mid]) will be greater than a[j].
     * 3. Create a recursive function to divide the array into halves and find the answer by
     * summing the number of inversions in the first half, the number of inversions in the
     * second half and the number of inversions by merging the two.
     *      a. The base case of recursion is when there is only one element in the given half.
     * 4. Print the answer.
     *
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param arr
     * @param n
     * @return
     */
    private static int countInversions1(int[] arr, int n) {
        int[] temp = new int[n];
        return modifiedMergeSort(arr, temp, 0, n-1);
    }

    private static int modifiedMergeSort(int[] arr, int[] temp, int left, int right) {
        int mid, inversionCount = 0;
        if(right > left) {
            mid = (right + left) / 2;

            inversionCount += modifiedMergeSort(arr, temp, left, mid);
            inversionCount += modifiedMergeSort(arr, temp, mid + 1, right);

            inversionCount += countAndMerge(arr, temp, left, mid + 1, right);
        }
        return inversionCount;
    }

    static int countAndMerge(int[] arr, int[] temp, int left, int mid, int right) {
       int i, j, k;
       int inversionCount = 0;

       i = left;
       j = mid;
       k = left;

        while ((i <= mid - 1) && (j <= right)) {
            if(arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                inversionCount += (mid - i);
            }
        }

        // Copy the remaining elements of left subarray
        while (i <= mid - 1) {
           temp[k++] = arr[i++];
        }

        // Copy the remaining elements of left subarray
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        // Copy back the merged elements to original array
        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return inversionCount;
    }
}
