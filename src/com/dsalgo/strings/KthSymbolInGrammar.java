package com.dsalgo.strings;

public class KthSymbolInGrammar {
    public static void main(String[] args) {
        int n = 3;
        int k = 4;

        System.out.println(kthGrammar(n, k));
    }

    public static int kthGrammar(int n, int k) {
        if(n == 1) {
            return 0;
        }
        int numberOfColumns = (int) (Math.pow(2, n - 1));
        int mid = numberOfColumns / 2;

        if(k <= mid) {
            return kthGrammar(n - 1, k);
        } else {
            k = k - mid;
            int o = kthGrammar(n - 1, k);
            return o == 0 ? 1 : 0;
        }
    }
}
