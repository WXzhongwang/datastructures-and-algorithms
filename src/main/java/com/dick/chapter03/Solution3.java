package com.dick.chapter03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2021/4/14
 */
public class Solution3 {

    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for (int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0;
        // 窗口开始位置
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i);
            System.out.println(index);
            System.out.println("compare: " + start + "," + (last[index] + 1));
            start = Math.max(start, last[index] + 1);
            res = Math.max(res, i - start + 1);
            System.out.println("start:" + start + ", res: " + res);
            last[index] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        // System.out.println(new Solution3().lengthOfLongestSubstring("abcbx"));
        System.out.println(new Solution3().lengthOfLongestSubstringV2("pwwkew"));
    }

    public int lengthOfLongestSubstringV2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
            System.out.println(map.toString());
        }
        return ans;
    }
    
}
