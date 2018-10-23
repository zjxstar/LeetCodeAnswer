package com.leetcode.problems.p7;


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
//        if (big.compareTo(new BigInteger()))
        System.out.println(big.toString());

        return 0;
    }
}
