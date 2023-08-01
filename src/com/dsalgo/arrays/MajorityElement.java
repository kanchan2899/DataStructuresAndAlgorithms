package com.dsalgo.arrays;

import java.util.HashMap;

/*
    https://leetcode.com/problems/majority-element/
    The majority element is the element that appears more than floor(n/2) times. You may assume
    that the majority element always exists in the array.

 */
public class MajorityElement {
    public static void main(String[] args) {
        int[][] arr = {
                        {3, 2, 3},
                        {2, 2, 1, 1, 1, 2, 2},
                        {1, 1, 3, 1, 1, 3, 3, 3, 3, 3},
                        {1, 2, 3}
                    };

        for(int[] a : arr) {
            System.out.println("Using Boyer-Moore Majority Element: " + majorityElement1(a));
            System.out.println("Using HashMap: " + majorityElement2(a));
            System.out.println("Using Bruteforce: " + majorityElement3(a));
            System.out.println("**********************");
        }
    }

    /**
     * Using Bruteforce: Traverse all elements with loop i from 0 to n-1. Initialize count to 0
     * Start an inner loop j from i+1 to n-1 to find if a[j] == a[i]. If so, increment count.
     * If count is greater than n/2, return the index of the element i.
     *
     * TC: O(n^2)
     * SC: O(1)
     * @param a
     * @return
     */
    private static int majorityElement3(int[] a) {
        for(int i = 0; i < a.length; i++) {
            int count = 1;
            for(int j = i + 1; j < a.length; j++) {
                if(a[i] == a[j]) {
                    count++;
                }
            }
            if(count > a.length / 2) {
                return a[i];
            }
        }
        return -1;
    }

    /**
     * Boyer-Moore Majority Element: This algorithm works on the fact that if an element occurs
     * more than N/2 times, it means that the remaining elements other than this would definitely
     * be less than N/2. The approach is to first choose a candidate from the given set of elements
     * if it is the same as the candidate element, increase the votes. Otherwise, decrease the votes.
     * If votes becomes 0, select another new element as the new candidate.
     *
     * Intuition behind working: When the elements are the same as the candidate element, votes are
     * incremented whereas when some other element is found (not equal to the candidate element), we
     * decreased the count. This actually means that we are decreasing the priority of winning ability
     * of the selected candidate, since we know that if the candidate is in majority, it occurs more
     * than N/2 times and the remaining elements are less than N/2. We keep decreasing the votes since
     * we found some different element(s) other than the candidate element. When votes become 0, this
     * actually means that there are the equal number of votes for different elements, which should
     * not be the case for the element to be the majority element. So the candidate element cannot be
     * the majority and hence we choose the present element as the candidate and continue the same till
     * all the elements get finished. The final candidate would be our majority element. We check
     * using the second traversal to see whether its count is greater than N/2. If it is true, we
     * consider it as the majority element.
     *
     * Steps:
     * 1. Find a candidate with the majority
     *      a. Initialize a variable say i, votes = 0, candidate = 1
     *      b. Traverse through the array using for loop
     *      c. If votes = 0, choose the candidate = arr[i], make votes = 1
     *      d. Else if the current element is the same as the candidate, increment votes
     *      e. Else decrement votes.
     * 2. Check if the candidates has more than N/2 votes
     *      a. Initialize a variable count = 0 and increment count if it is the same as the candidate.
     *      b. If the count > N/2, return the candidate.
     *      c. Else return -1.
     *
     * Example:
     * arr[] =          1    1   1   1   2   3   5
     * votes = 0        1   2   3   4   3   2   1
     * candidate = -1   1   1   1   1   1   1   1
     * candidate = 1 after first traversal
     *
     * count = 0        1   2   3   4   4   4   4
     * candidate = 1 and count > 7/2. Hence, 1 is the majority element.
     *
     * Time complexity: O(n), traverse the array 2n times
     * Space complexity: O(1)
     *
     *
     * @param a array with one majority element
     * @return the majority element
     */
    private static int majorityElement1(int[] a) {
        int count = 0, candidate = -1;

        // Find the majority candidate
        for(int i = 0; i < a.length; i++) {
            if(count == 0){
                candidate = a[i];
                count = 1;
            } else {
                if(a[i] == candidate) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        // Check if majority candidate occurs more than N/2 times
        count = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i] == candidate) {
                count++;
            }
            if(count > a.length / 2) {
                return candidate;
            }
        }

        return -1;
    }

    /**
     * Using Hashmap: Create a frequency map for all array elements. Traverse through the map and
     * check if the frequency of any element is greater than n/2. If so, return the index of element.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param a
     * @return
     */
    private static int majorityElement2(int[] a) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for(int i : a) {
            frequencyMap.put(i, frequencyMap.getOrDefault(i, 0) + 1);
        }
        for(Integer i : frequencyMap.keySet()) {
            if(frequencyMap.get(i) > a.length / 2) {
                return i;
            }
        }
        return -1;
    }


}
