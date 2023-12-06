package com.dsalgo.trie;
public class TrieNode {
    static final int ALPHABET_SIZE = 26;
    TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    // isEndOfWord is true if the node represents end of a word
    boolean isEndOfWord;
}
