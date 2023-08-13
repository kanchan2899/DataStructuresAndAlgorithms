package com.dsalgo.hashing.core;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

// Todo: Implement the same with key-value pair


public class SeparateChaining {
    int BUCKET;
    ArrayList<LinkedList<Integer>> table;

    SeparateChaining(int b) {
        BUCKET = b;
        table = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < b ; i++) {
            table.add(new LinkedList<Integer>());
        }
    }

    void insert(int key) {
        int i = key % BUCKET;
        table.get(i).add(key);
    }

    void delete(int key) {
        int i = key % BUCKET;
        table.get(i).remove((Integer) key);
    }

    boolean search(int key) {
        int i = key % BUCKET;
        return table.get(i).contains(key);
    }

    void displayHash() {
        for(int i = 0; i < BUCKET; i++) {
            System.out.print(i);
            for(Integer x : table.get(i)) {
                System.out.print(" ---> " + x);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SeparateChaining s = new SeparateChaining(7);
        int[] arr = {15, 11, 27, 8, 12};
        for(int i = 0; i < arr.length; i++) {
            s.insert(arr[i]);
        }

        s.delete(12);

        s.displayHash();

        s.delete(27);

        s.displayHash();
    }
}
