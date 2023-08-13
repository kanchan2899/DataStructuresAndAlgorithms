package com.dsalgo.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.geeksforgeeks.org/find-winner-election-votes-represented-candidate-names/
public class WinnerOfElection {
    public static void main(String[] args) {
        String[] votes = {"john", "johnny", "jackie", "johnny", "john", "jackie", "jamie", "jamie",
                "john", "johnny", "jamie", "johnny", "john"};
        System.out.println(Arrays.toString(winner(votes)));
        System.out.println(winner1(votes));
    }

    /**
     * Using Bruteforce: Run two loops and count the occurrences of every word and then find the
     * maximum count.
     * 1. Iterate over every string
     *   a. Count the occurrence of the current string in the given votes[]
     *   b. Maximise the result if count > previous count
     * 2. Return result
     *
     * TC: O(n^2)
     * SC: O(1)
     * @param votes
     * @return
     */
    private static String winner1(String[] votes) {
        int n = votes.length;

        int previousCount = 0;
        String winner = "";

        for(int i = 0; i < n; i++) {
            int count = 0;
            for(int j = i; j < n; j++) {
                if(votes[i].equals(votes[j])) {
                    count++;
                }

                // maximise the result if count > previous count
                if(count > previousCount) {
                    previousCount = count;
                    winner = votes[i];
                } else if(count == previousCount && votes[i].compareTo(winner) < 0) {
                    winner = votes[i];
                }
            }
        }

        return winner;
    }

    /**
     * Using hashing: Insert all votes in a hash map and keep track of counts of different names.
     * Then traverse the map and print the person with the maximum votes.
     *
     * 1. Create a map of string, value pair
     * 2. Now iterate on the votes array and increment the count of every string
     * 3. Traverse the map and the string having maximum count store it as a string variable
     * 4. If there is a tie pick the smaller one
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param votes
     * @return
     */
    private static String[] winner(String[] votes) {
        Map<String, Integer> countMap = new HashMap<>();
        String[] winner = new String[2];

        // insert all votes in the map
        for(String vote : votes) {
            countMap.put(vote, countMap.getOrDefault(vote, 0) + 1);
        }

        // traverse through the map to find the candidate with maximum votes
        int maxVotes = 0;

        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            String candidate = entry.getKey();
            Integer candidate_votes = entry.getValue();

            if(candidate_votes > maxVotes) {
                maxVotes = candidate_votes;
                winner[0] = candidate;
                winner[1] = String.valueOf(maxVotes);
            } else if (candidate_votes == maxVotes && winner[0].compareTo(candidate) > 0) {
                winner[0] = candidate;
                winner[1] = String.valueOf(maxVotes);
            }
        }

        return winner;
    }
}
