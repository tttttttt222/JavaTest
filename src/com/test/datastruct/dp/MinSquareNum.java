package com.test.datastruct.dp;

import java.util.Arrays;

/**
 * 项目名称:testProject
 * 描述:
 * 给一个正整数 n, 找到若干个完全平方数(比如1, 4, 9, ... )使得他们的和等于 n 你需要让平方数的个数最少
 * 给出 n = 12, 返回 3 因为 12 = 4 + 4 + 4
 * 给出 n = 13, 返回 2 因为 13 = 4 + 9
 * 创建人:ryw
 * 创建时间:2018/7/16
 */
public class MinSquareNum {


    public static void main(String[] args) {
        int n = 12;

        int count = minSquareNum(n);

        System.out.println(count);
    }

    private static int minSquareNum(int n) {
        int[] dp = new int[n + 1];
        // 将所有非平方数的结果置最大，保证之后比较的时候不被选中
        Arrays.fill(dp, Integer.MAX_VALUE);
        // 将所有平方数的结果置1
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        // 从小到大找任意数a
        for (int a = 0; a <= n; a++) {
            // 从小到大找平方数bｘb
            for (int b = 0; a + b * b <= n; b++) {
                // 因为a+b*b可能本身就是平方数，所以我们要取两个中较小的
                dp[a + b * b] = Math.min(dp[a] + 1, dp[a + b * b]);
            }
        }
        return dp[n];

    }


}
