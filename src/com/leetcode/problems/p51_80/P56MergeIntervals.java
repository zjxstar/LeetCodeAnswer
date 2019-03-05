package com.leetcode.problems.p51_80;

import java.util.*;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class P56MergeIntervals {

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 1) {
            return intervals;
        }

        // 按照start排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        List<Interval> result = new ArrayList<>();
        int size = intervals.size();
        for (int i = 0; i < size; i++) {
            int j = i + 1;
            int start = intervals.get(i).start;
            int end = intervals.get(i).end;
            while (j < size) {
                if (end >= intervals.get(j).start) {
                    if (end < intervals.get(j).end) {
                        end = intervals.get(j).end;
                    }
                    j++;
                } else {
                    result.add(new Interval(start, end));
                    i = j - 1;
                    break;
                }
            }
            if (j == size) {
                result.add(new Interval(start, end));
                break;
            }
        }

        return result;
    }


}
