package com.leetcode.problems.p1_20.p16;

import java.util.Arrays;

/**
 * 定义三个工作指针left mid right
 * 先进行排序
 * left初始指向数组第一位，mid=left+1，right初始指向数组最后一位
 * 计算三数之和sum，和target比较，同时计算最小差距
 * 如果大了，则right-1，如果小了，则mid+1，循环mid<right
 * 一轮结束后，left+1，mid=left+1，right=end，继续循环
 */
public class Solution {

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int sum;
        int minSum = nums[0] + nums[1] + nums[2];
        for (int left = 0; left < nums.length; left++) {
            int right = nums.length - 1;
            int mid = left + 1;
            while (mid < right) {
                sum = nums[left] + nums[mid] + nums[right];
                if (Math.abs(sum - target) < Math.abs(minSum - target)) {
                    minSum = sum;
                }
                if (sum > target) {
                    right--;
                } else {
                    mid++;
                }
            }
        }

        return minSum;
    }

}
