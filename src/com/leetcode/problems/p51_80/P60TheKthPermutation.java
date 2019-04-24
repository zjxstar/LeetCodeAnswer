package com.leetcode.problems.p51_80;

import java.util.LinkedList;

/**
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 *
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 *
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 *
 * 说明：
 *
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 *
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 *
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class P60TheKthPermutation {

    /**
     * 循环确认第几组，把相应组的数字加入到结果中
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        StringBuilder result = new StringBuilder();

        LinkedList<Integer> list = initNumList(n);
        int count = 1;
        int a; // 先计算n-1的阶乘
        int b; // 整数部分，说明是第几组
        int c; // 余数部分，说明去除第b个数后，剩下数组成的字符串中的第c个

        k = k - 1; // 这里减去1是为了方便下标计数

        do {
            a = calculateFactorial(n - count); // 还有n-count个数处理
            b = k / a;
            c = k % a;
            result.append(list.get(b)); // 第b个加入到结果集中
            list.remove(b); // 从列表中删除
            count++; // 当前已经确定的数字个数
            k = c; // 新的k
        } while (c != 0);

        // 剩余的数
        if (!list.isEmpty()) {
            for (Integer num : list) {
                result.append(num);
            }
        }

        return result.toString();
    }

    /**
     * 初始化数字列表
     * 因为涉及到删除元素，所以不用数组了
     * @param n
     * @return
     */
    private LinkedList<Integer> initNumList(int n) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }

        return list;
    }

    /**
     * 计算n的阶乘
     * @param n
     * @return
     */
    private int calculateFactorial(int n) {
        int result = 1;

        for (int i = 1; i <= n; i++) {
            result *= i;
        }

        return result;
    }

}
