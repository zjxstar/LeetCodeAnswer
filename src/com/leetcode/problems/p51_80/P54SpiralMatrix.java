package com.leetcode.problems.p51_80;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 *
 * 输入:
 * [
 *   [1, 2, 3, 4],
 *   [5, 6, 7, 8],
 *   [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class P54SpiralMatrix {

    /**
     * 相当于每次都处理一个矩形
     * 四个步骤：1.向右；2.向下；3.向左；4.向上
     * 其中：
     * 1.向右：是一定可以执行的；
     * 2.向下：只有行数最少2行才可以向下；
     * 3.向左：只有列数最少2列才可以向左；
     * 4.向上：只有行数最少3行才可以向上；
     * 递归处理每个矩形
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return list;
        }
        printRect(matrix, 0, matrix.length - 1,
                0, matrix[0].length - 1, list);
        return list;
    }

    private void printRect(int[][] matrix, int rowStart, int rowEnd,
                           int colStart, int colEnd, List<Integer> list) {
        // 递归的时候会出现列头大于列尾的情况，直接结束
        if (colStart > colEnd) {
            return;
        }
        // to right
        for (int j = colStart; j <= colEnd; j++) {
            list.add(matrix[rowStart][j]);
        }
        // to down
        if (rowEnd - rowStart > 0) {
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                list.add(matrix[i][colEnd]);
            }
        } else {
            return;
        }
        // to left
        if (colEnd - colStart > 0) {
            for (int j = colEnd - 1; j >= colStart; j--) {
                list.add(matrix[rowEnd][j]);
            }
        } else {
            return;
        }
        // to up
        if (rowEnd - rowStart > 1) {
            for (int i = rowEnd - 1; i >= rowStart + 1; i--) {
                list.add(matrix[i][colStart]);
            }
        } else {
            return;
        }
        // loop
        printRect(matrix, rowStart + 1, rowEnd - 1,
                colStart + 1, colEnd - 1, list);
    }
}
