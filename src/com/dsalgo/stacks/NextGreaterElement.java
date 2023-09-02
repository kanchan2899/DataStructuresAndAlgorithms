package com.dsalgo.stacks;

import java.util.*;

// https://www.geeksforgeeks.org/next-greater-element/
public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        System.out.println(Arrays.toString(nextGreaterElement(arr)));
        System.out.println(Arrays.toString(nextGreaterElement1(arr)));
        System.out.println(Arrays.toString(nextGreaterElement2(arr)));
    }

    /**
     * Bruteforce: The idea is to use two loops , The outer loop picks all the elements one by one.
     * The inner loop looks for the first greater element for the element picked by the outer loop.
     * If a greater element is found then that element is printed as next, otherwise, -1 is printed.
     *
     * TC: O(n ^ 2)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int[] nextGreaterElement(int[] arr) {
        int[] nextGreaterElement = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            int j;
            for(j = i + 1; j < arr.length; j++) {
                if(arr[j] > arr[i]) {
                    nextGreaterElement[i] = arr[j];
                    break;
                }
            }

            if(j == arr.length) {
                nextGreaterElement[i] = -1;
            }
        }
        return nextGreaterElement;
    }

    /**
     * Using stack: The idea is to store the elements for which we have to find the next greater
     * element in a stack and while traversing the array, if we find a greater element, we will pair
     * it with the elements from the stack till the top element of the stack is less than the
     * current element.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    private static int[] nextGreaterElement1(int[] arr) {
        int n = arr.length;
        int[] nextGreater = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[n - 1]);
        nextGreater[n - 1] = -1;

        for(int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return nextGreater;
    }

    /**
     * Using map:
     *
     * 1. This is same as above method but the elements are pushed and popped only once into the
     * stack. The array is changed in place. The array elements are pushed into the stack until
     * it finds a greatest element in the right of array. In other words the elements are popped
     * from stack when top of the stack value is smaller in the current array element.
     * 2. Once all the elements are processed in the array but stack is not empty. The left out
     * elements in the stack doesn't encounter any greatest element . So pop the element from
     * stack and change it's index value as -1 in the array.
     *
     * TC: O(n)
     * SC: O(n)
     *
     *
     * @param arr
     * @return
     */
    private static int[] nextGreaterElement2(int[] arr) {
        ArrayList<HashMap<String, Integer>> maps = new ArrayList<>();

        // iterating over the array
        for(int i = 0; i < arr.length; i++) {
            while (maps.size() > 0 && maps.get(maps.size() - 1).get("value") < arr[i]) {
                // updating the array as per the stack top
                HashMap<String, Integer> map = maps.get(maps.size() - 1);
                maps.remove(maps.size() - 1);
                arr[map.get("ind")] = arr[i];
            }

            // pushing values to stack
            HashMap<String, Integer> e = new HashMap<>();
            e.put("value", arr[i]);
            e.put("ind", i);
            maps.add(e);
        }

        // updating the array as per the stack top
        while (maps.size() > 0) {
            HashMap<String, Integer> d = maps.get(maps.size() - 1);
            maps.remove(maps.size() - 1);
            arr[d.get("ind")] = -1;
        }
        return arr;
    }
}
