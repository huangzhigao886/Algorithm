package com.algorithm.sort;

/**
 * @Auther: huangzhigao
 * @Date: 2021/3/1
 * @Description: 冒泡排序
 */
public class MPSort {
    /**
     * 冒泡排序
     *
     * @param arr
     */
    public static void mpSort(int[] arr) {
        //如果为false,则认为后面皆为有序，不需要在排了
        boolean sortFlag = true;
        for (int i = 0; i < arr.length && sortFlag; i++) {
            sortFlag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    //sortFlag为true代表呗重新排过一次
                    sortFlag = true;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    public void quickSort(int[] s, int l, int r) {
        if (l < r) {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j)
                    s[i++] = s[j];

                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quickSort(s, l, i - 1); // 递归调用
            quickSort(s, i + 1, r);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 6, 7};
        MPSort mpSort = new MPSort();
        mpSort.quickSort(arr, 0, arr.length - 1);
        for(int i = 0 ;i<arr.length;i++){
            System.out.print(arr[i]+"-");
        }
//        mpSort(arr);

    }
}
