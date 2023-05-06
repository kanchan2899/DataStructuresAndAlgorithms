package com.dsalgo.arrays;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/
public class KidsWithGreatestNumberOfCandies {
    public static void main(String[] args) {
        int[] candies = {12, 1, 12};
        int extraCandies = 10;
        System.out.println(kidsWithCandies(candies, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        if(candies.length < 1) {
            return null;
        }
        int max = getMax(candies);
        List<Boolean> res = new ArrayList<>();
        for(int i = 0; i < candies.length; i++) {
            if(candies[i] + extraCandies >= max) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    private static int getMax(int[] candies) {
        int max = candies[0];
        for(int i = 0; i < candies.length; i++) {
            if(candies[i] > max) {
                max = candies[i];
            }
        }
        return max;
    }
}
