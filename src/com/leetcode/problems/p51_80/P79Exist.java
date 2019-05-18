package com.leetcode.problems.p51_80;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 */
public class P79Exist {

    /**
     * 回溯法
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int len = word.length(); // 单词的长度，即回溯的深度
        int m = board.length; // 行数
        int n = board[0].length; // 列数
        int[][] visited = new int[m][n]; // 用来标记是否已经使用过

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    // 匹配word的第一个值
                    boolean result = backtrace(board, visited, word,0, len, i, j, m, n);
                    if (result) { // 找到了就直接结束循环
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean backtrace(char[][] board, int[][] visited, String word, int curIndex, int len,
                              int i, int j, int m, int n) {

        if (curIndex == len) { // 这里用的是len，而不是len-1
            return true;
        }

        if (i < 0 || i >= m || j < 0 || j >= n
                || visited[i][j] == 1
                || board[i][j] != word.charAt(curIndex)) { // 越界条件和不匹配条件
            return false;
        } else {
            visited[i][j] = 1; // 标记，说明当前值在word中
            // 当前点的上下左右都要查看
            boolean result = backtrace(board, visited, word, curIndex + 1, len, i + 1, j, m, n) ||
                    backtrace(board, visited, word, curIndex + 1, len, i, j + 1, m, n) ||
                    backtrace(board, visited, word, curIndex + 1, len, i - 1, j, m, n) ||
                    backtrace(board, visited, word, curIndex + 1, len, i, j - 1, m, n);

            visited[i][j] = 0; // 说明相邻值没有在word中，复位标记

            return result;
        }

    }

}
