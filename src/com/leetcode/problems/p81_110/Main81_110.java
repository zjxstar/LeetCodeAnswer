package com.leetcode.problems.p81_110;

import java.util.List;

public class Main81_110 {

    public static void main(String[] args) {
        solveP94();
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

}
