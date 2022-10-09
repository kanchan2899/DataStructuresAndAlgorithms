package com.dsalgo.recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 1, 2, 2, 2};
        int target = 1;
//        System.out.println(rotatedBinarySearch(arr, target, 0, arr.length - 1));
//        System.out.println(rotatedBinarySearch1(arr, target));
        System.out.println(rotatedBinarySearch2(arr, target));
    }

    private static boolean rotatedBinarySearch2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return true;
            }
            else if(nums[mid] > nums[start]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (nums[mid] < nums[start]) {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start += 1;
            }
        }
        return false;
    }

    private static int rotatedBinarySearch1(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            while(start <= end) {
                int mid = start + (end - start) / 2;
                if(nums[mid] == target) {
                    return mid;
                }
                if(nums[mid] >= nums[start]) {
                    if((target >= nums[start] && target <= nums[mid])) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if(target >= nums[mid] && target <= nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                }
            }
            return -1;
    }

    private static int rotatedBinarySearch(int[] arr, int target, int s, int e) {
        if (s > e) {
            return -1;
        }
        int m = s + (e - s) / 2;
        if(arr[m] == target) {
            return m;
        }
        if(arr[m] > arr[s]) {
            if(target >= arr[s] && target <= arr[m]) {
                return rotatedBinarySearch(arr, target, s, m - 1);
            } else {
                return rotatedBinarySearch(arr, target, m + 1, e);
            }
        }
        if(target >= arr[m] && target <= arr[e]) {
            return rotatedBinarySearch(arr, target, m + 1, e);
        }

        return rotatedBinarySearch(arr, target, s, m - 1);
    }
}
