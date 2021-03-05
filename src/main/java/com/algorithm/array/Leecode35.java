package com.algorithm.array;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description: 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 */
public class Leecode35 {
    public static int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r - l) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if(target > nums[mid]){
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3};
        System.out.println(searchInsert(arr, 1));
    }
}
