package com.dsalgo.grokking.patterns.greedy;

public class JumpGameII {
    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(jumpGameII(arr));
    }

    private static int jumpGameII(int[] arr) {
        int jumps = 0, farthestJump = 0, currentJump = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            farthestJump = Math.max(i + arr[i], farthestJump);
            if(i == currentJump) {
                jumps++;
                currentJump = farthestJump;
            }
        }
        return jumps;
    }
}
