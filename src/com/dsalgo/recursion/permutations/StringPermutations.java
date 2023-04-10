package com.dsalgo.recursion.permutations;

import java.util.ArrayList;

public class StringPermutations {
    public static void main(String[] args) {
        String s = "abc";
        permutations(s, "");
        System.out.println();
        System.out.println(permutationInList("", s));

    }

    private static void permutations(String unprocessed, String processed) {
        if(unprocessed.isEmpty()) {
            System.out.print(processed + " ");
            return;
        }
        char ch = unprocessed.charAt(0);
        for(int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            permutations(unprocessed.substring(1), first + ch + second);
        }
    }

    private static ArrayList<String> permutationInList(String processed, String unprocessed) {
        if(unprocessed.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        char ch = unprocessed.charAt(0);
        ArrayList<String> permutations = new ArrayList<>();

        for(int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());

            permutations.addAll(permutationInList(first + ch + second, unprocessed.substring(1)));

        }

        return permutations;
    }
}
