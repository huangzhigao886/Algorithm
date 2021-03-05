package com.algorithm.array;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description: 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 思路：用一个下标索引从第一个元素开始，并以第一个数为基准数，
 * 如果下一个数与基准数不一致，换一下索引后的下一个值，最后索引+1的值即为不重复的总数
 */
public class LeeCode26 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        int left = 0;
        int num = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (num != nums[i]) {
                nums[++left] = nums[i];
                num = nums[i];
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 4, 5};
        System.out.println(removeDuplicates(arr));
    }
}
