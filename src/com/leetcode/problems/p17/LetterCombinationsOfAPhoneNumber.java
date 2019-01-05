package com.leetcode.problems.p17;

import java.util.List;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> result = solution.letterCombinations("");
        for (String str : result) {
            System.out.println(str);
        }
    }

}
