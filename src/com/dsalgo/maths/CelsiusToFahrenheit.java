package com.dsalgo.maths;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        int[] celsius = {32, 50};
        for(int i = 0; i < celsius.length; i++) {
            System.out.println("Celsius " + celsius[i] + " = " + cToF(celsius[i]));
        }
    }

    public static double cToF(int c)
    {
        return (c * 9 / 5) + 32;
    }
}
