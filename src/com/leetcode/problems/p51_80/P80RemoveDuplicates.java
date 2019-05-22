package com.leetcode.problems.p51_80;

/**
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 示例 1:
 *
 * 给定 nums = [1,1,1,2,2,3],
 *
 * 函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,0,1,1,1,1,2,3,3],
 *
 * 函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class P80RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length <= 2) {
            return nums.length;
        }

        int i = 0;
        int j = 1;

        while (j < nums.length) {
            if (nums[i] == nums[j]) { // 如果相等，则j往前移动，直到不等为止
                i++; // 因为i永远在j的后面，所以不用担心i溢出
                nums[i] = nums[j]; // 直接复制
                j++;
                while (j < nums.length && nums[i] == nums[j]) { // 找到下一个不相等的数
                    j++;
                }
            } else {
                i++; // 因为i永远在j的后面，所以不用担心i溢出
                nums[i] = nums[j];
                j++;
            }
        }

        return i + 1; // i从0开始
    }

}
