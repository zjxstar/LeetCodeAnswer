package com.leetcode.problems.p51_80;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 示例 1:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * 输出: false
 */
public class P74SearchMatrix {

    /**
     * 还有种浪费空间的做法，就是把二维数组转成一维数组，然后直接二分查找
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0 ) {
            return false;
        }
        int n = matrix[0].length;
        if (n == 0 ) {
            return false;
        }

        int searchRow = -1; // 使用二分查找的行
        for (int i = 0; i < m; i++) {
            // 和每行的最后一个数比较，可以确定可能所在的行
            if (target <= matrix[i][n - 1]) {
                searchRow = i;
                break;
            }
        }

        if (searchRow == -1) {
            return false;
        }

        // 确定了所在行，剩下的就用二分查找
        return halfSearch(matrix[searchRow], target);

    }

    private boolean halfSearch(int[] nums, int target) {
        return halfInternal(nums, target, 0, nums.length - 1);
    }

    private boolean halfInternal(int[] nums, int target, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left + right) >> 1;
        if (nums[mid] == target) {
            return true;
        } else if (nums[mid] > target) {
            return halfInternal(nums, target, left, mid - 1);
        } else {
            return halfInternal(nums, target, mid + 1, right);
        }
    }

}
