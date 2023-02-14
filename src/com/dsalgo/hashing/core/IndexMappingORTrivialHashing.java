package com.dsalgo.hashing.core;


// https://www.geeksforgeeks.org/index-mapping-or-trivial-hashing-with-negatives-allowed/

// Trivial Hashing or Index Mapping is a simple form of hashing where the data is directly mapped
// to an index in a hash table.

public class IndexMappingORTrivialHashing {
    final static int MAX = 1000;
    static boolean[][] hasNum = new boolean[MAX + 1][2];
    public static void main(String[] args) {
        int a[] = {-1, 9, 2, 6, -8, 10};
        int n = a.length;
        insert(a, n);

        int x = -8;
        if(search(x) == true) {
            System.out.println("number is present");
        } else {
            System.out.println("number is not present");
        }
    }

    private static boolean search(int x) {
        if(x >= 0) {
            if(hasNum[x][0] == true){
                return true;
            }
        } else {
            int abs_x = Math.abs(x);
            if(hasNum[abs_x][1]) {
                return true;
            }
        }
        return false;
    }

    private static void insert(int[] a, int n) {
        for(int i = 0; i < n; i++) {
            if(a[i] >= 0) {
                hasNum[a[i]][0] = true;
            } else {
                int abs_num = Math.abs(a[i]);
                hasNum[abs_num][1] = true;
            }
        }
    }
}
