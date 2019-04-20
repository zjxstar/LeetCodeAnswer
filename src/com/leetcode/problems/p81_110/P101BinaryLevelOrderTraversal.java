package com.leetcode.problems.p81_110;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class P101BinaryLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result; // 空树
        }

        TreeNode curNode = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(curNode);

        while (!queue.isEmpty()) {
            int size = queue.size(); // 当前队列中的节点数
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                curNode = queue.poll(); // 取出
                level.add(curNode.val);
                if (curNode.left != null) { // 左孩子进队
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) { // 右孩子进队
                    queue.offer(curNode.right);
                }
            }
            result.add(level);
        }

        return result;
    }

}
