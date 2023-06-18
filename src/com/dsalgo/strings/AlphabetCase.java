package com.dsalgo.strings;

import java.util.Scanner;

public class AlphabetCase {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a character: ");
        char ch = in.next().trim().charAt(0); // No Scanner method to input a character
        if(ch >= 'a' && ch <= 'z'){
            System.out.println("Lowercase");
        } else{
            System.out.println("Uppercase");
        }
    }
}
