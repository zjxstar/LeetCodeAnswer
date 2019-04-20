package com.zjx.algorithm.sort;

public class SortMain {

    public static void main(String[] args) {
        int[] nums = {0,4,9,12,2,3,8,37};
//        QuickSort quickSort = new QuickSort();
//        quickSort.quickSort3(nums, 0, nums.length - 1);

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
