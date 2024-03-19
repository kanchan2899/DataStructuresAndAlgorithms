package com.dsalgo.grokking.patterns.union.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/number-of-islands/description/
class UnionFind1 {
    private List<Integer> parent;
    private List<Integer> rank;
    private int count;

    UnionFind1(List<List<Character>> grid) {
        int m = grid.size();
        int n = grid.get(0).size();

        this.parent = new ArrayList<>();
        this.rank = new ArrayList<>();
        this.count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid.get(i).get(j) == '1') {
                    parent.add(i * n + j);
                    this.count += 1;
                } else {
                    this.parent.add(-1);
                }
                this.rank.add(1);
            }
        }
    }

    public List<Integer> getParent() {
        return this.parent;
    }

    public int getCount() {
        return this.count;
    }

    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1 != p2) {
            if(this.rank.get(p1) > this.rank.get(p2)) {
                this.parent.set(p2, p1);
            } else if (this.rank.get(p1) > this.rank.get(p2)) {
                this.parent.set(p1, p2);
            } else {
                this.parent.set(p2, p1);
                this.rank.set(p1, this.rank.get(p1) + 1);
            }
            count--;
        }
    }

    private int find(int v) {
        if(this.parent.get(v) != v) {
            this.parent.set(v, this.find(this.parent.get(v)));
        }

        return this.parent.get(v);
    }
}
public class NumberOfIslands {
    public static void main(String[] args) {
        List<List<Character>> grid1 = Arrays.asList(
                Arrays.asList('1', '1', '1'),
                Arrays.asList('0', '1', '0'),
                Arrays.asList('1', '0', '0'),
                Arrays.asList('1', '0', '1'));

        System.out.println(numberOfIslands(grid1));
    }

    private static int numberOfIslands(List<List<Character>> grid) {
        // if grid is empty, return 0
        if(grid.size() == 0) {
            return 0;
        }
        // get the number of rows and columns in the grid
        int cols = grid.get(0).size();
        int rows = grid.size();

        // create a union find class object to represent the islands in the grid
        UnionFind1 unionFind = new UnionFind1(grid);

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                // if the current cell is a land, then mark it as visited
                if(grid.get(r).get(c) == '1') {
                    grid.get(r).set(c, '0');

                    // check the horizontal and vertical neighbours of the current cell
                    // If any of the neighbours are also lands, then unite the current cell with
                    // the neighbour
                    if(r - 1 >= 0 && grid.get(r - 1).get(c) == '1') {
                        unionFind.union(r * cols + c, (r - 1) * cols + c);
                    }
                    if(r + 1 < rows && grid.get(r + 1).get(c) == '1') {
                        unionFind.union(r * cols + c, (r + 1) * cols + c);
                    }
                    if(c - 1 >= 0 && grid.get(r).get(c - 1) == '1') {
                        unionFind.union(r * cols + c, r * cols + c - 1);
                    }
                    if(c + 1 < cols && grid.get(r).get(c + 1) == '1') {
                        unionFind.union(r * cols + c, r * cols + c + 1);
                    }
                }
            }
        }

        int count = unionFind.getCount();
        return count;
    }
}
