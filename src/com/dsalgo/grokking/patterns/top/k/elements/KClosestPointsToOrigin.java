package com.dsalgo.grokking.patterns.top.k.elements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/find-k-closest-points-to-the-origin/
public class KClosestPointsToOrigin {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int distanceFromOrigin() {
            return (x * x) + (y * y);
        }
    }
    public static void main(String[] args) {
        Point[] pointsOne = new Point[] {
                new Point(1, 3),
                new Point(3, 4),
                new Point(2, -1)};
        int k = 2;

        System.out.println(kClosestPointsToOrigin(pointsOne, k));

    }

    /**
     * Time complexity: O(n * log k), where n is the total number of points and k is the number of
     * points closest to the origin. This is because we need to iterate over all the n points and
     * perform operations on the heap size of k, which takes O( n * log k) time in the worst case.
     *
     * @param pointsOne
     * @param k
     * @return
     */
    private static List<Point> kClosestPointsToOrigin(Point[] pointsOne, int k) {

        PriorityQueue<Point> maxHeap = new PriorityQueue<>((p1, p2) -> p2.distanceFromOrigin() - p1.distanceFromOrigin());

        // put first k points in the maxHeap
        for(int i = 0; i < k; i++) {
            maxHeap.add(pointsOne[i]);
        }

        // go through the remaining points of the input array, if a location is closer than the top location
        // of the maxheap, remove the top location from heap and add the location from the input array
        for(int i = k; i < pointsOne.length; i++) {
            if(pointsOne[i].distanceFromOrigin() < maxHeap.peek().distanceFromOrigin()) {
                maxHeap.poll();
                maxHeap.add(pointsOne[i]);
            }
        }
        // the heap has k points closes to the origin, return them in a list
        return new ArrayList<>(maxHeap);
    }
}
