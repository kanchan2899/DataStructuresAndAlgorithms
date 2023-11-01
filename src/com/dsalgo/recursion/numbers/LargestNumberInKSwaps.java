package com.dsalgo.recursion.numbers;

// https://www.geeksforgeeks.org/find-maximum-number-possible-by-doing-at-most-k-swaps/
public class LargestNumberInKSwaps {
    static String ans = "";
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        char[] arr = str.toCharArray();
        ans = str;
        int n = arr.length;
        solve(arr, k, 0, n);
        return ans;
    }

    static void solve(char[] arr, int k, int swapCount, int n) {
        if(swapCount == k) {
            return;
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j <= n - 1; j++) {
                if(arr[i] < arr[j]) {
                    swap(arr, i, j);
                    if(String.valueOf(arr).compareTo(ans) > 0) {
                        ans = String.valueOf(arr);
                    }
                    solve(arr, k, swapCount + 1, n);
                    swap(arr, j, i);
                }
            }
        }
    }

    static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

    }

    public static void main(String[] args) {
        String str = "129814999";
        int k = 4;

        System.out.println(findMaximumNum(str, k));
    }
}
