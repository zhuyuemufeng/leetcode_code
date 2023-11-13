package org.example.leetcode_hash;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_hash_454 {
    /*
    给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
        0 <= i, j, k, l < n
        nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     */

    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> nums1_nums2_sun = new HashMap<>((int) (nums1.length / 0.85));
        for (int num1_value : nums1) {
            for (int num2_value : nums2) {
                int key = num2_value + num1_value;
                nums1_nums2_sun.merge(key, 1, Integer::sum);
            }
        }
        int count = 0;
        for (int num3_value : nums3) {
            for (int num4_value : nums4) {
                int targetNum = -(num3_value + num4_value);
                Integer value = nums1_nums2_sun.get(targetNum);
                if (value != null){
                    count += value;
                }
            }
        }
        return count;
    }
}
