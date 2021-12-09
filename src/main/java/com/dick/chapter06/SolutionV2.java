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

public class SolutionV2 {

    public static void main(String[] args) {
        double middleValue = new SolutionV2().findMedianSortedArrays(new int[]{1, 2, 3, 4, 5}, new int[]{6, 7, 8, 9, 10});
        System.out.println(middleValue);

    }


    /**
     * O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = (m + n) / 2;
        int k = 0;
        int[] nums = new int[length + 1];
        int i = 0, j = 0;
        while (k < length + 1) {
            int value1 = i >= m ? Integer.MAX_VALUE : nums1[i];
            int value2 = j >= n ? Integer.MAX_VALUE : nums2[j];
            if (value1 >= value2) {
                nums[k] = nums2[j];
                j++;
            } else {
                nums[k] = nums1[i];
                i++;
            }
            k++;
        }
        return (m + n) % 2 == 0 ? (double) (nums[k - 1] + nums[k - 2]) / 2 : nums[k - 1];
    }
}
