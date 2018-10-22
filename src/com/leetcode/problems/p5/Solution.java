package com.leetcode.problems.p5;

public class Solution {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        int left = 0;
        int right = 0;

        int len1;
        int len2;

        int len;
        for (int i = 0; i < s.length(); i++) {
            len1 = getLen(s, i, i);
            len2 = getLen(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > right - left) {
                left = i - (len - 1) / 2;
                right = i + len / 2;
            }
        }

        return s.substring(left, right + 1);
    }


    private int getLen(String s, int left, int right) {
        int l = left;
        int r = right;
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return r - l - 1;
    }


    public boolean isPalindrome(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }

        int len = str.length();
        if (len == 1) {
            return true;
        }

        int mid = len / 2;
        String subStart = str.substring(0, mid);
        String subEnd;
        if (len % 2 == 0) {
            subEnd = str.substring(mid, len);
        } else {
            subEnd = str.substring(mid + 1, len);
        }

        StringBuilder sb = new StringBuilder(subEnd);
        subEnd = sb.reverse().toString();
        return subStart.equals(subEnd);
    }

}
