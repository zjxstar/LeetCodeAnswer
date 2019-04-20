package com.zjx.algorithm.link;

public class LinkProblem {

    /**
     * 逆转单链表
     * @param node
     * @return
     */
    public LinkNode reversedList(LinkNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        LinkNode p = null; // 工作指针，记录已经完成的部分
        LinkNode t = null; // 暂存指针，记录每次分离的节点
        LinkNode q = node; // 工作指针，记录剩余的部分

        while (q.next != null) {
            t = q;
            q = q.next;
            t.next = p;
            p = t;
        }

        q.next = t; // 最后一个节点单独处理

        return q;
    }

    /**
     * 递归处理
     * @param node
     * @return
     */
    public LinkNode reversedList2(LinkNode node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            LinkNode headNode = reversedList2(node.next); // 找到最后一个节点，作为头
            node.next.next = node; // 从后往前，node.next指向的是headNode，相当于headNode.next = node
            node.next = null;
            return headNode;
        }
    }

}
