package com.dsalgo.grokking.patterns.topological.sort;

import java.util.*;

// https://leetcode.com/problems/alien-dictionary/
public class AlienDictionary {
    public static void main(String[] args) {
        List<String> alienWords = Arrays.asList("mzosr", "mqov", "xxsvq", "xazv", "xazau", "xaqu", "suvzu", "suvxq", "suam", "suax", "rom", "rwx", "rwv");
        System.out.println(sortedAlienWords(alienWords));
    }

    /**
     *
     * 1. Extract the necessary information to identify the dependency rules from the words.
     * For example, in the words [“patterns”, “interview”], the letter “p” comes before “i.”
     *
     * 2. With the gathered information, we can put these dependency rules into a directed
     * graph with the letters as nodes and the dependencies (order) as the edges.
     *
     * 3. Lastly, we can sort the graph nodes topologically to generate the letter ordering
     * (dictionary).
     *
     *
     * @param alienWords
     * @return
     */
    private static String sortedAlienWords(List<String> alienWords) {
        HashMap<Character, List<Character>> adjList = new HashMap<>();
        // counts stores the number of unique letters
        HashMap<Character, Integer> count = new HashMap<>();

        for(String word: alienWords) {
            char[] charArray = word.toCharArray();
            for(char c : charArray) {
                count.put(c, 0);
            }
        }

        Set<Character> characters = count.keySet();

        // Step 1: We need to populate adj_list and counts.
        // For each pair of adjacent words...
        for(int i = 0; i < alienWords.size() - 1; i++) {
            String word1 = alienWords.get(i);
            String word2 = alienWords.get(i + 1);
            int j = 0;
            for(j = 0; j < word1.length() || j < word2.length(); j++) {
                char c = word1.charAt(j), d = word2.charAt(j);
                if(c != d) {
                    if (adjList.get(c) == null) {
                        adjList.put(c, new ArrayList<Character>());
                    }
                    if(adjList.get(d) == null) {
                        adjList.put(d, new ArrayList<Character>());
                    }

                    boolean found = false;

                    for(int k = 0; k < adjList.get(c).size(); k++) {
                        if(adjList.get(c).get(k) == d) {
                            found = true;
                        }
                    }

                    if(found == false) {
                        adjList.get(c).add(d);
                        count.put(d, count.get(d) + 1);
                    }
                    break;
                }
            }
            // check that second word isn't a prefix of the first word
            if(j >= word1.length() || j >= word2.length()) {
                if(word2.length() < word1.length()) {
                    return "";
                }
            }
        }

        // Step 2. We need to repeatedly pick off nodes with an indegree of 0.
        List<Character> result = new ArrayList<>();
        Deque<Character> queue = new ArrayDeque<>();
        for(char c : count.keySet()) {
            if(count.get(c) == 0) {
                queue.add(c);
            }
        }

        while (!queue.isEmpty()) {
            char c = queue.removeFirst();
            result.add(c);

            if(adjList.get(c) == null) {
                adjList.put(c, new ArrayList<>());
            }

            for(int f = 0; f < adjList.get(c).size(); f++) {
                char d = adjList.get(c).get(f);
                count.put(d, count.get(d) - 1);
                if(count.get(d) == 0) {
                    queue.add(d);
                }
            }
        }

        // if not all the letters are in result, that means there was a cycle and so no valid
        // ordering. Return ""
        if(result.size() < characters.size()) {
            return "";
        }

        // otherwise, convert the ordering we found into a string and return it
        StringBuilder sb = new StringBuilder();

        // append characters one by one
        for(Character ch: result) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
