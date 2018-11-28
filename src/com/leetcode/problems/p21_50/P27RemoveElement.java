package com.leetcode.problems.p21_50;

/**
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 1:
 *
 * 给定 nums = [3,2,2,3], val = 3,
 *
 * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 *
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 *
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 *
 * 注意这五个元素可为任意顺序。
 *
 * 你不需要考虑数组中超出新长度后面的元素
 */
public class P27RemoveElement {

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int i = 0; // 头指针
        int j = len - 1; // 尾指针
        for (;i <= j;) {
            if (i == j) {
                if (nums[i] == val) {
                    return i;
                } else {
                    return i + 1;
                }
            }

            if (nums[j] == val) {
                j--; // 尾部为val直接前移
                continue;
            }

            if (nums[i] == val) {
                nums[i] = nums[j]; // 交换
                nums[j] = val; // 这里改不改值不影响结果
                i++;
                j--;
            } else {
                i++;
            }
        }

        // 这样的新数组，前i个元素为要求元素，后面的元素都为val
        return i;
    }

}
