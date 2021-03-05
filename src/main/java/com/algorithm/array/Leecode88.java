package com.algorithm.array;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/4
 * @Description: 合并两个有序数组
 * 从后往前比较，大的放在最后一位
 */
public class Leecode88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int r1 = m - 1;
        int r2 = n - 1;
        int size = m + n;
        while (r1 > -1 && r2 > -1) {
            if (nums1[r1] > nums2[r2]) {
                nums1[--size] = nums1[r1--];
            } else {
                nums1[--size] = nums2[r2--];
            }
        }
        while (r2 > -1) {
            nums1[--size] = nums2[r2--];
        }
    }

    public static void main(String[] args) {
        int[] m = {1, 2, 3, 0, 0, 0};
        int[] n = {2, 5, 6};
        Leecode88 leecode88 = new Leecode88();
        leecode88.merge(m, 3, n, 3);
    }
}
