package com.leetcode.problems.p51_80;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class P55JumpGame {

    /**
     * 动态规划
     * 假设位置 i （0 <= i <= len-1）能够向远处跳的最远位置为 dp[i]
     * 则：
     * 1、dp[0] = nums[0] + 0 = nums[0]
     * 2、dp[i] ：如果 dp[i-1] >= i ，即从前一个位置能够到达第i位置时，才考虑计算dp[i]，否则dp[i] = 0
     *          dp[i] = max{ nums[i] + i, dp[i-1] }
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (dp[i-1] >= i) {
                // 能够到达位置i
                dp[i] = Math.max(nums[i] + i, dp[i-1]);
            } else {
                dp[i] = 0;
            }
            if (dp[i] >= nums.length - 1) {
                // 如果某个位置就已经能够到达最后尾部，则直接结束
                return true;
            }
        }

        return false;
    }

    /**
     * 贪心算法
     * 从后往前走，记录当前能到达尾部的最远位置
     * 如果最后是0，说明成功
     * @param nums
     * @return
     */
    public boolean canJump2(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        int maxIndex = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (i + nums[i] >= maxIndex) { // 新位置每次都和前一个位置比较
                maxIndex = i;
            }
        }

        return maxIndex == 0;
    }

}
