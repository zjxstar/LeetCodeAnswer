package com.leetcode.problems.p51_80;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 */
public class P59SpiralMatrix2 {

    /**
     * 一定是正方形
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];

        int rowStart = 0;
        int rowEnd = n - 1;
        int num = 1;

        while (rowStart <= rowEnd) {
            int colStart = rowStart;
            int colEnd = rowEnd;

            // to right
            for (int j = colStart; j <= colEnd; j++) {
                nums[rowStart][j] = num++;
            }
            // to down
            if (rowEnd - rowStart > 0) {
                for (int i = rowStart + 1; i <= rowEnd; i++) {
                    nums[i][colEnd] = num++;
                }
            }
            // to left
            if (colEnd - colStart > 0) {
                for (int j = colEnd - 1; j >= colStart; j--) {
                    nums[rowEnd][j] = num++;
                }
            }
            // to up
            if (rowEnd - rowStart > 1) {
                for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
                    nums[i][colStart] = num++;
                }
            }

            rowStart++;
            rowEnd--;
        }

        return nums;
    }

}
