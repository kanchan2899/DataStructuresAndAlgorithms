package com.dsalgo.apps;

import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        int ans = 0;
        Scanner in = new Scanner(System.in);
        // Take an input from the user till the user does not press X or x
        System.out.print("Enter the operator: ");
        while (true) {
            char op = in.next().trim().charAt(0);
            if (op == '+' || op == '-' || op == '*' || op == '/' || op == '%') {
                // Input two numbers
                System.out.print("Enter two numbers: ");
                int num1 = in.nextInt();
                int num2 = in.nextInt();

                if (op == '+') {
                    ans = num1 + num2;
                }
                if (op == '-') {
                    ans = num1 - num2;
                }
                if (op == '/') {
                    if (num2 != 0) {
                        ans = num1 / num2;
                    }
                }
                if (op == '*') {
                    ans = num1 * num2;
                }
                if (op == '%') {
                    ans = num1 % num2;
                }
            } else if (op == 'X' || op == 'x') {
                break;
            } else {
                System.out.println("Invalid operation");
            }
            System.out.println("The answer is " + ans);
        }
    }
}
