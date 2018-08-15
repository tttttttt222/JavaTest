package com.test.datastruct.dp;

/**
 * 项目名称:testProject
 * 描述:
 * Sample Input
 * <p>
 * abcfbc abfcab
 * programming    contest
 * abcd    mnp
 * <p>
 * Sample Output
 * 4
 * 2
 * 0
 * 创建人:ryw
 * 创建时间:2018/7/12
 */
public class LCS {

    public static char[] ch1 = {'a', 'b', 'c', 'f', 'b', 'c'};

    public static char[] ch2 = {'a', 'b', 'f', 'c', 'a', 'b'};

//    public static char[] ch1 = {'a', 'b', 'c'};

//    public static char[] ch2 = {'a', 'b'};


    public static void main(String[] args) {
        int lcs = lcs(ch1, ch2);
        System.out.println(lcs);
    }

    private static int lcs(char[] c1, char[] c2) {
        int[][] maxLcs = new int[50][50];

        for (int i = 0; i <= c1.length; i++) {
            maxLcs[i][0] = 0;
        }

        for (int j = 0; j <= c2.length; j++) {
            maxLcs[0][j] = 0;
        }

        for (int i = 1; i <= c1.length; i++) {
            for (int j = 1; j <= c2.length; j++) {
                if (c1[i - 1] == c2[j - 1]) {
                    maxLcs[i][j] = maxLcs[i - 1][j - 1] + 1;
                } else {
                    maxLcs[i][j] = max(maxLcs[i - 1][j], maxLcs[i][j - 1]);
                }
            }
        }
        return maxLcs[c1.length][c2.length];
    }

    public static int max(int i, int j) {
        return i > j ? i : j;
    }
}
