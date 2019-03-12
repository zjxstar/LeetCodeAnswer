package com.leetcode.problems.p51_80;


import java.util.ArrayList;
import java.util.List;

public class Main51_80 {

    public static void main(String[] args) {
//        solve53();
//        solve54();
//        solve55();
//        solve56();
//        solve58();
        solve62();
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

    private static void solve56() {
        P56MergeIntervals p56MergeIntervals = new P56MergeIntervals();
        List<Interval> list = new ArrayList<>();
//        list.add(new Interval(1,3));
//        list.add(new Interval(8,10));
//        list.add(new Interval(15,18));
//        list.add(new Interval(2,6));

        list.add(new Interval(1, 4));
        list.add(new Interval(2, 3));

        List<Interval> result = p56MergeIntervals.merge(list);
        for (Interval interval : result) {
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        }
    }

    private static void solve58() {
        P58LastWordLength p58LastWordLength = new P58LastWordLength();
        System.out.println(p58LastWordLength.lengthOfLastWord("Hello World"));
        System.out.println(p58LastWordLength.lengthOfLastWord(""));
        System.out.println(p58LastWordLength.lengthOfLastWord(" "));
        System.out.println(p58LastWordLength.lengthOfLastWord("aaa "));
        System.out.println(p58LastWordLength.lengthOfLastWord("   aaa "));
    }

    private static void solve62() {
        P62UniquePaths p62UniquePaths = new P62UniquePaths();
        System.out.println(p62UniquePaths.uniquePaths(3, 2));
        System.out.println(p62UniquePaths.uniquePaths(7, 3));
    }

}
