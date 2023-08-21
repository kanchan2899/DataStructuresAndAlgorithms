package com.dsalgo.strings;

// https://www.geeksforgeeks.org/print-characters-frequencies-order-occurrence/
// Print the characters and their frequency in sorted order
public class FrequencyOfCharacters {
    public static void main(String[] args) {
        String str = "geeksforgeeks";
        frequenciesInSortedOrder(str);
    }

    private static void frequenciesInSortedOrder(String str) {
        int[] count = new int[26];
        for(int i = 0; i < str.length(); i++) {
            // To convert the char into index ranging from 0 to 25, subtract character with 'a'
            count[str.charAt(i) - 'a'] += 1;
        }

        for(int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                // To convert 0 to 25 based index to  a character, add 'a' to the index and type
                // cast it to char
                System.out.println((char) (i + 'a') + " " + count[i]);
            }
        }
    }
}
