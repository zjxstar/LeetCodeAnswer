package com.leetcode.problems.p1_20.p6;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Example 1:
 *  Input: s = "PAYPALISHIRING", numRows = 3
 *  Output: "PAHNAPLSIIGYIR"
 *
 * Example 2:
 *  Input: s = "PAYPALISHIRING", numRows = 4
 *  Output: "PINALSIGYAHRPI"
 *  Explanation:
 *
 *  P     I    N
 *  A   L S  I G
 *  Y A   H R
 *  P     I
 */
public class ZigZag {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result_3 = solution.convert("PAYPALISHIRING", 3);
        String result_4 = solution.convert("PAYPALISHIRING", 4);

        System.out.println(result_3); // PAHNAPLSIIGYIR
        System.out.println(result_4); // PINALSIGYAHRPI

        String test = solution.convert("AB", 1);
        System.out.println(test);
    }

}
