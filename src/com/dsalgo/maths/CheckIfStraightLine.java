package com.dsalgo.maths;

public class CheckIfStraightLine {
    public static void main(String[] args) {
        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int y0 = coordinates[0][1];
        int x1 = coordinates[1][0];
        int y1 = coordinates[1][1];

        int dx = x1 - x0;
        int dy = y1 - y0;

        for(int[] coordinate: coordinates) {
            int x = coordinate[0];
            int y = coordinate[1];

            if(dx * (y - y1) != dy * (x - x1)) {
                return false;
            }
        }
        return true;
    }
}
