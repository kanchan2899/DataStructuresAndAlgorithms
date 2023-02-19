package com.dsalgo.hashing;

import java.util.*;


// https://leetcode.com/problems/intersection-of-two-arrays-ii/

/*
    I/P: a[] = {1, 2, 2, 1}, b[] = {2, 2}
    O/P: [2, 2]
 */

public class IntersectionOfTwoArraysII {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2};
        System.out.println(Arrays.toString(intersection1(nums1, nums2)));
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
    }

    private static int[] intersection1(int[] a, int[] b) {
        Map<Integer, Integer> map1 = new HashMap();
        Map<Integer, Integer> map2 = new HashMap();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            map1.put(a[i], map1.getOrDefault(a[i], 0) + 1);
        }
        for(int i = 0; i < b.length; i++){
            map2.put(b[i], map2.getOrDefault(b[i], 0) + 1);
        }

        for(int key: map1.keySet()) {
            if(map2.containsKey(key)) {
                int min = Integer.min(map1.get(key), map2.get(key));
                for(int i = 0; i < min; i++) {
                    list.add(key);
                }
            }
        }

        return list.stream().mapToInt(Number::intValue).toArray();
    }


    /**
     *
     *
     * Time complexity: O(M + N)
     * Space complexity: O(min(M, N))
     * @param a
     * @param b
     * @return
     */
    private static int[] intersection2(int[] a, int[] b) {
        if(a.length > b.length) return intersection2(b, a);
        Map<Integer, Integer> map1 = new HashMap();
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < a.length; i++){
            map1.put(a[i], map1.getOrDefault(a[i], 0) + 1);
        }

        for(int x : b) {
            if(map1.containsKey(x)) {
                if(map1.get(x) > 0) {
                    list.add(x);
                    map1.replace(x, map1.get(x) - 1);
                }
            }
        }

        return list.stream().mapToInt(Number::intValue).toArray();
    }
}
