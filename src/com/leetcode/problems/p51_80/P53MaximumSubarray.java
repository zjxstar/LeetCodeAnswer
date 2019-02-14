package com.leetcode.problems.p51_80;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class P53MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) { // 直接抛弃
                sum = nums[i];
            } else {
                sum += nums[i];
            }

            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

    /**
     * 动态规划
     * dp[i] = max(dp[i-1] + a[i], a[i])
     * dp[i]表示：以第i个数结尾的最大连续子串和
     * （1）以第i-1个数结尾，在加上第i个数
     * （2）只有第i个数
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int k = 0;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i] > dp[k]) k = i;
        }

        return dp[k];
    }

}
