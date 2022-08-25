package com.dsalgo.arrays;

import java.util.*;

// https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection1(nums1, nums2)));
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
    }

    private static int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], 0);
        }
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i])){
                map.replace(nums2[i], -1);
            }
        }
        for(Integer key: map.keySet()){
            if(map.get(key).equals(-1)){
                list.add(key);
            }
        }
        return list.stream().mapToInt(Number::intValue).toArray();
    }

    // Solution 1 - O(m + n) TC & O(m + n) SC
    // Using sets, firstly add all values to set1. Then iterate through set 2, if set1 contains the value, add it to set2.

    private static int[] intersection1(int[] nums1, int[] nums2){
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> list = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            set1.add(nums1[i]);
        }

        for(int i = 0; i < nums2.length; i++){
            if(set1.contains(nums2[i])){
                list.add(nums2[i]);
            }
        }
        return list.stream().mapToInt(Number::intValue).toArray();
    }
}
