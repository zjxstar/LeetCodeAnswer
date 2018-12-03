package com.leetcode.problems.p21_50;

public class P28Str {

    public int strStr(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }

        if (needle == null) {
            return -1;
        }

        if (needle.equals("")) {
            return 0;
        }

        return haystack.indexOf(needle);
    }

}
