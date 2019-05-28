package com.leetcode.problems.p81_110;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。
 *
 * 编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 *
 * 示例 1:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 0
 * 输出: true
 * 示例 2:
 *
 * 输入: nums = [2,5,6,0,0,1,2], target = 3
 * 输出: false
 */
public class P81Search {

    public boolean search(int[] nums, int target) {
        return halfSearch(nums, 0, nums.length - 1, target);
    }

    private boolean halfSearch(int[] nums, int left, int right, int target) {
        if (left > right) {
            return false;
        }

        int mid = (left + right) >> 1;
        if (nums[mid] == target) {
            return true;
        }

        if (nums[mid] < nums[right]) {
            // 右边是有序的
            if (nums[mid] < target && target <= nums[right]) {
                // target在右边
                return halfSearch(nums, mid + 1, right, target);
            } else {
                return halfSearch(nums, left, mid - 1, target);
            }
        } else if(nums[mid] > nums[left]) {
            // 左边是有序的
            if (nums[mid] > target && target >= nums[left]) {
                // target在左边
                return halfSearch(nums, left, mid - 1, target);
            } else {
                return halfSearch(nums, mid + 1, right, target);
            }
        } else if(nums[mid] == nums[left]) {
            // mid和左边值相等，则左边加一
            return halfSearch(nums, left + 1, right, target);
        } else {
            // mid和右边值相等，则右边减一
            return halfSearch(nums, left, right - 1, target);
        }
    }
}
