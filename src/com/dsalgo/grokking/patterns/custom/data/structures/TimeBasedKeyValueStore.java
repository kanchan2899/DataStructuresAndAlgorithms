package com.dsalgo.grokking.patterns.custom.data.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/time-based-key-value-store/description/
class Triplet {
    public String course;
    public String cName;
    public int id;

    public Triplet(String course, String cName, int id) {
        this.course = course;
        this.cName = cName;
        this.id = id;
    }
}
public class TimeBasedKeyValueStore {
    HashMap<String, List<String>> valuesDict;
    HashMap<String, List<Integer>> timestampsDict;

    public TimeBasedKeyValueStore() {
        valuesDict = new HashMap<>();
        timestampsDict = new HashMap<>();
    }

    public void setValue(String key, String value, int timestamp) {
        // check if the given key already exists in the values dictionary
        if(valuesDict.containsKey(key)) {
            // check if the given value of the key already exists in the values dictionary
            if(value != valuesDict.get(key).get(valuesDict.get(key).size() - 1)) {
                // store values for the given key in the values dictionary
                valuesDict.get(key).add(value);

                // store timestamp for the given key in the timestamp dictionary
                timestampsDict.get(key).add(timestamp);
            }
        } else {
            // store value and key for the given key in the values dictionary
            valuesDict.put(key, new ArrayList<String>());
            valuesDict.get(key).add(value);
            timestampsDict.put(key, new ArrayList<>());

            // store timestamp for the given key in the timestamp dictionary
            timestampsDict.get(key).add(timestamp);
        }
    }

    // find the index of right most occurrence of the given timestamp using binary search
    public int searchIndex(int n, String key, int timestamp) {
        int left = 0;
        int right = 0;
        int mid = 0;

        while (left < right) {
            // it will return the mid of the current dictionary
            mid = left + (right - left) / 2;

            // increase index value if required index is less than the current index otherwise decrease it
            if(!(timestampsDict.get(key).get(mid) > timestamp)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    // get the value for the given key and timestamp
    public String getValue(String key, int timestamp) {
        int index = 0;

        // check if the given key is present in the values dictionary
        if(!valuesDict.containsKey(key)) {
            // return empty string if item does not exist
            return "";
        } else {
            // find the right most occurrence of the given timestamp
            index = searchIndex(timestampsDict.get(key).size(), key, timestamp);
        }

        // if the timestamp exist in the timestamp dictionary, return the value with the timestamp
        if(index > -1) {
            return valuesDict.get(key).get(index);
        }

        // return empty string if the timestamp does not exist
        return "";
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore ts = new TimeBasedKeyValueStore();
        int num = 1;
        List<Triplet> input = Arrays.asList(new Triplet("course", "OOP", 3), new Triplet("course", "PF", 5), new Triplet("course", "OS", 7), new Triplet("course", "ALGO", 9), new Triplet("course", "DB", 10));

        for(int i = 0; i < input.size(); i++)
        {
            ts.setValue(input.get(i).course, input.get(i).cName, input.get(i).id);
            System.out.println(ts.getValue("course", 3));
        }
    }
}
