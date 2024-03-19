package com.dsalgo.grokking.patterns.trie;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public static void main(String[] args) {
        int n = 15;
        System.out.println(lexicalOrder(n));
    }

    private static List<Integer> lexicalOrder(int n) {
        List<Integer> lexicalOrder = new ArrayList<>();

        dfs(lexicalOrder, n, 0);

        return lexicalOrder;
    }

    private static void dfs(List<Integer> lexicalOrder, int n, int num) {
        for(int i = 0; i <= 9; i++) {
            int curr = 10 * num + i;

            // get rid of 0
            if(curr == 0) {
                continue;
            }

            // when larger than n, return to the previous level
            if(curr > n) {
                return;
            }
            lexicalOrder.add(curr);
            dfs(lexicalOrder, n, curr);
        }
    }
}

