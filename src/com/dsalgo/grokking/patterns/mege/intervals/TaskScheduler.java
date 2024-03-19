package com.dsalgo.grokking.patterns.mege.intervals;

import java.util.*;

// https://hsiyinl.medium.com/task-scheduler-leetcode-621-dd8312160f03
public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B', 'D', 'C', 'O', 'Z', 'D', 'E', 'Q'};
        int n = 3;
        System.out.println(leastTime(tasks, n));
    }

    private static int leastTime(char[] tasks, int n) {
        // initialize a hash map to store the frequencies of the tasks
        Map<Character, Integer> frequencies = new HashMap<>();

        // store the frequency of each task
        for(char t : tasks) {
            frequencies.put(t, frequencies.getOrDefault(t, 0) + 1);
        }

        // sort the frequencies
        List<Map.Entry<Character, Integer>> sortedFrequencies = new ArrayList<>(frequencies.entrySet());
        Collections.sort(sortedFrequencies, (lhs, rhs) -> lhs.getValue().compareTo(rhs.getValue()));

        // store the max frequency
        int maxFreq = sortedFrequencies.get(sortedFrequencies.size() - 1).getValue();
        sortedFrequencies.remove(sortedFrequencies.size() - 1);

        // compute the maximum possible idle time
        int idleTime = (maxFreq - 1) * n;

        // iterate over the frequencies array and update the idle time
        while (!sortedFrequencies.isEmpty() && idleTime > 0) {
            idleTime -= Math.min(maxFreq - 1, sortedFrequencies.get(sortedFrequencies.size() - 1).getValue());
            sortedFrequencies.remove(sortedFrequencies.size() - 1);
        }

        idleTime = Math.max(0, idleTime);

        // Return the total time, which is the sum of the busy time and idle time
        return tasks.length + idleTime;
    }
}
