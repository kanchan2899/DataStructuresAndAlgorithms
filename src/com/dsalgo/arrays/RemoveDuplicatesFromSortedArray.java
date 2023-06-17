package com.dsalgo.arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 3, 4, 5, 5};
        System.out.println("Number of unique elements is " + removeDuplicates(nums));
        int[] nums1 = {1, 1, 2, 2, 2, 2, 3, 4, 5, 5};
        System.out.println("Number of unique elements is " + removeDuplicates1(nums1));
    }

    /**
     * Using Bruteforce: Creare a new array temp. Copy first element of arr to temp
     * and initialize index to 1. Start a loop i from 1 to n and
     * check if current element i is equal to the index - 1 element. If not, copy the current
     * element i to index position in temp array. At the end, copy first index elements from temp
     * to arr. Return index.
     *
     * TC: O(n)
     * SC: O(n)
     *
     * @param nums
     * @return
     */
    private static int removeDuplicates1(int[] nums) {
        int[] temp = new int[nums.length];
        temp[0] = nums[0];

        int index = 1;

        for(int i = 1; i < nums.length; i++) {
            if(temp[index - 1] != nums[i]) {
                temp[index] = nums[i];
                index++;
            }
        }

        for(int i = 0; i < index; i++) {
            nums[i] = temp[i];
        }
        return index;
    }

    /**
     * Use two pointer approach: Intialize the current index left to 0. Start a loop right
     * from 0 to n. Check is element at right position is equal to element ar right - 1 index.
     * If not, assign the right+1 element to left+1 position. Return left+1 position;
     *
     * TC: O(n)
     * SC: O(1)
     * @param nums
     * @return
     */
    public  static int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1){
            return nums.length;
        }
        /*
        int left = 1;
        for(int right = 1; right < nums.length; right++){
            if(nums[right] != nums[right - 1]){
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
        */
        int left = 0;
        for(int right = 0; right < nums.length - 1; right++){
            if(nums[right] != nums[right+1]){
                nums[++left] = nums[right + 1];
            }
        }
        return left+1;
    }
}
