package com.dsalgo.grokking.patterns.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ReplaceWords {
    public static ReplaceWordNode root = new ReplaceWordNode();

    public static void insertInTrie(String key) {
        ReplaceWordNode temp = root;
        for(int i = 0; i < key.length(); i++) {
            int index = key.charAt(i) - 'a';
            if(temp.children[index] == null) {
                temp.children[index] = new ReplaceWordNode();
            }
            temp = temp.children[index];
        }
        temp.isEOW = true;
    }

    public static String replace(String str) {
        ReplaceWordNode temp = root;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            sb.append(str.charAt(i));
            if(Objects.isNull(temp.children[index])) {
                return str;
            }
            temp = temp.children[index];

            if(temp.isEOW) {
                return sb.toString();
            }
        }
        return sb.toString();
    }
    public static String replaceWords(String sentence, List<String> dictionary) {
        for(String prefix: dictionary) {
            insertInTrie(prefix);
        }

        List<String> sentenceList = Arrays.asList(sentence.split(" "));
        List<String> newList = new ArrayList<>();

        for(String str: sentenceList) {
            newList.add(replace(str));
        }

        return String.join(" ", newList);
    }

    public static void main(String[] args) {
        String sentence = "where there is a will there is a way";
        List<String> dictionary = Arrays.asList("wi", "wa", "w");

        System.out.println(replaceWords(sentence, dictionary));
    }
}
