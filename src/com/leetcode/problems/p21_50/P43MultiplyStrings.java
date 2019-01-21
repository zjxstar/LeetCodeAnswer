package com.leetcode.problems.p21_50;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 示例 1:
 *
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 *
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * 说明：
 *
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class P43MultiplyStrings {

    /**
     * 按照乘法运算规则，使用数组处理即可
     * 两数相乘，结果值的长度可能是：n + m （发生进位） 和 n + m - 1
     * 所以，使用长度为 n+m 的数组存储结果
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // 初始化结果数组
        int[] result = new int[num1.length() + num2.length()];
        int temp;
        int carry;
        int i , j;
        for (i = num1.length() - 1; i >= 0; i--) {
            carry = 0;
            for (j = num2.length() - 1; j >= 0; j--) {
                temp = (num1.charAt(i) - '0') * (num2.charAt(j) - '0') + result[i + j + 1] + carry;
                result[i + j + 1] = temp % 10; // 因为可能最高位由溢出，所以这里+1
                carry = temp / 10;
            }
            // 最后一个数可能进位
            result[i + j + 1] = carry;
        }

        // 去掉开头的0
        i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }

        StringBuilder sb = new StringBuilder();
        for (; i < result.length; i++) {
            sb.append(result[i]);
        }
        return sb.toString();
    }

}
