package com.dsalgo.heap;

public class HeapNode implements Comparable<HeapNode>{
    int x;
    int y;
    int value;

    HeapNode(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    @Override
    public int compareTo(HeapNode hn) {
        if(this.value <= hn.value) {
            return -1;
        } else {
            return 1;
        }
    }
}
