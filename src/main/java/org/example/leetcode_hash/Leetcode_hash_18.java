package org.example.leetcode_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode_hash_18 {

    /*
    给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：
        0 <= a, b, c, d < n
        a、b、c 和 d 互不相同
        nums[a] + nums[b] + nums[c] + nums[d] == target
        你可以按 任意顺序 返回答案 。
     */

    public static void main(String[] args) {
        int[] query = {1000000000,1000000000,1000000000,1000000000};
        System.out.println(fourSum(query, -294967296));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            int topNum = nums[k];
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            int left, right;
            for (int i = k+1; i < nums.length - 2; i++) {
                int currentValue = nums[i];
                // 如果首位出现与前一位重复，则该位置的遍历跳过
                if (i > k+1 && nums[i] == nums[i - 1]) {
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
                    long sum = Long.sum(topNum,currentValue) +  Long.sum(left_value,right_value);
                    if (sum > target) {
                        right --;
                        continue;
                    }
                    if (sum < target) {
                        left ++;
                        continue;
                    }
                    if (sum == target) {
                        List<Integer> nodeResult = new ArrayList<>();
                        nodeResult.add(topNum);
                        nodeResult.add(currentValue);
                        nodeResult.add(nums[left]);
                        nodeResult.add(nums[right]);
                        result.add(nodeResult);
                        left ++;
                        right --;
                    }
                }
            }
        }
        return result;
    }
}
