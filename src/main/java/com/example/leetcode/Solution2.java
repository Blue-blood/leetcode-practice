package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc:
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * 则中位数是 2.0
 *
 * 示例 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author: MrDi
 * @Date: 2020/7/14 13:51
 */
public class Solution2 {
    //时间复杂度 O(m+n)   没到O(log(m+n))
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;

        List<Integer> list = new ArrayList();
        if (nums1.length<1){
            for (int i = 0; i < nums2.length; i++) {
                list.add(nums2[i]);
            }
        }else if (nums2.length<1){
            for (int i = 0; i < nums1.length; i++) {
                list.add(nums1[i]);
            }
        }else {
            int i = 0;
            int i1 = 0;
            int i2 = 0;
            while (true) {
                if (nums1[i1] < nums2[i2]) {
                    list.add(nums1[i1]);
                    i1++;
                } else {
                    list.add(nums2[i2]);
                    i2++;
                }
                if (i1 >= nums1.length) {
                    while (i2 < nums2.length) {
                        list.add(nums2[i2]);
                        i2++;
                    }
                }
                if (i2 >= nums2.length) {
                    while (i1 < nums1.length) {
                        list.add(nums1[i1]);
                        i1++;
                    }
                }
                if (i1 >= nums1.length && i2 >= nums2.length) break;
                i++;
            }
        }
        int jo = list.size()%2;
        if (jo==0){
            result = (list.get(list.size()/2)+list.get(list.size()/2-1))/2d;
        }else {
            result = list.get ((list.size()-1)/2);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a1 = new int[]{};
        int[] a2 = new int[]{3};
        System.out.println(findMedianSortedArrays(a1,a2));
    }
}
