package com.dsalgo.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/sort-array-according-order-defined-another-array/
public class SortArrayAccordingToOther {
    public static void main(String[] args) {
        int[] a1 = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] a2 = {2, 1, 8, 3};
        System.out.println(Arrays.toString(sortA1ByA2(a1, a2)));
        System.out.println(Arrays.toString(sortA1ByA2_1(a1, a2)));
        System.out.println(Arrays.toString(sortA1ByA2_2(a1, a2)));
    }

    /**
     * Using customized comparator:
     *
     * Steps:
     * 1. If num1 and num2 both are in a2, then the number with a lower index in a2 will be treated
     * smaller than others.
     * 2. If only one of the num1 or num2 present in a2, then that number will be treated smaller
     * than the other which doesn't present in a2
     * 3. If both are not in a2, then the neutral ordering will be taken
     *
     * TC: O(n * m * log m), m = a1 size, n = a2 size
     * SC: O(n), n = a2 size
     *
     * @param a1
     * @param a2
     * @return
     */
    private static int[] sortA1ByA2_2(int[] a1, int[] a2) {
        // map to store the indices of elements in the second array
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for(int i = 0; i < a2.length; i++) {
            // consider only the first occurrence of element
            if(!indexMap.containsKey(a2[i])) {
                // assign value of i+1
                indexMap.put(a2[i], i+1);
            }
        }

        // since Java does not support custom comparators on primitive data types, we box the
        // elements in wrapper class.
        // sorted values are stored in a temporary array
        int[] temp = Arrays.stream(a1)
                .boxed()
                .sorted((p1, p2) -> {
                    int idx1 = indexMap.getOrDefault(p1, 0);
                    int idx2 = indexMap.getOrDefault(p2, 0);

                    // if both p1 and p2 are not present in the second array, sort them in ascending order
                    if(idx1 == 0 && idx2 == 0) {
                        return p1 - p2;
                    }

                    // if only p2 is present in the second array, p2 comes before p1
                    if(idx1 == 0) {
                        return 1;
                    }

                    // if only p1 is present in the second array, p1 comes before p2
                    if(idx2 == 0) {
                        return -1;
                    }

                    // if both p1 and p2 are present in the second array, sort them according to their
                    // respective indices
                    return idx1 - idx2;
                })
                .mapToInt(i -> i)
                .toArray();

        return temp;
    }

    /**
     * Using Hashing: Store the frequency of a1 and decrement the frequency in the a2 order
     *
     * Steps:
     * 1. Loop through a1, store the frequency of every element in a map
     * 2. Loop through a2, check if it is present in map, if so, put it in output array that many times
     * and remove the element from map
     * 3. Sort the rest of the numbers present in map and put it in the output array
     *
     * TC: O(m + n)
     * SC: O(m)
     *
     * @param a1
     * @param a2
     * @return
     */
    private static int[] sortA1ByA2_1(int[] a1, int[] a2) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int[] sortedArray = new int[a1.length];

        // indexing for output array
        int index = 0;

        // frequency of a1 elements in a map
        for(int i = 0; i < a1.length; i++) {
            frequencyMap.put(a1[i], frequencyMap.getOrDefault(a1[i], 0) + 1);
        }

        // traversing through a2 and store a1 elements according to a2 in sortedArray
        for(int i = 0; i < a2.length; i++) {
            // if a2[i] is present in map, iterate till the frequency of that element and store
            // a2[i] in the output array
            if(frequencyMap.containsKey(a2[i])) {
                for(int j = 1; j <= frequencyMap.get(a2[i]); j++) {
                    sortedArray[index++] = a2[i];
                }
            }

            // to avoid duplicate storing of elements
            frequencyMap.remove(a2[i]);
        }

        // last index in sortedArray - use it to sort the rest of the elements in a1
        int i = index;

        for(Map.Entry<Integer, Integer> entry: frequencyMap.entrySet()) {
            for(int j = 0; j < entry.getValue(); j++) {
                sortedArray[index++] = entry.getKey();
            }
        }

        Arrays.sort(sortedArray, i, a1.length);
        return sortedArray;
    }

    /**
     * Using binary search: First sort the a1 array and then according to a2 store the elements
     * Steps:
     * 1. Create a temporary array and copy a1 into temp array
     * 2. Create another array visited[] and initialize all entries in it as false. visited[] is used
     * to mark those elements in temp[] which are copied to a1
     * 3. Sort temp
     * 4. Initialize the output index as 0
     * 5. Do the following for every element of a2
     *      a. Binary search for all occurrences of a2 in temp, if present then copy all occurrences
     *      of a1[index] and increment index. Also, mark the copied elements visited[]
     * 6. Copy all unvisited elements from temp to a1
     *
     * TC: O(m * log m + n * log m), m = a1 size, n = a2 size
     * SC: O(m), m - a1 size
     *
     * @param a1
     * @param a2
     * @return
     */
    public static int[] sortA1ByA2(int a1[], int a2[]) {
        int[] temp = new int[a1.length];
        int[] visited = new int[a1.length];

        // temp array to store a copy of a1 and visited array is used to mark the visited elements
        // in a1
        for(int i = 0; i < a1.length; i++) {
            temp[i] = a1[i];
            visited[i] = 0;
        }

        // sort temp array
        Arrays.sort(temp);

        // for index of output which is sorted a1
        int index = 0;

        // consider all elements of a2, find them in temp and copy to a1 in order
        for(int i = 0; i < a2.length; i++) {
            // find index of the first occurrence of a2[i] in temp
            int firstIndex = firstIndex(temp, 0, a1.length - 1, a2[i]);

            if(firstIndex == -1) {
                continue;
            }

            // copy all occurrences of a2 to a1
            for(int j = firstIndex; j < a1.length && temp[j] == a2[i]; j++) {
                a1[index++] = temp[j];
                visited[j] = 1;
            }
        }

        // now copy all items of temp which are not present in a2
        for(int i = 0; i < a1.length; i++) {
            if(visited[i] == 0) {
                a1[index++] = temp[i];
            }
        }
        return a1;
    }

    private static int firstIndex(int[] arr, int low, int high, int x) {
        if(high >= low) {
            int mid = low + (high - low) / 2;
            if((mid == 0 || x > arr[mid - 1]) && arr[mid] == x) {
                return mid;
            }
            if(x > arr[mid]) {
                return firstIndex(arr, mid + 1, high, x);
            }
            return firstIndex(arr, low, mid - 1, x);
        }
        return -1;
    }
}
