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
//        solve31();
//        solve33();
//        solve34();
//        solve35();
//        solve36();
//        solve38();
//        solve39();
//        solve40();
//        solve43();
//        solve46();
//        solve47();
//        solve48();
//        solve49();
        solve50();
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

    private static void solve33() {
        P33SearchInRotatedSortedArray p33 = new P33SearchInRotatedSortedArray();
        int nums[] = {4, 5, 6, 7, 0 ,1, 2};
        System.out.println(p33.search(nums, 0));
        System.out.println(p33.search(nums, 3));
    }

    private static void solve34() {
        P34FindFirstAndLastPosition p34 = new P34FindFirstAndLastPosition();
        int nums[] = {5, 7, 7, 8, 8, 10};
        int[] result = p34.searchRange(nums, 6);
        printNums(result);
    }

    private static void solve35() {
        P35SearchInsertPosition p35 = new P35SearchInsertPosition();
        int[] nums = {3, 5, 7, 9, 10};
        System.out.println(p35.searchInsert(nums, 8));
        System.out.println(p35.searchInsert(nums, 2));
        System.out.println(p35.searchInsert(nums, 7));
        System.out.println(p35.searchInsert(nums, 0));
    }

    private static void solve36() {
        char[][] nums = {{'5','3','.','.','7','.','.','.','.'},
                         {'6','.','.','1','9','5','.','.','.'},
                         {'.','9','8','.','.','.','.','6','.'},
                         {'8','.','.','.','6','.','.','.','3'},
                         {'4','.','.','8','.','3','.','.','1'},
                         {'7','.','.','.','2','.','.','.','6'},
                         {'.','6','.','.','.','.','2','8','.'},
                         {'.','.','.','4','1','9','.','.','5'},
                         {'.','.','.','.','8','.','.','7','9'}};
        P36ValidSudoku p36 = new P36ValidSudoku();
        System.out.println(p36.isValidSudoku(nums));
    }

    private static void solve38() {
        P38CountAndSay p38 = new P38CountAndSay();
        System.out.println(p38.countAndSay(1));
        System.out.println(p38.countAndSay(2));
        System.out.println(p38.countAndSay(3));
        System.out.println(p38.countAndSay(4));
        System.out.println(p38.countAndSay(5));
        System.out.println(p38.countAndSay(6));
    }

    private static void solve39() {
        P39CombinationSum p39 = new P39CombinationSum();
        int[] nums = {2, 3, 6, 7};
        printListList(p39.combinationSum(nums, 7));
    }

    private static void solve40() {
        P40CombinationSum2 p40 = new P40CombinationSum2();
        int[] nums = {1, 1};
        printListList(p40.combinationSum2(nums, 2));
    }

    private static void solve43() {
        P43MultiplyStrings p43MultiplyStrings = new P43MultiplyStrings();
        System.out.println(p43MultiplyStrings.multiply("99", "999"));
    }

    private static void solve46() {
        P46Permutations p46Permutations = new P46Permutations();
        int[] nums = {1, 2, 3};
        printListList(p46Permutations.permute(nums));
    }

    private static void solve47() {
        P47Permutations2 p47Permutations2 = new P47Permutations2();
        int[] nums = {1, 1, 2};
        printListList(p47Permutations2.permuteUnique(nums));
    }

    private static void solve48() {
        P48RotateImage p48RotateImage = new P48RotateImage();
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
                {7, 8, 9}
        };
        p48RotateImage.rotate2(arr);
        printArrays(arr);
    }

    private static void solve49() {
        P49GroupAnagrams p49 = new P49GroupAnagrams();
        String[] strs = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        printListListStr(p49.groupAnagrams(strs));
    }

    private static void solve50() {
        P50Pow p50Pow = new P50Pow();
        System.out.println(p50Pow.myPow(2.00000, Integer.MIN_VALUE));
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

    private static void printListList(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print( i + " ");
            }
            System.out.println();
        }
    }

    private static void printListListStr(List<List<String>> lists) {
        for (List<String> list : lists) {
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    private static void printArrays(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

}

