package com.leetcode.problems.p7;

import java.math.BigInteger;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 *  Input: 123
 *  Output: 321
 *
 * Example 2:
 *  Input: -123
 *  Output: -321
 *
 * Example 3:
 *  Input: 120
 *  Output: 21
 */
public class ReverseInteger {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
//        System.out.println(solution.reverse(123));
//        System.out.println(solution.reverse(-123));
//        System.out.println(solution.reverse(-12300));
        System.out.println(solution.reverse(-1563847412));
    }
}
