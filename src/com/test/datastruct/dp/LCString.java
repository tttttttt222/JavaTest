package com.test.datastruct.dp;

/**
 * 项目名称:testProject
 * 描述:
 * 创建人:ryw
 * 创建时间:2018/7/13
 */
public class LCString {

    public static char[] ch1 = {'a', 'b', 'c', 'f', 'b', 'c'};

    public static char[] ch2 = {'a', 'b', 'f', 'c', 'a', 'b', 'c', 'f'};


    public static void main(String[] args) {
        int c = lcString(ch1, ch2);
        System.out.println(c);
    }

    private static int lcString(char[] ch1, char[] ch2) {
        int maxLcs[][] = new int[50][50];
        int res = 0;

        for (int i = 0; i <= ch1.length; i++) {
            maxLcs[i][0] = 0;
        }

        for (int j = 0; j <= ch2.length; j++) {
            maxLcs[0][j] = 0;
        }

        for (int i = 1; i <= ch1.length; i++) {
            for (int j = 1; j <= ch2.length; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    maxLcs[i][j] = maxLcs[i - 1][j - 1] + 1;
                    res = max(maxLcs[i][j], res);
                } else {
                    maxLcs[i][j] = 0;
                }
            }
        }

        return res;
    }


    public static int max(int i, int j) {
        return i > j ? i : j;
    }

}
