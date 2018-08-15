package com.test.datastruct.dp;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/7/17
 */
public class LongIncreaseSeq {


    public static int[] seq = {5, 1, 2, 6, 3, 4, 7, 2, 3, 8};

    public static void main(String[] args) {
        int i = longIncreaseSeq(seq);
        System.out.println(i);
    }

    private static int longIncreaseSeq(int[] seq) {

        int[] dp = new int[seq.length];
        int maxCount = 0;

        for (int i = 0; i < seq.length; i++) {

            dp[i] = 1;

            for (int j = 0; j < i; j++) {
                if (seq[i] > seq[j]) {
                    dp[i] = max(dp[i], dp[j] + 1);
                }
            }


            if (dp[i] > maxCount) {
                maxCount = dp[i];
            }
        }

        return maxCount;
    }

    public static int max(int i, int j) {
        return i > j ? i : j;
    }

}
