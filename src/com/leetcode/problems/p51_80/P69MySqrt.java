package com.leetcode.problems.p51_80;

/**
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 */
public class P69MySqrt {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4 ) {
            return 1;
        }

        int result = 2;
        for (int i = 2; i <= 46340; i++) {
            if (i == 46340) {
                result = 46340;
                break;
            }
            if (i * i <= x && (i + 1) * (i + 1) > x) {
                result = i;
                break;
            }
        }

        return result;
    }

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        if (x < 4) {
            return 1;
        }
        long half = x; // 一定要用long，int会溢出
        // 二分法找到第一个小于x的half
        while (true) {
            half = half / 2;
            if (half * half > x) {
                continue;
            } else {
                break;
            }
        }
        long result = half;
        while (true) {
            if (result * result > x) {
                return (int) result - 1;
            }
            result++;
        }
    }

}
