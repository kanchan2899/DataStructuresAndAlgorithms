package com.dsalgo.grokking.patterns.union.find;

// https://leetcode.com/problems/regions-cut-by-slashes/

class UnionFind5 {
    private int[] parent;
    private int[] rank;

    public UnionFind5(int n) {
        parent = new int[n];
        rank = new int[n];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    public int find(int v) {
        if(parent[v] != v) {
            parent[v] = find(parent[v]);
        }
        return parent[v];
    }

    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);

        if(p1 != p2) {
            if(rank[p1] > rank[p2]) {
                parent[p2] = p1;
                rank[p1] += rank[p2];
            } else {
                parent[p1] = p2;
                rank[p2] += rank[p1];
            }
        }
    }
}
public class RegionsCutBySlashes {
    public static void main(String[] args) {
        String[] input = {
                " \\/",
                " /\\",
                "\\/ "
        };
        System.out.println(regionsBySlashes(input));
    }

    private static int regionsBySlashes(String[] grid) {
        int n = grid.length;
        UnionFind5 findUnion = new UnionFind5(4 * n * n);

        // traverse the list
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                int root = 4 * (r * n  + c);
                char val = grid[r].charAt(c);
                if((val == '/') || (val == ' ')) {
                    // connect the north and west component of the box
                    findUnion.union(root + 0, root + 1);

                    // connect the east and south component of the box
                    findUnion.union(root + 2, root + 3);
                }
                if ((val == '\\') || (val == ' ')) {

                    // Connecting the north and east components of the box
                    findUnion.union(root + 0, root + 2);

                    // Connecting the west and south components of the box
                    findUnion.union(root + 1, root + 3);
                }

                // Connecting the south component of the current box with the north component of the box below it
                if (r + 1 < n)
                    findUnion.union(root + 3, (root + 4 * n) + 0);

                // Connecting the north component of the current box with the south component of the box above it
                if (r - 1 >= 0)
                    findUnion.union(root + 0, (root - 4 * n) + 3);

                // Connecting the east component of the current box with the west component of the box on its right
                if (c + 1 < n)
                    findUnion.union(root + 2, (root + 4) + 1);

                // Connecting the west component of the current box with the east component of the box on its left
                if (c - 1 >= 0)
                    findUnion.union(root + 1, (root - 4) + 2);
            }
        }

        // Finding the number of connected components
        int count = 0;
        for (int x = 0; x < 4 * n * n; ++x) {
            if (findUnion.find(x) == x)
                count++;
        }

        return count;
    }
}
