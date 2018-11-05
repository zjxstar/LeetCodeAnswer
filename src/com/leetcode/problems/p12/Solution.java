package com.leetcode.problems.p12;

public class Solution {

    public String intToRoman(int num) {

        if (num < 1 || num > 3999) {
            return "";
        }

        int i = 0;
        int n;
        StringBuilder sb = new StringBuilder();
        while (num / 10 != 0) {
            n = num % 10;
            num = num / 10;
            if (n == 0) {
                i++;
                continue;
            }
            sb.insert(0, toRoman(i++, n));
        }

        sb.insert(0, toRoman(i, num));

        return sb.toString();
    }

    /**
     * 划分：1、4、5、9
     * @param curRow
     * @param number
     * @return
     */
    private String toRoman(int curRow, int number) {
        String[][] romanStrs = {{"I", "IV", "V", "IX"},
                {"X", "XL", "L", "XC"},
                {"C", "CD", "D", "CM"},
                {"M", "", "", ""}};

        String result;
        if (curRow == 3) { // 最高位单独处理
            return repeat(number, romanStrs[curRow][0]);
        }
        if (number >= 1 && number < 4) {
            result = repeat(number, romanStrs[curRow][0]);
        } else if (number == 4) {
            result = romanStrs[curRow][1];
        } else if (number >= 5 && number < 9) {
            result = romanStrs[curRow][2] + repeat(number - 5, romanStrs[curRow][0]);
        } else {
            result = romanStrs[curRow][3];
        }

        return result;
    }

    private String repeat(int n, String str) {
        return new String(new char[n]).replace("\0", str);
    }

}
