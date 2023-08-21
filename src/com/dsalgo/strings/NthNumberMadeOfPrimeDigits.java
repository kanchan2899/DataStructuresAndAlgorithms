package com.dsalgo.strings;

// https://www.geeksforgeeks.org/finding-n-th-number-made-prime-digits/
public class NthNumberMadeOfPrimeDigits {
    public static void main(String[] args) {
        int n = 21;
        System.out.println(nthprimedigitsnumber(n));
    }

    private static int nthprimedigitsnumber(int number) {
        int rem;
        String num = "";

        while (number > 0) {
            rem = number % 4;
            switch (rem) {
                case 1:
                    num += '2';
                    break;
                case 2:
                    num += '3';
                    break;
                case 3:
                    num += '5';
                    break;
                case 0:
                    num += '7';
                    break;
            }
            if(number % 4 == 0) {
                number--;
            }
            number = number / 4;
        }
        num = new StringBuilder(num).reverse().toString();
        return Integer.parseInt(num);
    }
}
