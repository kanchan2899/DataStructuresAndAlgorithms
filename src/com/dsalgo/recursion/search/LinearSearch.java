package com.dsalgo.recursion.search;

import java.util.ArrayList;

public class LinearSearch {
    static ArrayList<Integer> indexList = new ArrayList<>();
    public static void main(String[] args) {
        int target = 3;
        int[] arr = {3, 2, 4, 9, 5, 3};
        System.out.println(findIndex(arr, target, 0));
        System.out.println(isElementPresent(arr, target, 0));
        findAllIndex(arr, target, 0);
        System.out.println(indexList);
        System.out.println(findIndex1(arr, target, 0));
    }

    private static ArrayList<Integer> findIndex1(int[] arr, int target, int i) {
        ArrayList<Integer> list = new ArrayList<>();
        if(i == arr.length)
            return list;
        if(arr[i] == target)
            list.add(i);
        ArrayList<Integer> ansFromBelowCalls = findIndex1(arr, target, i + 1);
        list.addAll(ansFromBelowCalls);
        return list ;
    }

    private static void findAllIndex(int[] arr, int target, int i) {
        if(i == arr.length)
            return;
        if(arr[i] == target)
            indexList.add(i);
        findAllIndex(arr, target, i + 1);
    }

    private static boolean isElementPresent(int[] arr, int target, int i) {
        if(i == arr.length){
            return false;
        }
        return arr[i] == target || isElementPresent(arr, target, i + 1);
    }

    private static int findIndex(int[] arr, int target, int currentElement) {
        if(currentElement == arr.length)
            return -1;
        if(arr[currentElement] == target)
            return currentElement;
        return findIndex(arr, target, currentElement + 1);
    }
}
