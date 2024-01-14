package com.dsalgo.trie;

public class Trie {
    static TrieNode root;

    static void insert(String key) {
        int index;

        TrieNode current = root;
        for(int level = 0; level < key.length(); level++) {
            index = key.charAt(level) - 'a';
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        // mark the last node as leaf
        current.isEndOfWord = true;
    }

    static boolean search(String key) {
        int index;
        TrieNode current = root;

        for(int i = 0; i < key.length(); i++) {
            index = key.charAt(i) - 'a';
            if(current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    /**
     *
     * Case 1: Key may not be present in the trie. In this case, the delete operation should not
     * modify trie.
     * Case 2: Key present as a unique key (no part of key contains another key (prefix), nor the
     * key itself is a prefix of another key in trie). In this case, delete all the nodes of that key.
     * Case 3: Key is a prefix key of another long key in the trie. In this case, simply unmark the
     * leaf node.
     * Case 4: Key present in the trie, having at least one other key as a prefix key. In this case,
     * delete nodes from the end of key until first leaf node of longest prefix key.
     *
     *
     * @param key
     * @return
     */
    static void delete(String key) {
        if(key.length() > 0) {
            helper(root, key, 0);
        }
    }
    static TrieNode helper(TrieNode root, String key, int i) {
        if(root == null) {
            return null;
        }

        if(i == key.length()) {
            root.isEndOfWord = false;
            if(isEmpty(root) == true) {
                root = null;
            }
            return root;
        }

        int index = key.charAt(i) - 'a';
        root.children[index] = helper(root.children[index], key, i + 1);

        if(isEmpty(root) && root.isEndOfWord == false) {
            root = null;
        }
        return root;
    }

    static boolean isEmpty(TrieNode root) {
        for(int i = 0; i < 26; i++) {
            if(root.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "this"};

        root = new TrieNode();

        for(int i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }

        if(search("this")) {
            System.out.println("'this' is present in the dictionary");
        }

        delete("their");

        if(search("the")) {
            System.out.println("'the' is present in the dictionary");
        }

        if(search("their")) {
            System.out.println("'their' is present in the dictionary");
        }
    }
}
