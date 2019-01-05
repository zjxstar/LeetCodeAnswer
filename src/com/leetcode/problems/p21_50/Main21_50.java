package com.leetcode.problems.p21_50;

import java.util.List;

/**
 * 所有的都在这里运行
 */
public class Main21_50 {

    public static void main(String[] args) {
//        solveP21();
//        solveP26();
//        solveP27();
//        solve28();
//        solve22();
//        solve24();
//        solve29();
        solve31();
    }

    private static void solveP21() {
        P21MergeTwoSortedLists p21 = new P21MergeTwoSortedLists();
        ListNode result = p21.mergeTwoLists(p21.createList1(), p21.createList2());
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

    private static void solveP26() {
        P26RemoveDuplicatesfromSortedArray p26 = new P26RemoveDuplicatesfromSortedArray();
        int[] nums1 = new int[] {0, 0, 0, 1, 2, 3};
        System.out.println("nums1 的新长度：" + p26.removeDuplicates(nums1));
        System.out.println("----------删除重复元素后的nums1----------");
        for (int num : nums1) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] nums2 = new int[] {0,0,1,1,1,2,2,3,3,4};
        System.out.println("nums2 的新长度：" + p26.removeDuplicates(nums2));
        System.out.println("----------删除重复元素后的nums2----------");
        for (int num : nums2) {
            System.out.print(num + " ");
        }

        System.out.println();
        System.out.println("null 的新长度：" + p26.removeDuplicates(null));
        System.out.println("1个元素的新长度：" + p26.removeDuplicates(new int[] { 1 }));


        int[] nums3 = new int[] { 1, 2, 4, 7 };
        System.out.println("nums3 的新长度：" + p26.removeDuplicates(nums3));
        System.out.println("----------删除重复元素后的nums3----------");
        for (int num : nums3) {
            System.out.print(num + " ");
        }
    }

    private static void solveP27() {
        P27RemoveElement p27RemoveElement = new P27RemoveElement();
        int[] nums1 = new int[] {0,1,2,2,3,0,4,2};
        System.out.println("nums1的新长度：" + p27RemoveElement.removeElement(nums1, 2));
        System.out.println("--------------------删除2后的数组-------------------");
        for (int num : nums1) {
            System.out.print(num + " ");
        }

        System.out.println();

        int[] nums2 = new int[] {0,1,2,2,3,2,4,5,2,7,2,2};
        System.out.println("nums2的新长度：" + p27RemoveElement.removeElement(nums2, 2));
        System.out.println("--------------------删除2后的数组-------------------");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
    }

    private static void solve28() {
        P28Str p28Str = new P28Str();
        System.out.println(p28Str.strStr("hello", "ll"));
        System.out.println(p28Str.strStr("hello", "a"));
        System.out.println(p28Str.strStr("hello", ""));
    }

    private static void solve22() {
        P22GenerateParentheses p22GenerateParentheses = new P22GenerateParentheses();
        List<String> result = p22GenerateParentheses.generateParenthesis(3);
        for (String str : result) {
            System.out.println(str);
        }
    }

    private static void solve24() {
        ListNode head = new ListNode(1);
//        head = null;
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
//        printListNode(head);
        P24SwapNodesInPairs p24SwapNodesInPairs = new P24SwapNodesInPairs();
        ListNode result = p24SwapNodesInPairs.swapPairs(head);
        printListNode(result);
    }

    private static void solve29() {
        P29DivideTwoIntegers p29DivideTwoIntegers = new P29DivideTwoIntegers();
//        System.out.println(p29DivideTwoIntegers.divide2(10, 3));
//        System.out.println(p29DivideTwoIntegers.divide2(7, -3));
        System.out.println(p29DivideTwoIntegers.divide2(-2147483648, 2));
//        System.out.println(p29DivideTwoIntegers.divide2(2147483647, 1));
    }

    private static void solve31() {
        P31NextPermutation p31NextPermutation = new P31NextPermutation();
        int[] nums = new int[] {
            3, 2, 1
        };
        p31NextPermutation.nextPermutation(nums);
        printNums(nums);
    }

    private static void printNums(int[] nums) {
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    private static void printListNode(ListNode head) {
        if (head == null) {
            System.out.println("ListNode is Null");
            return;
        }
        while (head != null) {
            if (head.next == null) {
                System.out.println(head.val);
            } else {
                System.out.print(head.val + " -> ");
            }
            head = head.next;
        }
    }

}

