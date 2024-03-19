package com.dsalgo.grokking.patterns.union.find;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/description/
class UnionFind2 {
    private Map<Integer, Integer> parents;
    private Map<Integer, Integer> ranks;

    public UnionFind2() {
        parents = new HashMap<>();
        ranks = new HashMap<>();
    }

    public int find(int coordinate) {
        if(coordinate != parents.get(coordinate)) {
            parents.put(coordinate, find(parents.get(coordinate)));
        }
        return parents.get(coordinate);
    }
    public void union(int x, int y) {
        // set the parent of each coordinate to itself if not already present in the map
        parents.putIfAbsent(x, x);
        parents.putIfAbsent(y, y);

        // set the ranks of each coordinate to 0 if not already present in the map
        ranks.putIfAbsent(x, 0);
        ranks.putIfAbsent(y, 0);

        // compare the ranks of the two coordinates to decide which should be the parent
        if(ranks.get(x) > ranks.get(y)) {
            parents.put(find(y), find(x));
        } else if (ranks.get(x) < ranks.get(y)) {
            parents.put(find(x), find(y));
        } else {
            // if the ranks are equal, choose one coordinate as the parent and increment its rank
            parents.put(find(x), find(y));
            ranks.put(y, ranks.get(y) + 1);
        }
    }

    public Map<Integer, Integer> getParents() {
        return this.parents;
    }
}
public class MostStonesRemovedWithSameRowsOrColumn {
    public static void main(String[] args) {
        int[][] stones = {{1, 0}, {2, 1}, {2, 3}, {3, 1}, {3, 3}};
        System.out.println(removeStones(stones));
    }
    public static int removeStones(int[][] stones) {
        // using offset for y coordinate ato avoid any possible clash with x coordinates
        int offset = 100000;
        UnionFind2 stone = new UnionFind2();

        // iterate over all stones
        for(int[] s : stones) {
            int x = s[0];
            int y = s[1];
            stone.union(x, y + offset);
        }

        // create a set of all the roots of the connected groups
        Set<Integer> groups = new HashSet<>();
        Map<Integer, Integer> parents = stone.getParents();
        for(Map.Entry<Integer, Integer> entry: parents.entrySet()) {
            groups.add(stone.find(entry.getKey()));
        }

        return stones.length - groups.size();
    }
}
