package com.dsalgo.grokking.patterns.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-search-ii/description/
class Trie {
    Trie[] next = new Trie[26];
    String word = null;
}

public class WordSearch {
    static List<String> findWords(char[][] board, String[] words) {
        Trie trie = buildTrie(words);
        Set<String> res = new HashSet<>();

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                dfs(board, trie, res, i, j);
            }
        }
        return new ArrayList<>(res);
    }

    static private void dfs(char[][] board, Trie node, Set<String> res, int i, int j) {
        char ch = board[i][j];

        if(ch == '#' || node.next[ch - 'a'] == null) {
            return;
        }
        node = node.next[ch - 'a'];

        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        dfs(board, node, res, i - 1, j);
        dfs(board, node, res, i + 1, j);
        dfs(board, node, res, i, j - 1);
        dfs(board, node, res, i, j + 1);

        board[i][j] = ch;
    }

    static public Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for(String w: words) {
            Trie p = root;
            for(char ch: w.toCharArray()) {
                if(p.next[ch - 'a'] == null) {
                    p.next[ch - 'a'] = new Trie();
                }
                p = p.next[ch - 'a'];
            }
            p.word = w;
        }
        return root;
    }

    public static void main(String[] args) {
        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        System.out.println(findWords(board, words));
    }
}
