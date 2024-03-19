package com.dsalgo.grokking.patterns.union.find;

import java.util.*;

// https://leetcode.com/problems/accounts-merge/description/
class UnionFind6 {
    private int[] parents;

    public UnionFind6(int n) {
        parents = new int[n];
        for(int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public int find(int node) {
        if(parents[node] == node) {
            return node;
        }
        return find(parents[node]);
    }

    public void union(int node1, int node2) {
        int rootNode1 = find(node1);
        int rootNode2 = find(node2);

        if(rootNode1 != rootNode2) {
            parents[rootNode2] = rootNode1;
        }
    }
}
public class AccountsMerge {

    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(Arrays.asList("Emma", "emma@mail.com", "emma_work@mail.com"),
                Arrays.asList("Bob", "bob_home@mail.com", "bob123@mail.com"),
                Arrays.asList("Emma", "emma_art@mail.com", "emma_work@mail.com"),
                Arrays.asList("Bob", "bob321@mail.com"));

        List<List<String>> merged = accountsMerge(accounts);
        for(List<String> row: merged) {
            System.out.println(row);
        }
    }

    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind6 unionFind = new UnionFind6(accounts.size());

        // create a map for mapping emails to their parent IDs
        Map<String, Integer> emailMapping = new HashMap<>();

        for(int i = 0; i < accounts.size(); i++) {
            List<String> emails = accounts.get(i);

            // if the email already exists in the map, take union
            for(int j = 1; j < emails.size(); j++) {
                if(emailMapping.containsKey(emails.get(j))) {

                    // before we take the union, make sure both the accounts have the same name
                    if(!accounts.get(i).get(0).equals(accounts.get(emailMapping.get(emails.get(j))).get(0))) {
                        // return an empty list to indicate an error
                        return new ArrayList<>();
                    }

                    unionFind.union(emailMapping.get(emails.get(j)), i);
                }
                emailMapping.put(emails.get(j), i);
            }
        }

        // create a map to store the merged accounts
        Map<Integer, List<String>> mergedAccounts = new HashMap<>();
        for(Map.Entry<String, Integer> entry: emailMapping.entrySet()) {
            int root = unionFind.find(entry.getValue());
            mergedAccounts.computeIfAbsent(root, k -> new ArrayList<>()).add(entry.getKey());
        }


        // sort the merged accounts
        List<List<String>> finalMerged = new ArrayList<>();

        for(Map.Entry<Integer, List<String>> entry: mergedAccounts.entrySet()) {
            int parent = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);

            List<String> merged = new ArrayList<>();
            merged.add(accounts.get(parent).get(0));
            merged.addAll(emails);
            finalMerged.add(merged);
        }
        return finalMerged;
    }
}
