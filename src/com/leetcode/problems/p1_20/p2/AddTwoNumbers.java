package com.leetcode.problems.p1_20.p2;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Example:
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  Explanation: 342 + 465 = 807
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        l1.next = l11;
        l11.next = l12;

        ListNode l2 = new ListNode(9);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        l2.next = l21;
        l21.next = l22;
        l22.next = l23;

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        print(result);

    }

    private static void print(ListNode listNode) {
        if (listNode != null) {
            StringBuilder sb = new StringBuilder();
            while (listNode.next != null) {
                sb.append(listNode.val).append(" -> ");
                listNode = listNode.next;
            }
            sb.append(listNode.val);
            System.out.println(sb.toString());
        }
    }

}
