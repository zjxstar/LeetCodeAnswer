package com.leetcode.problems.p1_20.p7;


public class Solution2 {

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

        long xL = Long.valueOf(result.toString());

        if (xL > Integer.MAX_VALUE || xL < Integer.MIN_VALUE) {
            return 0;
        }

        return Integer.valueOf(result.toString());
    }
}
