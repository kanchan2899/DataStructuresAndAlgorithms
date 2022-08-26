package com.dsalgo.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
public class FindRotation {
    public static void main(String[] args) {
        int[][] mat = { {1, 2}, {3, 4}};
        int[][] target = { {2, 4}, {1, 3}};
        int[][] mat1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] target1 = {{4, 5, 6}, {1, 2, 3}, {7, 8, 9}};
        System.out.println(findRotation(mat, target));
        System.out.println(findRotation(mat1, target1));
    }

    public static boolean findRotation(int[][] mat, int[][] target) {
        int count = 4;
        int[][] rotatedMatrix = mat;
        while(count > 0){
            rotatedMatrix = rotateBy90(rotatedMatrix);
            if(Arrays.deepEquals(rotatedMatrix, target)){
                return true;
            }
            count--;
        }
        return false;
    }

    public static int[][] rotateBy90(int[][] mat){
        int[][] rotatedMat = new int[mat.length][mat[0].length];
        int n = mat[0].length;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[i].length; j++){
                rotatedMat[j][n - i - 1] = mat[i][j];
            }
        }
        return rotatedMat;
    }
}
