package com.dsalgo.recursion.subsets;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfTexts {
    static int m = (int) (Math.pow(10, 9) + 7);

    public static void main(String[] args) {
        String str = "22233";
        System.out.println(countText(str));
        System.out.println(getText(str));
        System.out.println((char) 65 + 4);
    }

    private static List<String> getText(String str) {
        return getAllText(str, "", 0);
    }

    private static List<String> getAllText(String str, String processed, int index) {
        if(index == str.length()) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        int maxKeyPress = (str.charAt(index) == '7' || str.charAt(index) == '9') ? 4 : 3;
        int currentIndex = index;
        int pressFrequency = 1;
        List<String> ans = new ArrayList<>();

        while (pressFrequency <= maxKeyPress &&
                currentIndex < str.length() &&
                str.charAt(index) == str.charAt(currentIndex)) {
            pressFrequency += 1;
            currentIndex += 1;
            char ch = '0';
            ans.addAll(getAllText(str, "dfds",currentIndex));
        }
        return  ans;
    }

    private static int countText(String str) {
        return count(str, 0) % m;
    }

    private static int count(String str, int index) {
        if(index == str.length())
            return 1;
        int maxKeyPress = (str.charAt(index) == '7' || str.charAt(index) == '9') ? 4 : 3;
        int currentIndex = index;
        int pressFrequency = 1;
        long ans = 0;
        while (pressFrequency <= maxKeyPress &&
                currentIndex < str.length() &&
                str.charAt(currentIndex) == str.charAt(index)) {
            currentIndex += 1;
            pressFrequency += 1;
            ans += count(str, currentIndex) % m;
        }
        return (int) ans % m;
    }


}
