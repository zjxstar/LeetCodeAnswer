package com.leetcode.problems.p21_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用一次。
 *
 * 说明：
 *
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 *
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class P40CombinationSum2 {

    /**
     * 回溯法，注意去除重复数据
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        // 排序，升序
        Arrays.sort(candidates);
        // 如果第一个数就比target大，则直接结束
        if (candidates[0] > target) {
            return result;
        }

        // 计算最大树高
        int maxHeight = 1;
        int sum = 0;
        for (int i = 0; i < candidates.length; i++) {
            sum += candidates[i];
            if (sum > target) {
                // 因为下标是从0开始，而此时sum大于target，所以直接赋值i
                maxHeight = i;
                break;
            } else if (sum == target) {
                maxHeight = i + 1;
                break;
            }
        }

        // 处理每个高度
        for (int height = 1; height <= maxHeight; height++) {
            List<Integer> trace = new ArrayList<>();
            backtrace(candidates, target, result, trace, 0, 0, 1, height);
        }

        return result;
    }

    private void backtrace(int[] candidates, int target, List<List<Integer>> result, List<Integer> trace,
                           int curSum, int curIndex, int curHeight, int maxHeight) {
        for (int i = curIndex; i < candidates.length; i++) {
            int newCurSum = curSum + candidates[i]; // 计算和
            if (newCurSum > target) {
                break;
            }
            trace.add(candidates[i]); // 添加路径
            if (curHeight == maxHeight) {
                if (newCurSum == target) {
                    result.add(createNewTrace(trace));
                }
            } else {
                backtrace(candidates, target, result, trace, newCurSum, i + 1,curHeight + 1, maxHeight);
            }
            trace.remove(trace.size() - 1); // 把最后加入的路径去掉
            // 把重复的过滤
            while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
                i++;
            }
        }
    }

    private List<Integer> createNewTrace(List<Integer> oldTrace) {
        List<Integer> newTrace = new ArrayList<>();
        newTrace.addAll(oldTrace);
        return newTrace;
    }

}
