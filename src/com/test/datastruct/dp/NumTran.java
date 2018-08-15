package com.test.datastruct.dp;

/**
 * 项目名称:testProject
 * 描述:
 * 7
 * 3   8
 * 8   1   0
 * 2   7   4   4
 * 4   5   2   6   5
 * 创建人:ryw
 * 创建时间:2018/7/12
 */
public class NumTran {


    public static void main(String[] args) {
        int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        int count = count(arr);
        System.out.println(count);
    }

    private static int count(int[][] arr) {
        int[] maxsum = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; --i) {
            for (int j = 0; j <= i; j++) {
                maxsum[j] = max(maxsum[j], maxsum[j + 1]) + arr[i][j];
            }
        }
        return maxsum[0];

    }

    public static int max(int i, int j) {
        return i > j ? i : j;
    }

}
