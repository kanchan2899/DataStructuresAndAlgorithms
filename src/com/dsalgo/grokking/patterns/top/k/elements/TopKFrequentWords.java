package com.dsalgo.grokking.patterns.top.k.elements;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-words/description/
public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        System.out.println(topKFrequentWords(words, k));
    }

    private static List<String> topKFrequentWords(String[] words, int k) {

        List<String> topKWords = new ArrayList<>();
        Map<String, Integer> frequencyMap = new HashMap<>();

        for(int i = 0; i < words.length; i++) {
            frequencyMap.put(words[i], frequencyMap.getOrDefault(words[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b) ->
                a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue());

        for(Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
            maxHeap.offer(entry);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        while (!maxHeap.isEmpty()) {
            topKWords.add(0, maxHeap.poll().getKey());
        }
        return topKWords;
    }
}
