package com.dsalgo.bit.manipulation;

// https://leetcode.com/problems/add-binary/
public class AddBinary {
    public static void main(String[] args) {
        String a = "11";
        String b = "1";
        System.out.println(addBinary(a, b));
    }

    private static String addBinary(String a, String b) {
        int aLastIndex = a.length() - 1;
        int bLastIndex = b.length() - 1;
        int carry = 0;
        StringBuilder sum = new StringBuilder();

        while(aLastIndex >= 0 || bLastIndex >= 0) {
            int s = carry;
            if(aLastIndex >= 0) {
                s = s + a.charAt(aLastIndex) - '0';
                aLastIndex--;
            }
            if(bLastIndex >= 0) {
                s = s + b.charAt(bLastIndex) - '0';
                bLastIndex--;
            }
            sum.append(s % 2);
            carry = s / 2;
        }
        if(carry > 0) sum.append(carry);
        return sum.reverse().toString();
    }
}
