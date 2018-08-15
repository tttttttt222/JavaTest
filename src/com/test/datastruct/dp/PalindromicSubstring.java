package com.test.datastruct.dp;

/**
 * 项目名称:testProject
 * 描述:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * 创建人:ryw
 * 创建时间:2018/7/13
 */
public class PalindromicSubstring {

    public static char ch1[] = {'b', 'a', 'b', 'a', 'd', 'd', 'd', 'd', 'd', 'd'};

    public static char ch2[] = {'b', 'a', 'a', 'b', 'a'};

    public static String str = "babad";

    public static String str2 = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";

    public static void main(String[] args) {
//        String res = palindromicSubstring(ch2);
//        System.out.println(res);
//        String res2 = palindromicSubstring(ch2);
//        System.out.println(res2);

        String s = palindromicSubstring(str2);
        System.out.println(s);

    }

    private static String palindromicSubstring(char[] ch) {
        int dp[][] = new int[50][50];
        int ans = 0;
        int s = 0;
        int e = 0;
        for (int i = 0; i < ch.length; i++) {
            dp[i][i] = 1;
            if (i < ch.length - 1 && ch[i] == ch[i + 1]) {
                dp[i][i + 1] = 1;
                ans = 2;
            }
        }

        for (int k = 3; k <= ch.length; k++) {
            for (int i = 0; i < ch.length - k - 1; i++) {
                int en = i + k - 1;
                if (ch[i] == ch[en] && dp[i + 1][en - 1] == 1) {
                    dp[i][en] = 1;
                    ans = k;
                    s = i;
                    e = en;
                }
            }
        }

        System.out.println(ans + "--" + s + "--" + e);
        return new String(ch, s, ans);
    }

    private static String palindromicSubstring(String str) {
        int size = str.length();
        if (size <= 1) return str;
        //dp为size*size大小的矩阵，dp[i][j]表示以s[i]开头，s[j]结尾的回文串长度（如果不是回文串，则为0）
        int dp[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                //初始化，将对角线元素设为1
                if (i == j) dp[i][j] = 1;
                else dp[i][j] = 0;
            }
        }
        int start = 0, max = 1;
        for (int j = 0; j < size; j++) {
            for (int i = j - 1; i >= 0; i--) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (j - i == 1) dp[i][j] = 2;
                    else {
                        if (dp[i + 1][j - 1] > 0) {
                            dp[i][j] = dp[i + 1][j - 1] + 2;
                        } else dp[i][j] = 0;
                    }
                } else dp[i][j] = 0;


                if (dp[i][j] > max) {
                    max = dp[i][j];
                    start = i;
                }
            }
        }
        return str.substring(start, start+max);
    }


}
