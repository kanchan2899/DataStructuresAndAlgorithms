package com.dsalgo.grokking.patterns.tree.bfs;

import java.util.*;

public class WordLadder {
    public static int wordLadder(String src, String dest, List<String> words) {
        // create a set of words for faster lookup
        Set<String> wordsSet = new HashSet<>(words);

        // if the dest is not in the set, return 0;
        if(!wordsSet.contains(dest)) {
            return 0;
        }

        // create a queue for the words to be checked
        Queue<String> queue = new LinkedList<>();
        queue.offer(src);

        // initialize the length counter
        int length = 0;

        while (!queue.isEmpty()) {
            length++;
            // store the length of the queue
            int size = queue.size();

            // check all the words in the current level
            for(int i = 0; i < size; i++) {
                String curr = queue.poll();

                // iterate on each character of the popped word
                for(int j = 0; j < curr.length(); j++) {

                    String alphabets = "abcdefghijklmnopqrstuvwxyz";

                    // iterate with all possible characters
                    for(int k = 0; k < alphabets.length(); k++) {
                        // create a new word by replacing the jth character of the popped word
                        char[] temp = curr.toCharArray();
                        temp[j] = alphabets.charAt(k);

                        String newWord = new String(temp);

                        // check if the new word is the dest
                        if(newWord.equals(dest)) {
                            return length + 1;
                        }

                        // check if the new word is in the set
                        // if it is, push it into the queue and remove it from the set
                        if(wordsSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordsSet.remove(newWord);
                        }
                    }
                }
            }
        }
        // return 0 if noe sequence exists
        return 0;
    }
}
