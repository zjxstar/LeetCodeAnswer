package com.leetcode.problems.p1;

public class Solution {

    /**
     * violent solution
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length <= 1) {
            return null;
        }

        if (nums.length == 2) {
            if ((nums[0] + nums[1]) == target) {
                return new int[] {0, 1};
            }
        }

        int[] result = new int[2]; // one solution
        int temp;
        boolean flag = false; // quick end
        for(int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                temp = nums[i] + nums[j];
                if (temp == target) {
                    result[0] = i;
                    result[1] = j;
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        return result;
    }
}
