package com.dsalgo.hashing;


import com.dsalgo.recursion.numbers.Handshakes;

import java.util.*;

// https://www.geeksforgeeks.org/sort-elements-by-frequency/

class Element {
    int count, index, value;
}

// Sort by value
class ValueComparator implements Comparator<Element> {

    @Override
    public int compare(Element o1, Element o2) {
        return o1.value - o2.value;
    }
}

class FrequencyComparator implements Comparator<Element> {

    @Override
    public int compare(Element o1, Element o2) {
        if(o1.count != o2.count)
        {
            return o1.count - o2.count;
        }
        return o2.index - o1.index;
    }
}
public class SortElementsByFrequency {
    public static void main(String[] args) {
        int[] arr = {5,5,4,6,4};
        sortByFreq(arr);
        System.out.println(Arrays.toString(arr));
        Integer[] arr1 = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
        sortBasedOnFrequencyAndValue(arr1);
        int[] arr2 = {3, 2, 3, 2, 2, 4, 4, 5};
        System.out.println(sortByFrequency(arr2));
    }

    /**
     * Using priority queue:
     *
     *
     * @param arr
     * @return
     */
    private static List<Integer> sortByFrequency(int[] arr) {
        List<Integer> list = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int item : arr) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<>((a, b) -> a.getValue() == b.getValue() ?
                        a.getKey() - b.getKey() : b.getValue() - a.getValue());

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(e);
        }

        while(!pq.isEmpty()) {
            int ch = pq.poll().getKey();
            int val = map.get(ch);
            while(val != 0) {
                list.add(ch);
                val--;
            }
        }
        return list;
    }

    private static void sortBasedOnFrequencyAndValue(Integer[] a) {
        List<Integer> list = Arrays.asList(a);

        HashMap<Integer, Integer> mapCount = new HashMap<>();
        HashMap<Integer, Integer> mapIndex = new HashMap<>();

        for(int i = 0; i < a.length; i++) {
            if(mapCount.containsKey(a[i])) {
                mapCount.put(a[i], mapCount.get(a[i]) + 1);
            } else {
                mapCount.put(a[i], 1);
                mapIndex.put(a[i], i);
            }
        }


        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                int freq1 = mapCount.get(n1);
                int freq2 = mapCount.get(n2);
                if(freq1 != freq2) {
                    return freq2 - freq1;
                } else {
                    return mapIndex.get(n1) - mapIndex.get(n2);
                }
            }
        });
        System.out.println(list);
    }

    /**
     * Using sorting:
     *
     * Use a sorting algorithm to sort the elements
     * Iterate the sorted array and construct a 2D array of elements and count
     * Sort the 2D array according to the count
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param arr
     */
    static void sortByFreq(int arr[])
    {
        ArrayList<Element> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            list.add(new Element());
            list.get(i).index = i;
            list.get(i).count = 0;
            list.get(i).value = arr[i];
        }

        // sort the structure elements according to value
        Collections.sort(list, new ValueComparator());

        // initialize count of first element as 1
        list.get(0).count = 1;

        // count occurrences of remaining elements
        for(int i = 1; i < arr.length; i++) {
            if(list.get(i).value == list.get(i - 1).value) {
                list.get(i).count += list.get(i - 1).count + 1;

                // set the count of previous element as -1 because we will again sort on the basis of
                // counts are equal than on the basis of index
                list.get(i - 1).count = -1;

                // retain the first index
                list.get(i).index = list.get(i - 1).index;
            } else { // previous element is not equal to the current element, so set it to 1
                list.get(i).count = 1;
            }
        }

        // now we have counts and first index for each element so now sort on the basis
        // count and in case of tie use index to sort

        Collections.sort(list, new FrequencyComparator());

        for(int i = arr.length - 1, index = 0; i >= 0; i--) {
            if(list.get(i).count != -1) {
                for(int j = 0; j < list.get(i).count; j++) {
                    arr[index++] = list.get(i).value;
                }
            }
        }
    }


}
