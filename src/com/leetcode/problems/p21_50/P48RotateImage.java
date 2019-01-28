package com.leetcode.problems.p21_50;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 */
public class P48RotateImage {

    /**
     * 先对角线交换
     * 再列交换
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix[0].length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) { // 注意这里减去i
                matrix[i][j] = matrix[i][j] ^ matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = matrix[i][j] ^ matrix[n - j - 1][n - i - 1];
                matrix[i][j] = matrix[i][j] ^ matrix[n - j - 1][n - i - 1];
            }
        }

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = matrix[i][j] ^ matrix[n - i - 1][j];
                matrix[n - i - 1][j] = matrix[i][j] ^ matrix[n - i - 1][j];
                matrix[i][j] = matrix[i][j] ^ matrix[n - i - 1][j];
            }
        }

    }

    /**
     * 每四个一交换
     * @param matrix
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        // 顺时针处理
        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - 1 - i; j++) { // 减去i防止已经交换的数据再次被交换
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][i]; // 最后一个到第一个位置
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]; // 倒数第二个到倒数第一位置
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]; // 倒数第三个到倒数第二位置
                matrix[j][n - 1 - i] = tmp; // 第二个位置
            }
        }
    }

}
