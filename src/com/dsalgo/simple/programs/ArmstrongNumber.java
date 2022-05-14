package com.dsalgo.simple.programs;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {

//        Scanner in = new Scanner(System.in);
//        System.out.print("Please enter the number: ");
//        int n = in.nextInt();
//        System.out.println("Is number " + n + " an armstrong number ? : " + isArmstrong(n));
        for(int i = 100; i < 1000; i++){
            if(isArmstrong(i)){
                System.out.println(i + " ");
            }
        }

    }

    private static boolean isArmstrong(int n) {
        int sum = 0;
        int originalN = n;
        while(n > 0){
            int rem = n % 10;
            sum += rem * rem * rem;
            n = n / 10;
        }
        return sum == originalN;
    }
}
