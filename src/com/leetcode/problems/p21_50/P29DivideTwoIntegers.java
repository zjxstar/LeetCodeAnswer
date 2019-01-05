package com.leetcode.problems.p21_50;

public class P29DivideTwoIntegers {

    /**
     * 使用减法
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide1(int dividend, int divisor) {
        // 考虑溢出情况
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        long absDividend = Math.abs(dividend);
        long absDivisor = Math.abs(divisor);
        int result;
        if (absDividend == absDivisor) {
            result = 1;
        } else if (absDividend > absDivisor) {
            int count = 0;
            while (absDividend >= absDivisor) {
                count++;
                absDividend = absDividend - absDivisor;
            }
            result = count;
        } else {
            result = 0;
        }

        // 考虑正负
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            result = -result;
        }

        return result;
    }

    /**
     * 通过位运算加速
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide2(int dividend, int divisor) {
        // 考虑溢出情况
        if (dividend == 0) {
            return 0;
        }

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE;
        }

        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        boolean flag = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
        int result = 0;

        while (absDividend >= absDivisor) {
            long t = 1;
            long temp = absDivisor;
            while (absDividend > (temp << 1)) {
                temp <<= 1;
                t <<= 1;
            }
            absDividend -= temp;
            result += t;
        }

        // 考虑正负
        if (flag) {
            result = -result;
        }

        return result;
    }

}
