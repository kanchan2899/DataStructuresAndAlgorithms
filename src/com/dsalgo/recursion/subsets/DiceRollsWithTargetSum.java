package com.dsalgo.recursion.subsets;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class DiceRollsWithTargetSum {
    public static void main(String[] args) {
//        diceRolls("", 4);
//        System.out.println(diceRollsInList("", 5));
        System.out.println(diceRollsCount(2, 6, 7));
    }

    static void diceRolls(String processed, int target) {
        if(target == 0) {
            System.out.println(processed);
            return;
        }

        for(int i = 1; i <= 6 && i <= target; i++) {
            diceRolls(processed + i, target - i);
        }
    }

    static int diceRollsCount(int numberOfDices, int faces, int target) {
        if(target == 0) {
            int count = 1;
            return count;
        }
        if(numberOfDices == 1 && target <= faces) {
            return 1;
        }
        int count = 0;
        for(int i = numberOfDices; i <= target; i++) {
            count += diceRollsCount(numberOfDices, faces, target - i);
        }
        return count;
    }
    static List<String> diceRollsInList(String processed, int target) {
        if(target == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1; i <= 6 && i <= target; i++) {
            list.addAll(diceRollsInList(processed + i, target - i));
        }
        return list;
    }
}
