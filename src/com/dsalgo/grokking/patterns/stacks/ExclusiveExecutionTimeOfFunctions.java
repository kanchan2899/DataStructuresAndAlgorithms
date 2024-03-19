package com.dsalgo.grokking.patterns.stacks;

import java.util.*;

// https://leetcode.com/problems/exclusive-time-of-functions/description/
public class ExclusiveExecutionTimeOfFunctions {
    static class Event {
        private int id;
        private boolean isStart;
        private int time;

        public Event(String content) {
            String[] strs = content.split(":");
            this.id = Integer.parseInt(strs[0]);
            this.isStart = strs[1].equals("start");
            this.time = Integer.parseInt(strs[2]);
        }

        public int getId() {
            return this.id;
        }

        public boolean getIsStart() {
            return this.isStart;
        }

        public int getTime() {
            return this.time;
        }
    }
    public static void main(String[] args) {
        int n = 3;
        List<String> events = Arrays.asList("0:start:0", "1:start:2", "1:end:3", "2:start:4", "2:end:7", "0:end:8");
        System.out.println(Arrays.toString(exclusiveTime(n, events)));
    }

    private static int[] exclusiveTime(int n, List<String> events) {
        Deque<Event> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<Integer> (Collections.nCopies(n, 0));
        for (String content: events) {
            // Extract the log details from the content(string)
            Event event = new Event(content);
            if (event.getIsStart()) {
                // Push the event details to the stack
                stack.push(event);
            } else {
                // Pop the log details from the stack
                Event top = stack.pop();
                // Add the execution time of the current function in the actual result
                result.set(top.getId(), result.get(top.getId()) + (event.getTime() - top.getTime() + 1));
                // If the stack is not empty, subtract the current child function execution time
                // from the parent function
                if (!stack.isEmpty()) {
                    result.set(stack.peek().getId(), result.get(stack.peek().getId()) - (event.getTime() - top.getTime() + 1));
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
