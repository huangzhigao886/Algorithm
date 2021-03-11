package com.algorithm.array;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 */
public class Leecode35 {
    public static int searchInsert(int[] nums, int target) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums[0] > target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        int l = 0;
        int r = nums.length;
        int mid = 0;
        boolean flag = false;

        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
                if (l == r) {
                    flag = false;
                }
            } else if (nums[mid] < target) {
                l = mid + 1;

            } else {
                return mid;
            }
        }

        return flag ? mid : mid - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
        System.out.println(searchInsert(arr, 1));
    }
}
