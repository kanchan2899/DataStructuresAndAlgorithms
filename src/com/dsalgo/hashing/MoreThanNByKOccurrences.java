package com.dsalgo.hashing;

import java.util.*;

// https://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
public class MoreThanNByKOccurrences {
    public static void main(String[] args) {
        int[][] arr = {
                {30, 10, 20, 20, 10, 20, 30, 30},
                {30, 10, 20, 30, 30, 40, 30, 40, 30}
        };
        int[] k = {
                4,
                2
        };

        for(int i = 0; i < arr.length; i++) {
            System.out.println("Using Bruteforce: " + moreThanNByKOccurrences1(arr[i], k[i]));
            System.out.println("Using HashMap: " + moreThanNByKOccurrences2(arr[i], k[i]));
            System.out.println("Using Boyer-Moore algorithm: " + moreThanNByKOccurrences3(arr[i], k[i]));
            System.out.println("***************");
        }

    }


    /**
     * Using Bruteforce: Sort the array first. Initialize i = 1 and count to 1.
     * Start a while loop till  i < n. Start inner while loop til i < n  && arr[i] == arr[i - 1]
     * Increment count and i. Come out of while and check if count > n / k. Print a[i - 1]
     * Reset count to 1 and increment i.
     *
     * Time complexity: O(n * log n)
     * Space complexity: O(1)
     *
     * @param arr
     * @param k
     * @return the elements that have occurrence more than n / k
     */

    private static ArrayList moreThanNByKOccurrences1(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> elementsList = new ArrayList<>();
        int i = 1, count = 1;
        while(i < arr.length) {
            while(i < arr.length && arr[i] == arr[i - 1]) {
                count++;
                i++;
            }
            if(count > arr.length / k) {
                elementsList.add(arr[i - 1]);
            }
            count = 1;
            i++;
        }
        return elementsList;
    }

    /**
     * Using HashMap: Initialize the HashMap that will contain the count of each element.
     * Traverse through the array and add the elements to the hashmap.
     * Traverse through the hashmap and check if the count is more that n / k. Print the element (key).
     *
     * Time complexity: O(n)
     * Space complexity: O(n)
     *
     * @param arr
     * @param k
     * @return the elements that have occurrence more than n / k
     */

    private static ArrayList<Integer> moreThanNByKOccurrences2(int[] arr, int k) {
        ArrayList<Integer> elementsList = new ArrayList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for(int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }

        for(Integer i : countMap.keySet()) {
            if(countMap.get(i) > arr.length / k) {
                elementsList.add(i);
            }
        }
        return elementsList;
    }


    /**
     * Let result_count be the number of elements in the result, then result_count <= k - 1.
     *      k * (n / k + 1) <= n, means that n + k <= n (which is not true)
     *
     *  Extension of Boyer-Moore Algorithm:
     *  1. Create an empty map m
     *  2. for(int i = 0 ; i < a.length; i++)
     *  3.      if(m.contains(a[i]) { m[a[i]]++; }
     *  4.      else if(m.size() is less than k - 1 { m.put(arr[i], 1); }
     *  5.      else { decrease all values in m by 1. If value becomes 0, remove it.}
     *  6. For all elements in m, print the elements that actually appear more than n/k times.
     *
     *  TC: O(n)
     *  SC: O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    private static ArrayList<Integer> moreThanNByKOccurrences3(int[] arr, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            if(frequencyMap.containsKey(arr[i])) {
                frequencyMap.put(arr[i], frequencyMap.get(arr[i]) + 1);
            }
            else if(frequencyMap.size() < k - 1) {
                frequencyMap.put(arr[i], 1);
            } else {
                Iterator it = frequencyMap.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry item = (Map.Entry) it.next();
                    item.setValue((int)item.getValue() - 1);
                    if((int)item.getValue() == 0){
                        it.remove();
                    }
                }
//                for(Integer p : frequencyMap.keySet()) {
//                    frequencyMap.replace(p, frequencyMap.get(p) - 1);
//                    if(frequencyMap.get(p) == 0) {
//                        frequencyMap.remove(p);
//                    }
//                }
            }
        }

        for(Integer r : frequencyMap.keySet()){
            int count = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == r) {
                    count++;
                }
            }
            if(count > arr.length/k) {
                al.add(r);
            }
        }
        return al;
    }


}
