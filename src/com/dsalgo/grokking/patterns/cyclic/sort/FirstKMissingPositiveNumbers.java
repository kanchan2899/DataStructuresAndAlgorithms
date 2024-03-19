package com.dsalgo.grokking.patterns.cyclic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FirstKMissingPositiveNumbers {
    public static void main(String[] args) {
        int[] arr = {0,-5,1,3,5,4};
        int k = 6;

        System.out.println(firstKMissingPositiveNumbers(arr, k));
    }

    private static List<Integer> firstKMissingPositiveNumbers(int[] arr, int k) {
        List<Integer> missingNumbers = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i : arr) {
            if(i >= 0) {
                map.put(i, i);
            }
            else {
                continue;
            }
        }

        int count  = 0;
        int f1 = 0;

        for(int i = 0; i < (arr.length + k); i++) {
            if(!map.containsKey(count)) {
                f1 += 1;
                missingNumbers.add(count);
                if(f1 == k) {
                    break;
                }
            }
            count += 1;
        }
        return missingNumbers;
    }
}
