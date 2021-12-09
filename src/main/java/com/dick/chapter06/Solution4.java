package com.dick.chapter06;

/**
 * @author zhongshengwang
 * @description TODO
 * @date 2021/12/9 10:08 下午
 * @email zhongshengwang@shuwen.com
 */

public class Solution4 {
    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        int kthElement = solution4.findKthElement(new int[]{1, 3, 5, 7, 9}, new int[]{2, 4, 6, 8, 10}, 6);
        System.out.println(kthElement);
    }


    /**
     * 寻找两个有序数组中第K小的元素
     *
     * @param array1
     * @param array2
     * @param k
     * @return
     */
    public int findKthElement(int[] array1, int[] array2, int k) {
        int len1 = array1.length;
        int len2 = array2.length;
        int index1 = 0, index2 = 0;
        while (true) {
            if (index1 == len1) {
                return array2[index2 + k - 1];
            }

            if (index2 == len2) {
                return array1[index1 + k - 1];
            }
            if (k == 1) {
                return Math.min(array1[index1], array2[index2]);
            }

            // 正常情况
            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;
            int pivot1 = array1[newIndex1];
            int pivot2 = array2[newIndex2];
            if (pivot1 <= pivot2) {
                // 压缩K 第一个数组的下标右移
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                // 压缩K, 第二个数组的下标右移
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

}
