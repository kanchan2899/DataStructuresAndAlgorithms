package com.dsalgo.arrays;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

// https://leetcode.com/problems/find-the-difference-of-two-arrays/
public class DifferenceOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        System.out.println(findDifference(nums1, nums2));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> difference = new ArrayList<>();
        // Convert int[] array to a hashset
        Set<Integer> num1Set = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> num2Set = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        Iterator<Integer> it = num1Set.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            if(num2Set.contains(i)) {
                it.remove();
                num2Set.remove(i);
            }
        }
        List<Integer> list1 = new ArrayList<>(num1Set);
        List<Integer> list2 = new ArrayList<>(num2Set);

        difference.add(list1);
        difference.add(list2);
        return difference;
    }
}
