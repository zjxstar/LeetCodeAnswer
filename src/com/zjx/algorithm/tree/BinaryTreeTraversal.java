package com.zjx.algorithm.tree;

/**
 * 二叉树遍历
 */
public class BinaryTreeTraversal {

    /**
     * 先序遍历
     */
    public void preTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preTraversal(root.left);
        preTraversal(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */
    public void midTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        midTraversal(root.left);
        System.out.print(root.value + " ");
        midTraversal(root.right);
    }

    /**
     * 后续遍历
     * @param root
     */
    public void postTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postTraversal(root.left);
        postTraversal(root.right);
        System.out.print(root.value + " ");
    }

}
