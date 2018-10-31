package com.leetcode.problems.p8;

public class Solution {

    /**
     * 注意特殊输入
     * " -000789"
     * "   +"
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;

        StringBuilder sb = new StringBuilder();
        int len = str.length();
        int index = 0;
        // 找到第一个非空字符
        for (; index < len; index++) {
            if (!isBlank(str.charAt(index)))
                break;
        }

        // 如果超长了直接返回
        if (index >= len)
            return 0;

        // 判断第一个非空字符是什么类型
        int kind = judgeStart(str.charAt(index));
        switch (kind) {
            case 0: // +
                break;
            case 1: // -
                sb.append('-');
                break;
            case 2: // 数字
                if (str.charAt(index) != '0')
                    sb.append(str.charAt(index));
                break;
            case -1:
                return 0;
        }

        index++;
        for (;index < len; index++) {
            if ((sb.toString().equals("") || sb.toString().equals("-")) && (str.charAt(index) == '0'))
                continue;

            if (isNumber(str.charAt(index))) {
                sb.append(str.charAt(index));
            } else {
                break;
            }
        }

        String result = sb.toString();
        if (result.equals("") || result.equals("-")) {
            return 0;
        }

        if (result.startsWith("-") && result.length() > 11) {
            return Integer.MIN_VALUE;
        }

        if (result.length() > 12) {
            return Integer.MAX_VALUE;
        }

        long resultL = Long.valueOf(result);

        if (resultL > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (resultL < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return Integer.valueOf(sb.toString());
    }

    private int judgeStart(char c) {
        if (isPositive(c)) {
            return 0; // +号开头
        }

        if (isNegative(c)) {
            return 1; // -号开头
        }

        if (isNumber(c)) {
            return 2; // 数字开头
        }

        return -1; // 非法字符
    }

    private boolean isBlank(char c) {
        return c == ' ';
    }

    private boolean isNegative(char c) {
        return c == '-';
    }

    private boolean isPositive(char c) {
        return c == '+';
    }

    private boolean isNumber(char c) {
        return c >= '0' && c <= '9';
    }
}
