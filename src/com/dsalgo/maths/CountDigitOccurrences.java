package com.dsalgo.maths;

import java.util.Scanner;

public class CountDigitOccurrences {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the number: ");
        int num = in.nextInt();
        System.out.println("Please enter the digit you want to count: ");
        int digit = in.nextInt();
        System.out.println("The number of occurrences of " + digit + " in the number " + num + " is " + countOccurrence(num, digit));
    }

    private static int countOccurrence(int num, int digit){
        int count = 0;
        while (num > 0){
            if( num % 10 == digit){
                count++;
            }
            num = num/10;
        }
        return count;
    }
}
