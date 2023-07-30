package com.dsalgo.grokking.patterns.mege.intervals;

import java.util.Arrays;

public class MeetingMaxGuests {
    public static void main(String[] args) {
        int[] arr = {1, 2, 10, 5, 5};
        int[] dep = {4, 5, 12, 9, 12};
        System.out.println(findMaxGuests(arr, dep, arr.length));

        System.out.println(findMaxGuests1(arr, dep, arr.length));
    }

    /**
     * Using an auxiliary array:
     *
     * 1. Create an auxiliary array used for storing dynamic data of starting and ending points.
     * 2. Loop through the whole array of elements and increase the value at the starting point by 1
     * and similarly decrease the value after ending point by 1.
     * x[start[i]] -= 1 and x[end[i] + 1] -= 1
     * 3. While looping, after calculating the auxiliary array: permanently add the value at current
     * index and check for the maximum valued index traversing from left to right.
     *
     *  TC: O(max(departure time))
     *  SC: O(max(departure time))
     *
     * @param start
     * @param end
     * @param n
     * @return
     */
    private static int findMaxGuests1(int[] start, int[] end, int n) {
        int maxStartingTime = Arrays.stream(start).max().getAsInt();
        int maxEndingTime = Arrays.stream(end).max().getAsInt();

        int maxTime = Math.max(maxEndingTime, maxStartingTime);

        int[] x = new int[maxTime + 2];

        Arrays.fill(x, 0);

        int current = 0, index = 0;

        // create an auxiliary array
        for(int i = 0; i < n; i++) {
            // lazy addition
            ++x[start[i]];
            --x[end[i] + 1];
        }

        int maxy = Integer.MIN_VALUE;

        // lazily calculating value at index i
        for(int i = 0; i <= maxTime; i++) {
            current += x[i];
            if(maxy < current) {
                maxy = current;
                index = i;
            }
        }

        return maxy;
    }

    /**
     * Efficient solution: The idea is to consider all events (all arrivals and departures) in sorted
     * order. Once we have all events in sorted order, we can trace the number of guests at any time
     * keeping track of guests that have arrived but not exited. Total number of guests at any time
     * can be obtained by subtracting total exits from total arrivals by that time.
     *
     * TC: O(n * log n)
     * SC: O(1)
     * @param arr
     * @param dep
     * @param n
     * @return
     */
    private static int findMaxGuests(int[] arr, int[] dep, int n) {
        // sort the arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // guests_in indicates number of guests at a time
        // minimum 1 guest is the assumption
        // max_guest and guests_in and i are initialized as 1 assuming first guest can be met with.
        int guests_in = 1, max_guests = 1, time = arr[0];
        int i = 1, j = 0;

        // process all guests in sorted order
        while(i < n && j < n) {
            // if next guest in sorted order is arrival, increment count of guests
            if(arr[i] <= dep[j]) {
                guests_in++;

                // update max_guests if needed
                if(guests_in > max_guests) {
                    max_guests = guests_in;
                    time = arr[i];
                }
                i++;    // increment index of arrival
            } else {
                guests_in--;
                j++;
            }
        }
        return max_guests;
    }
    
    
}
