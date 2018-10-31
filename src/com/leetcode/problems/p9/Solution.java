package com.leetcode.problems.p9;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    /**
     * 不将整数转成字符串
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int len = 0;
        List<Integer> list = new ArrayList<>();
        while (x / 10 != 0) {
            list.add(x % 10);
            len++;
            x = x / 10;
        }

        list.add(x);
        len++;

        boolean flag = true;
        for (int i = 0; i <= len / 2; i++) {
            if (list.get(i) != list.get(len - i - 1)) {
                flag = false;
                break;
            }
        }

        return flag;
    }

}
