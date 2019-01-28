package com.leetcode.problems.p21_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P47Permutations2 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> trace = new ArrayList<>();
        List<Integer> traceIndex = new ArrayList<>();
        backtrace(nums, result, trace, traceIndex, 1, nums.length);

        return result;
    }

    private void backtrace(int[] nums, List<List<Integer>> result, List<Integer> trace,
                           List<Integer> traceIndex, int curHeight, int maxheight) {
        for (int i = 0; i < nums.length; i++) {
            if (isInTraceIndex(traceIndex, i)) {
                continue;
            }
            trace.add(nums[i]);
            traceIndex.add(i);
            if (curHeight == maxheight) {
                result.add(createNewTrace(trace));
            } else {
                backtrace(nums, result, trace, traceIndex, curHeight + 1, maxheight);
            }
            trace.remove(trace.size() - 1); // 把最后加入的路径去掉
            traceIndex.remove(traceIndex.size() - 1); // 把最后加入的路径去掉
            // 把重复的过滤
            while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }

    private boolean isInTraceIndex(List<Integer> traceIndex, int target) {
        if (traceIndex == null || traceIndex.isEmpty()) {
            return false;
        }

        return traceIndex.contains(target);
    }

    private List<Integer> createNewTrace(List<Integer> oldTrace) {
        List<Integer> newTrace = new ArrayList<>();
        newTrace.addAll(oldTrace);
        return newTrace;
    }

}
