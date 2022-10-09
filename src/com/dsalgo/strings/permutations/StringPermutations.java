package com.dsalgo.strings.permutations;

import java.util.ArrayList;
import java.util.List;

public class StringPermutations {
    public static void main(String[] args) {
        String str = "abc";
        permutations(str, "");
        permutationsUsingSwap(str, 0, str.length() - 1);
        System.out.println(permutationsInList(str, ""));
        System.out.println(permutationsCount(str, ""));
//        System.out.println(permutationsCount1(str, "", 0));
    }

    private static void permutationsUsingSwap(String str, int startIndex, int endIndex) {
        if(startIndex == endIndex) {
            System.out.println(str);
        } else {
            for(int i = startIndex; i <= endIndex; i++) {
                str = swap(str, startIndex, i);
                permutationsUsingSwap(str, startIndex + 1, endIndex);
                str = swap(str, startIndex, i);
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    // Not working as expected
    private static int permutationsCount1(String unprocessed, String processed, int count) {
        if(unprocessed.isEmpty()) {
            System.out.println(processed);
            return 1;
        }
        char ch = unprocessed.charAt(0);
        for(int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            count += permutationsCount1(unprocessed.substring(1), first + ch + second, count);
        }
        return count;
    }

    static void permutations(String unprocessed, String processed) {
        if(unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char ch = unprocessed.charAt(0);

        for(int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            permutations(unprocessed.substring(1), first + ch + second);
        }
    }

    static ArrayList<String> permutationsInList(String unprocessed, String processed) {
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
            permutations.addAll(permutationsInList(unprocessed.substring(1),first + ch + second));
        }
        return permutations;
    }

    static int permutationsCount(String unprocessed, String processed) {
        if(unprocessed.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = unprocessed.charAt(0);
        for(int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            count = count + permutationsCount(unprocessed.substring(1), first + ch + second);
        }
        return count;
    }
}
