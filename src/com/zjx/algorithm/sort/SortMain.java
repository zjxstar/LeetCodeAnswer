package com.zjx.algorithm.sort;

public class SortMain {

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {0,4,9,12,2,3,8,37};
        quickSort.quickSort3(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
