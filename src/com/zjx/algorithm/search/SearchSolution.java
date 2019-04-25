package com.zjx.algorithm.search;

public class SearchSolution {

    public int search(int[] nums, int target) {
        return half(nums, target, 0, nums.length - 1);
    }

    public int half(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return half(nums, target, left, mid - 1);
        } else {
            return half(nums, target, mid + 1, right);
        }
    }

}
