package com.dsalgo.arrays;

// https://leetcode.com/problems/find-the-highest-altitude/
public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[][] gains = {{-5,1,5,0,-7}, {-4,-3,-2,-1,4,3,2}};
        for(int[] gain : gains){
            System.out.println(largestAltitude(gain));
        }
    }
    public static int largestAltitude(int[] gain) {
        int[] alt = new int[gain.length + 1];
        int max = alt[0];
        for(int i = 0; i < gain.length; i++){
            alt[i + 1] = alt[i] + gain[i];
            if(alt[i+1] > max){
                max = alt[i + 1];
            }
        }
        return max;
    }
}
