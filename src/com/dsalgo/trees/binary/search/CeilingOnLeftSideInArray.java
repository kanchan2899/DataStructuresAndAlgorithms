package com.dsalgo.trees.binary.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

// https://www.geeksforgeeks.org/ceiling-in-right-side-for-every-element-in-an-array/
public class CeilingOnLeftSideInArray {
    public static void main(String[] args) {
        int[] arr = {50, 20, 200, 100, 30};
        System.out.println(closestGreaterOnLeft(arr));
    }

    /**
     * Using Self Balancing Tree: Traverse the array from left to right and call ceiling function
     * for the current array element. If found, update the ceiling list otherwise add -1 to the list.
     * Then add the element to the treeSet.
     *
     * TC: O(n * log n)
     * SC: O(n)
     * 
     * @param arr
     * @return
     */
    private static List<Integer> closestGreaterOnLeft(int[] arr) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        List<Integer> ceilings = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            Integer greater = treeSet.ceiling(arr[i]);
            if(greater == null) {
                ceilings.add(-1);
            } else {
                ceilings.add(greater);
            }
            treeSet.add(arr[i]);
        }
//        Collections.reverse(ceilings);
        return ceilings;
    }
}
