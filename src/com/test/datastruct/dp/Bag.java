package com.test.datastruct.dp;

/**
 * 项目名称:testProject
 * 描述:i 1 2 3 4
 * w(体积) 2 3 4 5
 * v(价值) 3 4 5 6
 * 创建人:ryw
 * 创建时间:2018/7/16
 */
public class Bag {


    public static void main(String[] args) {
        int capacity = 8;
        int[] w = {2, 3, 4, 5};
        int[] v = {3, 4, 5, 6};
        int[][] res = valBag(w, v, capacity);
    }

    private static int[][] valBag(int[] w, int[] v, int capacity) {
        int[][] dp = new int[w.length + 1][capacity + 1];

        for (int i = 1; i <= w.length; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j < w[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - w[i - 1]] + v[i - 1]);
                }
            }
        }

        System.out.println(dp[w.length][capacity]);


        return new int[10][10];
    }


    public static int max(int i, int j) {
        return i > j ? i : j;
    }
}
