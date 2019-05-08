package com.leetcode.problems.p51_80;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2:
 *
 * 输入:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出:
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class P73SetZeros {

    public void setZeroes(int[][] matrix) {

        List<Integer> zeroRows = new ArrayList<>();
        List<Integer> zeroColumns = new ArrayList<>();
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) { // 记录0元素的行号和列号
                    zeroRows.add(i);
                    zeroColumns.add(j);
                }
            }
        }

        // 置0行
        for (int row : zeroRows) {
            for (int j = 0; j < n; j++) {
                matrix[row][j] = 0;
            }
        }

        // 置0列
        for (int column : zeroColumns) {
            for (int i = 0; i < m; i++) {
                matrix[i][column] = 0;
            }
        }


    }

    /**
     * 只需要记住列号
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {

        List<Integer> zeroColumns = new ArrayList<>();
        int m = matrix.length; // 行数
        int n = matrix[0].length; // 列数

        boolean isRowZero; // 通过该变量判断当前行是否置0
        for (int i = 0; i < m; i++) {
            isRowZero = false;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) { // 记录0元素的列号
                    isRowZero = true;
                    zeroColumns.add(j);
                }
            }
            if (isRowZero) { // 直接把行置0
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }

        }

        // 置0列
        for (int column : zeroColumns) {
            for (int i = 0; i < m; i++) {
                matrix[i][column] = 0;
            }
        }

    }

}
