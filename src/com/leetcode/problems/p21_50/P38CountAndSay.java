package com.leetcode.problems.p21_50;

/**
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 *
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "1211"
 */
public class P38CountAndSay {

    /**
     * 思路：数字字符串中，连续相同数字的个数与该数组成一组，然后反向拼接即可
     * 比如：1211 ： 1->连续1个->11 ， 2->连续1个->12 ， 1->连续2个->21  =>  111221
     * 递归：前一个输出作为下一个的输入
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        String temp = countAndSay(n - 1);
        int i = 0;
        StringBuilder result = new StringBuilder();
        while (i < temp.length()) {
            int count = 1;
            char num = temp.charAt(i);
            while (i+1 < temp.length() && temp.charAt(i) == temp.charAt(i+1)) {
                count++;
                i++;
            }
            result.append(count).append(num);
            i++;
        }
        return result.toString();
    }

}
