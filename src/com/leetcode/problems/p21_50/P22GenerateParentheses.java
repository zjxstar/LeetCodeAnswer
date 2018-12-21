package com.leetcode.problems.p21_50;

import java.util.ArrayList;
import java.util.List;

public class P22GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    /**
     * 回溯法
     * 只有左括号数量大于右括号时才可以增加右括号
     * @param result
     * @param cur
     * @param open
     * @param close
     * @param max
     */
    public void backtrack(List<String> result, String cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            result.add(cur);
            return;
        }
        if (open < max) {
            backtrack(result, cur + "(", open + 1, close, max);
        }
        if (open > close) {
            backtrack(result, cur + ")", open, close + 1, max);
        }
    }

}
