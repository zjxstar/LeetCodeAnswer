package com.leetcode.problems.p1_20.p3;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    /**
     * 思路：滑动窗口
     * 定义一个Map用来存放子串，其中key为子串的字符，value为子串的下标+1
     * 定义两个指针i,j；j向前移动，查看s[j]是否在Map中；
     * 如果在Map中，则出现字符重复，此时需要移动指针i，而i应该直接移动到重复字符的后一位
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int len = s.length();
        int maxLen = 0; // 记录最长子串长度
        // 记录子串，key为char，value为下标，从1开始方便移动
        Map<Character, Integer> subStrMap = new HashMap<>();
        char c;
        for (int i = 0, j = 0; j < len; j++) {
            c = s.charAt(j);
            if (subStrMap.containsKey(c)) {
                // 找到了重复字符，则移动i
                i = Math.max(subStrMap.get(c), i);
            }
            maxLen = Math.max(maxLen, j - i + 1);
            subStrMap.put(c, j + 1); // 这里是记录的是下标+1，方便i移动
        }

        return maxLen;
    }

}
