package com.leetcode.problems.p51_80;


import java.util.List;

public class Main51_80 {

    public static void main(String[] args) {
//        solve53();
//        solve54();
        solve55();
    }

    private static void solve53() {
        P53MaximumSubarray p53MaximumSubarray = new P53MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(p53MaximumSubarray.maxSubArray2(nums));
    }

    private static void solve54() {
        P54SpiralMatrix p54SpiralMatrix = new P54SpiralMatrix();
        int[][] matrix = {{1,2,3,4},{5,6,7,8}};
        List<Integer> list = p54SpiralMatrix.spiralOrder(matrix);
        for (int num : list) {
            System.out.print(num + " ");
        }
    }

    private static void solve55() {
        P55JumpGame p55JumpGame = new P55JumpGame();
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        System.out.println(p55JumpGame.canJump2(nums));
    }

}
