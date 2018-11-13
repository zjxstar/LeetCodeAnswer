package com.leetcode.problems.p15;

import java.util.List;

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
