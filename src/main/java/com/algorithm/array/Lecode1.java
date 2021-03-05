package com.algorithm.array;

import java.util.HashMap;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description: 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 */
public class Lecode1 {

    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(nums[i])) {
                return new int[]{i, map.get(nums[i])};
            } else {
                map.put(tmp, i);
            }
        }
        return null;
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

    }
}
