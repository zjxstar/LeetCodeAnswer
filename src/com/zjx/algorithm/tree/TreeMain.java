package com.zjx.algorithm.tree;

public class TreeMain {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        System.out.println("先序遍历：递归");
        binaryTreeTraversal.preOrderTraversal(root);
        System.out.println();
        System.out.println("先序遍历：非递归");
        binaryTreeTraversal.preOrder(root);
        System.out.println();
        System.out.println("中序遍历：递归");
        binaryTreeTraversal.inOrderTraversal(root);
        System.out.println();
        System.out.println("中序遍历：非递归");
        binaryTreeTraversal.inOrder(root);
        System.out.println();
        System.out.println("后序遍历：递归");
        binaryTreeTraversal.postOrderTraversal(root);
        System.out.println();
        System.out.println("后序遍历：非递归");
        binaryTreeTraversal.postOrder(root);
        System.out.println();
        System.out.println("层次遍历：");
        binaryTreeTraversal.levelOrder(root);
        System.out.println();
        System.out.println("Z字型层次遍历：");
        binaryTreeTraversal.levelZOrder(root);
    }

}
