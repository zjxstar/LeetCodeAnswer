package com.leetcode.problems.p1_20.p18;

import java.util.List;

public class FourSum {

    public static void main(String[] args) {

        Solution solution = new Solution();
        List<List<Integer>> result = solution.fourSum(new int[] {-3,-2,-1,0,0,1,2,3},
        0);
        for (List<Integer> list : result) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

    }

}
