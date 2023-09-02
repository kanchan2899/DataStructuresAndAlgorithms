package com.dsalgo.stacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://www.geeksforgeeks.org/largest-rectangular-area-in-a-histogram-using-stack/
public class LargestRectangularAreaInHistogram {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(getMaxArea(arr));
        System.out.println(getMaxArea1(arr));
        System.out.println(getMaxArea2(arr));
    }

    /**
     * Using previous and next smaller elements: Find the previous and the next smaller element
     * for every element of the histogram, as this would help to calculate the length of the
     * subarray in which this current element is the minimum element. So we can create a
     * rectangle of size (current element * length of the subarray) using this element.
     * Take the maximum of all such rectangles.
     *
     * 1. Initialize area = 0;
     * 2. Find previous smaller element for every element
     * 3. Find next smaller element for every element
     * 4. Do the following for every element arr[i]
     *      curr = arr[i];
     *      curr += (i - ps[i] - 1) * arr[i]
     *      curr += (ns[i] - i - 1) * arr[i]
     * 5. area = max(area, curr)
     * 6. return area
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int getMaxArea1(int[] arr) {
        int area = Integer.MIN_VALUE;
        Deque<Integer> stack = new ArrayDeque<>();

        int[] previousSmaller = new int[arr.length];
        int[] nextSmaller = new int[arr.length];

        stack.push(-1);

        Arrays.fill(previousSmaller, -1);
        Arrays.fill(nextSmaller, arr.length);

        int i = 0;
        while (i < arr.length) {
            // if the current element is smaller than element with index stored on the top of
            // stack then, we pop the top element and store the current element index as the
            // right_smaller for the popped element.
            while (!stack.isEmpty() && stack.peek() != -1 && arr[i] < arr[stack.peek()]) {
               nextSmaller[stack.peek()] = (int) i;
               stack.pop();
            }

            // we use this condition to avoid the unnecessary loop to find the
            // left_smaller. since the previous element is same as current element, the
            // left_smaller will always be the same for both.
            if(i > 0 && arr[i] == arr[i - 1]) {
                previousSmaller[i] = previousSmaller[(int) (i - 1)];
            } else {
                previousSmaller[i] = stack.peek();
            }
            stack.push(i);
            i++;
        }

        for(i = 0; i < arr.length; i++) {
            area = Math.max(area, arr[i] * (nextSmaller[i] - previousSmaller[i] - 1));
        }
        return area;
    }

    /**
     * Bruteforce: For every element, find the element which is greater than the current element
     * on the left side consecutively. Similarly find the element greater than the current
     * element on the right side consecutively. If the element is found, add the value to the
     * current area. Take the max of current aread and max area
     *
     * TC: O(n ^ 2)
     * SC: O(1)
     *
     * @param arr
     * @return
     */
    private static int getMaxArea(int[] arr) {
        int area = 0;
        for(int i = 0; i < arr.length; i++) {
            int current = arr[i];
            for(int j = i - 1; j >= 0; j--) {
                if(arr[j] >= arr[i]) {
                    current += arr[i];
                } else {
                    break;
                }
            }

            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] >= arr[i]) {
                    current += arr[i];
                } else {
                    break;
                }
            }

            area = Math.max(area, current);
        }

        return area;
    }

    /**
     *
     * Using stack with 1 traversal:
     *
     * 1. Create an empty stack.
     * 2. Start from the first bar, and do the following for every bar hist[i] where 'i'
     * varies from 0 to n-1
     * 3. If the stack is empty or hist[i] is higher than the bar at top of the stack,
     * then push 'i' to stack.
     * 4. If this bar is smaller than the top of the stack, then keep removing the top of
     * the stack while the top of the stack is greater.
     * 5. Let the removed bar be hist[tp]. Calculate the area of the rectangle with hist[tp]
     * as the smallest bar.
     * 6. For hist[tp], the 'left index' is previous (previous to tp) item in stack and
     * 'right index' is 'i' (current index).
     * 7. If the stack is not empty, then one by one remove all bars from the stack and do
     * step (2.2 and 2.3) for every removed bar
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int getMaxArea2(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        int area = 0;
        int current;

        for(int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int top = stack.pop();
                current = arr[top] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                area = Math.max(current, area);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            current = arr[top] * (stack.isEmpty() ? arr.length : (arr.length - stack.peek() - 1));
            area = Math.max(area, current);
        }
        return area;
    }
}
