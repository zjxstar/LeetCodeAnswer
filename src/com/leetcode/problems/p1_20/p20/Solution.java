package com.leetcode.problems.p1_20.p20;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        if (s == null || s.length() == 1) {
            return false;
        }

        if (s.length() == 0) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for (char c : s.toCharArray()) {
            if (isLeftParentheses(c)) {
                stack.push(c); // 左括号压栈
            } else { // 右括号匹配
                if (stack.isEmpty()) {
                    result = false;
                    break;
                }
                char topC = stack.pop(); // 取出栈顶括号
                switch (c) {
                    case ']':
                        result = topC == '[';
                        break;
                    case '}':
                        result = topC == '{';
                        break;
                    case ')':
                        result = topC == '(';
                        break;
                }
            }
            if (!result) {
                break;
            }
        }

        // 最后栈要空
        return result && stack.isEmpty();
    }

    private boolean isLeftParentheses(char c) {
        if (c == '[' || c == '{' || c == '(') {
            return true;
        }

        return false;
    }

}
