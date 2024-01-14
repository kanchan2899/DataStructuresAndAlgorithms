package com.dsalgo.grokking.patterns.sliding.window;

import java.util.*;

// https://leetcode.com/problems/repeated-dna-sequences/
public class RepeatedDNASequence {
    public static void main(String[] args) {
        List<String> inputString = Arrays.asList("AGT", "AGACCTAGAC", "AAAAACCCCCAAAAACCCCCC",
                "GGGGGGGGGGGGGGGGGGGGGGGGG", "TTTTTCCCCCCCTTTTTTCCCCCCCTTTTTTT", "TTTTTGGGTTTTCCA",
                "AAAAAACCCCCCCAAAAAAAACCCCCCCTG", "ATATATATATATATAT");
        List<Integer> inputK = Arrays.asList(3, 3, 8, 12, 10, 14, 10, 6);

        for(int i = 0; i <inputString.size(); i++) {
            System.out.println((i + 1) + ". Input Sequence: " + inputString.get(i) + "\n\tk: " +
                    inputK.get(i) + "\n");
            findRepeatedSequence(inputString.get(i), inputK.get(i));
            System.out.println("----------------------------------------------------------");
        }
    }

    private static Set<String> findRepeatedSequence(String s, Integer k) {
        int n = s.length();

        if(n < k) {
            return new HashSet<>();
        }
        Map<Character, Integer> charMap = new HashMap<>();
        charMap.put('A', 1);
        charMap.put('C', 2);
        charMap.put('G', 3);
        charMap.put('T', 4);

        // base value
        int a = 4;

        // Numeric representation of the sequence
        List<Integer> numbers = new ArrayList<>(Arrays.asList(new Integer[n]));
        Arrays.fill(numbers.toArray(), 0);
        for(int i = 0; i < n; i++) {
            numbers.set(i, charMap.get(s.charAt(i)));
        }
        // System.out.println("\tConverted sequence: " + numbers.toString());

        int hashValue = 0;

        // 1. Hash set to store the unique hash values
        // 2. Output set to store the repeated sequences
        Set<Integer> hashSet = new HashSet<>();
        Set<String> output = new HashSet<>();

        for(int i = 0; i < n - k + 1; i++) {
            // If the window is at its initial position, calculate the hash value from scratch

            if(i == 0) {
                for(int j = 0; j < k; j++) {
                    hashValue += numbers.get(j) * (int) Math.pow(a, k - j - 1);
                }
            } else {
                int previousHash = hashValue;
                hashValue = ((previousHash - numbers.get(i - 1) * (int) Math.pow(a, k - 1)) * a) +
                        numbers.get(i + k - 1);
            }

            // if the current hash value is present in the hash set, the current substring has been
            // repeated, so we add it to the output
            if(hashSet.contains(hashValue)) {
                output.add(s.substring(i, i + k));
            }

            // We add the evaluated hash value to the hash set
            hashSet.add(hashValue);

            System.out.println("\n\tHash value of " + s.substring(i, i + k) + ": " + hashValue +
                    "\n\tHash set: " + hashSet +
                    "\n\tOutput: " + output);
        }
        return output;
    }
}
