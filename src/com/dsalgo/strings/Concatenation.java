package com.dsalgo.strings;

import java.util.ArrayList;

public class Concatenation {
    public static void main(String[] args) {
        // Adding the ASCII value of a and b
        System.out.println('a' + 'b');

        // Adding ASCII value of a with 3
        System.out.println('a' + 3);

        // Adds ASCII value of a with 3 and converts the resulting ASCII value to char
        System.out.println((char)('a' + 3));

        // Two strings concatenation
        // Creates a new object "ab"
        System.out.println("a" + "b");

        // 1 will be converted into string first and then concatenated
        // integer will be converted to Integer and will call toString()
        System.out.println("a" + 1);

        // ArrayList is empty so it will print []
        System.out.println("Robot" + new ArrayList<>());

        // If you pass any object in println() method, it will be converted to string first

        // Error because Operator '+' cannot be applied to 'java.lang.Integer',
        // 'java.util.ArrayList<java.lang.Object>'
        // Operator + works either on primitives or if any of the operands is a string
        // System.out.println(new Integer(9) + new ArrayList<>());
        // Below statement won't throw an error because at least one operand is string
         System.out.println(new Integer(9) + "" + new ArrayList<>());
    }
}
