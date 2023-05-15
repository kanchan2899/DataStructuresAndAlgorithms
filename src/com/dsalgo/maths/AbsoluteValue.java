package com.dsalgo.maths;

public class AbsoluteValue {
    public static void main(String[] args) {
        int[] arr = {32, 0, -32, -12};
        for(int i = 0; i < arr.length; i++)
            System.out.println("The absolute value of " + arr[i] + " is " + absolute(arr[i]));
    }

    public static int absolute(int i) {
        if(i < 0) {
            return -i;
        }
        return i;
    }
}
