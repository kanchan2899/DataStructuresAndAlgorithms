package com.dsalgo.stacks;

import java.util.Stack;

// https://www.geeksforgeeks.org/maximum-size-rectangle-binary-sub-matrix-1s/
public class MaximalRectangle {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 1}, {1, 1, 1}, {0, 1, 1}};
        System.out.println(maximalRectangle1(3, 3, arr));
    }

    /**
     * Bruteforce: Consider every cell as a starting point. Consider all sizes of rectangles with
     * current cell as a starting point. For the current rectangle, check if it has all 1's. If so,
     * update the result if current size is greater.
     *
     * TC: O((row ^ 3) * (col ^ 3))
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int maximalRectangle(int[][] arr) {
        return 0;
    }

    /**
     * Using stack and largest rectangular area logic:
     *
     * 1. Run a loop from 0 to r-1
     * 2. Update the histogram for the current row
     * 3. Find the largest area in the histogram and update the result if required
     *
     * TC: O(r * c)
     * SC: O(c)
     *
     * @param arr
     * @return
     */
    private static int maximalRectangle1(int r, int c, int[][] arr) {
        int max_area = maxHist(r, c, arr[0]);

        for(int i = 1; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] += arr[i - 1][j];
                }
            }
            max_area = Math.max(max_area, maxHist(r, c, arr[i]));
        }
        return max_area;
    }

    private static int maxHist(int r, int c, int[] row) {
        Stack<Integer> stack = new Stack<>();
        int top_val;
        int max_area = 0;
        int area = 0;

        int i = 0;

        while (i < c) {
            if(stack.empty() || row[stack.peek()] <= row[i]) {
                stack.push(i++);
            } else {
                top_val = row[stack.peek()];
                stack.pop();
                area = top_val * i;

                if(!stack.empty()) {
                    area = top_val * (i - stack.peek() - 1);
                }
                max_area = Math.max(area, max_area);
            }
        }

        while (!stack.empty()) {
            top_val = row[stack.peek()];
            stack.pop();
            area = top_val * i;
            if(!stack.empty()) {
                area = top_val * (i - stack.peek() - 1);
            }
            max_area = Math.max(area, max_area);
        }
        return max_area;
    }

}
