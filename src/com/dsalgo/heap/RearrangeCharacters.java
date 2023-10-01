package com.dsalgo.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
public class RearrangeCharacters {
    static int MAX_CHAR = 26;

    public static void main(String[] args) {
        String str = "bbbaa";
        System.out.println(rearrangeString(str));
        System.out.println(rearrangeString1(str));
    }

    /**
     * Fill all the even positions of the result string first, with the highest frequency
     * character. If there are still some even positions remaining, fill them first.
     * Once even positions are done, then fill the odd positions. This way, it can be ensured
     * that no two adjacent characters are the same.
     *
     * 1. Calculate the frequencies of every character in the input string
     * 2. If a character with a maximum frequency has a frequency greater than (n + 1) / 2,
     * then return an empty string, as it is not possible to construct a string
     * 3. Now fill the even index positions with the maximum frequency character, if some even
     * positions are remaining then first fill them with remaining characters
     * 4. Then fill odd index positions with the remaining characters
     * 5. Return the constructed string
     *
     *
     * @param str
     * @return
     */
    private static String rearrangeString1(String str) {
        int n  = str.length();
        if(n == 0) {
            return null;
        }

        int[] count = new int[26];
        Arrays.fill(count, 0);

        for(char ch : str.toCharArray()) {
            count[(int) ch - (int) 'a']++;
        }

        char ch_max = getMaxCountChar(count);

        int max_count = count[ch_max - 'a'];

        if(max_count > (n + 1) / 2) {
            return null;
        }

        String result = "";

        for(int i = 0; i < n; i++) {
            result += ' ';
        }

        int index = 0;

        while (max_count > 0) {
            result = result.substring(0, index) + ch_max + result.substring(index + 1);

            index = index + 2;

            max_count--;
        }

        // now filling the other chars, first filling the even positions and then the odd positions
        for(int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                index = (index >= n) ? 1 : index;
                result = result.substring(0, index) + (char)('a' + i) + result.substring(index + 1);

                index += 2;
                count[i]--;
            }
        }
        
        return result;
    }

    private static char getMaxCountChar(int[] count) {
        int max = 0;
        char ch = 0;

        for(int i = 0; i < 26; i++) {
            if(count[i] > max) {
                max = count[i];
                ch = (char) ((int)'a' + i);
            }
        }
        return ch;
    }

    /**
     * Using heap: The idea is to put the highest frequency character first (a greedy approach).
     * Use a priority queue (Or Binary Max Heap) and put all characters and ordered by their
     * frequencies (highest frequency character at root). One by one take the highest frequency
     * character from the heap and add it to result. After adding it, just decrease the frequency
     * of the character and then temporarily move this character out of priority queue so that
     * it is not picked again next time.
     *
     * 1. Build a Priority_queue or max_heap, pq that stores characters with their frequencies.
     *      a. Priority_queue or max_heap is built on the basis of the frequency of character.
     * 2. Create a temporary Key that will be used as the previously visited element
     * (the previous element in the resultant string. Initialize it { char = ‘#’ , freq = ‘-1’ }
     * 3. While pq is not empty.
     *      a. Pop an element and add it to the result.
     *      b. Decrease the frequency of the popped element by ‘1’
     *      c. Push the previous element back into the priority_queue if its frequency is
     *      greater than zero.
     *      d. Make the current element as the previous element for the next iteration.
     * 4. If the length of the resultant string and the original string is not equal,
     * then print “not possible”, else print the resultant string.
     *
     * TC: O(n * log n)
     * SC: O(n)
     *
     * @param str
     * @return
     */
    private static String rearrangeString(String str) {
        int n = str.length();
        int[] count = new int[MAX_CHAR];

        // store the frequency of each character
        for(int i = 0; i < n; i++) {
            count[str.charAt(i) - 'a']++;
        }

        PriorityQueue<Key> pq = new PriorityQueue<>();
        // insert all characters with their frequencies into a PQ
        for(char c = 'a'; c <= 'z'; c++) {
            int val = c - 'a';
            if(count[val] > 0)
            {
                pq.add(new Key(count[val], c));
            }
        }

        // str that will store resultant value
        str = "";

        // work as the previous visited element initial previous element be
        Key prev = new Key(-1, '#');

        while (pq.size() != 0) {
            Key k = pq.peek();
            pq.poll();

            str = str + k.ch;

            // if frequency of previous character is less than zero that means it is useless,
            // we need not to push it
            if(prev.freq > 0) {
                pq.add(prev);
            }

            k.freq--;

            prev = k;
        }
        if(n != str.length()) {
            return null;
        }
        return str;
    }
}

class Key implements Comparable<Key>{
    int freq;
    char ch;

    Key(int freq, char ch) {
        this.freq = freq;
        this.ch = ch;
    }

    @Override
    public int compareTo(Key o) {
        if(this.freq < o.freq) {
            return 1;
        } else if(this.freq > o.freq) {
            return -1;
        } else {
            return 0;
        }
    }
}
