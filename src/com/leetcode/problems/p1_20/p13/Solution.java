package com.leetcode.problems.p1_20.p13;


public class Solution {

    /**
     * 累加即可
     * 注意 4 9 40 90 400 900 这几个特殊的情况
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        char[] ss = s.toCharArray();
        int sum = 0;
        char ci;
        char ci1;
        for (int i = 0; i < ss.length; i++) {
            ci = ss[i];
            // 注意i的越界
            if (i == ss.length - 1) {
                ci1 = '0'; // 随便赋值
            } else {
                ci1 = ss[i+1];
            }

            switch (ci) {
                case 'I':
                    if (ci1 == 'V') {
                        sum += 4;
                        i++; // 多过一个字符
                    } else if(ci1 == 'X') {
                        sum += 9;
                        i++;
                    } else {
                        sum += 1;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if (ci1 == 'L') {
                        sum += 40;
                        i++;
                    } else if(ci1 == 'C') {
                        sum += 90;
                        i++;
                    } else {
                        sum += 10;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (ci1 == 'D') {
                        sum += 400;
                        i++;
                    }else if(ci1 == 'M') {
                        sum += 900;
                        i++;
                    } else {
                        sum += 100;
                    }
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }

        }

        return sum;
    }

}
