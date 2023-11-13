package org.example.leetcode_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_hash_15 {

    /*
        给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
        你返回所有和为 0 且不重复的三元组。
        注意：答案中不可以包含重复的三元组。
     */

    public static void main(String[] args) {
        int[] query = {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
        List<List<Integer>> lists = threeSum(query);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    // 使用双指针进行解决
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        int left, right;
        for (int i = 0; i < nums.length - 2; i++) {
            int currentValue = nums[i];
            // 如果第一位还大于0，那么后面寻找的必然大于0
            if (currentValue > 0) {
                return result;
            }
            // 如果首位出现与前一位重复，则该位置的遍历跳过
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length -1;
            while (left < right) {
                int left_value = nums[left];
                int right_value = nums[right];
                if (left - 1 > i && left_value == nums[left - 1]) {
                    left ++;
                    continue;
                }
                if (right + 1 <= nums.length - 1 && right_value == nums[right + 1]) {
                    right --;
                    continue;
                }
                int sum = currentValue + left_value + right_value;
                if (sum > 0) {
                    right --;
                    continue;
                }
                if (sum < 0) {
                    left ++;
                    continue;
                }
                if (sum == 0) {
                    List<Integer> nodeResult = new ArrayList<>();
                    nodeResult.add(currentValue);
                    nodeResult.add(nums[left]);
                    nodeResult.add(nums[right]);
                    result.add(nodeResult);
                    left ++;
                    right --;
                }
            }
        }
        return result;
    }
}
