package com.leetcode.problems.p1_20.p19;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode((2));
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        Solution solution = new Solution();
        ListNode result = solution.removeNthFromEnd(head, 2);

        while (result != null) {
            if (result.next != null) {
                System.out.print(result.val + "->");
            } else {
                System.out.println(result.val);
            }

            result = result.next;
        }
    }

}
