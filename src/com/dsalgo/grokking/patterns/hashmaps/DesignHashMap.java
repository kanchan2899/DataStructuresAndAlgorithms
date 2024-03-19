package com.dsalgo.grokking.patterns.hashmaps;

import java.util.List;

// https://leetcode.com/problems/design-hashmap/
class ListNode {
    int key, val;
    ListNode next;

    public ListNode(int key, int val, ListNode next) {
        this.key = key;
        this.val = val;
        this.next = next;
    }
}
public class DesignHashMap {
    static final int size = 19997;
    static final int multiplier = 12582917;

    ListNode[] data;

    public DesignHashMap() {
        this.data = new ListNode[size];
    }

    private int hash(int key) {
        return (int) ((long) key * multiplier % size);
    }

    public void put(int key, int val) {
        remove(key);
        int hash = hash(key);
        ListNode node = new ListNode(key, val, data[hash]);
        data[hash] = node;
    }

    private void remove(int key) {
        int hash = hash(key);
        ListNode node = data[hash];

        if(node == null) {
            return;
        }
        if(node.key == key) {
            data[hash] = node.next;
        } else {
            for (; node.next != null; node = node.next) {
                if(node.next.key == key) {
                    node.next = node.next.next;
                    return;
                }
            }
        }
    }

    public int get(int key) {
        int hash = hash(key);
        ListNode node = data[hash];

        for(; node != null; node = node.next) {
            if(node.key == key) {
                return node.val;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DesignHashMap map = new DesignHashMap();

        map.put(1, 3);
        map.put(2, 4);
        map.put(3, 5);
        System.out.println(map.get(2));
        map.remove(1);
        System.out.println(map.get(1));
    }
}
