package com.dsalgo.hashing.core;


// -1 represents an empty slot and -2 represents the deleted slot
public class LinearProbing {
    int[] arr;
    int capacity, size;

    LinearProbing(int c){
        capacity = c;
        size = 0;
        for(int i = 0; i < capacity; i++) {
            arr[i] = -1;
        }
    }

    int hash(int key) {
        return key % capacity;
    }

    boolean search(int key) {
        int h = hash(key);
        int i = h;
        while (arr[i] != key){
            if(arr[i] == key) {
                return true;
            }
            i = (i + 1) % capacity;
            if(i == h) {
                return false;
            }
        }

        return false;
    }

    boolean insert(int key) {
        if(size == capacity) {
            return false;
        }
        int i = hash(key);
        while(arr[i] != -1 && arr[i] != -2 && arr[i] != key) {
            i = (i + 1) % capacity;
        }
        if(arr[i] == key) {
            return false;
        } else {
            arr[i] = key;
            size++;
            return true;
        }
    }

    boolean delete(int key) {
        int h = hash(key);
        int i = h;
        while(arr[i] != -1) {
            if(arr[i] == key) {
                arr[i] = -2;
                return true;
            }
            i = (i + 1) % capacity;
            if(i == h) {
                return false;
            }
        }
        return false;
    }
}
