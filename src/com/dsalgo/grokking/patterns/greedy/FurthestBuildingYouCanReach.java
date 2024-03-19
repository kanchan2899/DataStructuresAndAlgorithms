package com.dsalgo.grokking.patterns.greedy;

import java.util.PriorityQueue;

// https://leetcode.com/problems/furthest-building-you-can-reach/?envType=daily-question&envId=2024-02-17
public class FurthestBuildingYouCanReach {
    static Integer[][][] memo;
    public static void main(String[] args) {
        int[] heights = {4,2,7,6,9,14,12};
        int bricks = 5;
        int ladders = 1;

        System.out.println(furthestBuilding(heights, bricks, ladders));
        System.out.println(furthestBuilding1(heights, bricks, ladders));
        System.out.println(furthestBuilding2(heights, bricks, ladders));
    }

    private static int furthestBuilding2(int[] heights, int bricks, int ladders) {
        int n = heights.length;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0; i < n - 1; i++) {
            int diff = heights[i + 1] - heights[i];

            if(diff > 0) {
                if(priorityQueue.size() < ladders) {
                    priorityQueue.add(diff);
                } else {
                    if(priorityQueue.isEmpty() || priorityQueue.peek() >= diff) {
                        bricks -= diff;
                    } else {
                        int poll = priorityQueue.poll();
                        priorityQueue.add(diff);
                        bricks -= poll;
                    }
                    if(bricks < 0) {
                        return i;
                    }
                }
            }
        }
        return n - 1;
    }

    private static int furthestBuilding1(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        memo = new Integer[n + 1][bricks + 1][ladders + 1];
        return helper1(heights, 0, bricks, ladders);
    }

    private static int helper1(int[] heights, int i, int bricks, int ladders) {
        if(i == heights.length - 1) {
            return i;
        }

        if(memo[i][bricks][ladders] != null) {
            return memo[i][bricks][ladders];
        }

        int diff = heights[i + 1] - heights[i];

        if(diff > 0) {
            int ans = i;
            if(bricks >= diff) {
                ans = Math.max(ans, helper1(heights, i + 1, bricks - diff, ladders));
            }
            if(ladders > 0) {
                ans = Math.max(ans, helper1(heights, i + 1, bricks, ladders - 1));
            }

            return memo[i][bricks][ladders] = ans;
        } else {
            return memo[i][bricks][ladders] = helper1(heights, i+1, bricks, ladders);
        }

    }

    private static int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        return helper(heights, 0, bricks, ladders);
    }

    private static int helper(int[] heights, int i, int bricks, int ladders) {
        if(i == heights.length - 1) {
            return i;
        }

        int diff = heights[i + 1] - heights[i];

        if(diff > 0) {
            int ans = i;
            if(bricks >= diff) {
                ans = Math.max(ans, helper(heights, i + 1, bricks - diff, ladders));
            }
            if(ladders > 0) {
                ans = Math.max(ans, helper(heights, i + 1, bricks, ladders - 1));
            }
            return ans;
        } else {
            return helper(heights, i + 1, bricks, ladders);
        }
    }
}
