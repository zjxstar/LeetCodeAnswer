package com.leetcode.problems.p51_80;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 */
public class P70ClimbStairs {

    /**
     * f(n) = f(n - 1) + f(n - 2)
     * f(1) = 1
     * f(2) = 2
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        // 防止超时，得记录已经计算过的值，避免重复计算
       int[] result = new int[n + 1];
       result[1] = 1;
       result[2] = 2;
       return climbStairsInternal(result, n);
    }

    private int climbStairsInternal(int[] result, int n) {
        if (result[n] != 0) {
            return result[n];
        }
        int temp = climbStairsInternal(result, n - 1) + climbStairsInternal(result,n - 2);
        result[n] = temp;
        return temp;
    }

}
