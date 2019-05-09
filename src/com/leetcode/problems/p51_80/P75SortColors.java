package com.leetcode.problems.p51_80;

import java.util.HashMap;

/**
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 注意:
 * 不能使用代码库中的排序函数来解决这道题。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class P75SortColors {

    /**
     * 计数法
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;

        for (int i = 0; i < nums.length; i++) {
            switch (nums[i]) {
                case 0:
                    zeroCount++;
                    break;
                case 1:
                    oneCount++;
                    break;
                case 2:
                    twoCount++;
                    break;
            }
        }

        int k = 0;
        while (zeroCount > 0) {
            nums[k++] = 0;
            zeroCount--;
        }
        while (oneCount > 0) {
            nums[k++] = 1;
            oneCount--;
        }
        while (twoCount > 0) {
            nums[k++] = 2;
            twoCount--;
        }

    }

    /**
     * 三指针
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int i = 0; // 用来处理1
        int j = nums.length - 1; // 用于处理2
        int k = 0; // 用来处理0

        while (k <= j) {
            if (nums[k] == 0 && k > i) {
                swap(nums, k, i); // 出现0，且k的位置在i的前面，交换
                i++;
            } else if (nums[k] == 2) {
                swap(nums, k, j); // 出现2，和j的位置进行交换
                j--;
            } else {
                k++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

}
