package com.dsalgo.recursion.numbers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinnerOfTheCircularGame {
    public static void main(String[] args) {
        int n = 6, k = 5;
        System.out.println(findTheWinner(n, k));
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> list = IntStream.rangeClosed(1, n)
                .boxed()
                .collect(Collectors.toList());
        return helper(k, 0, list);
    }

    private static int helper(int k, int i, List<Integer> list) {
        if(list.size() == 1) {
            return list.get(0);
        }
        int index = (i + k - 1) % list.size();
        list.remove(index);
        return helper(k, index, list);
    }
}
