package com.dsalgo.stacks;

// https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
public class TwoStacksInAnArray {
    int arr[];
    int capacity, top1, top2;

    TwoStacksInAnArray(int n) {
        arr = new int[n];
        capacity = n;
        top1 = -1;
        top2 = n;
    }

    boolean push1(int x) {
        if(top1 < top2 - 1) {
            top1++;
            arr[top1] = x;
            return true;
        }
        return false;
    }

    boolean push2(int x) {
        if(top1 < top2 - 1) {
            top2--;
            arr[top2] = x;
            return true;
        }
        return false;
    }

    int pop1() {
        if(top1 >= 0) {
            int x = arr[top1];
            top1--;
            return x;
        }
        return -1;
    }

    int pop2() {
        if(top2 < capacity) {
            int x = arr[top2];
            top2++;
            return x;
        }
        return -1;
    }

    int size1() {
        return (top1 + 1);
    }

    int size2() {
        return (capacity - top2);
    }

    public static void main(String[] args) {
        TwoStacksInAnArray twoStacksInAnArray = new TwoStacksInAnArray(10);
        twoStacksInAnArray.push1(1);
        twoStacksInAnArray.push2(10);
        twoStacksInAnArray.push2(9);
        twoStacksInAnArray.push1(2);
    }
}
