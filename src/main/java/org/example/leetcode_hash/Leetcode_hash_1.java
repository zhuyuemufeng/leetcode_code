package org.example.leetcode_hash;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_hash_1 {

    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     *
     * 你可以按任意顺序返回答案。
     */

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] twoSum = twoSum(nums, 9);
        if (twoSum == null) {
            System.out.println("null");
        } else {
            for (int i : twoSum) {
                System.out.println(i);
            }
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int residue = target - currentNum;
            Integer index = map.get(Integer.valueOf(residue));
            if (index == null) {
                map.put(currentNum, i);
            } else {
                result[0] = i;
                result[1] = index;
                return result;
            }
        }
        return null;
    }

}
