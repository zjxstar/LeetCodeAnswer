package com.leetcode.problems.p14;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[] {
                "flower", "flow", "flight"
        }));

        System.out.println(solution.longestCommonPrefix(new String[]{
                "dog","racecar","car"
        }));
    }

}
