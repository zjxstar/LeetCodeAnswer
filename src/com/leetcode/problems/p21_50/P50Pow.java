package com.leetcode.problems.p21_50;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/2^2 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−2^31, 2^31 − 1] 。
 */
public class P50Pow {

    /**
     * x^n * x^n = x^(2n)
     * x^n * x^n * x = x^(2n +1)
     * 递归处理 n，每次一半
     * 注意n的正负
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {

        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (power(x, -(n + 1)) * x);
            }
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }

    }

    public double power(double x, int n) {
        if (n == 0) return 1.0;

        double half = power(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        }
        return x * half * half;
    }

}
