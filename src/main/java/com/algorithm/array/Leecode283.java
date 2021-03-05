package com.algorithm.array;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
 */
public class Leecode283 {
    public static void moveZeroes(int[] nums) {
        //index表示非0位置
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //如果不等于0，则直接覆盖，当上次为0，index指向0的位置，则将其覆盖
                nums[index++] = nums[i];
            }
        }
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }


    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        moveZeroes(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
