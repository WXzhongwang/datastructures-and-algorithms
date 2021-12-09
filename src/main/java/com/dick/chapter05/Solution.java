package com.dick.chapter05;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhongshengwang
 * @description TODO
 * <p>
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * @date 2021/12/8 10:16 下午
 * @email zhongshengwang@shuwen.com
 */

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (null == s || s.equals("")) return 0;
        int length = s.length();
        int start = 0, len = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0; end < length; end++) {
            Character c = s.charAt(end);
            System.out.println("start:" + start);
            // 出现重复字符
            if (map.containsKey(c)) {
                System.out.println("出现重复字符：" + c);
                start = Math.max(start, map.get(c));
            }
            // 更新最长子串的长度
            len = Math.max(len, end - start + 1);
            System.out.println("put map, key: " + c + ", value: " + (end + 1));
            map.put(c, end + 1);
        }
        return len;
    }
}
