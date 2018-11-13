package com.leetcode.problems.p15;

import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result1 = solution.threeSum(new int[] {
           -1, 0, 0, 0, 1, 2, -1, -4, 2
        });
        List<List<Integer>> result2 = solution.threeSum(new int[] {

        });
        print(result1);
        print(result2);
    }

    private static void print(List<List<Integer>> lists) {
        if (lists == null || lists.size() == 0) {
            return;
        }

        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
