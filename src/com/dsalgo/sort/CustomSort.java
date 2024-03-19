package com.dsalgo.sort;

import java.util.HashMap;

// https://leetcode.com/problems/custom-sort-string/?envType=daily-question&envId=2024-03-11
public class CustomSort {
    public static void main(String[] args) {
        String order = "abd";
        String str = "abcd";
        System.out.println(customSort(order, str));
    }

    private static String customSort(String order, String str) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c : order.toCharArray()) {
            if(map.containsKey(c)) {
                result.append(String.valueOf(c).repeat(Math.max(0, map.get(c))));
                map.remove(c);
            }
        }

        for(char c : map.keySet()) {
            result.append(String.valueOf(c).repeat(Math.max(0, map.get(c))));
        }

        return result.toString();
    }
}
