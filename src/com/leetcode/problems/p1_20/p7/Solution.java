package com.leetcode.problems.p1_20.p7;


import java.math.BigInteger;

public class Solution {

    public int reverse(int x) {
        if (x == 0) {
            return x;
        }

        String strX = String.valueOf(x);
        boolean flag = false;
        if (strX.charAt(0) == '-') {
            // 负数
            flag = true;
            strX = strX.substring(1, strX.length());
        }

        StringBuilder result = new StringBuilder();
        if (flag) {
            result.append('-');
        }
        int end = strX.length() - 1;
        for (; end >= 0; end--) {
            if (strX.charAt(end) != '0') {
                break;
            }
        }

        for (; end >= 0; end--) {
            result.append(strX.charAt(end));
        }

        BigInteger big = new BigInteger(result.toString());
        if (big.shiftRight(31).compareTo(new BigInteger("0")) > 0) {
            return 0;
        }

        if (flag && big.abs().shiftRight(31).compareTo(new BigInteger("1")) > 0) {
            return 0;
        }

        return Integer.valueOf(result.toString());
    }
}
