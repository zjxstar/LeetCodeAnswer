package com.leetcode.problems.p21_50;

/**
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * 说明:
 *
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class P24SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head;
        ListNode q = head.next;
        ListNode newHead = p;
        ListNode t = newHead;
        int count = 0;
        while(q != null) {
            if (count % 2 == 0) {
                p.next = q.next;
                q.next = p;
                if (count == 0) {
                    newHead = q;
                } else {
                    t.next = q;
                }
                t = p;
                q = p.next; // 因为p、q已经换过位置了，要保证工作指针q在p的前面一位
            } else {
                p = p.next;
                q = q.next;
            }
            count++;

        }
        return newHead;
    }

}
