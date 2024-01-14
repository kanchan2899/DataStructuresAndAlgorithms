package com.dsalgo.grokking.patterns.fast.slow.pointers;

public class CircularArrayLoop {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 7, 2, -1, 2, -1, -1};
        System.out.println(circularArrayLoop(arr));
    }

    private static boolean circularArrayLoop(int[] arr) {
        int size = arr.length;
        for(int i = 0; i < size; i++) {
            int slow = i, fast = i;
            boolean forward = arr[i] > 0;

            while (true) {
                slow = nextStep(slow, arr[slow], size);

                if(isNotCycle(arr, forward, slow)) {
                    break;
                }

                fast = nextStep(fast, arr[fast], size);

                if(isNotCycle(arr, forward, fast)) {
                    break;
                }

                fast = nextStep(fast, arr[fast], size);

                if(isNotCycle(arr, forward, fast)) {
                    break;
                }

                if(slow == fast) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if(result < 0) {
            result += size;
        }
        return result;
    }

    public static boolean isNotCycle(int[] arr, boolean prevDirection, int pointer) {
        boolean currDirection = arr[pointer] >= 0;
        if(prevDirection != currDirection || Math.abs(arr[pointer] % arr.length) == 0) {
            return true;
        }
        return false;
    }
}
