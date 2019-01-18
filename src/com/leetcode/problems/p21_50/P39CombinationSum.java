package com.leetcode.problems.p21_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class P39CombinationSum {

    /**
     * 回溯法，树的最大高度为 target / 排序后的第一个数
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        // 排序，升序
        Arrays.sort(candidates);
        // 计算树高
        int maxHeight = target / candidates[0];
        // 处理每个高度
        for (int height = 1; height <= maxHeight; height++) {
            List<Integer> trace = new ArrayList<>();
            backtrace(candidates, target, result, trace, 0, 0, 1, height);
        }

        return result;
    }

    private void backtrace(int[] candidates, int target, List<List<Integer>> result, List<Integer> trace, int curSum,
                           int curIndex, int curHeight, int maxHeight) {
        for (int i = curIndex; i < candidates.length; i++) {
            int newCurSum = curSum + candidates[i]; // 计算和
            if (newCurSum > target) { // 如果和已经大于目标，直接进入下个循环
                break;
            }
            trace.add(candidates[i]); // 添加路径
            if (curHeight == maxHeight) {
                // 到达指定树高了，开始比较target
                if (newCurSum == target) {
                    // 一定要重新赋值个List
                    result.add(createNewTrace(trace));
                }
            } else {
                // 继续往下走
                backtrace(candidates, target, result, trace, newCurSum, i, curHeight + 1, maxHeight);
            }
            trace.remove(trace.size() - 1); // 把最后加入的路径去掉
        }
    }

    private List<Integer> createNewTrace(List<Integer> oldTrace) {
        List<Integer> newTrace = new ArrayList<>();
        newTrace.addAll(oldTrace);
        return newTrace;
    }

}
