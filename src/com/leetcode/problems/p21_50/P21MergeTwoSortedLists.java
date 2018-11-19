package com.leetcode.problems.p21_50;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class P21MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2; // l1空直接返回l2

        if (l2 == null)
            return l1; // l2空直接返回l1

        ListNode p = l1; // l1的工作指针
        ListNode q = l2; // l2的工作指针
        ListNode t; // 结果链表的工作指针
        if (p.val <= q.val) {
            t = p;
            p = p.next;
        } else {
            t = q;
            q = q.next;
        }
        ListNode result = t; // 结果链表

        while(p != null && q != null) {
            if (p.val <= q.val) {
                // l1的值小于等于l2，添加l1的结点
                t.next = p;
                p = p.next;
            } else { // 添加l2的结点
                t.next = q;
                q = q.next;
            }
            t = t.next;
        }

        // 处理剩余链表
        if (p == null)
            t.next = q;

        if (q == null) {
            t.next = p;
        }

        return result;
    }

    public ListNode createList1() {
        ListNode list = new ListNode(2);
        list.next = new ListNode(2);
        list.next.next = new ListNode(4);
        list.next.next.next = new ListNode(9);
        return list;
    }

    public ListNode createList2() {
        ListNode list = new ListNode(3);
        list.next = new ListNode(3);
        list.next.next = new ListNode(4);
//        list.next.next.next = new ListNode(7);
        return list;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

