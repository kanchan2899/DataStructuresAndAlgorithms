package com.dsalgo.grokking.patterns.trie;

import java.util.Arrays;
import java.util.List;

public class ImplementTrie {
    TrieNode root;
    public ImplementTrie() {
        this.root = new TrieNode();
    }

    // insert a string in a trie
    public void insert(String word) {
        TrieNode trieNode = this.root;

        // iterate over the word character by character
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            // if a child node is not present, create a new node and add to trie
            if(!trieNode.children.containsKey(c)) {
                trieNode.children.put(c, new TrieNode());
            }

            trieNode = trieNode.children.get(c);
        }

        // once the complete word is added to the trie, set boolean variable to true
        trieNode.isWord = true;
    }

    // search for a string
    public boolean search(String word) {

        TrieNode trieNode = this.root;

        // iterate over the word character by character
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // if there is no children of a node, return false as we do not find the word
            if(!trieNode.children.containsKey(ch)) {
                return false;
            }

            trieNode = trieNode.children.get(ch);
        }
        // return the word after traversing all nodes as it is found
        return trieNode.isWord;
    }

    // searching for a prefix
    public boolean searchPrefix(String prefix) {
        TrieNode trieNode = this.root;

        // iterate over the prefix character by character
        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            // if there is no children of a node, return false as we do not find the prefix
            if(!trieNode.children.containsKey(ch)) {
                return false;
            } else {
                trieNode = trieNode.children.get(ch);
            }
        }
        // return true after traversing all nodes as the prefix is found
        return true;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("the", "a", "there", "answer");

        ImplementTrie trie = new ImplementTrie();

        for(String word: words) {
            trie.insert(word);
        }

        List<String> searches = Arrays.asList("a", "answer", "xyz", "an");

        for(String word: searches) {
            System.out.println(trie.search(word));
        }

        List <String> searchPrefix = Arrays.asList("b", "an");

        for(String prefix: searchPrefix) {
            System.out.println(trie.searchPrefix(prefix));
        }
    }

}
