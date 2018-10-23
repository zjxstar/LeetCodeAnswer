package com.leetcode.problems.p6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    /**
     * 按行读取
     * @param s
     * @param numRows
     * @return
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows == 0) {
            return "";
        }

        if (s.length() < numRows) {
            return s;
        }

        if (numRows == 1) {
            return s;
        }

        // 初始化暂存器
        List<StringBuilder> strs = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            StringBuilder sb = new StringBuilder();
            strs.add(sb);
        }

        boolean down = false;
        int curRow = 0;

        for (char c : s.toCharArray()) {
            strs.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                down = !down; // 换方向
            }
            if (down) {
                curRow++;
            } else {
                curRow--;
            }
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : strs) {
            result.append(sb);
        }

        return result.toString();
    }


}
