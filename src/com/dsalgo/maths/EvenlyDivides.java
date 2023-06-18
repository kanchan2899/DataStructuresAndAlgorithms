package com.dsalgo.maths;

public class EvenlyDivides {
    public static void main(String[] args) {
        int[] n = {22074};
        for(int i = 0; i < n.length; i++) {
            System.out.println(evenlyDivides(n[i]));
        }
    }

    static int evenlyDivides(int n){
        int count = 0;
        int temp = n;
        while (temp > 0) {
            int rem = temp % 10;
            temp = temp / 10;
            if(rem != 0 && n % rem == 0) {
                count++;
            }
        }
        return count;
    }
}
