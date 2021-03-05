package com.algorithm.array;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description:
 */
public class Leecode27 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int R = nums.length;
        while (index < R) {
            if (nums[index] == val) {
                swap(--R, index, nums);
            } else {
                index++;
            }
        }
        return R;

    }

    public void swap(int l, int r, int[] arr) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
