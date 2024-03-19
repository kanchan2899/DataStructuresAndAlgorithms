package com.dsalgo.grokking.patterns.bitwise.manipulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/encode-and-decode-strings/
public class EncodeDecode {
    public static void main(String[] args) {
        List<String> strs = Arrays.asList("I", "love", "educative");
        String encoded = encode(strs);
        System.out.println(encoded);
        List<String> decoded = decode(encoded);
        System.out.println(decoded);
    }

    private static List<String> decode(String encoded) {
        int i = 0;
        List<String> decodedString = new ArrayList<>();
        while (i < encoded.length()) {
            int length = bytesToLength(encoded.substring(i, i + 4));

            i += 4;

            decodedString.add(encoded.substring(i, i + length));

            i += length;
        }
        return decodedString;
    }

    private static int bytesToLength(String byteString) {
        int result = 0;
        for(char c: byteString.toCharArray()) {
            result = result * 256 + c;
        }
        return result;
    }

    private static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(String x: strs) {
            encodedString.append(lengthToBytes(x)).append(x);
        }
        return encodedString.toString();
    }

    private static String lengthToBytes(String x) {
        // converts a 4-byte string to an integer
        // if byteString is "0040", the function will return 40
        int length = x.length();
        StringBuilder bytes = new StringBuilder();

        for(int i = 0; i < 4; i++) {
            // apply right shift operator
            bytes.append((char) (length >> (i * 8)));
        }
        return bytes.reverse().toString();
    }
}
