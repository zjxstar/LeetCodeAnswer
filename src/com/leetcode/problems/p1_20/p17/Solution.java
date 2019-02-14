package com.leetcode.problems.p1_20.p17;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return result;
        }
        backtrace(digits, getStrByNum(digits.charAt(0)), result, "", 0, digits.length() - 1);
        return result;
    }

    private void backtrace(String digits, String str, List<String> result, String curStr, int height, int n) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            String s = curStr + String.valueOf(c);
            if (height == n) {

                result.add(s);
            } else {

                backtrace(digits, getStrByNum(digits.charAt(height + 1)), result, s,height + 1, n);
            }

        }
    }

    private String getStrByNum(char c) {
        String result = "abc";
        switch (c) {
            case '3':
                result = "def";
                break;
            case '4':
                result = "ghi";
                break;
            case '5':
                result = "jkl";
                break;
            case '6':
                result = "mno";
                break;
            case '7':
                result = "pqrs";
                break;
            case '8':
                result = "tuv";
                break;
            case '9':
                result = "wxyz";
                break;
        }
        return result;
    }

}
