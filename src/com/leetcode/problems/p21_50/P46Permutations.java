package com.leetcode.problems.p21_50;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class P46Permutations {

    /**
     * 回溯法
     * 没下一层都要去除已经在路径中的数
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        List<Integer> trace = new ArrayList<>();
        backtrace(nums, result, trace, 1, nums.length);

        return result;
    }

    private void backtrace(int[] nums, List<List<Integer>> result, List<Integer> trace, int curHeight, int maxheight) {
        for (int i = 0; i < nums.length; i++) {
            if (isInTrace(trace, nums[i])) {
                continue;
            }
            trace.add(nums[i]);
            if (curHeight == maxheight) {
                result.add(createNewTrace(trace));
            } else {
                backtrace(nums, result, trace, curHeight + 1, maxheight);
            }
            trace.remove(trace.size() - 1); // 把最后加入的路径去掉
        }
    }

    private boolean isInTrace(List<Integer> trace, int target) {
        if (trace == null || trace.isEmpty()) {
            return false;
        }

        return trace.contains(target);
    }

    private List<Integer> createNewTrace(List<Integer> oldTrace) {
        List<Integer> newTrace = new ArrayList<>();
        newTrace.addAll(oldTrace);
        return newTrace;
    }

}
