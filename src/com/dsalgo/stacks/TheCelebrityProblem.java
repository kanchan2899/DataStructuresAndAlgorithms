package com.dsalgo.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

// https://www.geeksforgeeks.org/the-celebrity-problem/
public class TheCelebrityProblem {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> m = new ArrayList<>();
        m.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0)));
        m.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0)));
        m.add(new ArrayList<>(Arrays.asList(0, 0, 0, 0)));
        m.add(new ArrayList<>(Arrays.asList(0, 0, 1, 0)));


        int[][] mat = { { 0, 0, 1, 0 },
                        { 0, 0, 1, 0 },
                        { 0, 0, 0, 0 },
                        { 0, 0, 1, 0 } };
        System.out.println(celebrity(m, m.size()));
        System.out.println(celebrity1(mat, m.size()));

        System.out.println(celebrity2(mat, m.size()));
        System.out.println(celebrity3(mat, m.size()));
    }

    private static boolean knows(int[][] m, int a, int b) {
        return (m[a][b] == 1) ? true : false;
    }
    private static int celebrity3(int[][] mat, int size) {
        Stack<Integer> stack = new Stack<>();
        int c;

        // push everything into the stack
        for(int i = 0; i < size; i++) {
            stack.push(i);
        }

        while (stack.size() > 1) {
            // pop off top two parents from the stack, discard one person based on return
            // status of knows(a, b)
            int a = stack.pop();
            int b = stack.pop();

            // Push the remained person onto stack
            if(knows(mat, a, b)) {
                stack.push(b);
            } else {
                stack.push(b);
            }
        }

        // if there are only two people and there is no potential candidate
        if(stack.isEmpty()) {
            return  -1;
        }

        c = stack.pop();

        // check if the last person is celebrity or not
        for(int i = 0; i < size; i++) {
            // if any person doesn't know 'c' or 'a' doesn't know any person, return -1

            if(i != c && (knows(mat, c, i) || !(knows(mat, i, c)))) {
                return -1;
            }
        }
        return c;
    }

    /**
     * Using elimination technique:
     *
     * The idea is to follow below to steps based on the above approach:
     *
     * 1. If A knows B, then A can’t be a celebrity. Discard A, and B may be celebrity.
     * 2. If A doesn’t know B, then B can’t be a celebrity. Discard B, and A may be celebrity.
     * We will not use any extra space as will use spaces M[i][i] for storing whether i th
     * person is a celebrity or not as these are by default 0, so if we find i th person is not
     * a celebrity then we will mark M[i][i] as 1
     *
     * 1. We will make a variable that will store the current row and start a loop from 0 to n-1
     * and if M[row][i] is 1 then mark M[row][row]=1 and update row = i and if M[row][i]=0 then
     * mark M[i][i]=1.
     * 2. After the loop we iterate on the diagonal of the matrix i.e M[i][i] where i->(0,n-1)
     * there will be only one element in the diagonal whose value will be 0, when found iterate
     * on all the rows from top to bottom with the column set to i  and if there is no 0 in that
     * column then return i and if there are positive number of zeroes then return -1.
     *
     * TC:
     *
     * @param mat
     * @param size
     * @return
     */
    private static int celebrity2(int[][] mat, int size) {
        int r = 0;
        for(int i = 1; i < size; i++) {
            // checking if the rth person knows ith person
            if(mat[r][i] == 1) {
                mat[r][r] = 1;
                r = i;
            } else {
                mat[i][i] = 1;
            }
        }

        for(int i = 0; i < size; i++) {
            // checking if ith person can be a celebrity or not
            if(mat[i][i] == 0) {
                boolean flag = false;
                // iterating in the ith column to check whether everyone knows ith person or not
                for(int j = 0; j < size; j++) {
                    // checking if mat[j][i] is not a diagonal element and if jth person knows
                    // ith person or not
                    if(j != i && mat[j][i] == 0) {
                        flag = true;
                        break;
                    }
                }

                if(flag) {
                    return i;
                }
            }
        }
        return  -1;
    }

    /**
     * Using two pointers: The idea is to use two pointers, one from start and one from the end.
     * Assume the start person is A, and the end person is B. If A knows B, then A must not be
     * the celebrity. Else, B must not be the celebrity. At the end of the loop, only one index
     * will be left as a celebrity. Go through each person again and check whether this is the
     * celebrity.
     * The Two Pointer approach can be used where two pointers can be assigned, one at the start
     * and the other at the end, and the elements can be compared and the search space can be reduced.
     *
     * 1. Create two indices i and j, where i = 0 and j = n-1
     * 2. Run a loop until i is less than j.
     * 3. Check if i knows j, then i can’t be a celebrity. so increment i, i.e. i++
     * 4. Else j cannot be a celebrity, so decrement j, i.e. j–
     * 5. Assign i as the celebrity candidate
     * 6. Now at last check whether the candidate is actually a celebrity by re-running a loop
     * from 0 to n-1  and constantly checking if the candidate knows a person or if there is a
     * candidate who does not know the candidate.
     * 7. Then we should return -1. else at the end of the loop, we can be sure that the
     * candidate is actually a celebrity.
     *
     * TC: O(n)
     * SC: O(1)
     *
     * @param m
     * @param size
     * @return
     */
    private static int celebrity1(int[][] m, int size) {
        int i = 0;
        int j = size - 1;

        while (i < j) {
            if(m[i][j] == 1) {
                j--;
            } else {
                i++;
            }
        }

        // i points to the celebrity candidate
        int candidate = i;

        for(i = 0; i < size; i++) {
            if(i != candidate) {
                if(m[i][candidate] == 0 || m[candidate][i] == 1) {
                    return -1;
                }
            }
        }
        return candidate;
    }

    private static int celebrity(ArrayList<ArrayList<Integer>> m, int n) {
        ArrayList<Integer>[] adj = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            for(int j = 0; j < n; j++) {
                if(m.get(i).get(j) == 1) {
                    adj[i].add(j);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            if(adj[i].isEmpty()) {
                boolean flag = true;
                for(int j = 0; j < n; j++) {
                    if(i == j) {
                        continue;
                    }
                    if(!adj[i].contains(i)) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return i;
                }
            }
        }
        return -1;
    }


}
