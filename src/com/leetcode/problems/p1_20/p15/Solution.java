package com.leetcode.problems.p1_20.p15;

import java.util.*;

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }

        Map<Integer, Integer> numCountMap = new HashMap<>(); // 记录每个数的个数
        Set<Integer> negativeSet = new HashSet<>(); // 负数集合，不重复
        Set<Integer> positiveSet = new HashSet<>(); // 正数集合，不重复
        List<Integer> zeroList = new ArrayList<>(); // 零集合

        for (Integer num : nums) {
            if (num == 0) {
                zeroList.add(num);
            } else if (num < 0) {
                negativeSet.add(num);
            } else {
                positiveSet.add(num);
            }
            if (numCountMap.containsKey(num)) {
                numCountMap.put(num, numCountMap.get(num) + 1);
            } else {
                numCountMap.put(num, 1);
            }
        }

        // 三个0的情况
        if (zeroList.size() >= 3) {
            List<Integer> zeroTriple = new ArrayList<>();
            zeroTriple.add(0);
            zeroTriple.add(0);
            zeroTriple.add(0);
            result.add(zeroTriple);
        }

        // 一个0，一个正数，一个负数的情况，不可能有2个0的组合
        if (zeroList.size() >= 1) {
            for (Integer negative : negativeSet) {
                if (numCountMap.containsKey(-negative)) {
                    List<Integer> triple = new ArrayList<>();
                    triple.add(negative);
                    triple.add(0);
                    triple.add(-negative);
                    result.add(triple);
                }
            }
        }

        // 单个负数有多余1个的情况
        handleMoreOne(result, negativeSet, numCountMap);

        // 单个正数有多余1个的情况
        handleMoreOne(result, positiveSet, numCountMap);

        // 两个负数，一个正数的情况
        handleTwoOne(result, negativeSet, numCountMap);

        // 两个正数，一个负数的情况
        handleTwoOne(result, positiveSet, numCountMap);

        return result;
    }

    /**
     * 相同的负数+一个正数
     * 相同的正数+一个负数
     *
     * 处理方法：
     * 从map中可以判断一个数是否有重复
     * 不管重复多少个，只要一对即可
     * 而且对应的数可以直接从map中获取
     */
    private void handleMoreOne(List<List<Integer>> result, Set<Integer> sets, Map<Integer, Integer> map) {
        for (Integer num : sets) {
            if (map.get(num) >= 2) {
                int plus = num + num;
                if (map.containsKey(-plus)) {
                    List<Integer> triple = new ArrayList<>();
                    triple.add(num);
                    triple.add(num);
                    triple.add(-plus);
                    result.add(triple);
                }
            }
        }
    }

    /**
     * 两个不同的负数+一个正数
     * 两个不同的正数+一个负数
     *
     * 处理方法：
     * 循环取两个不同的数
     */
    private void handleTwoOne(List<List<Integer>> result, Set<Integer> sets, Map<Integer, Integer> map) {
        Object[] nums = sets.toArray();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int numi = (int) nums[i];
                int numj = (int) nums[j];
                int plus = numi + numj;
                if (map.containsKey(-plus)) {
                    List<Integer> triple = new ArrayList<>();
                    triple.add(numi);
                    triple.add(numj);
                    triple.add(-plus);
                    result.add(triple);
                }
            }
        }
    }

}
