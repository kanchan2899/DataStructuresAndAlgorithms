package com.dsalgo.hashing.core;

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
        table.get(i).remove((Integer) i);
    }

    boolean search(int key) {
        int i = key % BUCKET;
        return table.get(i).contains(key);
    }

    public static void main(String[] args) {
        SeparateChaining s = new SeparateChaining(10);

    }
}
