package com.leetcode.problems.p51_80;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 */
public class P77Combine {

    /**
     * 回溯
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (k ==0 || k > n) {
            return result;
        }

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) { // 初始化原始数组
            nums[i] = i + 1;
        }

        List<Integer> list = new ArrayList<>();
        // 回溯
        backtrace(result, list, 0, nums, 1, n, k);

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
