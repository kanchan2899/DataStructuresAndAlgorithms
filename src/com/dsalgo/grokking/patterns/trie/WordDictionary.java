package com.dsalgo.grokking.patterns.trie;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class WordDictionary {
    static WordDictionaryNode root = new WordDictionaryNode();
    static boolean canFind = false;

    public WordDictionary() {
        root = new WordDictionaryNode();
        canFind = false;
    }

    public static List<String> getWords() {
        List<String> wordsList = new ArrayList<>();
        // return an empty list if the root is null
        if(root == null) {
            return new ArrayList<>();
        }
        // perform DFS on the trie
        return DFS(root, "", wordsList);
    }

    private static List<String> DFS(WordDictionaryNode node, String word, List<String> wordsList) {
        // if the node is null, return the wordList
        if(node == null) {
            return wordsList;
        }


        // if the word is complete, add it to the wordsList
        if(node.complete) {
            wordsList.add(word);
        }

        for(int i = (int)'a'; i <= (int)'z'; i++) {
            String prefix = word + (char) i;
            wordsList = DFS(node.children[i - 'a'], prefix.toString(), wordsList);
        }
        return wordsList;
    }

    public static void addWord(String word) {
        int n = word.length();

        WordDictionaryNode currentNode = root;

        for(int i = 0; i < n; i++) {
            // find the correct index of the character in the list of nodes
            int index = (int)(word.charAt(i) - 'a');

            // if the letter is not present in the trie, then create a new trie node for it,
            // otherwise use the existing trie node for this letter
            if(currentNode.children[index] == null) {
                currentNode.children[index] = new WordDictionaryNode();
            }

            currentNode = currentNode.children[index];

            if(i == n - 1) {
                // if we've reached the end of word and complete flag is already set
                // this means that it is already present in the dictionary
                if(currentNode.complete) {
                    return;
                }
            }

            currentNode.complete = true;
        }
    }

    public static boolean search(String word) {
        // set the canFind variable as FALSE
        canFind = false;

        // perform depth-first search to iterate over the children nodes
        searchHelper(root, word, 0);
        return canFind;
    }

    private static void searchHelper(WordDictionaryNode node, String word, int i) {
        // if the word has already been found and there is no need for further searching,
        // return the control to the calling context
        if(canFind)
            return;

        // return the control to the calling context if the current node is empty
        if(node == null) {
            return;
        }

        int n = word.length();

        // if we have found the last character of the query string in the trie and
        // the complete flag is set, we have found the entire word
        if(n == i) {
            if(node.complete) {
                canFind = true;
            }
            return;
        }

        // if the word contains a wildcard character ".", match it with all of the children
        // (letters) of the current node and perform depth first search starting at each child
        if(word.charAt(i) == '.') {
            for(int j = (int)'a'; j <= (int)'z'; j++) {
                searchHelper(node.children[(char) j - 'a'], word, i + 1);
            }
        } else {
            // otherwise, simply locate the child corresponding to the current character
            int index = word.charAt(i) - 'a';

            // and continue the depth-first traversal
            searchHelper(node.children[index], word, i + 1);
        }
    }

    public static void main(String[] args) {
        String[] words = {"add", "sky", "hello", "multi", "addition", "sky", "multiply", "table"};

        for(String word: words) {
            addWord(word);
        }

        String[] wordSearch = {"helo", "multiple", "...le", "..llo", "..r"};

        for(String word: wordSearch) {
            System.out.println(search(word));
        }

        System.out.println(getWords());
    }
}
