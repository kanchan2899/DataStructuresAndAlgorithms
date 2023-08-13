package com.dsalgo.hashing;

import java.util.ArrayList;
import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/positive-negative-pair5209/1
public class PositiveNegativePair {
    public static void main(String[] args) {
        int[] arr = {1,3,6,-2,-1,-3,2,7};
        System.out.println(findPairs(arr));
    }

    public static ArrayList<Integer> findPairs(int arr[]) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < arr.length; i++) {
            if(set.contains(-arr[i])) {
                list.add(-Math.abs(arr[i]));
                list.add(Math.abs(arr[i]));
            } else {
                set.add(arr[i]);
            }
        }
        if(list.isEmpty()) {
            list.add(0);
            return list;
        }
        return list;
    }
}
