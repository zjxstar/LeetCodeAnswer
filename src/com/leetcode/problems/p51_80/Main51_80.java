package com.leetcode.problems.p51_80;

public class Main51_80 {

    public static void main(String[] args) {
        solve53();
    }

    private static void solve53() {
        P53MaximumSubarray p53MaximumSubarray = new P53MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(p53MaximumSubarray.maxSubArray2(nums));
    }

}
