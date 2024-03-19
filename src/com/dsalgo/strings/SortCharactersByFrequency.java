package com.dsalgo.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(sortChars(s));
    }

    private static String sortChars(String s) {
        Map<Character, Integer> freq = new HashMap<>();

        for(char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        StringBuilder str = new StringBuilder();

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue());

        pq.addAll(freq.entrySet());

        while(!pq.isEmpty()) {
            Map.Entry<Character, Integer> entry = pq.poll();
            str.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return str.toString();
    }
}
