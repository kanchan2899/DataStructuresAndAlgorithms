package com.dsalgo.strings.pattern;

// https://practice.geeksforgeeks.org/problems/keypad-typing0119/1
public class KeyboardTyping {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(printNumber(s, s.length()));
    }
    public static String printNumber(String s, int n)
    {
        String str="";
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            String ch=""+c;
            if("abc".contains(ch)) str+='2';
            if("def".contains(ch)) str+='3';
            if("ghi".contains(ch)) str+='4';
            if("jkl".contains(ch)) str+='5';
            if("mno".contains(ch)) str+='6';
            if("pqrs".contains(ch)) str+='7';
            if("tuv".contains(ch)) str+='8';
            if("wxyz".contains(ch)) str+='9';
        }
        return str;
    }
}
