package com.dsalgo.recursion.permutations;

public class StringPermutationsCount {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(countPermutations(str, ""));
    }

    private static int countPermutations(String unprocessed, String processed) {
        if(unprocessed.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = unprocessed.charAt(0);
        for(int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            count = count + countPermutations(unprocessed.substring(1),
                    first + ch + second);
        }
        return count;
    }
}
