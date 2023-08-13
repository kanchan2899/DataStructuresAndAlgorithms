package com.dsalgo.hashing;

import java.util.ArrayList;
import java.util.HashMap;

// https://practice.geeksforgeeks.org/problems/non-repeating-element3958/1
public class CountNonRepeatedElements {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 20, 30, 40, 50};
        System.out.println(countNonRepeated(arr));
    }

    /**
     * Using HashMap: Count the frequency of all elements. Traverse the map and add the element to
     * the list which are not repeating.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param arr
     * @return
     */
    static ArrayList<Integer> countNonRepeated(int arr[])
    {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(int key: map.keySet()) {
            if(map.get(key) == 1) {
                list.add(key);
            }
        }

        return list;
    }
}
