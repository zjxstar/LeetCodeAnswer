package com.leetcode.problems.p1_20.p2;

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
        int[] tempResult;
        // 这部分是l1和l2长度相同的部分，两个指针同时前进
        while (!isListEnd(l1) && !isListEnd(l2)) {
            tempResult = getCurrentNodeValue(l1.val, l2.val, carry);
            l1.val = tempResult[0];// 直接在l1上修改
            carry = tempResult[1];
            l1 = l1.next;
            l2 = l2.next;
        }

        // l1和l2相同长度的最后一位
        tempResult = getCurrentNodeValue(l1.val, l2.val, carry);
        l1.val = tempResult[0];
        carry = tempResult[1];

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
            tempResult = getCurrentNodeValue(0, lLast.val, carry);
            lLast.val = tempResult[0];
            carry = tempResult[1];
            lEnd = lLast;
            lLast = lLast.next;
        }

        // 最后一位有进位
        if (carry == 1) {
            lEnd.next = new ListNode(1);
        }

        return result;
    }

    private boolean isZeroOrNull(ListNode listNode) {
        return listNode == null || (listNode.next == null && listNode.val == 0);
    }

    private boolean isListEnd(ListNode listNode) {
        return listNode.next == null;
    }

    private int[] getCurrentNodeValue(int l1Val, int l2Val, int carry) {
        int[] result = new int[2]; // result[0]存放值，result[1]存放进位

        result[0] = l1Val + l2Val + carry;
        if (result[0] >= 10) {
            result[0] -= 10;
            result[1] = 1; // 进位1
        } else {
            result[1] = 0; // 进位复位
        }

        return result;
    }

}
