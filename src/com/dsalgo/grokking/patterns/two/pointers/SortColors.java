package com.dsalgo.grokking.patterns.two.pointers;

import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/
public class SortColors {
    public static void main(String[] args) {
        int[] colors = {0, 1, 0, 0, 1, 2, 1, 0, 1, 2, 2, 0};
        System.out.println(Arrays.toString(sortColors(colors)));
    }

    private static int[] sortColors(int[] colors) {
        int red = 0, white = 0, blue = colors.length - 1;
        while(white <= blue) {
            if(colors[white] == 0) {
                if(colors[red] != 0) {
                    int temp = colors[red];
                    colors[red] = colors[white];
                    colors[white] = temp;
                }
                white++;
                red++;
            } else if(colors[white] == 1) {
                white++;
            } else {
                if(colors[blue] != 2) {
                    int temp = colors[white];
                    colors[white] = colors[blue];
                    colors[blue] = temp;
                }
                blue--;
            }
        }
        return colors;
    }

    private static void swap(int[] colors, int i, int j) {
        int temp = colors[i];
        colors[i] = colors[j];
        colors[j] = temp;
    }
}
