package com.dsalgo.recursion.numbers;

public class Handshakes {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(count(n));
    }

    static int count(int N)
    {
        if(N == 0) return 1;
        int ans = 0;
        for(int i = 0; i < N; i+=2) {
            ans += count(i) * count(N - 2 - i);
        }
        return ans;
    }
}
