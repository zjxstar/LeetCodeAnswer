package com.leetcode.problems.p1_20.p18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 与三数之和解法类似
 * 排序
 * 这里固定两个值，其他两个值变化
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        // 排序
        Arrays.sort(nums);
        int len = nums.length;
        int lastTarget;
        int sum;
        for (int p = 0; p < len - 3; p++) {
            for (int q = p + 1; q < len - 2; q++) {
                lastTarget = target - nums[p] - nums[q];
                int i = q + 1;
                int j = len - 1;
                while (i < j) {
                    sum = nums[i] + nums[j];
                    if (sum == lastTarget) {
                        List<Integer> item = new ArrayList<>();
                        item.add(nums[p]);
                        item.add(nums[q]);
                        item.add(nums[i]);
                        item.add(nums[j]);
                        result.add(item);
                        i++;  // 相等时也要注意移动重复数据
                        while (nums[i] == nums[i-1] && i < j) {
                            i++;
                        }
                    }
                    if (sum < lastTarget) {
                        i++;
                        while (nums[i] == nums[i-1] && i < j) {
                            i++;
                        }
                    }
                    if (sum > lastTarget) {
                        j--;
                    }
                }
                // 第二个数避免重复
                while (nums[q] == nums[q+1] && q < len - 2) {
                    q++;
                }
            }
            // 第一个数避免重复
            while (nums[p] == nums[p+1] && p < len - 3) {
                p++;
            }
        }

        return result;
    }

}
