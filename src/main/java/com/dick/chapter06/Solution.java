package com.dick.chapter06;

/**
 * @author zhongshengwang
 * @description TODO
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * @date 2021/12/8 10:58 下午
 * @email zhongshengwang@shuwen.com
 */

public class Solution {

    public static void main(String[] args) {

    }


    /**
     * O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums;
        int m = nums1.length;
        int n = nums2.length;
        nums = new int[m + n];
        if (m == 0) {
            if (n % 2 == 0) {
                return (nums2[n / 2 - 1] + nums2[n / 2 + 1]) / 2.0;
            } else {
                return nums2[n / 2] / 2.0;
            }
        }
        if (n == 0) {
            if (m % 2 == 0) {
                return (nums1[n / 2 - 1] + nums1[n / 2 + 1]) / 2.0;
            } else {
                return nums1[n / 2] / 2.0;
            }
        }

        int count = 0;
        int i = 0, j = 0;
        while (count != (m + n)) {
            if (nums1[i] < nums2[j]) {
                nums[count++] = nums1[i++];
            } else {
                nums[count++] = nums2[j++];
            }

            if (i == m) {
                while (j != n) {
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if (j == n) {
                while (i != m) {
                    nums[count++] = nums1[i++];
                }
            }
        }

        if (count % 2 == 0) {
            return (nums[count / 2 - 1] + nums[count / 2]) / 2.0;
        } else {
            return nums[count / 2];
        }
    }
}
