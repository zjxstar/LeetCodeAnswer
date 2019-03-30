package com.zjx.algorithm.sort;

/**
 * 快速排序
 */
public class QuickSort {

    /**
     * 已最左元素为轴
     * @param nums
     * @param left
     * @param right
     */
    public void quickSort1(int[] nums, int left, int right) {
        int flag = nums[left]; // 最左边的为轴
        int i = left;
        int j = right;

        while (i < j) {
            while (j > left && nums[j] >= flag) {
                j--;
            }
            swap(nums, i, j);
            i++;
            while (i < right && nums[i] <= flag) {
                i++;
            }
            swap(nums, i, j);
            j--;
        }

        if (i - 1 > left) {
            quickSort1(nums, left, i - 1);
        }
        if (j + 1 < right) {
            quickSort1(nums, j + 1, right);
        }
    }

    // 栈溢出了
    public void quickSort2(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        int mid = (i + j) / 2; // 可换成随机位置
        swap(nums, left, mid);
        int flag = nums[left]; // 最左边的为轴

        while (i < j) {
            while (j > left && nums[j] >= flag) {
                j--;
            }
            swap(nums, i, j);
            i++;
            while (i < right && nums[i] <= flag) {
                i++;
            }
            swap(nums, i, j);
            j--;
        }

        if (i - 1 > left) {
            quickSort2(nums, left, i - 1);
        }
        if (j + 1 < right) {
            quickSort2(nums, j + 1, right);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void quickSort3(int[] nums, int left, int right) {
        if (left < right) {
            int p = partition(nums, left, right);
            quickSort3(nums, left, p - 1);
            quickSort3(nums, p + 1, right);
        }
    }

    /**
     * 随机快速排序
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] nums, int left, int right) {
        // 取随机位置
        int randIndex = (int) (Math.random() * (right - left + 1) + left);
        swap(nums, randIndex, right); // 和最后一位交换，作为轴

        int flag = nums[right];
        int i = left - 1; // 标记轴要插入的前一个位置，即值小于轴的最后一个数的位置
        for (int j = left; j <= right - 1; j++) { // 最后一位不参与
            // 将小于轴的数往前排
            if (nums[j] <= flag) {
                i++; // i初始位置是非法的
                swap(nums, i, j); // 将前面大于轴的数和该小于轴的数交换
            }
        }
        // 此时i位置之前的数都小于轴，之后的数都大于轴
        // 将轴放到i+1处，相当于把第一个大于轴的数换到了最后
        swap(nums, i + 1, right);
        return i + 1; // 返回的是轴最后的位置
    }

}
