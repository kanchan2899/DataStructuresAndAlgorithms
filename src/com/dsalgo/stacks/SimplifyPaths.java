package com.dsalgo.stacks;


import java.util.Arrays;
import java.util.Stack;

// https://leetcode.com/problems/simplify-path/solutions/?orderBy=most_votes
public class SimplifyPaths {
    public static void main(String[] args) {
        String[] paths = {"/home/", "/../", "/home//foo/", "/a/./b/../../c/"};
        for(String path: paths) {
            System.out.println(simplifyPath(path));
        }
    }
    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder canonicalPath = new StringBuilder();
        String[] p = path.split("/");
        for (int i = 0; i < p.length; i++) {
            if(!stack.isEmpty() && p[i].equals(".."))
                stack.pop();
            else if (!p[i].equals("..") && !p[i].equals("") && !p[i].equals(".")) {
                stack.push(p[i]);
            }
        }

        if(stack.isEmpty()) {
            return "/";
        }

        while (!stack.isEmpty()) {
            canonicalPath.insert(0, stack.pop()).insert(0, "/");
        }

        return canonicalPath.toString();
    }
}
