package com.dsalgo.grokking.patterns.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/search-suggestions-system/description/
public class SearchSuggestionSystem {
    private SearchTrieNode root = new SearchTrieNode();

    public void insert(String word) {
        SearchTrieNode node = root;

        for(char ch: word.toCharArray()) {
            int index = ch - 'a';

            // create a new node if char does not exist in children dictionary
            if(node.children[index] == null) {
                node.children[index] = new SearchTrieNode();
            }

            node = node.children[index];

            node.searchWords.offer(word);

            if(node.searchWords.size() > 3) {
                node.searchWords.pollLast();
            }
        }
    }

    public List<List<String>> search(String searchWord) {
        List<List<String>> result = new ArrayList<>();
        SearchTrieNode node = root;

        for(char ch: searchWord.toCharArray()) {
            int index = ch - 'a';
            if(node != null) {
                node = node.children[index];
            }
            result.add(node == null ? Arrays.asList() : node.searchWords);
        }
        return result;
    }

    public List<List<String>> suggestProducts(String[] products, String searchWords) {
        Arrays.sort(products);

        // insert each products string in trie
        for(String product: products) {
            insert(product);
        }

        return search(searchWords);
    }

    public static void main(String[] args) {
        String[] products = {"bat", "bag", "bassinet", "bread", "cable",
                "table", "tree", "tarp"};
        String[] searchWordList = {"ba", "in", "ca", "t"};

        for(int i = 0; i < searchWordList.length; i++) {
            SearchSuggestionSystem suggestionSystem = new SearchSuggestionSystem();
            System.out.println(suggestionSystem.suggestProducts(products, searchWordList[i]));
        }
    }
}
