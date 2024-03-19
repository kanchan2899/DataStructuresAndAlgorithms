package com.dsalgo.grokking.patterns.trie;

import java.util.HashMap;

public class TrieNode {
    boolean isWord;
    HashMap< Character, TrieNode > children;
    public TrieNode() {
        this.children = new HashMap <> ();
        this.isWord = false;
    }
}
