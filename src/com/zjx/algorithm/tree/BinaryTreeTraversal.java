package com.zjx.algorithm.tree;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 二叉树遍历
 */
public class BinaryTreeTraversal {

    /**
     * 先序遍历：递归实现
     */
    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    /**
     * 先序遍历：非递归实现，需要借助栈
     * 根节点打印，左孩子入栈，直到到达最左孩子
     * 栈顶元素出栈，如果
     * @param root
     */
    public void preOrder(TreeNode root) {
        if (root == null) // 空树
            return;
        // 定义工作指针和管理栈
        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();

        // 只有当栈不空或者节点不空时才循环处理
        while (!stack.isEmpty() || curNode != null) {
            // 将该节点的左子树入栈，直到最左节点
            while (curNode != null) {
                System.out.print(curNode.value + " "); // 先序遍历，先打印根节点
                stack.push(curNode);
                curNode = curNode.left; // 左孩子
            }

            // 此时已经到最左节点了，需要出栈走右子树了
            // 如果右孩子为null的话，会在下次循环中直接跳过其左孩子入栈的步骤
            // 从而继续出栈，走下一个根节点的右子树
            if (!stack.isEmpty()) {
                curNode = stack.pop(); // 取栈顶
                curNode = curNode.right; // 右孩子
            }
        }

    }

    /**
     * 中序遍历：递归实现
     * @param root
     */
    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    /**
     * 中序遍历：非递归
     * 和先序遍历类似
     * @param root
     */
    public void inOrder(TreeNode root) {
        if (root == null) // 空树
            return;
        // 定义工作指针和管理栈
        TreeNode curNode = root;
        Stack<TreeNode> stack = new Stack<>();

        // 只有当栈不空或者节点不空时才循环处理
        while (!stack.isEmpty() || curNode != null) {
            // 将该节点的左子树入栈，直到最左节点
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left; // 左孩子
            }

            // 此时已经到最左节点了，需要出栈走右子树了
            // 如果右孩子为null的话，会在下次循环中直接跳过其左孩子入栈的步骤
            // 从而继续出栈，走下一个根节点的右子树
            if (!stack.isEmpty()) {
                curNode = stack.pop(); // 取栈顶
                // 中序遍历，先打左孩子，再打印根
                System.out.print(curNode.value + " ");
                curNode = curNode.right; // 右孩子
            }
        }
    }

    /**
     * 后序遍历：递归实现
     * @param root
     */
    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.value + " ");
    }

    /**
     * 后序遍历：非递归
     * @param root
     */
    public void postOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode curNode = root;
        TreeNode lastNode = null;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || curNode != null) {
            while (curNode != null) { // 左子树入栈，到达最左
                stack.push(curNode);
                curNode = curNode.left;
            }

            if (!stack.isEmpty()) {
                curNode = stack.pop();
                // 只有出栈节点的右子树为null，或者右节点被访问过，才能打印
                if (curNode.right == null || curNode.right == lastNode) {
                    System.out.print(curNode.value + " ");
                    lastNode = curNode;
                    curNode = null; // 一定要置空，让下次循环是从栈里取
                } else { // 否则的话，该节点回到栈里，并且开始处理其右子树
                    stack.push(curNode);
                    curNode = curNode.right;
                }
            }
        }
    }

    /**
     * 二叉树的层次遍历
     * @param root
     */
    public void levelOrder(TreeNode root) {
        if (root == null)
            return;
        TreeNode curNode  = root; // 工作指针
        Queue<TreeNode> queue = new LinkedList<>(); // 工作队列

        queue.offer(curNode); // 根节点进队列

        while (!queue.isEmpty()) {
            curNode = queue.poll(); // 对头取节点
            System.out.print(curNode.value + " "); // 打印

            if (curNode.left != null)
                queue.offer(curNode.left); // 左孩子存在的话进队列

            if (curNode.right != null)
                queue.offer(curNode.right); // 右孩子存在的话进队列
        }

    }

    /**
     * 二叉树的Z字形层次遍历
     * @param root
     */
    public void levelZOrder(TreeNode root) {
        if (root == null) {
            return; // 空树
        }
        TreeNode curNode = root; // 工作指针
        LinkedList<TreeNode> queue = new LinkedList<>(); // 工作队列
        int depth = 0; // 深度

        queue.offer(curNode); // 队列早期只有一个根节点

        while (!queue.isEmpty()) {
            int size = queue.size(); // 某一层的节点数
            for (int i = 0; i < size; i++) {
                if (depth % 2 == 1) {
                    // 从左到右
                    curNode = queue.pollLast(); // 从队列尾部取
                    System.out.print(curNode.value + " ");
                    // 因为是从尾部取，所以插到前面
                    if (curNode.right != null) { // 因为是头插，所以先判断右孩子
                        queue.offerFirst(curNode.right);
                    }
                    if (curNode.left != null) {
                        queue.offerFirst(curNode.left);
                    }

                } else {
                    curNode = queue.poll(); // 从队列头取
                    System.out.print(curNode.value + " ");
                    if (curNode.left != null) {
                        queue.offer(curNode.left);
                    }
                    if (curNode.right != null) {
                        queue.offer(curNode.right);
                    }
                }
            }
            depth++;
        }

    }

}
