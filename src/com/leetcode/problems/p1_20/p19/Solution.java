package com.leetcode.problems.p1_20.p19;

public class Solution {

    /**
     * 快慢指针
     * 快指针先走N步，然后快慢一起走，当快指针到头时，慢指针指向的下一个结点就是要删除的结点
     * 注意n等于链表长度的时候，快指针已经为null了，则直接返回head的下一结点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n < 1) {
            return head;
        }

        ListNode q = head;
        ListNode p = head;
        int i = 1;
        while (i <= n && q != null) {
            q = q.next;
            i++;
        }

        if (q == null) {
            return head.next;
        }

        while (q != null && q.next != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;

        return head;
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}