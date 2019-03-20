package com.leetcode.problems.p81_110;

import java.util.ArrayList;
import java.util.List;

public class P94BinaryInOrderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        inorder(result, root);

        return result;
    }

    private void inorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(list, root.left);
        list.add(root.val);
        inorder(list, root.right);
    }

}
