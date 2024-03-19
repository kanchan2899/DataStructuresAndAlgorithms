package com.dsalgo.grokking.patterns.trie;

import java.util.LinkedList;
import java.util.List;

public class SearchTrieNode {
    SearchTrieNode[] children = new SearchTrieNode[26];
    LinkedList<String> searchWords = new LinkedList<>();
}
