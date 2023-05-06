package com.dsalgo.grokking.patterns.sliding.window;

public class MaximumNumberOfVowelsInASubstring {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println(maxVowels(s, k));
        System.out.println(maxVowels1(s, k));
    }

    private static int maxVowels1(String s, int k) {
        int max = 0;
        int currMax = 0;


        for(int i = 0; i < s.length(); i++) {
            if(i >= k && isVowel(s.charAt(i-k))) {
                currMax -= 1;
            }
            if(isVowel(s.charAt(i))) {
                currMax += 1;
            }
            max = Math.max(currMax, max);
        }
        return max;
    }

    public static int maxVowels(String s, int k) {
        int max = 0;
        int currMax = 0;
        int j = 0;
        for(int i = 0; i <= s.length() - k; i++) {
            j = i;
            currMax = 0;
            while (j - i < k) {
                if(isVowel(s.charAt(j))) {
                    currMax++;
                }
                j++;
            }
            max = Math.max(currMax, max);
        }
        return max;
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c== 'u';
    }
}
