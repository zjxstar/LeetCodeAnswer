package com.leetcode.problems.p51_80;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class P61RotateRight {

    public ListNode rotateRight(ListNode head, int k) {

        // 空链表和一个节点链表直接返回
        if (head == null || head.next == null) {
            return head;
        }

        if (k == 0 ) {
            return head;
        }

        ListNode p = head; // 工作指针，慢指针
        ListNode q = head; // 工作指针，快指针

        int len = 1; // 链表长度至少为1
        // 一遍移动快指针，一遍统计链表长度，主要是判断k是否大于len
        boolean flag = false; // k是否大于len

        while (len <= k) {
            q = q.next;
            if (q == null) {
                // 已经到链表尾了
                flag = true;
                break;
            } else {
                len++;
            }
        }

        if (flag) {
            // 如果是因为到链表尾而结束的，要重新计算k
            k = k % len;
            if (k == 0) {
                // 说明移动k步后又变成了原来的链表
                return head;
            }

            // 否则重新走快指针
            q = head; // 复位
            int i = 1;
            while (i <= k) {
                q = q.next;
                i++;
            }
        }

        // 同时走快慢指针
        while (q.next != null) {
            q = q.next;
            p = p.next;
        }

        // 这个时候q已经到最后一个节点了
        ListNode newHead = p.next; // 新头节点
        p.next = null; // 新尾节点
        q.next = head; // 完成移动

        return newHead; // 返回新头

    }

}
