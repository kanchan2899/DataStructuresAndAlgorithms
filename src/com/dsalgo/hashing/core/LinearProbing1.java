package com.dsalgo.hashing.core;

import java.util.Arrays;
import java.util.HashSet;

public class LinearProbing1 {
    public static void main(String[] args) {
        int hash_size = 10;
        int sizeOfArray = 4;
        int[] arr = {9, 99, 999, 9999};

        System.out.println(Arrays.toString(linearProbing(hash_size, arr, sizeOfArray)));
    }

    static int[] linearProbing(int hash_size, int arr[], int sizeOfArray) {
        int[] table = new int[hash_size];

        Arrays.fill(table, -1);
        int size = 0;

        for(int j = 0; j < sizeOfArray; j++) {
            if(size == hash_size) {
                break;
            }
            int h = arr[j] % hash_size;
            int i = h;
            while(table[i] != -1 && table[i] != arr[j]) {
                i = (i + 1) % hash_size;
            }

            if(table[i] == arr[j]) {
                continue;
            } else {
                table[i] = arr[j];
                size++;
            }
        }

        return table;
    }
}
