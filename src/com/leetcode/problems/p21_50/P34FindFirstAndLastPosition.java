package com.leetcode.problems.p21_50;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class P34FindFirstAndLastPosition {

    /**
     * 二分法递归
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null) {
            return result;
        }
        searchHalf(nums, target, result, 0, nums.length - 1);
        return result;
    }

    private void searchHalf(int[] nums, int target, int[] result, int left, int right) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                if (result[0] == -1) {
                    result[0] = mid; // 第一次替换
                } else { // 替换start
                    result[0] = Math.min(result[0], mid);
                }
                if (result[1] == -1) {
                    result[1] = mid;
                } else { // 替换end
                    result[1] = Math.max(result[1], mid);
                }
                if (left <= mid - 1) { // 再从左半边找起始位置
                    searchHalf(nums, target, result, left, mid - 1);
                }
                if (mid + 1 <= right) { // 再从右半边找结束为止
                    searchHalf(nums, target, result, mid + 1, right);
                }
                return; // 一定要return，否则死循环
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

}
