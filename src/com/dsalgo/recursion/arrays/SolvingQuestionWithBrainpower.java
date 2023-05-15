package com.dsalgo.recursion.arrays;


// https://leetcode.com/problems/solving-questions-with-brainpower/description/
public class SolvingQuestionWithBrainpower {
    public static void main(String[] args) {
        int[][] questions = {{1,1},{2,2},{3,3},{4,4},{5,5}};
        System.out.println(mostPoints(questions));
    }

    public static long mostPoints(int[][] questions) {
        return helper(questions, 0);
    }

    private static long helper(int[][] questions, int i) {
        if(i >= questions.length)
            return 0;

        long take_it = questions[i][0] + helper(questions, i + questions[i][1] + 1);
        long leave_it = helper(questions, i + 1);

        return Math.max(take_it, leave_it);
    }
}
