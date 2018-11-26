package com.leetcode.problems.p21_50;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class P26RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int len = nums.length;
        int i = 0; // 工作指针
        int j = 1; // 工作指针
        int newLen = 0; // 新长度，从0开始

        while(i < len && j < len) {
            if (i < j) {
                if (nums[i] == nums[j]) {
                    j++; // 相同元素，前面的指针前进
                } else {
                    newLen++;
                    if (newLen != j) { // 不同元素的位置和新长度的尾位置不同时需赋值
                        nums[newLen] = nums[j];
                    }
                    i = j + 1; // 后面的指针直接跳到前面
                }
            }
            if (i < len && j < len & i > j) { // 这里要加入小于len的判读
                if (nums[i] == nums[j]) {
                    i++;
                } else {
                    newLen++;
                    if (newLen != i) {
                        nums[newLen] = nums[i];
                    }
                    j = i + 1;
                }
            }
        }
        return newLen + 1;
    }

}
