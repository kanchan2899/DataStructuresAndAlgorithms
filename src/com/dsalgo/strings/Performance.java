package com.dsalgo.strings;

public class Performance {
    public static void main(String[] args) {
        String series = "";
        for(int i = 0; i < 26; i++){
            char ch = (char)('a' + i);
            // It will create a new object every time and reference it to series variable
            // All intermediate objects will be de-referenced
            // TC = O(N*N) as 1 + 2 + 3 + ... + N addition operations requires
            series = series + ch;
        }
        System.out.println(series);
        // To optimize above problem and memory, StringBuilder class is used.
        // It doesn't create new objects and modifies the existing object
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < 26; i++){
            char ch = (char)('a' + i);
            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder);
    }
}
