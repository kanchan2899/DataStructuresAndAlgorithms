package com.dsalgo.recursion.numbers;

import java.util.ArrayList;
import java.util.LinkedHashSet;

// https://www.geeksforgeeks.org/find-all-unique-subsets-of-a-given-set/
public class UniqueSubsets {

    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        LinkedHashSet <ArrayList <Integer>> res = new LinkedHashSet<>();
        ArrayList<Integer> set = new ArrayList<>();

        res.add(set);

        helper(arr, res, set, 0);

        return new ArrayList<>(res);
    }

    static void helper(int arr[], LinkedHashSet<ArrayList<Integer>> res,
                       ArrayList<Integer> set, int index) {
        if(index == arr.length) {
            return;
        }

        set.add(arr[index]);

        res.add(new ArrayList<>(set));

        helper(arr, res, set, index + 1);

        set.remove(set.size() - 1);

        helper(arr, res, set, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 3, 1, 4};

        System.out.println(AllSubsets(arr, arr.length));
    }
}
