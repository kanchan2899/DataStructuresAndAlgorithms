package com.dsalgo.graphs;

import java.util.LinkedList;
import java.util.Queue;

// https://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become-rotten/
public class RottenOranges {
    static class Element {
        int x = 0;
        int y = 0;

        Element(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) {
        int[][] v = {{2, 1, 0, 2, 1},
                {1, 0, 1, 2, 1},
                {1, 0, 0, 2, 1}};

        System.out.println(rottenOranges(v));
        System.out.println(rottenOranges1(v));
    }

    /**
     * Bruteforce: Traverse through all oranges in multiple rounds. In every round, rot the oranges
     * to the adjacent position of oranges that were rotten in the last round.
     *
     * 1. Create a variable no = 2 and changed = false.
     * 2. Run a loop until there is no cell of the matrix which is changed in an iteration.
     * 3. Run a nested loop and traverse the matrix:
     *      a. If the element of the matrix is equal to no then assign the adjacent elements to
     *      no + 1 if the adjacent element’s value is equal to 1, i.e. not rotten, and update
     *      changed to true.
     * 4. Traverse the matrix and check if there is any cell that is 1.
     *      a. If 1 is present return -1
     * 5. Else return no – 2.
     *
     * TC: O(n ^ 4)
     * SC: O(1)
     *
     * @param v
     * @return
     */
    private static int rottenOranges(int[][] v) {
        boolean changed = false;
        int no = 2;

        while (true) {
            for(int i = 0; i < v.length; i++) {
                for(int j = 0; j < v[0].length; j++) {

                    // rot all other oranges present at (i+1, j), (i, j-1), (i, j+1), (i-1, j)
                    if(v[i][j] == no) {
                        if(issafe(i+1, j, v) && v[i+1][j] == 1) {
                            v[i+1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if(issafe(i-1, j, v) && v[i-1][j] == 1) {
                            v[i-1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if(issafe(i, j+1, v) && v[i][j+1] == 1) {
                            v[i][j+1] = v[i][j] + 1;
                            changed = true;
                        }
                        if(issafe(i, j-1, v) && v[i][j-1] == 1) {
                            v[i][j-1] = v[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }
            // if no rotten orange found, it means all oranges are rotten now
            if(!changed) {
                break;
            }
            changed = false;
            no++;
        }

        for(int i = 0; i < v.length; i++) {
            for(int j = 0; j < v[0].length; j++) {

                // if any orange is found not rotten, ans can't be found
                if(v[i][j] == 1) {
                    return -1;
                }
            }
        }
        return no - 2;
    }

    private static boolean issafe(int i, int j, int[][] v) {
        if(i >= 0 && i < v.length && j >= 0 && j < v[0].length) {
            return true;
        }
        return false;
    }

    /**
     * Using BFS: The condition of oranges getting rotten is when they come in contact with other
     * rotten oranges. This is similar to a breadth-first search where the graph is divided into
     * layers or circles and the search is done from lower or closer layers to deeper or higher
     * layers.
     *
     * 1. Create an empty queue Q.
     * 2. Find all rotten oranges and enqueue them to Q. Also, enqueue a delimiter to indicate the beginning of the next time frame.
     * 3. Run a loop While Q is not empty and do the following while the delimiter in Q is not reached
     *      a. Dequeue an orange from the queue, and rot all adjacent oranges.
     *      b. While rotting the adjacent, make sure that the time frame is incremented only once.
     *      And the time frame is not incremented if there are no adjacent oranges.
     *      c. Dequeue the old delimiter and enqueue a new delimiter. The oranges rotten in the
     *      previous time frame lie between the two delimiters.
     * 4. Return the last time frame.
     * @param v
     * @return
     */
    private static int rottenOranges1(int[][] v) {
        Queue<Element> queue = new LinkedList<>();
        Element temp;

        int ans = 0;

        // store all the cells having rotten orange in first time frame
        for(int i = 0; i < v.length; i++) {
            for(int j = 0; j < v[0].length; j++) {
                if(v[i][j] == 2) {
                    queue.add(new Element(i, j));
                }
            }
        }

        // separate these rotten oranges from the oranges which will rotten due to the oranges
        // in first time frame using delimiter which is (-1, -1)
        queue.add(new Element(-1, -1));

        // process the grid while there are rotten oranges in the queue
        while (!queue.isEmpty()) {
            // this flag is used to determine whether even a single fresh orange gets rotten
            // due to rotten oranges in the current time frame so we can increase the count
            // of the required time
            boolean flag = false;

            while (!isDelimiter(queue.peek())) {
                temp = queue.peek();

                // check right adjacent cell that if it can be rotten
                if(issafe(temp.x + 1, temp.y, v) && v[temp.x + 1][temp.y] == 1) {
                    if(!flag) {
                        // if this is the first orange to get rotten, increase count and set the flag.
                        ans++;
                        flag = true;
                    }
                    // make the orange rotten
                    v[temp.x + 1][temp.y] = 2;

                    //push the adjacent orange to queue
                    temp.x++;
                    queue.add(new Element(temp.x, temp.y));

                    // move back to current cell
                    temp.x--;
                }

                // check left adjacent cell that if it can be rotten
                if(issafe(temp.x - 1, temp.y, v) && v[temp.x - 1][temp.y] == 1) {
                    if(!flag) {
                        ans++;
                        flag = true;
                    }
                    v[temp.x - 1][temp.y] = 2;
                    temp.x--;
                    queue.add(new Element(temp.x, temp.y));
                    temp.x++;
                }

                // check top adjacent cell that if it can be rotten
                if(issafe(temp.x, temp.y+1, v) && v[temp.x][temp.y+1] == 1) {
                    if(!flag) {
                        ans++;
                        flag = true;
                    }
                    v[temp.x][temp.y+1] = 2;
                    temp.y++;
                    queue.add(new Element(temp.x, temp.y));
                    temp.y--;
                }

                // check bottom adjacent cell if it can be rotten
                if(issafe(temp.x, temp.y-1, v) && v[temp.x][temp.y-1] == 1) {
                    if(!flag) {
                        ans++;
                        flag = true;
                    }
                    v[temp.x][temp.y - 1] = 2;
                    temp.y--;
                    queue.add(new Element(temp.x, temp.y));
                    temp.y++;
                }
                queue.remove();
            }

            // pop the delimiter
            queue.remove();

            // if oranges were rotten in current frame when separate the rotten oranges
            // using delimiter for the next frame for processing.
            if(!queue.isEmpty()) {
                queue.add(new Element(-1, -1));
            }
        }
        return checkAll(v) ? -1 : ans;
    }

    private static boolean isDelimiter(Element temp) {
        return (temp.x == -1 && temp.y == -1);
    }

    private static boolean checkAll(int[][] v) {
        for(int i = 0; i < v.length; i++) {
            for(int j = 0; j < v[0].length; j++) {
                if(v[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

