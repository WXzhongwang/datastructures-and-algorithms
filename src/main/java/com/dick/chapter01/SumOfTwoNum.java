package com.dick.chapter01;

import java.util.HashMap;

/**
 * @author dick <18668485565@163.com>
 * @version V1.0.0
 * @description
 * @date created on 2021/4/14
 */
public class SumOfTwoNum {

    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
        }
        return indexs;
    }

    public static void main(String[] args) {
        int[] val = new SumOfTwoNum().twoSum(new int[] {2, 7, 11, 15}, 26);
        for (int i = 0; i < val.length; i++) {
            System.out.println(val[i]);
        }
    }
}
