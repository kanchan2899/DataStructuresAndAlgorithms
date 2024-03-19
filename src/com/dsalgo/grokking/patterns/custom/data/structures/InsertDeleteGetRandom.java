package com.dsalgo.grokking.patterns.custom.data.structures;

import java.util.*;

// https://leetcode.com/problems/insert-delete-getrandom-o1/description/
public class InsertDeleteGetRandom {
    Map<Integer, Integer> dict;
    List<Integer> list;
    Random random = new Random();

    public InsertDeleteGetRandom() {
        dict = new HashMap<>();     // map actually value to its index
        list = new ArrayList<>();   // store actual values in an array
    }

    public boolean insert(int n) {
        // inserts a value in the data structure
        // return True if it did not already contain the specified element
        if(dict.containsKey(n)) {
            return false;
        }

        dict.put(n, list.size());
        list.add(list.size(), n);

        return true;
    }

    public boolean delete(int val) {
        // deletes a value from the data structure
        // returns true if it contained the specified element

        if(!dict.containsKey(val)) {
            return false;
        }

        int last = list.get(list.size() - 1);
        int index = dict.get(val);
        list.set(index, last);
        dict.put(last, index);
        list.remove(list.size() - 1);
        dict.remove(val);

        return true;
    }

    public int getRandomData() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        char[][] commands = {{'I', 'G', 'I', 'I', 'R', 'G'},
                {'I', 'I', 'R', 'G', 'R', 'I'}};
        int[][] values = {{10, -1, 100, 1000, 200, -1}, {30, 60, 10, -1, 30, 90}};

        for (int i = 0; i < values.length; i++) {
            InsertDeleteGetRandom randomSet = new InsertDeleteGetRandom();
            for(int j = 0; j < commands[i].length; j++) {
                if(commands[i][j] == 'I') {
                    System.out.println(randomSet.insert(values[i][j]));
                } else if(commands[i][j] == 'G') {
                    System.out.println(randomSet.getRandomData());
                } else if (commands[i][j] == 'R') {
                    System.out.println(randomSet.delete(values[i][j]));
                }
            }
        }
    }
}
