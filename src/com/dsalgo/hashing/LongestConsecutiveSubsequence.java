package com.dsalgo.hashing;

import java.util.Arrays;
import java.util.HashSet;


/*
    The longest consecutive subsequence in the form of [x, x+1, x+2, x+3, .., x+i] with these
    elements appearing in any order in the array
    https://www.geeksforgeeks.org/longest-consecutive-subsequence/

    I/P: {1, 8, 3, 2, 4, 20}
    O/P: 4

    I/P: {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
    O/P: 5
 */
public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[][] arr = {
                {1, 9, 3, 2, 4, 20},
                {8, 20, 7, 30},
                {20, 30, 40}
        };

        for(int[] a : arr) {
            System.out.println("Using Bruteforce: " + longestConsecutiveSubsequence1(a));
            System.out.println("Using HashSet: " + longestConsecutiveSubsequence2(a));
            System.out.println("***************");
        }
    }


    /**
     * Using Bruteforce: Initialize longestConsecutiveSequenceLength and currentConsecutiveSequenceLength to 1.
     * Sort the array. Start the loop i from 1 to n - 1.
     * Compare current element with previous element. If they are in subsequence (x, x+1), increment
     * the currentConsecutiveSequenceLength count. Else, assign max of longestConsecutiveSequenceLength and
     * currentConsecutiveSequenceLength to longestConsecutiveSequenceLength and reset currentConsecutiveSequenceLength to 1.
     * Return the max of currentConsecutiveSequenceLength and longestConsecutiveSequenceLength.
     *
     * Time complexity: O(n * log n)
     * Space complexity: O(1) if input array is mutable. If it is not, SC is O(n)
     *
     * @param a array
     * @return the length of the longest consecutive sequence in the array
     */
    private static int longestConsecutiveSubsequence1(int[] a) {
        int longestConsecutiveSequenceLength = 1;
        Arrays.sort(a);
        int currentConsecutiveSequenceLength = 1;

        for(int i = 1; i < a.length; i++) {
            if(a[i] == a[i-1] + 1) {
                currentConsecutiveSequenceLength++;
            }
            // In case of duplicate elements, we want to ignore them.
            else if(a[i] != a[i-1]) {
                longestConsecutiveSequenceLength = Math.max(longestConsecutiveSequenceLength, currentConsecutiveSequenceLength);
                currentConsecutiveSequenceLength = 1;
            }
        }
        return Math.max(longestConsecutiveSequenceLength, currentConsecutiveSequenceLength);
    }


    /**
     * Using HashSet: First insert all the elements in the hashset. Then with 2n lookups, we find the
     * longest common subsequence.
     * 2n lookups: For the current element x, first check if x-1 is present.
     * If x-1 is not in the set, it means that x is the first element of the subsequence.
     * If x-1 is in the set, it means that x is not the first element of the subsequence, so we skip
     * the processing of x. Don't consider doing any computations.
     *
     * So if x is the first element, start a while loop checking if x+1, x+2, x+3 ... exists in
     * the set. Increment currentConsecutiveSequenceLength if elements of the subsequence exists.
     * After while loop ends, longestConsecutiveSequenceLength becomes max of longestConsecutiveSequenceLength
     * and currentConsecutiveSequenceLength.
     * Return longestConsecutiveSequenceLength
     *
     * Number of lookups is always 2n, where n is the size of the hashtable.
     * Example-1: set = {1, 3, 4, 2}
     * x = 1 => curr = 1, curr = 2, curr = 3, curr = 4 ------> 5 lookups (1 for x-1 and 4 for x+curr)
     * x = 3 => ---------> 1 (1 for x-1)
     * x = 4 => ---------> 1 (1 for x-1)
     * x = 2 => ---------> 1 (1 for x-1)
     * Total = 8 lookups
     *
     * Example-2: set = {8, 20, 4}
     * x = 8 => curr = 1 --------> 2 lookups (1 for x-1 and 1 for x+curr)
     * x = 20 => curr = 1 --------> 2 lookups (1 for x-1 and 1 for x+curr)
     * x = 4 => curr = 1 --------> 2 lookups (1 for x-1 and 1 for x+curr)
     * Total = 6 lookups
     *
     * For first elements: 2 + (len - 1) lookups, where len is the length of the subsequence
     * For other elements: 1 lookups
     *
     * Time complexity: Theta(n) - There is 2n lookups at most (always).
     * Space complexity: O(n)
     *
     * @param a
     * @return
     */
    private static int longestConsecutiveSubsequence2(int[] a) {
        int longestConsecutiveSequenceLength = 1;
        int currentConsecutiveSequenceLength;

        HashSet<Integer> set = new HashSet<>();
        for(int i : a) {
            set.add(i);
        }

        for(Integer i : set) {
            if(!set.contains(i-1)) {
                currentConsecutiveSequenceLength = 1;
                while (set.contains(i + currentConsecutiveSequenceLength)){
                    currentConsecutiveSequenceLength++;
                }
                longestConsecutiveSequenceLength = Math.max(longestConsecutiveSequenceLength,
                        currentConsecutiveSequenceLength);
            }
        }
        return longestConsecutiveSequenceLength;
    }

}
