package com.dsalgo.recursion.strings.subsequence;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/maximum-string-partition/
public class MaximumStringPartitions {
    public static void main(String[] args) {
        String[] str = {"aabccd", "aaaa", "geeksforgeeks"};
        for(String s : str) {
            System.out.println(maximumPartitions(s));
            System.out.println(maximumPartitionsCount(s));
        }
    }

    private static int maximumPartitionsCount(String s) {
        return helperWithCount(s, 0, new ArrayList<>());
    }

    private static int helperWithCount(String s, int index, ArrayList<String> partitions) {
        if(index >= s.length() - 1) {
            return partitions.size();
        }
        if(s.charAt(index) == s.charAt(index + 1)) {
            partitions.add(s.substring(index, index+1));
            return helperWithCount(s, index+1, partitions);
        } else{
            partitions.add(s.substring(index, index+2));
            return helperWithCount(s, index+2, partitions);
        }
    }

    private static List<String> maximumPartitions(String s) {
        return helper(s, 0, new ArrayList<>());
    }

    private static List<String> helper(String s, int index, ArrayList<String> partitions) {
        if(index >= s.length() - 1) {
            return partitions;
        }
        if(s.charAt(index) == s.charAt(index + 1)) {
            partitions.add(s.substring(index, index+1));
            return helper(s, index+1, partitions);
        } else{
            partitions.add(s.substring(index, index+2));
            return helper(s, index+2, partitions);
        }
    }
}
