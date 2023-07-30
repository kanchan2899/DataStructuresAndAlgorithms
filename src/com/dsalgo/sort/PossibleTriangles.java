package com.dsalgo.sort;


import java.util.Arrays;

// https://www.geeksforgeeks.org/find-number-of-triangles-possible/
public class PossibleTriangles {
    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 7};
        System.out.println("Using Bruteforce, the number of possible triangles are " + numberOfTriangles(arr));
        System.out.println("Using Sorting, the number of possible triangles are " + numberOfTriangles1(arr));
        System.out.println("Using Two Pointers, the number of possible triangles are " + numberOfTriangles2(arr));
    }

    /**
     * Using two pointers: First sort the array and run a nested loop, fix an index, and then try to
     * fix an upper and lower index within which we can use all the lengths to form a triangle with
     * that fixed index.
     *
     * Steps:
     * 1. Sort the array and then take three variables l, r, and i, pointing ot start, end-1 and array
     * elements starting from the end of the array.
     * 2. Traverse the array from end and for each iteration keep the value of l = 0 and r = i - 1
     * 3. Now if a triangle can be formed using arr[l] and arr[r], then triangles can be formed with
     * arr[l+1], arr[l+2] .. arr[r-1], arr[r], arr[i], because the array is sorted, which can be directly
     * calculated using r - l and then decrement the value of r and continue the loop till l is less
     * than r.
     * 4. If a triangle cannot be formed using arr[l] and arr[r], then increment the value of l and
     * continue the loop till l is less than r so the overall complexity of iterating through all
     * array elements reduces
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int numberOfTriangles2(int[] arr) {
        int n = arr.length;

        Arrays.sort(arr);

        int count = 0;

        for(int i = n - 1; i >= 1; i--) {
            int l = 0, r = i - 1;
            while (l < r) {
                if(arr[l] + arr[r] > arr[i]) {
                    // if it is possible with arr[l], arr[r] and arr[i], then it is possible with
                    // arr[l + 1] .. arr[r - 1], arr[r], arr[i]
                    count += r - l;
                    // checking for more possible solutions
                    r--;
                } else { // if not possible, check for higher value of arr[l]
                    l++;
                }
            }
        }
        return count;
    }

    /**
     * Bruteforce: Run three loops and keep track of the number of triangles so far. The three loops
     * select three different values from an array. The innermost loop checks for the triangle
     * property which specifies the sum of any two sides must be greater than the value of the third
     * side.
     *
     * TC: O(n ^ 3)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int numberOfTriangles(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(arr[i] + arr[j] > arr[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    /**
     * Using sorting: First sort the array in ascending order. Then use two loops. The outer loop to
     * fix the first side and the inner loop to fix the second side and then find the farthest index
     * of the third side (greater than indices of both sides) whose length is less than the sum of the
     * other two sides. So a range of values third side can be found, where it is guaranteed that its
     * length is greater than the other individual sides but less than the sum of both sides.
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int numberOfTriangles1(int[] arr) {
        int n = arr.length;

        // sort the array in ascending order
        Arrays.sort(arr);

        int count  = 0;

        // fix the first element and run the loop till n - 3 as the other two elements are selected
        // from arr[i + 1 .. n - 1]
        for(int i = 0; i < n - 2; i++) {

            // initialize index of the rightmost third element
            int k = i + 2;
            // fix the second element
            for(int j = i + 1; j < n; j++) {

                // find the rightmost element which is smaller than the sum of two fixed elements.
                // the important thing to note here is we use the previous value of k. If the value
                // of arr[i] + arr[j - 1] was greater than arr[k], then arr[i] + arr[j] must be
                // greater than k, because the array is sorted.
                while (k < n && arr[i] + arr[j] > arr[k]) {
                    ++k;
                }

                // total number of possible triangles that can be formed with the two fixed elements
                // is k - j + 1. The two fixed elements are arr[i] and arr[j]. All elements between
                // arr[j + 1] and arr[k - 1] can form a triangle with arr[i] and arr[j]. One is subtracted
                // from k because k is incremented one extra in above while loop. k will always be greater
                // than j. If j becomes equal to k, then above loop will increment k, because arr[k] + arr[i]
                // is always greater then arr[k]
                if(k > j) {
                    count += k - j - 1;
                }
            }
        }
        return count;
    }
}
