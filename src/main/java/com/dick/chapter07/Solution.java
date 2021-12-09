package com.dick.chapter07;

/**
 * 最长回文子串
 *
 * @author zhongshengwang
 * @description TODO
 * @date 2021/12/9 10:34 下午
 * @email zhongshengwang@shuwen.com
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abcbaef"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        // 动态规划 数组表述 s[i] 到 s[j] 的字符串是否为回文子串
        int maxLength = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        // 初始化：所有长度为 1 的子串都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        char[] charArray = s.toCharArray();
        // 通过子串长度开始递归
        for (int L = 2; L < len; L++) {
            // 枚举左边界，左边界的上限设置可以宽松一些
            for (int i = 0; i < len; i++) {
                // j - i + 1 = L; 反推右边界
                int j = L + i - 1;
                // 如果右边界越界，就可以退出当前循环
                if (j >= len) {
                    break;
                }
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][L] == true 成立，就表示子串 s[i..L] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    begin = i;
                }

            }
        }

        return s.substring(begin, begin + maxLength);
    }
}
