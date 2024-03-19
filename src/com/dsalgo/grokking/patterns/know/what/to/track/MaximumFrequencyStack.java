package com.dsalgo.grokking.patterns.know.what.to.track;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// https://leetcode.com/problems/maximum-frequency-stack/description/
public class MaximumFrequencyStack {
    Map<Integer, Integer> frequency;
    Map<Integer, Stack<Integer>> group;
    int maxFrequency;

    public MaximumFrequencyStack() {
        frequency = new HashMap<>();
        group = new HashMap<>();
        maxFrequency = 0;
    }

    // use push function to push the value into the frequencyStack
    public void push(int value) {
        // get the frequency for the given value and increment the frequency for the given value
        int frequency = this.frequency.getOrDefault(value,  0) + 1;
        this.frequency.put(value, frequency);

        // check if the maximum frequency is lower than the new frequency
        if(frequency >= maxFrequency) {
            maxFrequency = frequency;
        }

        // save the given showName for the new calculated frequency
        this.group.computeIfAbsent(frequency, z -> new Stack<>()).push(value);
    }

    // use the pop function to pop the maximum element from the stack
    public int pop() {
        int show = 0;
        if(maxFrequency > 0) {
            // fetch the top of the group[maxFrequency] stack and pop the top of the group[maxFrequency]
            // stack
            show = group.get(maxFrequency).pop();

            // decrement the frequency after the show has been popped
            frequency.put(show, frequency.get(show) - 1);
            if(group.get(maxFrequency).size() == 0) {
                maxFrequency--;
            }
        } else {
            return -1;
        }
        return show;
    }

    public static void main(String[] args) {
        int[] inputs = {5, 7, 7, 7, 4, 5, 3};
        MaximumFrequencyStack obj = new MaximumFrequencyStack();
        for(int i : inputs) {
            obj.push(i);
        }

        for(int i = 0; i < 3; i++) {
            System.out.println(obj.pop());
        }

    }
}
