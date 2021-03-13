package com.algorithm.array;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/10
 * @Description: 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。使用三次反转，在倒数K位置对前后进行反转，
 */
public class LeeCode189 {
    public static void rotate(int[] nums, int k) {
        int h = k % nums.length;
        if (h == 0) {
            return;
        }
        swapArr(0, nums.length - 1 - h, nums);
        swapArr(nums.length - h, nums.length - 1, nums);
        swapArr(0, nums.length - 1, nums);

    }

    public static void swapArr(int l, int r, int[] nums) {
        while (l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2};
        rotate(arr,3);
        for(int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }
}
