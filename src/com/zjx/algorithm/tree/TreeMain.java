package com.zjx.algorithm.tree;

public class TreeMain {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        System.out.println("先序遍历：");
        binaryTreeTraversal.preTraversal(root);
        System.out.println();
        System.out.println("中序遍历：");
        binaryTreeTraversal.midTraversal(root);
        System.out.println();
        System.out.println("后序遍历：");
        binaryTreeTraversal.postTraversal(root);
    }

}
