package com.dsalgo.grokking.patterns.greedy;

import java.util.Arrays;

// https://leetcode.com/problems/boats-to-save-people/
public class BoatsToSavePeople {
    public static void main(String[] args) {
        int[] people = {3, 5, 3, 4};
        int limit = 6;

        System.out.println(rescueBoats(people, limit));
    }

    private static int rescueBoats(int[] people, int limit) {
        // sort the array of people in ascending order
        Arrays.sort(people);

        // initialize pointers for the lightest and heaviest person
        int left = 0;
        int right = people.length - 1;

        // initialize the number of boats needed
        int boats = 0;

        // loop through the list of people until all people have been rescued
        while (left <= right) {
            // check if the lightest and heaviest person can fit on the same boat
            if(people[left] + people[right] <= limit) {
                // if they can move to the next lightest person
                left++;
            }

            // move on to the next heaviest person
            right--;

            // add a boat for the current group of people

            boats++;
        }

        return boats;
    }
}
