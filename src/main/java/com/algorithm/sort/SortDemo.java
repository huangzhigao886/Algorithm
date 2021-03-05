package com.algorithm.sort;

/**
 * @Author: huangzhigao
 * @Date: 2021/3/1 20:56 几种排序算法
 */
public class SortDemo {

    /**
     * 冒泡算法
     *
     * @param arr
     */
    public void mpSort(int[] arr) {
        for (int i = arr.length - 1; i > -1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    /**
     * 优化后的冒泡
     * flag为true时认为还需要排序，当最外层循环i= n，经过j<n的循环后，flag没发生变化，说明从0-n之间的数已经时有序的，此时不需要再次循环
     *
     * @param arr
     */
    public void betterMpSort(int[] arr) {
        boolean flag = true;
        for (int i = arr.length - 1; i > -1 && flag; i--) {
            flag = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1, arr);
                    flag = true;
                }
            }
        }
    }


    /**
     * 选择排序
     *
     * @param arr
     */
    public void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            if (i != index) {
                swap(i, index, arr);
            }

        }
    }


    /**
     * 插入排序
     *
     * @param arr
     */
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(j, j + 1, arr);
            }
        }
    }

    /**
     * 归并排序，将数组一分为2，左边排好序，右边拍好序，然后借用1个数组，用两个指针分别从左右两个排好序的数组中，依次比较，小的先插入辅助数据，指针加1，
     * 最后还剩余的数组，将值依次添加到队尾
     */
    public static void gbSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        gbSort(arr, L, mid);
        gbSort(arr, mid + 1, R);
        mergeArr(arr, L, mid, R);
    }

    public static void mergeArr(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            //如果p1小，则p1的指针向后移一位
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        //如果左边的数组有剩余，补充到辅助数据
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }

        //如果右边的数组有剩余，补充到辅助数据
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }

        for (int j = 0; j < help.length; j++) {
            arr[L + j] = help[j];
        }
    }


    public void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            int[] p = getPartion(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }


    public static int[] getPartion(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        int num = arr[R];
        while (L < more) {
            if (arr[L] < num) {
                swap1(++less, L++, arr);
            } else if (arr[R] > num) {
                swap1(--more, L, arr);
            } else {
                L++;
            }
        }
        swap1(more, R, arr);

        return new int[]{less + 1, more};
    }

    /**
     * 交换两数位置
     *
     * @param i
     * @param j
     * @param arr
     */
    public void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void swap1(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 2, 2};
        SortDemo sortDemo = new SortDemo();
        sortDemo.gbSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
