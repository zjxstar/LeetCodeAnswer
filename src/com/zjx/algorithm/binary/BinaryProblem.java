package com.zjx.algorithm.binary;

public class BinaryProblem {

    /**
     * 统计int整数的二进制数中1的个数
     * 无符号右移
     * @param n
     * @return
     */
    public int countIntOne(int n) {
        int count = 0;

        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }

        return count;
    }

    /**
     * n每减去1，n & (n-1)的二进制都会少一个1
     * @param n
     * @return
     */
    public int countIntOne2(int n) {
        int count = 0;

        while (n != 0) {
            count++;
            n = n & (n - 1);
        }

        return count;
    }

}
