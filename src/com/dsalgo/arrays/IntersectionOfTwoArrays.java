package com.dsalgo.arrays;

import java.util.*;

// https://leetcode.com/problems/intersection-of-two-arrays/
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection1(nums1, nums2)));
        System.out.println(Arrays.toString(intersection2(nums1, nums2)));
        System.out.println(Arrays.toString(intersection3(nums1, nums2)));
    }

    /**
     *    Using HashSet: Using sets, firstly add all values to set1.
     *    Then iterate through set 2, if set1 contains the value, add it to set2.
     *
     *    Time complexity: O(m + n)
     *    Space complexity: O(m + n)
     */

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

    /**
     *    Using HashMap: Using maps, firstly add all elements of array1 to map with value 0.
     *    Then iterate through array 2, if map contains the element, set the value to -1
     *    Then iterate through map and add the elements to a new array if the value of key is -1
     *
     *    Time complexity: O(m + n)
     *    Space complexity: O(m + n)
     */
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

    /**
     * Using Bruteforce: Create a new HashSet to store common elements between two arrays.
     * Start looping through first array and check the left side of element if it is visited already.
     * If it is, skip that element.
     * If not, check all elements in the second array. If elements a[i] & b[i] are same, add it to set
     * Return the array by converting the set to int array using streams.
     *
     * Time complexity: O(m * n)
     * Space complexity: (n)
     *
     */
    static int[] intersection3(int[] a, int[] b) {
        Set<Integer> intersectedElements = new HashSet<>();
        for(int i = 0; i < a.length; i++) {
            boolean flag = false;
            for(int j = 0; j < i - 1; j++) {
                if(a[i] == a[j]) {
                    flag = true;
                    break;
                }
            }
            if(flag == true)
                continue;
            for(int j = 0; j < b.length; j++) {
                if(a[i] == b[j]) {
                    intersectedElements.add(a[i]);
                    break;
                }
            }
        }

        return intersectedElements.stream().mapToInt(Number::intValue).toArray();
    }
}
