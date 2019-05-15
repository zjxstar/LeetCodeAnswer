package com.leetcode.problems.p51_80;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class P78Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        if (n == 0) {
            return result;
        }
        for (int k = 1; k <= n; k++) {
            List<Integer> list = new ArrayList<>();
            // 回溯
            backtrace(result, list, 0, nums, 1, n, k);
        }

        result.add(new ArrayList<>());

        return result;
    }

    public void backtrace(List<List<Integer>> result, List<Integer> list,
                          int curIndex, int[] nums, int curK, int n, int k) {
        for (int i = curIndex; i < n; i++) {
            list.add(nums[i]);
            if (curK == k) {
                result.add(createNewTrace(list));
            } else {
                curIndex = curIndex + 1;
                backtrace(result, list, curIndex, nums, curK + 1, n, k);
            }
            list.remove(list.size() - 1);
        }
    }

    private List<Integer> createNewTrace(List<Integer> oldTrace) {
        List<Integer> newTrace = new ArrayList<>();
        newTrace.addAll(oldTrace);
        return newTrace;
    }

}
