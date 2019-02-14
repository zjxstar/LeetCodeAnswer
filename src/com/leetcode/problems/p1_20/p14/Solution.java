package com.leetcode.problems.p1_20.p14;

public class Solution {

    /**
     * 随便取一个字符串，从第一个字符开始，取子串
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        String result = "";
        String firstStr = strs[0];
        if (firstStr.equals("")) {
            return "";
        }
        String temp;
        int end = 0;
        boolean flag;
        do {
            end++;
            temp = firstStr.substring(0, end);
            flag = false;
            for (int i = 1; i < strs.length; i++) {
                if (!strs[i].startsWith(temp)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            } else {
                result = temp;
            }
        } while (end < firstStr.length());

        return result;
    }

}
