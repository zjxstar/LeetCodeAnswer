package com.leetcode.problems.p2;

public class Solution {

    /**
     * 思路：同时从头遍历l1和l2；
     * 相加每个节点的值和进位值（进位值默认0），如果大于等于10，则减去10，进位值变成1；
     * 将值存在l1（或者l2)的当前节点；
     * 直到l1或者l2中某一个遍历完，则继续另一个没有遍历完的链表，只是此时节点相加的值中有其中一个值为0；
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // 当l1为空，或者仅有1位且为0，则直接返回l2
        if (isZeroOrNull(l1)) {
            return l2;
        }

        // 当l2为空，或者仅有1位且为0，则直接返回l1
        if (isZeroOrNull(l2)) {
            return l1;
        }

        ListNode result = l1;

        int carry = 0; // 进位，只可能是0或者1
        int curL1Val = 0; // 当前的l1值
        int curL2Val = 0; // 当前的l2值
        int curResultVal = 0; // 当前位的计算结果

        // 这部分是l1和l2长度相同的部分，两个指针同时前进
        while (!isListEnd(l1) && !isListEnd(l2)) {
            curL1Val = l1.val;
            curL2Val = l2.val;
            curResultVal = curL1Val + curL2Val + carry;
            if (curResultVal >= 10) {
                curResultVal = curResultVal - 10;
                carry = 1; // 进位1
            } else {
                carry = 0; // 进位复位
            }
            l1.val = curResultVal; // 直接在l1上修改
            l1 = l1.next;
            l2 = l2.next;
        }

        // l1和l2相同长度的最后一位
        curL1Val = l1.val;
        curL2Val = l2.val;
        curResultVal = curL1Val + curL2Val + carry;
        if (curResultVal >= 10) {
            curResultVal = curResultVal - 10;
            carry = 1; // 进位1
        } else {
            carry = 0; // 进位复位
        }
        l1.val = curResultVal; // 直接在l1上修改

        // l1和l2较长的剩下的值
        ListNode lLast; // 剩下的值
        if (isListEnd(l1)) {
            // 如果是l1到尾了
            lLast = l2.next;
        } else {
            lLast = l1.next;
        }

        l1.next = lLast;

        ListNode lEnd = l1;
        while (lLast != null) {
            curResultVal = lLast.val + carry;
            if (curResultVal >= 10) {
                curResultVal -= 10;
                carry = 1;
            } else {
                carry = 0;
            }
            lLast.val = curResultVal;
            lEnd = lLast;
            lLast = lLast.next;
        }

        // 最后一位有进位
        if (carry == 1) {
            ListNode end = new ListNode(1);
            lEnd.next = end;
        }

        return result;
    }

    private boolean isZeroOrNull(ListNode listNode) {
        return listNode == null || (listNode.next == null && listNode.val == 0);
    }

    private boolean isListEnd(ListNode listNode) {
        return listNode.next == null;
    }

}
