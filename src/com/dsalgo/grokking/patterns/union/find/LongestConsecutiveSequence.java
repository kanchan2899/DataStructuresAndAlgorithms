package com.dsalgo.grokking.patterns.union.find;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-consecutive-sequence/
class UnionFind3 {
    public Map<Integer, Integer> parent;
    public Map<Integer, Integer> size;
    public int maxLength;

    public UnionFind3(int[] nums) {
        parent = new HashMap<>();
        size = new HashMap<>();
        maxLength = 1;

        for(int n: nums) {
            parent.put(n, n);
            size.put(n, 1);
        }
    }

    public int find(int num) {
        if(parent.get(num) != num) {
            parent.put(num, find(parent.get(num)));
        }
        return parent.get(num);
    }

    public void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot != yRoot) {
            if(size.get(xRoot) < size.get(yRoot)) {
                int temp = xRoot;
                xRoot = yRoot;
                yRoot = temp;
            }
            parent.put(yRoot, xRoot);
            size.put(xRoot, size.get(xRoot) + size.get(yRoot));
            maxLength = Math.max(maxLength, size.get(xRoot));
        }
    }
}
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {150, 14, 200, 1, 3, 2, 4};
        System.out.println(longestConsecutiveSequence(nums));
    }

    private static int longestConsecutiveSequence(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        UnionFind3 ds = new UnionFind3(nums);

        for(int num: nums) {
            if(ds.parent.containsKey(num + 1)) {
                ds.union(num, num + 1);
            }
        }
        return ds.maxLength;
    }
}
