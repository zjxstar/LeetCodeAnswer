package com.leetcode.problems.p81_110;

import java.util.List;

public class Main81_110 {

    public static void main(String[] args) {
        solveP81();
//        solveP94();
//        solveP101();
    }

    private static void solveP81() {
        P81Search p81 = new P81Search();
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(p81.search(nums, 0));
        System.out.println(p81.search(nums, 3));
    }

    private static void solveP94() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        P94BinaryInOrderTraversal p94 = new P94BinaryInOrderTraversal();
        List<Integer> result = p94.inorderTraversal(root);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    private static void solveP101() {
        P101BinaryLevelOrderTraversal p101 = new P101BinaryLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = p101.levelOrder(root);
        for (List<Integer> list : result) {
            for (Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

}
