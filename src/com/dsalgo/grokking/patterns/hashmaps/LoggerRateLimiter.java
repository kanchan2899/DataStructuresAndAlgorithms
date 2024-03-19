package com.dsalgo.grokking.patterns.hashmaps;

import java.util.HashMap;

// https://leetcode.com/problems/logger-rate-limiter/
public class LoggerRateLimiter {
    private HashMap<String, Integer> requests;
    int limit;

    public LoggerRateLimiter(int timeLimit) {
        requests = new HashMap<>();
        limit = timeLimit;
    }

    public boolean messageRequestDetection(int timestamp, String request) {
        // check whether the specific request exists in the hash map or not
        if(!this.requests.containsKey(request)) {
            this.requests.put(request, timestamp);
            return true;
        }

        // if it exists, check whether its time duration lies within the defined timestamp
        if(timestamp - this.requests.get(request) >= limit) {
            // store this new request in the hash map, and return true
            this.requests.put(request, timestamp);
            return true;
        } else {
            // the request is already exists within the timestamp and is identical, request
            // should be rejected, return false
            return false;
        }
    }
    public static void main(String[] args) {
        int[] times = {1, 5, 6, 7, 15 };
        String[] messages = {"good morning", "hello world", "good morning", "good morning", "hello world"};

        LoggerRateLimiter rateLimiter = new LoggerRateLimiter(7);

        for(int i = 0; i < messages.length; i++) {
            System.out.println(rateLimiter.messageRequestDetection(times[i], messages[i]));
        }
    }
}
