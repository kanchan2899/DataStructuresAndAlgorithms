package com.dsalgo.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BuiltinMethods {
    public static void main(String[] args) {
        int[] arr = {0, 4, 1, 5, 7, 8, 2};
        System.out.println(Arrays.toString(arr));
        /**
         * Primitive types
         */
        // Using Arrays.sort(arr) -> Increasing/Ascending order
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // Using Arrays.sort(arr, startIndex, endIndex) -> Increasing/Ascending order for the
        // specified indexes
        int[] arr1 = {'a', 'u', 'i', 'o', 'e'};
        Arrays.sort(arr1, 0, 3);
        System.out.println(Arrays.toString(arr1));

    }
}

class Point implements Comparable<Point>{
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point P) {
        return this.x - P.x;
    }

    public String toString() {
        return this.x + " " + this.y;
    }
}

class PointTest{
    public static void main(String[] args) {
        Point[] points = {new Point(4, 1), new Point(9, 8), new Point(6, 2)};
        Arrays.sort(points);

        for(Point x: points) {
            System.out.println(x);
        }
        System.out.println("**************");
        Arrays.sort(points, Collections.reverseOrder());
        for(Point x: points) {
            System.out.println(x);
        }


    }
}

// Point class which does not implement Comparable interface.
// Thus, the objects of this class are not comparable.
class Coordinate {
    int x, y;

    Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return this.x + " " + this.y;
    }
}

// This class implements Comparator interface to compare
class CoordinateComparator implements Comparator<Coordinate> {

    public int compare(Coordinate c1, Coordinate c2) {
        return c1.x - c2.x;
    }
}

class CoordinateTest {
    public static void main(String[] args) {
        Coordinate[] coordinates = {new Coordinate(4, 1), new Coordinate(6, 9),
        new Coordinate(0, 7)};

        Arrays.sort(coordinates, new CoordinateComparator());

        for(Coordinate c: coordinates) {
            System.out.println(c);
        }

        System.out.println("*****************");


    }
}

// Sort an Integer array in such a way that all even numbers come first followed
// by all the odd numbers.
class EvenThenOddComparator implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
        return a%2 - b%2;
    }
}

class WrapperExample {
    public static void main(String[] args) {
        Integer[] arr = {9, 1, 4, 2, 5};

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, Collections.reverseOrder());

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr, new EvenThenOddComparator());

        System.out.println(Arrays.toString(arr));

    }
}