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
//        solve62();
//        solve63();
//        solve59();
//        solve60();
//        solve61();
//        solve66();
//        solve67();
//        solve69();
//        solve70();
//        solve71();
//        solve73();
//        solve74();
        solve75();
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

    private static void solve63() {
        P63UniquePaths2 p63UniquePaths2 = new P63UniquePaths2();
        int[][] grid = {{0,0,0}, {0, 1, 0}, {0,0,0}};
        System.out.println(p63UniquePaths2.uniquePathsWithObstacles(grid));
    }

    private static void solve59() {
        P59SpiralMatrix2 p59SpiralMatrix2 = new P59SpiralMatrix2();
        int[][] result = p59SpiralMatrix2.generateMatrix(4);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve60() {
        P60TheKthPermutation p60 = new P60TheKthPermutation();
        System.out.println(p60.getPermutation(4, 9));
    }

    private static void solve61() {
        P61RotateRight p61 = new P61RotateRight();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode newHead = p61.rotateRight(head, 4);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }

    private static void solve66() {
        P66PlusOne p66 = new P66PlusOne();
        int[] digits = {9, 9, 9};
        int[] result = p66.plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    private static void solve67() {
        P67AddBinary p67 = new P67AddBinary();
        System.out.println(p67.addBinary("11", "1"));
    }

    private static void solve69() {
        P69MySqrt p69 = new P69MySqrt();
        System.out.println(p69.mySqrt2(2));
    }

    private static void solve70() {
        P70ClimbStairs p70 = new P70ClimbStairs();
        System.out.println(p70.climbStairs(44));
    }

    private static void solve71() {
        P71SimplifyPath p71 = new P71SimplifyPath();
        System.out.println(p71.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(p71.simplifyPath("/home/"));
        System.out.println(p71.simplifyPath("/../"));
        System.out.println(p71.simplifyPath("/home//foo/"));
        System.out.println(p71.simplifyPath("/a/./b/../../c/"));
        System.out.println(p71.simplifyPath("/a//b////c/d//././/.."));
    }

    private static void solve73() {
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        P73SetZeros p73 = new P73SetZeros();
        p73.setZeroes2(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void solve74() {
        P74SearchMatrix p74 = new P74SearchMatrix();
//        int[][] matrix = {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}};
        int[][] matrix = {};
        System.out.println(p74.searchMatrix(matrix, 0));
    }

    private static void solve75() {
        P75SortColors p75 = new P75SortColors();
        int nums[] = {2,0,2,1,1,0};
        p75.sortColors2(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
