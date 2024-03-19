package com.dsalgo.grokking.patterns.trie;

public class WordDictionaryNode {
    public WordDictionaryNode[] children;
    public boolean complete;

    public WordDictionaryNode() {
        children = new WordDictionaryNode[26];
        complete = false;
    }
}
