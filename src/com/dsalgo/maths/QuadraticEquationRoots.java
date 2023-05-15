package com.dsalgo.maths;

import java.util.ArrayList;
import java.util.List;

// https://practice.geeksforgeeks.org/batch/dsa-4/track/DSASP-Mathematics/problem/quadratic-equation-roots
public class QuadraticEquationRoots {
    public static void main(String[] args) {
        int a = 1, b = -2, c = 1;
        System.out.println(quadraticRoots(a, b, c));
    }

    public static List<Integer> quadraticRoots(int a, int b, int c) {
        ArrayList<Integer> roots = new ArrayList<>();
        double d = Math.pow(b, 2) - (4 * a * c);
        if(d < 0) {
            roots.add(-1);
            return roots;
        }

        double root1 = (-b - Math.sqrt(d)) / (2 * a);
        double root2 = (-b + Math.sqrt(d)) / (2 * a);

        root1 = (int) Math.floor(root1);
        root2 = (int) Math.floor(root2);

        roots.add((int) Math.max(root1, root2));
        roots.add((int) Math.min(root1, root2));

        return roots;
    }
}
