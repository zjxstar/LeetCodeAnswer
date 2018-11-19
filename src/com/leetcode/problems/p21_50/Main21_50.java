package com.leetcode.problems.p21_50;

/**
 * 所有的都在这里运行
 */
public class Main21_50 {

    public static void main(String[] args) {
        solveP21();
    }

    private static void solveP21() {
        P21MergeTwoSortedLists p21 = new P21MergeTwoSortedLists();
        P21MergeTwoSortedLists.ListNode result = p21.mergeTwoLists(p21.createList1(), p21.createList2());
//        P21MergeTwoSortedLists.ListNode result = p21.mergeTwoLists(null, p21.createList2());
//        P21MergeTwoSortedLists.ListNode result = p21.mergeTwoLists(p21.createList1(), null);

        if (result == null) {
            System.out.println("null");
            return;
        }

        while (result != null) {
            if (result.next == null) {
                System.out.println(result.val);
            } else {
                System.out.print(result.val + " -> ");
            }
            result = result.next;
        }
    }

}

