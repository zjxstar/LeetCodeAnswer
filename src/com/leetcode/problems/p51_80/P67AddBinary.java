package com.leetcode.problems.p51_80;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class P67AddBinary {

    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();

        int[] result = new int[Math.max(aLen, bLen)];

        int len = Math.min(aLen, bLen); // 取小的长度
        int count = 0;
        int temp = 0;
        int aIndex = aLen - 1;
        int bIndex = bLen - 1;
        int flag = 0;
        int k = result.length - 1;

        // 尾部开始加
        while (count < len) {
            aIndex = aLen - 1 - count;
            bIndex = bLen - 1 - count;
            temp = (a.charAt(aIndex) - '0') + (b.charAt(bIndex) - '0') + flag;
            if (temp >= 2) {
                flag = 1; // 进位
                result[k--] = temp - 2;
            } else {
                flag = 0; // 复位
                result[k--] = temp;
            }
            count++;
        }

        // 此时aIndex和bIndex都在最后一次相加的位置，所有要减去1
        aIndex--;
        bIndex--;

        // 处理剩下的数
        for (; aIndex >= 0; aIndex--) {
            temp = a.charAt(aIndex) - '0' + flag;
            if (temp >= 2) {
                flag = 1; // 进位
                result[k--] = temp - 2;
            } else {
                flag = 0; // 复位
                result[k--] = temp;
            }
        }

        for (; bIndex >= 0; bIndex--) {
            temp = b.charAt(bIndex) - '0' + flag;
            if (temp >= 2) {
                flag = 1; // 进位
                result[k--] = temp - 2;
            } else {
                flag = 0; // 复位
                result[k--] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();

        if (flag == 1) {
            sb.append(1);
        }

        for (int num : result) {
            sb.append(num);
        }

        return sb.toString();
    }

}
